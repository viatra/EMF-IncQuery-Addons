/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthias Thiele - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.graphics3d.lwjgl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw3d.geometry.IMatrix4f;
import org.eclipse.draw3d.geometry.IPosition3D;
import org.eclipse.draw3d.geometry.IVector2f;
import org.eclipse.draw3d.geometry.Vector2fImpl;
import org.eclipse.draw3d.graphics.optimizer.PrimitiveSet;
import org.eclipse.draw3d.graphics.optimizer.RecordingGraphics;
import org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass;
import org.eclipse.draw3d.graphics.optimizer.primitive.PolygonPrimitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.Primitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.RenderRule;
import org.eclipse.draw3d.graphics.optimizer.primitive.SolidRenderRule;
import org.eclipse.draw3d.graphics.optimizer.primitive.TextPrimitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.TextRenderRule;
import org.eclipse.draw3d.graphics3d.AbstractGraphics3DDraw;
import org.eclipse.draw3d.graphics3d.DisplayListManager;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.Graphics3DDescriptor;
import org.eclipse.draw3d.graphics3d.Graphics3DException;
import org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBufferConfig;
import org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBuffers;
import org.eclipse.draw3d.graphics3d.ILodHelper;
import org.eclipse.draw3d.graphics3d.RenderImage;
import org.eclipse.draw3d.graphics3d.lwjgl.font.GLFontKey;
import org.eclipse.draw3d.graphics3d.lwjgl.font.LwjglFont;
import org.eclipse.draw3d.graphics3d.lwjgl.font.LwjglFontManager;
import org.eclipse.draw3d.graphics3d.lwjgl.font.LwjglVectorFont;
import org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglGradientQuadVBO;
import org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglImageVBO;
import org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglLineVBO;
import org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglPolygonVBO;
import org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglPolylineVBO;
import org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglPrimitiveClassifier;
import org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglQuadVBO;
import org.eclipse.draw3d.graphics3d.lwjgl.offscreen.LwjglOffscreenBackBuffers;
import org.eclipse.draw3d.graphics3d.lwjgl.offscreen.LwjglOffscreenBufferConfig;
import org.eclipse.draw3d.graphics3d.lwjgl.offscreen.LwjglOffscreenBuffersFbo;
import org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTextureFbo;
import org.eclipse.draw3d.graphics3d.lwjgl.texture.LwjglTextureManager;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.draw3d.util.LogGraphics;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.opengl.GLCanvas;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.GLUtessellator;
import org.lwjgl.util.glu.GLUtessellatorCallback;

/**
 * Graphics3DLwjgl is the implementor of the Graphics3D interface for the LWJGL
 * renderer. <h3>OpenGL Notes</h3> glMultMatrix(FloatBuffer) is replaced with
 * setPosition(Object).
 * 
 * @author Matthias Thiele
 * @version $Revision$
 * @since 06.12.2008
 */
