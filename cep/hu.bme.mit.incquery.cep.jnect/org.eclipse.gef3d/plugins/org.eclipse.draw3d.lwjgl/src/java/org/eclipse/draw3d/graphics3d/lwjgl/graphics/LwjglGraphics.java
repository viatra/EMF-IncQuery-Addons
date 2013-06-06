/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/

package org.eclipse.draw3d.graphics3d.lwjgl.graphics;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.geometry.IMatrix3f;
import org.eclipse.draw3d.geometry.IVector2f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Matrix3f;
import org.eclipse.draw3d.geometry.Matrix4f;
import org.eclipse.draw3d.graphics.GraphicsState;
import org.eclipse.draw3d.graphics.StatefulGraphics;
import org.eclipse.draw3d.graphics3d.DisplayListManager;
import org.eclipse.draw3d.graphics3d.lwjgl.font.LwjglFont;
import org.eclipse.draw3d.graphics3d.lwjgl.font.LwjglFontManager;
import org.eclipse.draw3d.util.ArcHelper;
import org.eclipse.draw3d.util.ColorConverter;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.draw3d.util.ImageConverter.ConversionSpecs;
import org.eclipse.draw3d.util.converter.ColorBufferInfo;
import org.eclipse.draw3d.util.converter.ImageConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.widgets.Display;
import org.lwjgl.opengl.GL11;

/**
 * Allows drawing to a texture object directly using OpenGL. The following
 * OpenGL state is expected:
 * <ul>
 * <li>{@link GL11#GL_TEXTURE_2D} enabled</li>
 * <li>{@link GL11#GL_BLEND} enabled</li>
 * <li>{@link GL11#glBlendFunc(int, int)} with arguments
 * {@link GL11#GL_SRC_ALPHA}, {@link GL11#ONE_MINUS_SRC_ALPHA}</li>
 * <li>GL shade model {@link GL11#GL_FLAT}</li>
 * <li>{@link GL11#GL_DEPTH_TEST} disabled</li>
 * <li>{@link GL11#GL_CULL_FACE} disabled</li>
 * <li>{@link GL11#GL_LINE_SMOOTH} enabled and {@link GL11#GL_LINE_SMOOTH_HINT}
 * set to {@link GL11#GL_NICEST}</li>
 * <li>viewport and projection matrix must be set up for orthographic 2D
 * projection like this:<br>
 * <code>gluOrtho2D(0, width, height, 0);<br>
 glViewport(0, 0, width, height);<br>glTranslatef(LwjglGraphics.RASTER_OFFSET, LwjglGraphics.RASTER_OFFSET, 0);</code>
 * .<br>
 * That last call is needed to achieve exact rasterization, if it is left out,
 * not only will rasterization be incorrect, but clipping planes will not work
 * either.</li>
 * </ul>
 * The following matrices and attribute groups may be modified by this class and
 * should be saved:
 * <ul>
 * <li>{@link GL11#GL_LIGHTING_BIT}</li>
 * <li>{@link GL11#GL_CURRENT_BIT}</li>
 * <li>{@link GL11#GL_TRANSFORM_BIT}</li>
 * <li>{@link GL11#GL_LINE_BIT}</li>
 * <li>{@link GL11#GL_POLYGON_BIT}</li>
 * <li>{@link GL11#GL_TEXTURE_BIT}</li>
 * </ul>
 * <h3>Limitations</h3> The following functions are not supported and will throw
 * an exception:
 * <ul>
 * <li>{@link Graphics#drawPath(org.eclipse.swt.graphics.Path)}</li>
 * <li>{@link Graphics#drawText(String, org.eclipse.draw2d.geometry.Point, int)}
 * </li>
 * <li>{@link Graphics#drawText(String, int, int, int)}</li>
 * <li>
 * {@link Graphics#drawTextLayout(org.eclipse.swt.graphics.TextLayout, int, int)}
 * </li>
 * <li>
 * {@link Graphics#drawTextLayout(org.eclipse.swt.graphics.TextLayout, int, int, int, int, Color, Color)}
 * </li>
 * <li>{@link Graphics#fillPath(org.eclipse.swt.graphics.Path)}</li>
 * <li>{@link Graphics#setClip(org.eclipse.swt.graphics.Path)}</li>
 * </ul>
 * The following functions are implemented, but will be ignored:
 * <ul>
 * <li>{@link Graphics#setAdvanced(boolean)} (GEF 3.5)</li>
 * <li>{@link Graphics#setAntialias(int)}</li>
 * <li>{@link Graphics#setBackgroundPattern(Pattern)}</li>
 * <li>{@link Graphics#setInterpolation(int)}</li>
 * <li>{@link Graphics#setFillRule(int)}</li>
 * <li>{@link Graphics#setLineCap(int)}</li>
 * <li>{@link Graphics#setLineJoin(int)}</li>
 * </ul>
 * Even if a setter is ignored, its corresponding getter will return the value
 * that was set before, with support for {@link #popState()} and
 * {@link #restoreState()}.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 08.03.2008
 * @todo revisit the method of calculating the number of segments to draw for an
 *       arc, since it will work for small arcs, but it will draw too many
 *       segments for long arcs, resulting in a performance penalty
 * @todo implement the unsupported methods
 * @todo tweak arc factors so that less segments are created
 * @todo cache textures for images
 */
@SuppressWarnings("unused")
public class LwjglGraphics extends StatefulGraphics {

	private enum LastColor {

		/**
		 * The last OpenGL color set by this graphics was the background color.
		 */
		BACKGROUND,

		/**
		 * The last OpenGL color set by this graphics was the foreground color.
		 */
		FOREGROUND,

		/**
		 * The last OpenGL color set by this graphics is unknown.
		 */
		UNKNOWN
	}

	private enum RasterOffset {

		LINE, POINT, POLYGON;

		public float getOffset() {

			switch (this) {
			case POLYGON:
				return 0;
			case LINE:
			case POINT:
				return 0;
				// return 0.49f;
			}

			throw new AssertionError("unknown raster offset enum: " + this);
		}
	}

