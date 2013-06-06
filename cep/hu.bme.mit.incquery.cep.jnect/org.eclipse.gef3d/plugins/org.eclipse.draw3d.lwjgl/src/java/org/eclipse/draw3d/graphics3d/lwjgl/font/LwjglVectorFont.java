/*******************************************************************************
 * Copyright (c) 2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.graphics3d.lwjgl.font;

import static java.awt.geom.PathIterator.SEG_CLOSE;
import static java.awt.geom.PathIterator.SEG_LINETO;
import static java.awt.geom.PathIterator.SEG_MOVETO;

import java.awt.Font;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphMetrics;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.logging.Logger;

import org.eclipse.draw3d.geometry.IVector2f;
import org.eclipse.draw3d.geometry.Vector2fImpl;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.swt.SWT;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.GLUtessellator;
import org.lwjgl.util.glu.GLUtessellatorCallbackAdapter;

/**
 * VectorFont There should really be more documentation here.
 * 
 * Here, at least OpenGL 1.5 is required due to call to 
 * {@link GL15#glGenBuffers()} and others.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 22.01.2010
 */
public class LwjglVectorFont {
	/**
	 * Logger for this class
	 */
	@SuppressWarnings("unused") //$NON-NLS-1$
	private static final Logger log = Logger.getLogger(LwjglVectorFont.class.getName());

	private static class FontCallback extends GLUtessellatorCallbackAdapter {

		private int m_currentType = 0;

		private int m_currentVertexCount = 0;

		private float[] m_currentVertices = new float[32];

		private int m_primCount = 0;

		private int[] m_types = new int[4];

		private float[][] m_vertices = new float[4][];