public class Graphics3DLwjgl extends AbstractGraphics3DDraw implements
		Graphics3D {
	/**
	 * @todo We have to find a better mechanism for ensuring 2D content to be
	 *       placed on top of surface plane
	 */
	private static final float OFFSET_2DCONTENT_SURFACE = -0.2f;

	private static class PolygonTesselator implements GLUtessellatorCallback {

		private int m_currentType;

		private List<IVector2f> m_currentVertices = new LinkedList<IVector2f>();

		private LwjglPolygonVBO m_lineLoops;

		private RenderRule m_renderRule;

		private LwjglPolygonVBO m_triangleFans;

		private LwjglPolygonVBO m_triangleSets;

		private LwjglPolygonVBO m_triangleStrips;

		public PolygonTesselator(RenderRule i_renderRule) {

			if (i_renderRule == null)
				throw new NullPointerException("i_renderRule must not be null");

			m_renderRule = i_renderRule;
		}

		public void addVBOs(List<RenderImage> i_vbos) {

			if (m_lineLoops != null)
				i_vbos.add(m_lineLoops);

			if (m_triangleFans != null)
				i_vbos.add(m_triangleFans);

			if (m_triangleSets != null)
				i_vbos.add(m_triangleSets);

			if (m_triangleStrips != null)
				i_vbos.add(m_triangleStrips);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.lwjgl.util.glu.GLUtessellatorCallback#begin(int)
		 */
		public void begin(int i_type) {

			m_currentType = i_type;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.lwjgl.util.glu.GLUtessellatorCallback#beginData(int,
		 *      java.lang.Object)
		 */
		public void beginData(int i_type, Object i_polygonData) {

			throw new UnsupportedOperationException();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.lwjgl.util.glu.GLUtessellatorCallback#combine(double[],
		 *      java.lang.Object[], float[], java.lang.Object[])
		 */
		public void combine(double[] i_coords, Object[] i_data,
			float[] i_weight, Object[] i_outData) {

			IVector2f v =
				new Vector2fImpl((float) i_coords[0], (float) i_coords[1]);

			i_outData[0] = v;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.lwjgl.util.glu.GLUtessellatorCallback#combineData(double[],
		 *      java.lang.Object[], float[], java.lang.Object[],
		 *      java.lang.Object)
		 */
		public void combineData(double[] i_coords, Object[] i_data,
			float[] i_weight, Object[] i_outData, Object i_polygonData) {

			throw new UnsupportedOperationException();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.lwjgl.util.glu.GLUtessellatorCallback#edgeFlag(boolean)
		 */
		public void edgeFlag(boolean i_boundaryEdge) {

			throw new UnsupportedOperationException();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.lwjgl.util.glu.GLUtessellatorCallback#edgeFlagData(boolean,
		 *      java.lang.Object)
		 */
		public void edgeFlagData(boolean i_boundaryEdge, Object i_polygonData) {

			throw new UnsupportedOperationException();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.lwjgl.util.glu.GLUtessellatorCallback#end()
		 */
		public void end() {

			switch (m_currentType) {
			case GL11.GL_TRIANGLE_FAN:
				if (m_triangleFans == null)
					m_triangleFans =
						new LwjglPolygonVBO(m_currentType, m_renderRule);

				m_triangleFans.addPolygon(m_currentVertices);
				break;
			case GL11.GL_TRIANGLE_STRIP:
				if (m_triangleStrips == null)
					m_triangleStrips =
						new LwjglPolygonVBO(m_currentType, m_renderRule);

				m_triangleStrips.addPolygon(m_currentVertices);
				break;
			case GL11.GL_TRIANGLES:
				if (m_triangleSets == null)
					m_triangleSets =
						new LwjglPolygonVBO(m_currentType, m_renderRule);

				m_triangleSets.addPolygon(m_currentVertices);
				break;
			case GL11.GL_LINE_LOOP:
				if (m_lineLoops == null)
					m_lineLoops =
						new LwjglPolygonVBO(m_currentType, m_renderRule);

				m_lineLoops.addPolygon(m_currentVertices);
				break;

			default:
				throw new IllegalStateException("unknown polygon type: "
					+ m_currentType);
			}

			m_currentVertices.clear();
			m_currentType = 0;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.lwjgl.util.glu.GLUtessellatorCallback#endData(java.lang.Object)
		 */
		public void endData(Object i_polygonData) {

			throw new UnsupportedOperationException();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.lwjgl.util.glu.GLUtessellatorCallback#error(int)
		 */
		public void error(int i_errnum) {

			throw new RuntimeException("error during polygon tesselation: "
				+ i_errnum);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.lwjgl.util.glu.GLUtessellatorCallback#errorData(int,
		 *      java.lang.Object)
		 */
		public void errorData(int i_errnum, Object i_polygonData) {

			throw new RuntimeException(
				"error during polygon tesselation of polygon " + i_polygonData
					+ ": " + i_errnum);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.lwjgl.util.glu.GLUtessellatorCallback#vertex(java.lang.Object)
		 */
		public void vertex(Object i_vertexData) {

			IVector2f v = (IVector2f) i_vertexData;
			m_currentVertices.add(v);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.lwjgl.util.glu.GLUtessellatorCallback#vertexData(java.lang.Object,
		 *      java.lang.Object)
		 */
		public void vertexData(Object i_vertexData, Object i_polygonData) {

			throw new UnsupportedOperationException();
		}
	}

	
	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(Graphics3DLwjgl.class.getName());

	/**
	 * Translation offset for 2D rendering of non-polygon shapes.
	 */
	public static final float RASTER_OFFSET = 0f; // 0.49f;

	/**
	 * Descriptor of this instance.
	 */
	protected Graphics3DDescriptor descriptor;

	/** Cashed hash code */
	final int hashCode;

	private Graphics m_activeGraphics;

	/**
	 * The GL context of this instance.
	 */
	public GLCanvas m_context = null;

	private DisplayListManager m_displayListManager = null;

	private LwjglFontManager m_fontManager;

	private boolean m_log2D;

	private GLUtessellator m_tesselator;

	/**
	 * The texture manager handles OpenGL texture as GL's mechanism to render 2D
	 * content. It is lazily created in
	 * {@link #activateGraphics2D(Object, int, int, int, Color)}.
	 */
	private LwjglTextureManager m_textureManager = null;

	private Map<GLFontKey, LwjglVectorFont> m_vectorFonts =
		new HashMap<GLFontKey, LwjglVectorFont>();

	Properties properties = new Properties();

	static Boolean checked = null;

	/**
	 * Standard constructor.
	 */
	public Graphics3DLwjgl() {
		super();

		hashCode = super.hashCode();

		if (log.isLoggable(Level.INFO)) {
			log.info("Graphics3DLwjgl constructor called"); //$NON-NLS-1$
		}
	}

	void check() {
		if (checked == null) {
			checked = false;

			try {
				m_context.setCurrent();
				GLContext.useContext(m_context);
				ContextCapabilities caps = GLContext.getCapabilities();

				// at least openGL 1.5:
				float version = openGLVersions(caps);
				if (version < 1.5f) {
					throw new Graphics3DException(
						"Need at least OpenGL version 1.5, found only "
							+ version);
				}

				//
				checked = true;
			} catch (LWJGLException ex) {
				throw new Graphics3DException(
					"Cannot retrieve OpenGL capabilies, error creating LWJGL display",
					ex);
			} 
		}
	}

	static float openGLVersions(ContextCapabilities caps) {
		float v = 0.0f;
		if (caps.OpenGL11)
			v = 1.1f;
		if (caps.OpenGL12)
			v = 1.2f;
		if (caps.OpenGL13)
			v = 1.3f;
		if (caps.OpenGL14)
			v = 1.4f;
		if (caps.OpenGL15)
			v = 1.5f;
		if (caps.OpenGL20)
			v = 2.0f;
		if (caps.OpenGL21)
			v = 2.1f;
		if (caps.OpenGL30)
			v = 3.0f;
		if (caps.OpenGL31)
			v = 3.1f;
		if (caps.OpenGL32)
			v = 3.2f;
		/**
		 * Only available as of LWJGL version 2.6:
		 */
		// if (caps.OpenGL33)
		// v = 3.3f;
		// if (caps.OpenGL40)
		// v = 4.0f;
		// if (caps.OpenGL41)
		// v = 4.1f;

		return v;
	}

	private IPosition3D m_current2DPosition;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3D#activateGraphics2D(Object,
	 *      int, int)
	 */
	public Graphics begin2DRendering(Object i_key, IPosition3D i_position,
		int i_width, int i_height) {

		// log.info("activating 2D graphics");

		m_activeGraphics =
			new RecordingGraphics(new LwjglPrimitiveClassifier());

		m_current2DPosition = i_position;

		// graphics.disableClipping();
		//
		// String fontAntialias = getProperty(PROP_FONT_AA);
		// if (fontAntialias != null)
		// graphics.setOverrideTextAntialias(Boolean.valueOf(fontAntialias));
		// else
		// graphics.setOverrideTextAntialias(null);
		//
		// // save all state variables that may be changed by the graphics
		// object
		// GL11.glPushAttrib(ATTRIB_MASK);
		//
		// GL11.glMatrixMode(GL11.GL_MODELVIEW);
		// GL11.glPushMatrix();
		//
		// Matrix4f m = Draw3DCache.getMatrix4f();
		// Vector3f t = Draw3DCache.getVector3f();
		// try {
		// t.set(0, 0, 0.001f);
		// m.set(i_position.getRotationLocationMatrix());
		// Math3D.translate(m, t, m);
		// setMatrix(m);
		// } finally {
		// Draw3DCache.returnVector3f(t);
		// Draw3DCache.returnMatrix4f(m);
		// }
		//
		// GL11.glShadeModel(GL11.GL_FLAT);
		// GL11.glDisable(GL11.GL_DEPTH_TEST);
		// // GL11.glDepthFunc(GL11.GL_LEQUAL);
		// // GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ZERO);
		// GL11.glDisable(GL11.GL_CULL_FACE);
		// GL11.glHint(GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST);
		// GL11.glEnable(GL11.GL_LINE_SMOOTH);

		if (m_log2D)
			return new LogGraphics(m_activeGraphics);

		return m_activeGraphics;
	}

	private LwjglVectorFont getVectorFont(
		org.eclipse.swt.graphics.Font i_swtFont, char i_startChar,
		char i_endChar, boolean i_antialias) {

		GLFontKey key =
			new GLFontKey(i_swtFont, i_startChar, i_endChar, i_antialias);
		LwjglVectorFont vectorFont = m_vectorFonts.get(key);
		if (vectorFont == null) {
			vectorFont =
				new LwjglVectorFont(i_swtFont, i_startChar, i_endChar,
					i_antialias);
			vectorFont.initialize();
			m_vectorFonts.put(key, vectorFont);
		}

		return vectorFont;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3D#deactivateGraphics2D()
	 */
	public RenderImage deactivateGraphics2D() {
		if (m_activeGraphics instanceof RecordingGraphics) {
			RecordingGraphics og = (RecordingGraphics) m_activeGraphics;
			List<PrimitiveSet> primiveSets = og.getPrimiveSets();
			final List<RenderImage> vbos = new LinkedList<RenderImage>();

			for (PrimitiveSet set : primiveSets) {
				PrimitiveClass clazz = set.getPrimitiveClass();
				if (clazz.isPolygon()) {
					tesselate(set, vbos);
				} else if (clazz.isQuad()) {
					if (clazz.isGradient())
						vbos.add(new LwjglGradientQuadVBO(set));
					else if (clazz.isImage())
						vbos.add(new LwjglImageVBO(set));
					else
						vbos.add(new LwjglQuadVBO(set));
				} else if (clazz.isPolyline()) {
					vbos.add(new LwjglPolylineVBO(set));
				} else if (clazz.isLine()) {
					vbos.add(new LwjglLineVBO(set));
				} else if (clazz.isText()) {
					TextRenderRule textRule = clazz.getRenderRule().asText();
					LwjglVectorFont vectorFont =
						getVectorFont(textRule.getFont(), (char) 32,
							(char) 127, true);
					LwjglFont textureFont =
						getFontManager().getFont(textRule.getFont(), (char) 32,
							(char) 127, true);

					final List<TextRenderImage> textImages =
						new LinkedList<TextRenderImage>();

					for (Primitive primitive : set.getPrimitives()) {
						TextPrimitive text = (TextPrimitive) primitive;
						textImages.add(new TextRenderImage(text, vectorFont,
							textureFont, m_current2DPosition));
					}

					vbos.add(new RenderImage() {
						public void dispose() {

							for (TextRenderImage image : textImages)
								image.dispose();

							textImages.clear();
						}

						public void initialize(Graphics3D i_g3d) {

							for (TextRenderImage image : textImages)
								image.initialize(i_g3d);
						}

						public void render(Graphics3D i_g3d,
							ILodHelper i_lodHelper) {

							for (TextRenderImage image : textImages)
								image.render(i_g3d, i_lodHelper);
						}
					});
					// vbos.add(new LwjglTextVBO(set, getFontManager()));
					// generateVectorText(set, vbos);
				} else {
					throw new AssertionError("unknown primitive class: "
						+ clazz);
				}
			}

			m_current2DPosition = null;

			return new RenderImage() {

				public void dispose() {

					for (RenderImage vbo : vbos)
						vbo.dispose();
				}

				public void initialize(Graphics3D i_g3d) {

					for (RenderImage vbo : vbos)
						vbo.initialize(i_g3d);
				}

				public void render(Graphics3D i_g3d, ILodHelper i_lodContext) {

					GL11.glMatrixMode(GL11.GL_MODELVIEW);
					GL11.glPushMatrix();
					try {
						for (RenderImage vbo : vbos) {
							glTranslatef(0, 0, OFFSET_2DCONTENT_SURFACE);
							vbo.render(i_g3d, i_lodContext);
						}
					} finally {
						GL11.glPopMatrix();
					}
				}
			};
		}

		return null;

		// GL11.glPopMatrix();
		// GL11.glPopAttrib();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3D#dispose()
	 */
	public void dispose() {
		
		try {
			if (m_textureManager != null)
				m_textureManager.dispose();
			if (m_fontManager != null)
				m_fontManager.dispose();
			if (m_displayListManager != null)
				m_displayListManager.dispose();
			if (m_tesselator != null)
				m_tesselator.gluDeleteTess();
			if (m_vectorFonts != null) {
				for (LwjglVectorFont font : m_vectorFonts.values())
					font.dispose();
				m_vectorFonts.clear();
				m_vectorFonts = null;
			}
		} catch (Exception ex) {
			log.warning("Error disposing texture manager: " + ex);
		}
	}

	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3D#getDescriptor()
	 */
	public Graphics3DDescriptor getDescriptor() {
		return descriptor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3D#getDisplayListManager()
	 */
	public DisplayListManager getDisplayListManager() {

		if (m_displayListManager == null)
			m_displayListManager = new DisplayListManager(this);

		return m_displayListManager;
	}

	private LwjglFontManager getFontManager() {

		if (m_fontManager == null)
			m_fontManager = new LwjglFontManager(getDisplayListManager());

		return m_fontManager;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3D#getGraphics3DId()
	 */
	public int getGraphics2DId(Object i_key) {

		LwjglTextureManager textureManager = getTextureManager();
		return textureManager.getTextureId(i_key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3D#getGraphics3DOffscreenBuffer(int,
	 *      int, org.eclipse.draw3d.graphics3d.Graphics3DOffscreenBufferConfig)
	 */
	public Graphics3DOffscreenBuffers getGraphics3DOffscreenBuffer(
		int i_height, int i_width,
		Graphics3DOffscreenBufferConfig i_bufferConfig) {
		if (LwjglTextureFbo.isSuppported()) {
			return new LwjglOffscreenBuffersFbo(i_height, i_width,
				i_bufferConfig);
		} else {
			return new LwjglOffscreenBackBuffers(i_height, i_width,
				i_bufferConfig);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3D#getGraphics3DOffscreenBufferConfig(int,
	 *      int[])
	 */
	public Graphics3DOffscreenBufferConfig getGraphics3DOffscreenBufferConfig(
		int i_buffers, int... i_args) {
		return new LwjglOffscreenBufferConfig(this, i_buffers, i_args);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3D#getID()
	 */
	public String getID() {
		return Graphics3DLwjgl.class.getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#getPlatform()
	 */
	public int getPlatform() {
		return org.lwjgl.LWJGLUtil.getPlatform();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3D#getProperty(java.lang.String)
	 */
	public String getProperty(String i_key) {
		return properties.getProperty(i_key);
	}

	private LwjglTextureManager getTextureManager() {

		if (m_textureManager == null)
			m_textureManager =
				new LwjglTextureManager(m_context, getDisplayListManager(),
					getFontManager());
		else if (m_textureManager.isDisposed())
			throw new IllegalStateException("TextureManager is disposed");

		return m_textureManager;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glBegin(int)
	 */
	public void glBegin(int mode) {
		org.lwjgl.opengl.GL11.glBegin(mode);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glBindTexture(int, int)
	 */
	public void glBindTexture(int target, int texture) {
		org.lwjgl.opengl.GL11.glBindTexture(target, texture);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glBlendFunc(int, int)
	 */
	public void glBlendFunc(int sfactor, int dfactor) {
		org.lwjgl.opengl.GL11.glBlendFunc(sfactor, dfactor);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glCallList(int)
	 */
	public void glCallList(int list) {
		org.lwjgl.opengl.GL11.glCallList(list);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glClear(int)
	 */
	public void glClear(int mask) {
		org.lwjgl.opengl.GL11.glClear(mask);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glClearColor(float,
	 *      float, float, float)
	 */
	public void glClearColor(float red, float green, float blue, float alpha) {
		org.lwjgl.opengl.GL11.glClearColor(red, green, blue, alpha);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glClearDepth(double)
	 */
	public void glClearDepth(double depth) {
		org.lwjgl.opengl.GL11.glClearDepth(depth);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glColor3f(float, float,
	 *      float)
	 */
	public void glColor3f(float red, float green, float blue) {
		org.lwjgl.opengl.GL11.glColor3f(red, green, blue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glColor4f(float, float,
	 *      float, float)
	 */
	public void glColor4f(float red, float green, float blue, float alpha) {
		org.lwjgl.opengl.GL11.glColor4f(red, green, blue, alpha);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glDeleteLists(int, int)
	 */
	public void glDeleteLists(int list, int range) {
		org.lwjgl.opengl.GL11.glDeleteLists(list, range);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glDisable(int)
	 */
	public void glDisable(int cap) {
		org.lwjgl.opengl.GL11.glDisable(cap);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glEnable(int)
	 */
	public void glEnable(int cap) {
		org.lwjgl.opengl.GL11.glEnable(cap);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glEnd()
	 */
	public void glEnd() {
		org.lwjgl.opengl.GL11.glEnd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glEndList()
	 */
	public void glEndList() {
		org.lwjgl.opengl.GL11.glEndList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glFinish()
	 */
	public void glFinish() {
		org.lwjgl.opengl.GL11.glFinish();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glFlush()
	 */
	public void glFlush() {
		org.lwjgl.opengl.GL11.glFlush();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glGenLists(int)
	 */
	public int glGenLists(int range) {
		return org.lwjgl.opengl.GL11.glGenLists(range);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glGetFloat(int,
	 *      java.nio.FloatBuffer)
	 */
	public void glGetFloat(int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL11.glGetFloat(pname, params);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glGetInteger(int,
	 *      java.nio.IntBuffer)
	 */
	public void glGetInteger(int pname, IntBuffer params) {
		org.lwjgl.opengl.GL11.glGetInteger(pname, params);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glGetString(int)
	 */
	public String glGetString(int name) {
		return org.lwjgl.opengl.GL11.glGetString(name);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glHint(int, int)
	 */
	public void glHint(int target, int mode) {
		org.lwjgl.opengl.GL11.glHint(target, mode);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glIsEnabled(int)
	 */
	public boolean glIsEnabled(int cap) {
		return org.lwjgl.opengl.GL11.glIsEnabled(cap);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glLineStipple(int,
	 *      short)
	 */
	public void glLineStipple(int factor, short pattern) {
		org.lwjgl.opengl.GL11.glLineStipple(factor, pattern);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glLineWidth(float)
	 */
	public void glLineWidth(float width) {
		org.lwjgl.opengl.GL11.glLineWidth(width);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glLoadIdentity()
	 */
	public void glLoadIdentity() {
		org.lwjgl.opengl.GL11.glLoadIdentity();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glMatrixMode(int)
	 */
	public void glMatrixMode(int mode) {
		org.lwjgl.opengl.GL11.glMatrixMode(mode);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glNewList(int, int)
	 */
	public void glNewList(int list, int mode) {
		org.lwjgl.opengl.GL11.glNewList(list, mode);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glNormal3f(float,
	 *      float, float)
	 */
	public void glNormal3f(float nx, float ny, float nz) {
		org.lwjgl.opengl.GL11.glNormal3f(nx, ny, nz);
	}

	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glPixelStorei(int, int)
	 */
	public void glPixelStorei(int pname, int param) {
		org.lwjgl.opengl.GL11.glPixelStorei(pname, param);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glPointSize(float)
	 */
	public void glPointSize(float size) {
		org.lwjgl.opengl.GL11.glPointSize(size);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glPolygonMode(int, int)
	 */
	public void glPolygonMode(int face, int mode) {
		org.lwjgl.opengl.GL11.glPolygonMode(face, mode);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glPopMatrix()
	 */
	public void glPopMatrix() {
		org.lwjgl.opengl.GL11.glPopMatrix();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glPushMatrix()
	 */
	public void glPushMatrix() {
		org.lwjgl.opengl.GL11.glPushMatrix();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glShadeModel(int)
	 */
	public void glShadeModel(int mode) {
		org.lwjgl.opengl.GL11.glShadeModel(mode);

		// org.lwjgl.opengl.GL11.glEnable(org.lwjgl.opengl.GL11.GL_LIGHTING);
		// org.lwjgl.opengl.GL11.glEnable(org.lwjgl.opengl.GL11.GL_LIGHT0);
		//
		// org.lwjgl.opengl.GL11.glColorMaterial(
		// org.lwjgl.opengl.GL11.GL_FRONT_AND_BACK,
		// org.lwjgl.opengl.GL11.GL_AMBIENT_AND_DIFFUSE); // GL_EMISSION ) ;
		// org.lwjgl.opengl.GL11.glEnable(org.lwjgl.opengl.GL11.GL_COLOR_MATERIAL);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glTexCoord2f(float,
	 *      float)
	 */
	public void glTexCoord2f(float s, float t) {
		org.lwjgl.opengl.GL11.glTexCoord2f(s, t);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glTexEnvi(int, int,
	 *      int)
	 */
	public void glTexEnvi(int target, int pname, int param) {
		org.lwjgl.opengl.GL11.glTexEnvi(target, pname, param);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glTranslatef(float,
	 *      float, infloatt)
	 */
	public void glTranslatef(float x, float y, float z) {
		org.lwjgl.opengl.GL11.glTranslatef(x, y, z);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DUtil#gluLookAt(float, float,
	 *      float, float, float, float, float, float, float)
	 */
	public void gluLookAt(float eyex, float eyey, float eyez, float centerx,
		float centery, float centerz, float upx, float upy, float upz) {
		org.lwjgl.util.glu.GLU.gluLookAt(eyex, eyey, eyez, centerx, centery,
			centerz, upx, upy, upz);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DUtil#gluOrtho2D(int, int,
	 *      int, int)
	 */
	public void gluOrtho2D(int left, int right, int bottom, int top) {
		org.lwjgl.util.glu.GLU.gluOrtho2D(left, right, bottom, top);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DUtil#gluPerspective(int,
	 *      float, int, int)
	 */
	public void gluPerspective(int fovy, float aspect, int zNear, int zFar) {
		org.lwjgl.util.glu.GLU.gluPerspective(fovy, aspect, zNear, zFar);
	}

//	/**
//	 * {@inheritDoc}
//	 * 
//	 * @see org.eclipse.draw3d.graphics3d.Graphics3DUtil#gluUnProject(int, int,
//	 *      float, java.nio.FloatBuffer, java.nio.FloatBuffer,
//	 *      java.nio.IntBuffer, java.nio.FloatBuffer)
//	 */
//	public void gluUnProject(int winx, int winy, float winz,
//		FloatBuffer modelMatrix, FloatBuffer projMatrix, IntBuffer viewport,
//		FloatBuffer obj_pos) {
//		org.lwjgl.util.glu.GLU.gluUnProject(winx, winy, winz, modelMatrix,
//			projMatrix, viewport, obj_pos);
//	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glVertex2f(float,
	 *      float)
	 */
	public void glVertex2f(float x, float y) {
		org.lwjgl.opengl.GL11.glVertex2f(x, y);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glVertex3f(float,
	 *      float, float)
	 */
	public void glVertex3f(float x, float y, float z) {
		org.lwjgl.opengl.GL11.glVertex3f(x, y, z);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#glViewport(int, int,
	 *      int, int)
	 */
	public void glViewport(int x, int y, int width, int height) {
		org.lwjgl.opengl.GL11.glViewport(x, y, width, height);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3D#hasGraphics2D(java.lang.Object)
	 */
	public boolean hasGraphics2D(Object i_key) {

		LwjglTextureManager textureManager = getTextureManager();
		return textureManager.contains(i_key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return hashCode;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3D#setDescriptor(org.eclipse.draw3d.graphics3d.Graphics3DDescriptor)
	 */
	public void setDescriptor(Graphics3DDescriptor i_graphics3DDescriptor) {
		descriptor = i_graphics3DDescriptor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3D#setGLCanvas(org.eclipse.swt.opengl.GLCanvas)
	 */
	public void setGLCanvas(GLCanvas i_canvas) {

		if (m_textureManager != null) {
			throw new IllegalStateException(
				"Texture manager already initialized, cannot set new canvas");
		}

		m_context = i_canvas;
		check();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3D#setLog2D(boolean)
	 */
	public void setLog2D(boolean i_log2D) {

		m_log2D = i_log2D;
	}

	private void setMatrix(IMatrix4f i_matrix) {

		FloatBuffer buffer = Draw3DCache.getFloatBuffer(16);
		try {
			buffer.rewind();
			i_matrix.toBufferRowMajor(buffer);
			buffer.rewind();
			org.lwjgl.opengl.GL11.glMultMatrix(buffer);
		} finally {
			Draw3DCache.returnFloatBuffer(buffer);
		}
	}

	/**
	 * Sets the position.
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#setPosition(IPosition3D)
	 */
	public void setPosition(IPosition3D i_position) {

		setMatrix(i_position.getTransformationMatrix());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3D#setProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	public void setProperty(String key, String value) {

		if (value != null)
			properties.setProperty(key, value);
		else
			properties.remove(key);
	}

	private void tesselate(float[] i_vertices) {

		m_tesselator.gluTessBeginPolygon(i_vertices);
		m_tesselator.gluTessNormal(0, 0, -1);
		m_tesselator.gluTessBeginContour();

		double[] coords = new double[3];
		coords[2] = 0;

		float x, y;

		for (int i = 0; i < i_vertices.length / 2; i++) {
			x = i_vertices[2 * i];
			y = i_vertices[2 * i + 1];

			coords[0] = x;
			coords[1] = y;

			IVector2f v = new Vector2fImpl(x, y);
			m_tesselator.gluTessVertex(coords, 0, v);
		}

		m_tesselator.gluTessEndContour();
		m_tesselator.gluTessEndPolygon();
	}

	/**
	 * @param i_set
	 * @param i_vbos
	 */
	private void tesselate(PrimitiveSet i_set, List<RenderImage> i_vbos) {

		if (m_tesselator == null)
			m_tesselator = GLU.gluNewTess();

		RenderRule renderRule = i_set.getPrimitiveClass().getRenderRule();
		PolygonTesselator callback = new PolygonTesselator(renderRule);

		// bug in LWJGL, must set edge flag callback to null before setting
		// begin callback
		m_tesselator.gluTessCallback(GLU.GLU_TESS_EDGE_FLAG, null);
		m_tesselator.gluTessCallback(GLU.GLU_TESS_EDGE_FLAG_DATA, null);
		m_tesselator.gluTessCallback(GLU.GLU_TESS_BEGIN, callback);
		m_tesselator.gluTessCallback(GLU.GLU_TESS_BEGIN_DATA, null);
		m_tesselator.gluTessCallback(GLU.GLU_TESS_VERTEX, callback);
		m_tesselator.gluTessCallback(GLU.GLU_TESS_VERTEX_DATA, null);
		m_tesselator.gluTessCallback(GLU.GLU_TESS_COMBINE, callback);
		m_tesselator.gluTessCallback(GLU.GLU_TESS_COMBINE_DATA, null);
		m_tesselator.gluTessCallback(GLU.GLU_TESS_END, callback);
		m_tesselator.gluTessCallback(GLU.GLU_TESS_END_DATA, null);
		m_tesselator.gluTessCallback(GLU.GLU_TESS_ERROR, null);
		m_tesselator.gluTessCallback(GLU.GLU_TESS_ERROR_DATA, callback);

		m_tesselator.gluTessProperty(GLU.GLU_TESS_TOLERANCE, 0);

		if (renderRule.isOutline()) {
			m_tesselator.gluTessProperty(GLU.GLU_TESS_BOUNDARY_ONLY, 1);
			m_tesselator.gluTessProperty(GLU.GLU_TESS_WINDING_RULE,
				GLU.GLU_TESS_WINDING_ODD);
		} else if (renderRule.isSolid()) {
			SolidRenderRule solid = renderRule.asSolid();

			m_tesselator.gluTessProperty(GLU.GLU_TESS_BOUNDARY_ONLY, 0);
			m_tesselator.gluTessProperty(GLU.GLU_TESS_WINDING_RULE, solid
				.getFillRule() == SWT.FILL_EVEN_ODD ? GLU.GLU_TESS_WINDING_ODD
				: GLU.GLU_TESS_WINDING_NONZERO);
		}

		for (Primitive primitive : i_set.getPrimitives()) {
			PolygonPrimitive polygon = (PolygonPrimitive) primitive;
			tesselate(polygon.getVertices());
		}

		callback.addVBOs(i_vbos);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.Graphics3DDraw#useContext(Object)
	 */
	public void useContext(Object context) throws Graphics3DException {
		try {
			GLContext.useContext(context);
		} catch (LWJGLException ex) {
			throw new Graphics3DException(ex);
		}
	}
}