	private static final float ARC_LENGTH_FACTOR =
		4 * (float) Math.PI * (float) Math.PI;

	private static final float ARC_PRECISION = 0.5f;

	/**
	 * Decrease this factor to get a larger number of segments and vice versa.
	 */
	private static final float ARC_SEGMENTS_FACTOR = 5 * (float) Math.PI;

	/**
	 * This value is used as the base for clipping plane equations.
	 */
	private static final double CLIP_BASE = 1000000d;

	private static final int LINE_STYLES =
		SWT.LINE_SOLID | SWT.LINE_DASH | SWT.LINE_DOT | SWT.LINE_DASHDOT
			| SWT.LINE_DASHDOTDOT;

	// @SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(LwjglGraphics.class.getName());

	private static final float[] TMP_F4 = new float[4];

	private boolean m_clippingEnabled = true;

	private Rectangle m_currentClip;

	private LwjglLinePattern m_currentLinePattern;

	private DisplayListManager m_displayListManager;

	private boolean m_disposed = false;

	private LwjglFontManager m_fontManager;

	private int m_height;

	private Map<Image, Integer> m_images = new HashMap<Image, Integer>();

	private LastColor m_lastColor = LastColor.UNKNOWN;

	private RasterOffset m_lastOffset;

	private Map<Object, LwjglLinePattern> m_linePatterns =
		new HashMap<Object, LwjglLinePattern>();

	private Boolean m_overrideTextAntialias;

	private int m_width;

	/**
	 * Creates a new OpenGL graphics object with the given width and height;
	 * 
	 * @param i_width the width of this graphics object
	 * @param i_height the height of this graphics object
	 * @param i_displayListManager the display list manager
	 * @param i_fontManager to the font manager to use
	 */
	public LwjglGraphics(int i_width, int i_height,
			DisplayListManager i_displayListManager,
			LwjglFontManager i_fontManager) {

		super();

		if (i_displayListManager == null)
			throw new NullPointerException(
				"i_displayListManager must not be null");

		if (i_fontManager == null)
			throw new NullPointerException("i_fontManager must not be null");

		m_width = i_width;
		m_height = i_height;

		glSetClip();
		glSetLineWidth();
		glSetLineStyle();
		glSetXORMode();

		m_fontManager = i_fontManager;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#clipRect(org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	public void clipRect(Rectangle i_clipRect) {

		checkDisposed();

		super.clipRect(i_clipRect);
		glSetClip();
	}

