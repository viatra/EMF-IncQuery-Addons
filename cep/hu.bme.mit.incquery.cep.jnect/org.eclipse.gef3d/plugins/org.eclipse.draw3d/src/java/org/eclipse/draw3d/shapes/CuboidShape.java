/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.shapes;

import java.util.Map;
import java.util.logging.Logger;

import org.eclipse.draw3d.RenderContext;
import org.eclipse.draw3d.geometry.IPosition3D;
import org.eclipse.draw3d.geometry.IVector2f;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Vector2fImpl;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.graphics3d.DisplayListManager;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.Graphics3DDraw;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/**
 * A cube with a color and an optional texture on its front face.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 27.02.2008
 */
public class CuboidShape extends PositionableShape {

	private static final String DL_FILL_FRONT = "fill_cube_front";

	private static final String DL_FILL_REST = "fill_cube_rest";

	private static final String DL_OUTLINE = "outline_cube";

	private static final String DL_TEXTURE = "cube_texture";

	/**
	 * Contains the indices of the vertices of the faces in the following order:
	 * <ol start="0">
	 * <li>The face on the plane Z=0.</li>
	 * <li>The face on the plane Z=1.</li>
	 * <li>The face on the plane X=0.</li>
	 * <li>The face on the plane X=1.</li>
	 * <li>The face on the plane Y=0.</li>
	 * <li>The face on the plane Y=1.</li>
	 * </ol>
	 * The vertices of each face are wound in counter-clockwise order.
	 */
	static final int[][] FACES = new int[6][4];

	@SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(CuboidShape.class.getName());

	/**
	 * Contains the normal vectors of the faces in the same order as the faces
	 * are in the {@link #FACES} array.
	 */
	static final IVector3f[] NORMALS = new IVector3f[6];

	/**
	 * Contains the texture coords for the face Z=0.
	 */
	static final IVector2f[] TEX_COORDS = new IVector2f[4];

	/**
	 * Contains the vertices of a unit cube. The position <code>i</code> of a
	 * vertex in the array determines its spacial position because i in binary
	 * equals xyz. So if a vector is at position 3, which is 011 in binary, its
	 * X component is 0 and its Y and Z component is 1.
	 */
	static final IVector3f[] VERTICES = new IVector3f[8];

	static {
		for (int i = 0; i < 8; i++) {
			int z = i & 1;
			int y = (i & 2) >> 1;
			int x = (i & 4) >> 2;
			VERTICES[i] = new Vector3fImpl(x, y, z);
		}

		FACES[0][0] = 2;
		FACES[0][1] = 6;
		FACES[0][2] = 4;
		FACES[0][3] = 0;
		NORMALS[0] = IVector3f.Z_AXIS_NEG;

		FACES[1][0] = 5;
		FACES[1][1] = 7;
		FACES[1][2] = 3;
		FACES[1][3] = 1;
		NORMALS[1] = IVector3f.Z_AXIS;

		FACES[2][0] = 1;
		FACES[2][1] = 3;
		FACES[2][2] = 2;
		FACES[2][3] = 0;
		NORMALS[2] = IVector3f.X_AXIS_NEG;

		FACES[3][0] = 6;
		FACES[3][1] = 7;
		FACES[3][2] = 5;
		FACES[3][3] = 4;
		NORMALS[3] = IVector3f.X_AXIS;

		FACES[4][0] = 4;
		FACES[4][1] = 5;
		FACES[4][2] = 1;
		FACES[4][3] = 0;
		NORMALS[4] = IVector3f.Y_AXIS_NEG;

		FACES[5][0] = 3;
		FACES[5][1] = 7;
		FACES[5][2] = 6;
		FACES[5][3] = 2;
		NORMALS[5] = IVector3f.Y_AXIS;

		TEX_COORDS[0] = new Vector2fImpl(0, 0);
		TEX_COORDS[1] = new Vector2fImpl(1, 0);
		TEX_COORDS[2] = new Vector2fImpl(1, 1);
		TEX_COORDS[3] = new Vector2fImpl(0, 1);
	}

	private int m_alpha = 0xFF;

	private boolean m_fill = true;