		/**
		 * 
		 */
		public FontCallback() {
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.lwjgl.util.glu.GLUtessellatorCallbackAdapter#begin(int)
		 */
		@Override
		public void begin(int i_type) {

			m_currentType = i_type;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.lwjgl.util.glu.GLUtessellatorCallbackAdapter#combine(double[],
		 *      java.lang.Object[], float[], java.lang.Object[])
		 */
		@Override
		public void combine(double[] i_coords, Object[] i_data,
			float[] i_weight, Object[] i_outData) {

			i_outData[0] =
				new Vector2fImpl((float) i_coords[0], (float) i_coords[1]);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.lwjgl.util.glu.GLUtessellatorCallbackAdapter#end()
		 */
		@Override
		public void end() {

			if (m_primCount == m_vertices.length) {
				float[][] temp = m_vertices;
				m_vertices = new float[2 * temp.length][];
				System.arraycopy(temp, 0, m_vertices, 0, temp.length);
			}

			m_vertices[m_primCount] = new float[2 * m_currentVertexCount];
			System.arraycopy(m_currentVertices, 0, m_vertices[m_primCount], 0,
				2 * m_currentVertexCount);

			if (m_primCount == m_types.length) {
				int[] temp = m_types;
				m_types = new int[2 * m_types.length];
				System.arraycopy(temp, 0, m_types, 0, temp.length);
			}

			m_types[m_primCount] = m_currentType;

			m_primCount++;
			m_currentVertexCount = 0;
			m_currentType = 0;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.lwjgl.util.glu.GLUtessellatorCallbackAdapter#error(int)
		 */
		@Override
		public void error(int i_errnum) {

			throw new RuntimeException(
				"caught error during polygon tesselation: " + i_errnum);
		}

		public int getCount() {

			return m_primCount;
		}

		public int getType(int i_index) {

			if (i_index < 0 || i_index >= m_primCount)
				throw new IndexOutOfBoundsException();

			return m_types[i_index];
		}

		public float[] getVertices(int i_index) {

			if (i_index < 0 || i_index >= m_primCount)
				throw new IndexOutOfBoundsException();

			return m_vertices[i_index];
		}

		public void reset() {

			m_primCount = 0;
			m_currentVertexCount = 0;
			m_currentType = 0;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.lwjgl.util.glu.GLUtessellatorCallbackAdapter#vertex(java.lang.Object)
		 */
		@Override
		public void vertex(Object i_vertexData) {

			if (m_currentVertexCount == m_currentVertices.length / 2) {
				float[] temp = m_currentVertices;
				m_currentVertices = new float[2 * temp.length];
				System.arraycopy(temp, 0, m_currentVertices, 0, temp.length);
			}

			IVector2f vertex = (IVector2f) i_vertexData;
			vertex.toArray(m_currentVertices, 2 * m_currentVertexCount++);
		}
	}

	private static int getAwtStyle(boolean i_bold, boolean i_italic) {

		int awtStyle = 0;
		if (i_bold)
			awtStyle |= java.awt.Font.BOLD;
		if (i_italic)
			awtStyle |= java.awt.Font.ITALIC;

		return awtStyle;
	}

	private boolean m_antialias;

	private Font m_awtFont;

	private int m_bufferId;

	private char m_endChar;

	private char m_startChar;

	public LwjglVectorFont(org.eclipse.swt.graphics.Font i_swtFont,
			char i_startChar, char i_endChar, boolean i_antialias) {

		this(i_swtFont.getFontData()[0].getName(),
			i_swtFont.getFontData()[0].getHeight(),
			(i_swtFont.getFontData()[0].getStyle() & SWT.BOLD) != 0,
			(i_swtFont.getFontData()[0].getStyle() & SWT.ITALIC) != 0,
			i_startChar, i_endChar, i_antialias);
	}

	public LwjglVectorFont(String i_name, int i_height, boolean i_bold,
			boolean i_italic, char i_startChar, char i_endChar,
			boolean i_antialias) {

		this(i_name, i_height, getAwtStyle(i_bold, i_italic), i_startChar,
			i_endChar, i_antialias);
	}

	public LwjglVectorFont(String i_name, int i_height, int i_awtStyle,
			char i_startChar, char i_endChar, boolean i_antialias) {

		if (i_name == null)
			throw new NullPointerException("i_name must not be null");

		m_awtFont = new Font(i_name, i_awtStyle, i_height);
		m_startChar = i_startChar;
		m_endChar = i_endChar;
		m_antialias = i_antialias;
	}

	public void dispose() {
		IntBuffer idBuffer = Draw3DCache.getIntBuffer(1);
		try {
			
			idBuffer.put(m_bufferId);
			idBuffer.rewind();

//			if (log.isLoggable(Level.INFO)) {
//				log.info("Delete Bufffer  - id=" + m_bufferId); //$NON-NLS-1$
//			}
			
			GL15.glDeleteBuffers(idBuffer);

			m_bufferId = 0;
		} finally {
			Draw3DCache.returnIntBuffer(idBuffer);
		}
	}

	/**
	 * 
	 * @return
	 */
	private int generateBufferId() {

		IntBuffer idBuffer = Draw3DCache.getIntBuffer(1);
		try {
			idBuffer.rewind();
			GL15.glGenBuffers(idBuffer);
			
			int id = idBuffer.get(0); 
			
//
//
//			if (log.isLoggable(Level.INFO)) {
//				log.info("Generate Buffer  - id=" + id); //$NON-NLS-1$
//			}
			
			return id;
		} finally {
			Draw3DCache.returnIntBuffer(idBuffer);
		}
	}

	public Font getAwtFont() {

		return m_awtFont;
	}

	private int m_listBaseId;
	private int m_offsetBaseId_StartChar;

	public void initialize() {

		GLUtessellator tesselator = GLU.gluNewTess();
		try {
			FontCallback callback = new FontCallback();

			// bug in LWJGL, must set edge flag callback to null before setting
			// begin callback
			tesselator.gluTessCallback(GLU.GLU_TESS_EDGE_FLAG, null);
			tesselator.gluTessCallback(GLU.GLU_TESS_EDGE_FLAG_DATA, null);
			tesselator.gluTessCallback(GLU.GLU_TESS_BEGIN, callback);
			tesselator.gluTessCallback(GLU.GLU_TESS_BEGIN_DATA, null);
			tesselator.gluTessCallback(GLU.GLU_TESS_VERTEX, callback);
			tesselator.gluTessCallback(GLU.GLU_TESS_VERTEX_DATA, null);
			tesselator.gluTessCallback(GLU.GLU_TESS_COMBINE, callback);
			tesselator.gluTessCallback(GLU.GLU_TESS_COMBINE_DATA, null);
			tesselator.gluTessCallback(GLU.GLU_TESS_END, callback);
			tesselator.gluTessCallback(GLU.GLU_TESS_END_DATA, null);
			tesselator.gluTessCallback(GLU.GLU_TESS_ERROR, callback);
			tesselator.gluTessCallback(GLU.GLU_TESS_ERROR_DATA, null);

			tesselator.gluTessProperty(GLU.GLU_TESS_TOLERANCE, 0);
			tesselator.gluTessProperty(GLU.GLU_TESS_BOUNDARY_ONLY, 0);

			tesselator.gluTessNormal(0, 0, -1);

			int charCount = m_endChar - m_startChar + 1;
			char[] chars = new char[charCount];
			for (int i = 0; i < charCount; i++)
				chars[i] = (char) (m_startChar + i);

			float[][][] vertices = new float[charCount][][];
			int[][] indices = new int[charCount][];
			int[][] lengths = new int[charCount][];
			int[][] types = new int[charCount][];
			float[] advances = new float[charCount];

			FontRenderContext ctx =
				new FontRenderContext(null, m_antialias, true);
			GlyphVector glyphs = m_awtFont.createGlyphVector(ctx, chars);

			int totalVertexCount = 0;
			double[] coords = new double[] { 0, 0, 0 };

			AffineTransform af = new AffineTransform();
			af.translate(0, m_awtFont.getSize());

			for (int i = 0; i < charCount; i++) {
				Shape outline = glyphs.getGlyphOutline(i);
				PathIterator path = outline.getPathIterator(af, 0.01d);

				if (!path.isDone()) {
					if (path.getWindingRule() == PathIterator.WIND_EVEN_ODD)
						tesselator.gluTessProperty(GLU.GLU_TESS_WINDING_RULE,
							GLU.GLU_TESS_WINDING_ODD);
					else if (path.getWindingRule() == PathIterator.WIND_NON_ZERO)
						tesselator.gluTessProperty(GLU.GLU_TESS_WINDING_RULE,
							GLU.GLU_TESS_WINDING_NONZERO);

					tesselator.gluTessBeginPolygon(chars[i]);
					while (!path.isDone()) {
						int segmentType = path.currentSegment(coords);

						switch (segmentType) {
						case SEG_MOVETO:
							tesselator.gluTessBeginContour();
							tesselator.gluTessVertex(coords, 0,
								new Vector2fImpl((float) coords[0],
									(float) coords[1]));
							break;
						case SEG_CLOSE:
							tesselator.gluTessEndContour();
							break;
						case SEG_LINETO:
							tesselator.gluTessVertex(coords, 0,
								new Vector2fImpl((float) coords[0],
									(float) coords[1]));
							break;
						}
						path.next();
					}
					tesselator.gluTessEndPolygon();

					int count = callback.getCount();
					vertices[i] = new float[count][];
					types[i] = new int[count];
					lengths[i] = new int[count];
					indices[i] = new int[count];

					for (int j = 0; j < count; j++) {
						vertices[i][j] = callback.getVertices(j);
						types[i][j] = callback.getType(j);
						indices[i][j] = totalVertexCount;
						lengths[i][j] = vertices[i][j].length / 2;

						totalVertexCount += lengths[i][j];
					}
					callback.reset();
				}

				GlyphMetrics metrics = glyphs.getGlyphMetrics(i);
				advances[i] = metrics.getAdvanceX();

				af.translate(-advances[i], 0);
			}

			FloatBuffer buffer =
				BufferUtils.createFloatBuffer(2 * totalVertexCount);
			for (int i = 0; i < vertices.length; i++)
				if (vertices[i] != null)
					for (int j = 0; j < vertices[i].length; j++)
						buffer.put(vertices[i][j]);

			m_bufferId = generateBufferId();
			uploadBuffer(m_bufferId, buffer);

			GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, m_bufferId);
			GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
			try {
				GL11.glVertexPointer(2, GL11.GL_FLOAT, 0, 0);
				// TODO possible creates marginally more lists than need (e.g.
				// for space char)
				m_listBaseId = GL11.glGenLists(charCount);
				m_offsetBaseId_StartChar = m_listBaseId - m_startChar;
				for (int i = 0; i < charCount; i++) {
					int listId = m_listBaseId + i;
					GL11.glNewList(listId, GL11.GL_COMPILE);

					float advance = advances[i];
					int[] indicesPerChar = indices[i];
					if (indicesPerChar != null) {
						int[] typesPerChar = types[i];
						int[] lengthsPerChar = lengths[i];

						for (int j = 0; j < indicesPerChar.length; j++) {
							int length = lengthsPerChar[j];
							if (length > 0) {
								int index = indicesPerChar[j];
								int type = typesPerChar[j];
								GL11.glDrawArrays(type, index, length);
							}
						}
					}

					GL11.glTranslatef(advance, 0, 0);
					GL11.glEndList();
				}
			} finally {
				GL11.glDisableClientState(GL11.GL_VERTEX_ARRAY);
			}
		} finally {
			tesselator.gluDeleteTess();
		}
	}

	public void render(String i_string) {

		if (i_string == null)
			throw new NullPointerException("i_string must not be null");

		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, m_bufferId);
		GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
		try {
			GL11.glVertexPointer(2, GL11.GL_FLOAT, 0, 0);

			IntBuffer listIdBuffer =
				Draw3DCache.getIntBuffer(i_string.length());

			try {
				listIdBuffer.rewind();
				final int l = i_string.length();
				char c;
				// final int offset = m_listBaseId - m_startChar;
				for (int i = 0; i < l; i++) {
					c = i_string.charAt(i);
					// TODO: what if c cannot be rendered
					if (c >= m_startChar && c <= m_endChar)
						listIdBuffer.put(m_offsetBaseId_StartChar + c);
					else
						listIdBuffer.put(m_offsetBaseId_StartChar + '_');
				}

				listIdBuffer.limit(listIdBuffer.position());
				listIdBuffer.rewind();

				GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
				GL11.glCallLists(listIdBuffer);
			} finally {
				Draw3DCache.returnIntBuffer(listIdBuffer);
			}
		} finally {
			GL11.glDisableClientState(GL11.GL_VERTEX_ARRAY);
		}
	}

	private void uploadBuffer(int i_bufferId, FloatBuffer i_buffer) {

		i_buffer.rewind();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, i_bufferId);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, i_buffer, GL15.GL_STREAM_READ);
	}

}