	/**
	 * Disables clipping.
	 */
	public void disableClipping() {

		if (m_clippingEnabled) {
			GL11.glDisable(GL11.GL_CLIP_PLANE0);
			GL11.glDisable(GL11.GL_CLIP_PLANE1);
			GL11.glDisable(GL11.GL_CLIP_PLANE2);
			GL11.glDisable(GL11.GL_CLIP_PLANE3);
			m_clippingEnabled = false;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#dispose()
	 */
	@Override
	public void dispose() {

		checkDisposed();

		if (log.isLoggable(Level.FINE))
			log.fine("disposing graphics " + this);

		// for (LwjglLinePattern linePattern : m_linePatterns.values())
		// linePattern.dispose();
		//
		// if (!m_images.isEmpty()) {
		// IntBuffer textureNames = Draw3DCache.getIntBuffer(m_images.size());
		// try {
		// textureNames.rewind();
		// for (Integer textureId : m_images.values())
		// textureNames.put(textureId);
		//
		// textureNames.rewind();
		// GL11.glDeleteTextures(textureNames);
		// } finally {
		// Draw3DCache.returnIntBuffer(textureNames);
		// }
		//
		// m_images.clear();
		// }

		m_fontManager = null;
		m_linePatterns = null;
		m_images = null;

		m_disposed = true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawArc(int, int, int, int, int, int)
	 */
	@Override
	public void drawArc(int i_x, int i_y, int i_w, int i_h, int i_offset,
		int i_length) {

		checkDisposed();

		glSetForegroundColor();
		glSetRasterOffset(RasterOffset.LINE);
		try {
			if (getState().getLineStyle() == SWT.LINE_CUSTOM) {
				m_currentLinePattern.activate();
				try {
					GL11.glBegin(GL11.GL_LINE_STRIP);
					glDrawTexturedArc(i_x, i_y, i_w, i_h, i_offset, i_length);
					GL11.glEnd();
				} finally {
					m_currentLinePattern.deactivate();
				}
			} else {
				GL11.glBegin(GL11.GL_LINE_STRIP);
				glDrawArc(i_x, i_y, i_w, i_h, i_offset, i_length);
				GL11.glEnd();
			}
		} finally {
			glResetRasterOffset();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawFocus(int, int, int, int)
	 */
	@Override
	public void drawFocus(int i_x, int i_y, int i_w, int i_h) {

		checkDisposed();

		pushState();
		try {
			Device dev = Display.getCurrent();
			Color c = dev.getSystemColor(SWT.COLOR_LIST_SELECTION);
			setForegroundColor(c);
			setLineStyle(SWT.LINE_SOLID);
			setLineWidth(2);
			drawRectangle(i_x, i_y, i_w, i_h);
		} finally {
			popState();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawImage(org.eclipse.swt.graphics.Image,
	 *      int, int)
	 */
	@Override
	public void drawImage(Image i_srcImage, int i_x, int i_y) {

		checkDisposed();

		org.eclipse.swt.graphics.Rectangle bounds = i_srcImage.getBounds();
		int x1 = bounds.x;
		int y1 = bounds.y;
		int x2 = i_x;
		int y2 = i_y;
		int w = bounds.width;
		int h = bounds.height;

		drawImage(i_srcImage, x1, y1, w, h, x2, y2, w, h);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawImage(org.eclipse.swt.graphics.Image,
	 *      int, int, int, int, int, int, int, int)
	 */
	@Override
	public void drawImage(Image i_srcImage, int i_x1, int i_y1, int i_w1,
		int i_h1, int i_x2, int i_y2, int i_w2, int i_h2) {

		checkDisposed();

		glSetRasterOffset(RasterOffset.POLYGON);
		try {
			GL11.glPushAttrib(GL11.GL_TEXTURE_BIT);
			try {
				Integer textureId = m_images.get(i_srcImage);
				if (textureId == null) {
					ConversionSpecs specs = new ConversionSpecs();
					specs.foregroundAlpha = 255;
					specs.textureWidth = i_w1;
					specs.textureHeight = i_h1;
					specs.clip =
						new org.eclipse.swt.graphics.Rectangle(i_x1, i_y1,
							i_w1, i_h1);

					ColorBufferInfo info =
						new ColorBufferInfo(i_w1, i_h1, GL11.GL_RGBA,
							GL11.GL_UNSIGNED_BYTE, 1);

					ByteBuffer buffer =
						Draw3DCache.getByteBuffer(info.getSize());
					IntBuffer nameBuffer = Draw3DCache.getIntBuffer(1);
					try {
						ImageConverter converter = ImageConverter.getInstance();
						buffer.rewind();

						buffer =
							converter.imageToBuffer(i_srcImage, info, buffer,
								false);

						nameBuffer.rewind();
						GL11.glGenTextures(nameBuffer);

						textureId = nameBuffer.get(0);
						GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureId);
						GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA,
							i_w1, i_h1, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE,
							buffer);

						GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
							GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
						GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
							GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
						GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
							GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
						GL11.glTexEnvi(GL11.GL_TEXTURE_ENV,
							GL11.GL_TEXTURE_ENV_MODE, GL11.GL_REPLACE);
					} finally {
						Draw3DCache.returnIntBuffer(nameBuffer);
						Draw3DCache.returnByteBuffer(buffer);
					}
				} else {
					GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureId);
				}

				GL11.glBegin(GL11.GL_QUADS);
				GL11.glTexCoord2f(0, 0);
				GL11.glVertex2i(i_x2, i_y2);

				GL11.glTexCoord2f(1, 0);
				GL11.glVertex2i(i_x2 + i_w2, i_y2);

				GL11.glTexCoord2f(1, 1);
				GL11.glVertex2i(i_x2 + i_w2, i_y2 + i_h2);

				GL11.glTexCoord2f(0, 1);
				GL11.glVertex2i(i_x2, i_y2 + i_h2);
				GL11.glEnd();
			} finally {
				GL11.glPopAttrib();
			}
		} finally {
			glResetRasterOffset();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawLine(int, int, int, int)
	 */
	@Override
	public void drawLine(int i_x1, int i_y1, int i_x2, int i_y2) {

		checkDisposed();

		glSetForegroundColor();
		glSetRasterOffset(RasterOffset.LINE);
		try {
			if (getState().getLineStyle() == SWT.LINE_CUSTOM) {
				m_currentLinePattern.activate();
				try {
					float s = m_currentLinePattern.getS(i_x1, i_y1, i_x2, i_y2);

					GL11.glBegin(GL11.GL_LINES);
					GL11.glTexCoord1f(0);
					GL11.glVertex2i(i_x1, i_y1);
					GL11.glTexCoord1d(s);
					GL11.glVertex2i(i_x2, i_y2);
					GL11.glEnd();
				} finally {
					m_currentLinePattern.deactivate();
				}
			} else {
				GL11.glBegin(GL11.GL_LINES);
				GL11.glVertex2i(i_x1, i_y1);
				GL11.glVertex2i(i_x2, i_y2);
				GL11.glEnd();
			}
		} finally {
			glResetRasterOffset();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawOval(int, int, int, int)
	 */
	@Override
	public void drawOval(int i_x, int i_y, int i_w, int i_h) {

		drawArc(i_x, i_y, i_w, i_h, 0, 360);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawPolygon(org.eclipse.draw2d.geometry.PointList)
	 */
	@Override
	public void drawPolygon(PointList i_points) {

		checkDisposed();

		glSetForegroundColor();
		glSetRasterOffset(RasterOffset.LINE);
		try {
			GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_LINE);
			if (getState().getLineStyle() == SWT.LINE_CUSTOM) {
				m_currentLinePattern.activate();
				try {
					GL11.glBegin(GL11.GL_LINE_LOOP);
					glDrawTexturedPointList(i_points);
					GL11.glEnd();
				} finally {
					m_currentLinePattern.deactivate();
				}
			} else {
				GL11.glBegin(GL11.GL_LINE_LOOP);
				glDrawPointList(i_points);
				GL11.glEnd();
			}
		} finally {
			glResetRasterOffset();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawPolyline(org.eclipse.draw2d.geometry.PointList)
	 */
	@Override
	public void drawPolyline(PointList i_points) {

		checkDisposed();

		if (i_points.size() < 2)
			return;

		glSetForegroundColor();
		glSetRasterOffset(RasterOffset.LINE);
		try {
			if (getState().getLineStyle() == SWT.LINE_CUSTOM) {
				m_currentLinePattern.activate();
				try {
					GL11.glBegin(GL11.GL_LINE_STRIP);
					glDrawTexturedPointList(i_points);
					GL11.glEnd();
				} finally {
					m_currentLinePattern.deactivate();
				}
			} else {
				GL11.glBegin(GL11.GL_LINE_STRIP);
				glDrawPointList(i_points);
				GL11.glEnd();
			}
		} finally {
			glResetRasterOffset();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawRectangle(int, int, int, int)
	 */
	@Override
	public void drawRectangle(int i_x, int i_y, int i_width, int i_height) {

		checkDisposed();

		glSetForegroundColor();
		glSetRasterOffset(RasterOffset.LINE);
		try {
			GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_LINE);
			if (getState().getLineStyle() == SWT.LINE_CUSTOM) {
				m_currentLinePattern.activate();
				try {
					GL11.glBegin(GL11.GL_LINE_LOOP);
					glDrawTexturedRectangle(i_x, i_y, i_width, i_height);
					GL11.glEnd();
				} finally {
					m_currentLinePattern.deactivate();
				}
			} else {
				GL11.glBegin(GL11.GL_LINE_LOOP);
				glDrawRectangle(i_x, i_y, i_width, i_height);
				GL11.glEnd();
			}
		} finally {
			glResetRasterOffset();
		}

		/*-
		 * // draw the final pixel
		 * // TODO: handle this properly when the line is textured
		 * Point lastPoint = Point.SINGLETON;
		 * i_points.getPoint(lastPoint, i_points.size() - 1);
		 * glBegin(GL_POINTS);
		 * glVertex2i(lastPoint.x, lastPoint.y);
		 * glEnd();
		 */
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawRoundRectangle(Rectangle, int, int)
	 */
	@Override
	public void drawRoundRectangle(Rectangle i_r, int i_arcWidth,
		int i_arcHeight) {

		checkDisposed();

		glSetForegroundColor();
		glSetRasterOffset(RasterOffset.LINE);
		try {
			GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_LINE);
			if (getState().getLineStyle() == SWT.LINE_CUSTOM) {
				m_currentLinePattern.activate();
				try {
					GL11.glBegin(GL11.GL_LINE_LOOP);
					glDrawTexturedRoundRectangle(i_r, i_arcWidth, i_arcHeight);
					GL11.glEnd();
				} finally {
					m_currentLinePattern.deactivate();
				}
			} else {
				GL11.glBegin(GL11.GL_LINE_LOOP);
				glDrawRoundRectangle(i_r, i_arcWidth, i_arcHeight);
				GL11.glEnd();
			}
		} finally {
			glResetRasterOffset();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawString(java.lang.String, int, int)
	 */
	@Override
	public void drawString(String i_s, int i_x, int i_y) {

		checkDisposed();

		glSetForegroundColor();
		glSetRasterOffset(RasterOffset.POLYGON);
		try {
			LwjglFont glFont = glGetFont();
			glFont.renderString(i_s, i_x, i_y, false);
		} finally {
			glResetRasterOffset();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawText(java.lang.String, int, int)
	 */
	@Override
	public void drawText(String i_s, int i_x, int i_y) {

		checkDisposed();

		glSetForegroundColor();
		glSetRasterOffset(RasterOffset.POLYGON);
		try {
			LwjglFont glFont = glGetFont();
			glFont.renderString(i_s, i_x, i_y, true);
		} finally {
			glResetRasterOffset();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawTextLayout(org.eclipse.swt.graphics.TextLayout,
	 *      int, int, int, int, org.eclipse.swt.graphics.Color,
	 *      org.eclipse.swt.graphics.Color)
	 */
	@Override
	public void drawTextLayout(TextLayout layout, int x, int y,
		int selectionStart, int selectionEnd, Color selectionForeground,
		Color selectionBackground) {

		drawText(layout.getText(), x, y);
		// checkText();
		// layout.draw(gc, x + translateX, y + translateY, selectionStart,
		// selectionEnd,
		// selectionForeground, selectionBackground);
	}

	/**
	 * Enables clipping.
	 */
	public void enableClipping() {

		if (!m_clippingEnabled) {
			m_clippingEnabled = true;
			glSetClip();
		}
	}

	private boolean equals(Object i_o1, Object i_o2) {

		if (i_o1 != null)
			return i_o1.equals(i_o2);

		if (i_o2 != null)
			return i_o2.equals(i_o1);

		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillArc(int, int, int, int, int, int)
	 */
	@Override
	public void fillArc(int i_x, int i_y, int i_w, int i_h, int i_offset,
		int i_length) {

		checkDisposed();

		glSetBackgroundColor();
		glSetRasterOffset(RasterOffset.POLYGON);
		try {
			GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
			GL11.glBegin(GL11.GL_POLYGON);
			GL11.glVertex2f(i_x + (float) i_w / 2, i_y + (float) i_h / 2);
			glDrawArc(i_x, i_y, i_w, i_h, i_offset, i_length);
			GL11.glEnd();
		} finally {
			glResetRasterOffset();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillGradient(int, int, int, int,
	 *      boolean)
	 */
	@Override
	public void fillGradient(int i_x, int i_y, int i_width, int i_height,
		boolean i_vertical) {

		checkDisposed();

		glSetRasterOffset(RasterOffset.POLYGON);

		GL11.glPushAttrib(GL11.GL_LIGHTING_BIT);
		try {
			GL11.glShadeModel(GL11.GL_SMOOTH);

			int x1 = i_x;
			int y1 = i_y;
			int x2 = i_x + i_width;
			int y2 = i_y + i_height;

			GL11.glBegin(GL11.GL_QUADS);
			glSetForegroundColor(); // from
			if (i_vertical) {
				GL11.glVertex2i(x1, y1);
				GL11.glVertex2i(x2, y1);
			} else {
				GL11.glVertex2i(x1, y2);
				GL11.glVertex2i(x1, y1);
			}

			glSetBackgroundColor(); // to
			if (i_vertical) {
				GL11.glVertex2i(x2, y2);
				GL11.glVertex2i(x1, y2);
			} else {
				GL11.glVertex2i(x2, y1);
				GL11.glVertex2i(x2, y2);
			}
			GL11.glEnd();
		} finally {
			glResetRasterOffset();
			GL11.glPopAttrib();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillOval(int, int, int, int)
	 */
	@Override
	public void fillOval(int i_x, int i_y, int i_w, int i_h) {

		fillArc(i_x, i_y, i_w, i_h, 0, 360);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillPolygon(org.eclipse.draw2d.geometry.PointList)
	 */
	@Override
	public void fillPolygon(PointList i_points) {

		checkDisposed();

		glSetBackgroundColor();
		glSetRasterOffset(RasterOffset.POLYGON);
		try {
			GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
			GL11.glBegin(GL11.GL_POLYGON);
			glDrawPointList(i_points);
			GL11.glEnd();
		} finally {
			glResetRasterOffset();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillRectangle(int, int, int, int)
	 */
	@Override
	public void fillRectangle(int i_x, int i_y, int i_width, int i_height) {

		checkDisposed();

		glSetBackgroundColor();
		glSetRasterOffset(RasterOffset.POLYGON);
		try {
			GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
			GL11.glBegin(GL11.GL_QUADS);
			glDrawRectangle(i_x, i_y, i_width, i_height);
			GL11.glEnd();
		} finally {
			glResetRasterOffset();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillRoundRectangle(org.eclipse.draw2d.geometry.Rectangle,
	 *      int, int)
	 */
	@Override
	public void fillRoundRectangle(Rectangle i_r, int i_arcWidth,
		int i_arcHeight) {

		checkDisposed();

		glSetBackgroundColor();
		glSetRasterOffset(RasterOffset.POLYGON);
		try {
			GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
			GL11.glBegin(GL11.GL_POLYGON);
			glDrawRoundRectangle(i_r, i_arcWidth, i_arcHeight);
			GL11.glEnd();
		} finally {
			glResetRasterOffset();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillString(java.lang.String, int, int)
	 */
	@Override
	public void fillString(String i_s, int i_x, int i_y) {

		checkDisposed();

		LwjglFont glFont = glGetFont();
		org.eclipse.swt.graphics.Point extent = glFont.getExtent(i_s, false);

		fillRectangle(i_x, i_y, extent.x, extent.y);
		drawString(i_s, i_x, i_y);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillText(java.lang.String, int, int)
	 */
	@Override
	public void fillText(String i_s, int i_x, int i_y) {

		checkDisposed();

		LwjglFont glFont = glGetFont();
		org.eclipse.swt.graphics.Point extent = glFont.getExtent(i_s, true);

		fillRectangle(i_x, i_y, extent.x, extent.y);
		drawText(i_s, i_x, i_y);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getAbsoluteScale()
	 */
	@Override
	public double getAbsoluteScale() {

		// just return 1.0
		return super.getAbsoluteScale();
	}

	private void glDrawArc(int i_x, int i_y, int i_w, int i_h, int i_offset,
		int i_length) {

		float rOffset = (float) Math.toRadians(i_offset);
		float rLength = (float) Math.toRadians(i_length);

		ArcHelper helper =
			new ArcHelper(ARC_PRECISION, i_x, i_y, i_w, i_h, rOffset + rLength,
				-rLength, false);

		for (IVector2f v : helper)
			GL11.glVertex2f(v.getX(), v.getY());
	}

	private void glDrawPointList(PointList i_points) {

		int[] vertices = i_points.toIntArray();
		for (int i = 0; i < vertices.length; i = i + 2) {
			int x = vertices[i];
			int y = vertices[i + 1];

			GL11.glVertex2i(x, y);
		}
	}

	private void glDrawRectangle(int i_x, int i_y, int i_width, int i_height) {

		int x1 = i_x;
		int y1 = i_y + i_height;
		int x2 = i_x + i_width;
		int y2 = i_y;

		GL11.glVertex2i(x1, y1);
		GL11.glVertex2i(x1, y2);
		GL11.glVertex2i(x2, y2);
		GL11.glVertex2i(x2, y1);
	}

	private void glDrawRoundRectangle(Rectangle i_r, int i_arcWidth,
		int i_arcHeight) {

		int x1 = i_r.x;
		int y1 = i_r.y;
		int x2 = x1 + i_r.width;
		int y2 = y1 + i_r.height;
		int w = i_arcWidth;
		int h = i_arcHeight;

		// left
		// GL11.glVertex2f(x1, y1 + h2);
		// GL11.glVertex2f(x1, y2 - h2);

		// bottom left corner
		glDrawArc(x1, y2 - h, w, h, 180, 90);

		// bottom
		// GL11.glVertex2f(x1 + w2, y2);
		// GL11.glVertex2f(x2 - w2, y2);

		// bottom right corner
		glDrawArc(x2 - w, y2 - h, w, h, 270, 90);

		// right
		// GL11.glVertex2f(x2, y2 - h2);
		// GL11.glVertex2f(x2, y1 + h2);

		// top right corner
		glDrawArc(x2 - w, y1, w, h, 0, 90);

		// top
		// GL11.glVertex2f(x2 - w2, y1);
		// GL11.glVertex2f(x1 + w2, y1);

		// top left corner
		glDrawArc(x1, y1, w, h, 90, 90);
	}

	private void glDrawTexturedArc(int i_x, int i_y, int i_w, int i_h,
		int i_offset, int i_length) {

		glDrawTexturedArc(i_x, i_y, i_w, i_h, i_offset, i_length, 0);
	}

	private float glDrawTexturedArc(int i_x, int i_y, int i_w, int i_h,
		int i_offset, int i_length, float i_s) {

		float start = (float) Math.toRadians(i_offset);
		float length = (float) Math.toRadians(i_length);

		float xFactor = ((float)i_w) / 2f;
		float yFactor = ((float)i_h) / 2f;

		float avgRadius = (xFactor + yFactor) / 2;
		float arcLength = ARC_LENGTH_FACTOR * avgRadius / length;

		float inc = ARC_SEGMENTS_FACTOR / arcLength;

		float xOffset = i_x + i_w / 2;
		float yOffset = i_y + i_h / 2;

		float lastX = xOffset + (float) Math.cos(start) * xFactor;
		float lastY = yOffset - (float) Math.sin(start) * yFactor;

		float s = i_s;
		GL11.glTexCoord1d(s);
		GL11.glVertex2d(lastX, lastY);

		for (float a = start + inc; a < start + length; a += inc) {
			float x = xOffset + (float) Math.cos(a) * xFactor;
			float y = yOffset - (float) Math.sin(a) * yFactor;
			s += m_currentLinePattern.getS(lastX, lastY, x, y);

			GL11.glTexCoord1d(s);
			GL11.glVertex2d(x, y);

			lastX = x;
			lastY = y;
		}

		float x = xOffset + (float) Math.cos(start + length) * xFactor;
		float y = yOffset - (float) Math.sin(start + length) * yFactor;
		s += m_currentLinePattern.getS(lastX, lastY, x, y);

		GL11.glTexCoord1d(s);
		GL11.glVertex2d(x, y);

		return s;
	}

	private void glDrawTexturedPointList(PointList i_points) {

		int[] vertices = i_points.toIntArray();

		if (vertices.length > 1) {
			int lastX = vertices[0];
			int lastY = vertices[1];

			float s = 0;

			GL11.glTexCoord1d(s);
			GL11.glVertex2i(lastX, lastY);

			for (int i = 2; i < vertices.length; i = i + 2) {
				int x = vertices[i];
				int y = vertices[i + 1];
				s += m_currentLinePattern.getS(lastX, lastY, x, y);

				GL11.glTexCoord1d(s);
				GL11.glVertex2i(x, y);

				lastX = x;
				lastY = y;
			}
		}
	}

	private void glDrawTexturedRectangle(int i_x, int i_y, int i_width,
		int i_height) {

		int x1 = i_x;
		int y1 = i_y + i_height;
		int x2 = i_x + i_width;
		int y2 = i_y;

		float s = 0;
		GL11.glTexCoord1d(s);
		GL11.glVertex2i(x1, y1);

		s += m_currentLinePattern.getS(x1, y1, x1, y2);
		GL11.glTexCoord1d(s);
		GL11.glVertex2i(x1, y2);

		s += m_currentLinePattern.getS(x1, y2, x2, y2);
		GL11.glTexCoord1d(s);
		GL11.glVertex2i(x2, y2);

		s += m_currentLinePattern.getS(x2, y2, x2, y1);
		GL11.glTexCoord1d(s);
		GL11.glVertex2i(x2, y1);
	}

	private void glDrawTexturedRoundRectangle(Rectangle i_r, int i_arcWidth,
		int i_arcHeight) {

		int x1 = i_r.x;
		int y1 = i_r.y;
		int x2 = x1 + i_r.width;
		int y2 = y1 + i_r.height;
		int w = i_arcWidth;
		int h = i_arcHeight;
		float w2 = ((float)w) / 2f;
		float h2 = ((float)h) / 2f;

		// left
		float s = 0;
		GL11.glTexCoord1d(s);
		GL11.glVertex2i(x1, y1 + h / 2);
		s += m_currentLinePattern.getS(x1, y1 + h2, x1, y2 - h2);
		GL11.glTexCoord1d(s);
		GL11.glVertex2i(x1, y2 - h / 2);

		// bottom left corner
		s = glDrawTexturedArc(x1, y2 - h, w, h, 180, 90, s);

		// bottom
		GL11.glVertex2d(x1 + w2, y2);
		s += m_currentLinePattern.getS(x1 + w2, y2, x2 - w2, y2);
		GL11.glTexCoord1d(s);
		GL11.glVertex2d(x2 - w2, y2);

		// bottom right corner
		s = glDrawTexturedArc(x2 - w, y2 - h, w, h, 270, 90, s);

		// right
		GL11.glVertex2d(x2, y2 - h2);
		s += m_currentLinePattern.getS(x2, y2 - h2, x2, y1 + h2);
		GL11.glTexCoord1d(s);
		GL11.glVertex2d(x2, y1 + h2);

		// top right corner
		s = glDrawTexturedArc(x2 - w, y1, w, h, 0, 90, s);

		// top
		GL11.glVertex2d(x2 - w2, y1);
		s += m_currentLinePattern.getS(x2 - w2, y1, x1 + w2, y1);
		GL11.glTexCoord1d(s);
		GL11.glVertex2d(x1 + w2, y1);

		// top left corner
		glDrawTexturedArc(x1, y1, w, h, 90, 90, s);
	}

	private LwjglFont glGetFont() {

		int antialias = getAntialias();
		if (m_overrideTextAntialias != null) {
			if (m_overrideTextAntialias)
				antialias = SWT.ON;
			else
				antialias = SWT.OFF;
		}

		Font font = getState().getFont();
		return m_fontManager.getFont(font, (char) 32, (char) 127,
			antialias == SWT.ON);
	}

	private void glResetRasterOffset() {

		if (m_lastOffset == null)
			throw new IllegalStateException("raster offset was reset");

		if (m_lastOffset.getOffset() != 0)
			GL11.glTranslatef(-m_lastOffset.getOffset(),
				-m_lastOffset.getOffset(), 0);

		m_lastOffset = null;
	}

	private void glRestoreState(GraphicsState i_previous) {

		Matrix3f transformation = i_previous.getTransformation();
		if (transformation != null
			&& !IMatrix3f.IDENTITY.equals(transformation)) {
			FloatBuffer buffer = Draw3DCache.getFloatBuffer(9);
			Matrix3f inverse = Draw3DCache.getMatrix3f();
			try {
				Math3D.invert(transformation, inverse);
				buffer.rewind();
				inverse.toBufferRowMajor(buffer);
				buffer.rewind();

				GL11.glMatrixMode(GL11.GL_MODELVIEW);
				GL11.glMultMatrix(buffer);
			} finally {
				Draw3DCache.returnFloatBuffer(buffer);
				Draw3DCache.returnMatrix3f(inverse);
			}
		}

		if (i_previous.getClip() == null) {
			if (getState().getClip() != null)
				glSetClip();
		} else {
			if (!i_previous.getClip().equals(getState().getClip()))
				glSetClip();
		}

		if (i_previous.getLineWidth() != getState().getLineWidth())
			glSetLineWidth();

		if (i_previous.getLineStyle() != getState().getLineStyle()
			|| (i_previous.getLineStyle() == SWT.LINE_CUSTOM
				&& getState().getLineStyle() == SWT.LINE_CUSTOM && !Arrays.equals(
				i_previous.getLineDash(), getState().getLineDash())))
			glSetLineStyle();

		if (i_previous.getXORMode() != getState().getXORMode())
			glSetXORMode();

		if (i_previous.getAntialias() != getState().getAntialias())
			glSetAntialias();

		m_lastColor = LastColor.UNKNOWN;
	}

	private void glSetAntialias() {

		if (getState().getAntialias() == SWT.ON) {
			GL11.glEnable(GL11.GL_LINE_SMOOTH);
			GL11.glEnable(GL11.GL_POINT_SMOOTH);
			GL11.glEnable(GL11.GL_POLYGON_SMOOTH);
		} else {
			GL11.glDisable(GL11.GL_LINE_SMOOTH);
			GL11.glDisable(GL11.GL_POINT_SMOOTH);
			GL11.glDisable(GL11.GL_POLYGON_SMOOTH);
		}
	}

	private void glSetBackgroundColor() {

		if (m_lastColor == LastColor.BACKGROUND)
			return;

		Color backgroundColor = getState().getBackgroundColor();
		int alpha = getState().getAlpha();

		ColorConverter.toFloatArray(backgroundColor, alpha, TMP_F4);
		GL11.glColor4f(TMP_F4[0], TMP_F4[1], TMP_F4[2], TMP_F4[3]);

		m_lastColor = LastColor.BACKGROUND;
	}

	private void glSetClip() {

		if (!m_clippingEnabled)
			return;

		Rectangle clip = getState().getClip();
		if (clip == null) {
			if (m_currentClip != null) {
				GL11.glDisable(GL11.GL_CLIP_PLANE0);
				GL11.glDisable(GL11.GL_CLIP_PLANE1);
				GL11.glDisable(GL11.GL_CLIP_PLANE2);
				GL11.glDisable(GL11.GL_CLIP_PLANE3);
				m_currentClip = null;
			}
			return;
		} else if (clip.equals(m_currentClip))
			return;

		if (m_currentClip == null)
			m_currentClip = new Rectangle();

		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPushMatrix();
		try {
			DoubleBuffer buffer = Draw3DCache.getDoubleBuffer(16);
			try {
				// left plane
				if (clip.x > 0) {
					double a = CLIP_BASE / clip.x;
					buffer.put(0, a);
					buffer.put(1, 0);
					buffer.put(2, 0);
					buffer.put(3, -CLIP_BASE);
					GL11.glEnable(GL11.GL_CLIP_PLANE0);
					GL11.glClipPlane(GL11.GL_CLIP_PLANE0, buffer);
				} else {
					GL11.glDisable(GL11.GL_CLIP_PLANE0);
				}

				// top plane
				if (clip.y > 0) {
					double b = CLIP_BASE / clip.y;
					buffer.put(0, 0);
					buffer.put(1, b);
					buffer.put(2, 0);
					buffer.put(3, -CLIP_BASE);
					GL11.glEnable(GL11.GL_CLIP_PLANE1);
					GL11.glClipPlane(GL11.GL_CLIP_PLANE1, buffer);
				} else {
					GL11.glDisable(GL11.GL_CLIP_PLANE1);
				}

				// right plane
				if (clip.x + clip.width < m_width - 1) {
					double a = -CLIP_BASE / (clip.x + clip.width);
					buffer.put(0, a);
					buffer.put(1, 0);
					buffer.put(2, 0);
					buffer.put(3, CLIP_BASE);
					GL11.glEnable(GL11.GL_CLIP_PLANE2);
					GL11.glClipPlane(GL11.GL_CLIP_PLANE2, buffer);
				} else {
					GL11.glDisable(GL11.GL_CLIP_PLANE2);
				}

				// bottom plane
				if (clip.y + clip.height < m_height - 1) {
					double b = -CLIP_BASE / (clip.y + clip.height);
					buffer.put(0, 0);
					buffer.put(1, b);
					buffer.put(2, 0);
					buffer.put(3, CLIP_BASE);
					GL11.glEnable(GL11.GL_CLIP_PLANE3);
					GL11.glClipPlane(GL11.GL_CLIP_PLANE3, buffer);
				} else {
					GL11.glDisable(GL11.GL_CLIP_PLANE3);
				}

				m_currentClip.setBounds(clip);
			} finally {
				Draw3DCache.returnDoubleBuffer(buffer);
			}
		} finally {
			GL11.glPopMatrix();
		}
	}

	private void glSetForegroundColor() {

		if (m_lastColor == LastColor.FOREGROUND)
			return;

		Color foregroundColor = getState().getForegroundColor();
		int alpha = getState().getAlpha();

		ColorConverter.toFloatArray(foregroundColor, alpha, TMP_F4);
		GL11.glColor4f(TMP_F4[0], TMP_F4[1], TMP_F4[2], TMP_F4[3]);

		m_lastColor = LastColor.FOREGROUND;
	}

	private void glSetLineStyle() {

		int lineStyle = getState().getLineStyle();
		switch (lineStyle) {
		case SWT.LINE_SOLID:
			m_currentLinePattern = null;
			GL11.glDisable(GL11.GL_LINE_STIPPLE);
			break;
		case SWT.LINE_DASH:
			m_currentLinePattern = null;
			GL11.glLineStipple(3, (short) 0x3F3F);
			GL11.glEnable(GL11.GL_LINE_STIPPLE);
			break;
		case SWT.LINE_DOT:
			m_currentLinePattern = null;
			GL11.glLineStipple(3, (short) 0x3333);
			GL11.glEnable(GL11.GL_LINE_STIPPLE);
			break;
		case SWT.LINE_DASHDOT:
			m_currentLinePattern = null;
			GL11.glLineStipple(3, (short) 0x6F6F);
			GL11.glEnable(GL11.GL_LINE_STIPPLE);
			break;
		case SWT.LINE_DASHDOTDOT:
			m_currentLinePattern = null;
			GL11.glLineStipple(3, (short) 0x5757);
			GL11.glEnable(GL11.GL_LINE_STIPPLE);
			break;
		case SWT.LINE_CUSTOM:
			GL11.glDisable(GL11.GL_LINE_STIPPLE);

			int[] dashPattern = getState().getLineDash();
			Object key = LwjglLinePattern.getKey(dashPattern);
			m_currentLinePattern = m_linePatterns.get(key);
			if (m_currentLinePattern == null) {
				m_currentLinePattern =
					new LwjglLinePattern(dashPattern, m_displayListManager);
				m_linePatterns.put(key, m_currentLinePattern);
			}
			break;
		default:
			throw new IllegalArgumentException("unknown line style: "
				+ lineStyle);
		}
	}

	private void glSetLineWidth() {

		float lineWidth = getState().getLineWidth();
		GL11.glLineWidth(lineWidth);
	}

	private void glSetRasterOffset(RasterOffset i_offset) {

		if (m_lastOffset != null)
			throw new IllegalStateException("raster offset was not reset");

		if (i_offset.getOffset() != 0)
			GL11.glTranslatef(i_offset.getOffset(), i_offset.getOffset(), 0);

		m_lastOffset = i_offset;
	}

	private void glSetXORMode() {

		if (getState().getXORMode()) {
			GL11.glEnable(GL11.GL_COLOR_LOGIC_OP);
			GL11.glLogicOp(GL11.GL_XOR);
		} else {
			GL11.glDisable(GL11.GL_COLOR_LOGIC_OP);
		}
	}

	/**
	 * Indicates whether clipping is enabled.
	 * 
	 * @return <code>true</code> if clipping is enabled and <code>false</code>
	 *         otherwise
	 */
	public boolean isClippingEnabled() {

		return m_clippingEnabled;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#popState()
	 */
	@Override
	public void popState() {

		GraphicsState currentState = getState();

		super.popState();
		glRestoreState(currentState);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#restoreState()
	 */
	@Override
	public void restoreState() {

		GraphicsState currentState = getState();

		super.restoreState();
		glRestoreState(currentState);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#rotate(float)
	 */
	@Override
	public void rotate(float i_degrees) {

		super.rotate(i_degrees);

		if (i_degrees != 0)
			GL11.glRotatef(i_degrees, 0, 0, 1);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#scale(double)
	 */
	@Override
	public void scale(double i_amount) {

		scale((float) i_amount, (float) i_amount);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#scale(float, float)
	 */
	@Override
	public void scale(float i_horizontal, float i_vertical) {

		super.scale(i_horizontal, i_vertical);

		if (i_horizontal != 0 || i_vertical != 0)
			GL11.glScalef(i_horizontal, i_vertical, 0);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setClip(org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	public void setClip(Rectangle i_clip) {

		PrecisionRectangle previous = getState().getClip();
		super.setClip(i_clip);

		if (!equals(previous, getState().getClip()))
			glSetClip();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.StatefulGraphics#setLineDash(float[])
	 */
	@Override
	public void setLineDash(float[] i_dash) {

		int[] previous = getState().getLineDash();
		super.setLineDash(i_dash);

		if (!Arrays.equals(previous, getState().getLineDash()))
			glSetLineStyle();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineDash(int[])
	 */
	@Override
	public void setLineDash(int[] i_dash) {

		int[] previous = getState().getLineDash();
		super.setLineDash(i_dash);

		if (!Arrays.equals(previous, getState().getLineDash()))
			glSetLineStyle();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineStyle(int)
	 */
	@Override
	public void setLineStyle(int i_lineStyle) {

		if ((i_lineStyle & LINE_STYLES) == 0)
			throw new IllegalArgumentException("unknown line style: "
				+ i_lineStyle);

		int previous = getState().getLineStyle();
		super.setLineStyle(i_lineStyle);

		if (previous != getLineStyle())
			glSetLineStyle();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineWidth(int)
	 */
	@Override
	public void setLineWidth(int i_lineWidth) {

		setLineWidthFloat(i_lineWidth);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineWidthFloat(float)
	 */
	@Override
	public void setLineWidthFloat(float i_lineWidth) {

		float previous = getLineWidthFloat();
		super.setLineWidthFloat(i_lineWidth);

		if (previous != getLineWidthFloat())
			glSetLineWidth();
	}

	/**
	 * Specifies whether the font antialiasing setting should be overridden.
	 * 
	 * @param i_overrideTextAntialias if <code>true</code>, font antialiasing is
	 *            always enabled, if <code>false</code>, it's always disabled,
	 *            if <code>null</code>, the value set by
	 *            {@link #setTextAntialias(int)} is used.
	 */
	public void setOverrideTextAntialias(Boolean i_overrideTextAntialias) {

		m_overrideTextAntialias = i_overrideTextAntialias;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setXORMode(boolean)
	 */
	@Override
	public void setXORMode(boolean i_enabled) {

		boolean previous = getXORMode();
		super.setXORMode(i_enabled);

		if (previous != getXORMode())
			glSetXORMode();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#shear(float, float)
	 */
	@Override
	public void shear(float i_horz, float i_vert) {

		super.shear(i_horz, i_vert);

		if (i_horz != 0 || i_vert != 0) {
			FloatBuffer buffer = Draw3DCache.getFloatBuffer(16);
			Matrix4f matrix = Draw3DCache.getMatrix4f();
			try {
				matrix.setIdentity();
				matrix.set(1, 0, i_horz);
				matrix.set(0, 1, i_vert);

				buffer.rewind();
				matrix.toBufferRowMajor(buffer);
				buffer.rewind();

				GL11.glMultMatrix(buffer);
			} finally {
				Draw3DCache.returnFloatBuffer(buffer);
				Draw3DCache.returnMatrix4f(matrix);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#translate(float, float)
	 */
	@Override
	public void translate(float i_dx, float i_dy) {

		super.translate(i_dx, i_dy);

		if (i_dx != 0 || i_dy != 0)
			GL11.glTranslatef(i_dx, i_dy, 0);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.StatefulGraphics#translate(int, int)
	 */
	@Override
	public void translate(int i_dx, int i_dy) {

		translate((float) i_dx, (float) i_dy);
	}
}