	private Color m_fillColor =
		Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);

	private boolean m_outline = true;

	private Color m_outlineColor =
		Display.getCurrent().getSystemColor(SWT.COLOR_BLACK);

	private boolean m_superimposed;

	private Integer m_textureId;

	/**
	 * Creates a new cuboid shape with the given position.
	 * 
	 * @param i_position3D the position of this cuboid shape
	 * @param i_superimposed whether this shape is superimposed
	 * @throws NullPointerException if the given position is <code>null</code>
	 */
	public CuboidShape(IPosition3D i_position3D, boolean i_superimposed) {

		super(i_position3D);
		m_superimposed = i_superimposed;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.shapes.PositionableShape#doGetDistance(org.eclipse.draw3d.geometry.IVector3f,
	 *      org.eclipse.draw3d.geometry.IVector3f, java.util.Map)
	 */
	@Override
	protected float doGetDistance(IVector3f i_rayOrigin,
		IVector3f i_rayDirection, Map<Object, Object> i_context) {

		IVector3f[] face = new Vector3f[4];
		float distance;

		for (int i = 0; i < FACES.length; i++) {
			for (int j = 0; j < FACES[i].length; j++)
				face[j] = VERTICES[FACES[i][j]];

			distance =
				Math3D.rayIntersectsPolygon(i_rayOrigin, i_rayDirection, face,
					NORMALS[i], null);

			if (!Float.isNaN(distance))
				return distance;
		}

		return Float.NaN;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.shapes.PositionableShape#doRender(org.eclipse.draw3d.RenderContext)
	 */
	@Override
	protected void doRender(RenderContext i_renderContext) {
		DisplayListManager displayListManager =
			i_renderContext.getGraphics3D().getDisplayListManager();

		Graphics3D g3d = i_renderContext.getGraphics3D();
		initDisplayLists(displayListManager, g3d);

		if (getRenderType() != RenderType.TRANSPARENT) {
			if (m_fill)
				renderFill(displayListManager, g3d);

			if (m_outline)
				renderOutline(displayListManager, g3d);
		} else {
			if (m_outline)
				renderOutline(displayListManager, g3d);

			if (m_fill)
				renderFill(displayListManager, g3d);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.RenderFragment#getRenderType()
	 */
	public RenderType getRenderType() {

		return RenderType.getRenderType(m_alpha, m_superimposed);
	}

	private void initDisplayLists(DisplayListManager i_displayListManager,
		final Graphics3D g3d) {

		if (i_displayListManager.isDisplayList(DL_OUTLINE, DL_FILL_REST,
			DL_FILL_FRONT, DL_TEXTURE))
			return;

		Runnable outline = new Runnable() {

			public void run() {
				g3d.glBegin(Graphics3DDraw.GL_LINE_LOOP);
				g3d.glVertex3f(0, 0, 0);
				g3d.glVertex3f(1, 0, 0);
				g3d.glVertex3f(1, 0, 1);
				g3d.glVertex3f(0, 0, 1);
				g3d.glEnd();

				g3d.glBegin(Graphics3DDraw.GL_LINE_LOOP);
				g3d.glVertex3f(0, 1, 0);
				g3d.glVertex3f(1, 1, 0);
				g3d.glVertex3f(1, 1, 1);
				g3d.glVertex3f(0, 1, 1);
				g3d.glEnd();

				g3d.glBegin(Graphics3DDraw.GL_LINES);
				g3d.glVertex3f(0, 0, 0);
				g3d.glVertex3f(0, 1, 0);
				g3d.glVertex3f(1, 0, 0);
				g3d.glVertex3f(1, 1, 0);
				g3d.glVertex3f(0, 0, 1);
				g3d.glVertex3f(0, 1, 1);
				g3d.glVertex3f(1, 0, 1);
				g3d.glVertex3f(1, 1, 1);
				g3d.glEnd();
			}
		};

		Runnable front = new Runnable() {
			public void run() {
				g3d.glBegin(Graphics3DDraw.GL_QUADS);
				g3d.glNormal3f(NORMALS[0]);
				for (int i = 0; i < 4; i++)
					g3d.glVertex3f(VERTICES[FACES[0][i]]);
				g3d.glEnd();
			}
		};

		Runnable texture = new Runnable() {
			public void run() {
				g3d.glBegin(Graphics3DDraw.GL_QUADS);
				g3d.glNormal3f(NORMALS[0]);
				for (int i = 0; i < 4; i++) {
					g3d.glTexCoord2f(TEX_COORDS[i]);
					g3d.glVertex3f(VERTICES[FACES[0][i]]);
				}

				g3d.glNormal3f(NORMALS[1]);
				for (int i = 3; i >= 0; i--) {
					g3d.glTexCoord2f(TEX_COORDS[i]);
					g3d.glVertex3f(VERTICES[FACES[0][i]]);
				}
				g3d.glEnd();
			}
		};

		Runnable rest = new Runnable() {
			public void run() {
				g3d.glBegin(Graphics3DDraw.GL_QUADS);
				for (int j = 1; j < FACES.length; j++) {
					g3d.glNormal3f(NORMALS[j]);
					for (int i = 0; i < 4; i++)
						g3d.glVertex3f(VERTICES[FACES[j][i]]);
				}
				g3d.glEnd();
			}
		};

		i_displayListManager.interruptDisplayList();
		try {
			i_displayListManager.createDisplayList(DL_OUTLINE, outline);
			i_displayListManager.createDisplayList(DL_FILL_FRONT, front);
			i_displayListManager.createDisplayList(DL_TEXTURE, texture);
			i_displayListManager.createDisplayList(DL_FILL_REST, rest);
		} finally {
			i_displayListManager.resumeDisplayList();
		}
	}

	private void renderFill(DisplayListManager displayListManager,
		Graphics3D g3d) {
		g3d.glPolygonMode(Graphics3DDraw.GL_FRONT_AND_BACK,
			Graphics3DDraw.GL_FILL);

		if (m_textureId != null) {
			g3d.glColor4f(0, 0, 0, 0);

			g3d.glBindTexture(Graphics3DDraw.GL_TEXTURE_2D, m_textureId);
			g3d.glTexEnvi(Graphics3DDraw.GL_TEXTURE_ENV,
				Graphics3DDraw.GL_TEXTURE_ENV_MODE, Graphics3DDraw.GL_REPLACE);
			displayListManager.executeDisplayList(DL_TEXTURE);
			g3d.glBindTexture(Graphics3DDraw.GL_TEXTURE_2D, 0);

			g3d.glColor(m_fillColor, m_alpha);
		} else {
			g3d.glColor(m_fillColor, m_alpha);
			displayListManager.executeDisplayList(DL_FILL_FRONT);
		}

		displayListManager.executeDisplayList(DL_FILL_REST);
	}

	private void renderOutline(DisplayListManager displayListManager,
		Graphics3D g3d) {
		g3d.glColor(m_outlineColor, m_alpha);
		displayListManager.executeDisplayList(DL_OUTLINE);
	}

	/**
	 * Sets the alpha value of this shape.
	 * 
	 * @param i_alpha the alpha value, should be between 0 and 255, inclusive
	 */
	public void setAlpha(int i_alpha) {

		m_alpha = i_alpha;
	}

	/**
	 * Specifies whether this cuboid should render its faces.
	 * 
	 * @param i_fill <code>true</code> if the cuboid should render its faces and
	 *            <code>false</code> otherwise
	 */
	public void setFill(boolean i_fill) {

		m_fill = i_fill;
	}

	/**
	 * Sets the fill color.
	 * 
	 * @param i_color the fill color
	 * @param i_alpha the alpha value
	 */
	public void setFillColor(Color i_color) {

		m_fillColor = i_color;
	}

	/**
	 * Specifies whether this cuboid should render its outline.
	 * 
	 * @param i_outline <code>true</code> if the cuboid should render its
	 *            outline and <code>false</code> otherwise
	 */
	public void setOutline(boolean i_outline) {

		m_outline = i_outline;
	}

	/**
	 * Sets the outline color.
	 * 
	 * @param i_color the outline color
	 * @param i_alpha the alpha value
	 */
	public void setOutlineColor(Color i_color) {

		m_outlineColor = i_color;
	}

	/**
	 * Sets the id of the texture to render on the front face. If the given id
	 * is <code>null</code>, no texture is rendered.
	 * 
	 * @param i_textureId the texture id
	 */
	public void setTextureId(Integer i_textureId) {

		m_textureId = i_textureId;
	}
}
