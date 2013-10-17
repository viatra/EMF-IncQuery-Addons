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
package org.eclipse.draw3d.graphics3d.lwjgl.graphics;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import org.eclipse.draw3d.graphics.optimizer.PrimitiveSet;
import org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass;
import org.eclipse.draw3d.graphics.optimizer.primitive.Primitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.TextPrimitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.TextRenderRule;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.ILodHelper;
import org.eclipse.draw3d.graphics3d.lwjgl.font.LwjglFont;
import org.eclipse.draw3d.graphics3d.lwjgl.font.LwjglFontManager;
import org.eclipse.draw3d.util.ColorConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;

/**
 * Vertex buffer object that renders text primitives.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 05.01.2010
 */
public class LwjglTextVBO extends LwjglVBO {

	private boolean m_buffersInitialized = false;

	private float[] m_color;

	private ByteBuffer m_colorBuffer;

	private LwjglFont m_glFont;

	private PrimitiveSet m_primitives;

	private FloatBuffer m_texCoordBuffer;

	private FloatBuffer m_vertexBuffer;

	private int m_vertexCount;

	/**
	 * Creates a new VBO that renders the given text primitives.
	 * 
	 * @param i_primitives the primitives to render
	 * @param i_fontManager the font manager to use
	 * @throws NullPointerException if any of the given arguments is
	 *             <code>null</code>
	 * @throws IllegalArgumentException if the given primitive set is empty or
	 *             does not contain text primitives
	 */
	public LwjglTextVBO(PrimitiveSet i_primitives,
			LwjglFontManager i_fontManager) {

		if (i_primitives == null)
			throw new NullPointerException("i_primitives must not be null");

		if (i_fontManager == null)
			throw new NullPointerException("i_fontManager must not be null");

		if (i_primitives.getSize() == 0)
			throw new IllegalArgumentException(i_primitives + " is empty");

		PrimitiveClass primitiveClass = i_primitives.getPrimitiveClass();
		if (!primitiveClass.isText())
			throw new IllegalArgumentException(i_primitives
				+ " does not contain text primitives");

		m_primitives = i_primitives;

		PrimitiveClass clazz = m_primitives.getPrimitiveClass();
		TextRenderRule renderRule = clazz.getRenderRule().asText();

		Font font = renderRule.getFont();
		boolean fontAntialias = renderRule.isFontAntialias();

		m_glFont =
			i_fontManager.getFont(font, (char) 32, (char) 127, fontAntialias);

		boolean first = true;
		Color constColor = null;
		int constAlpha = -1;

		m_vertexCount = 0;
		for (Primitive primitive : m_primitives.getPrimitives()) {
			TextPrimitive textPrimitive = (TextPrimitive) primitive;
			TextRenderRule textRenderRule =
				textPrimitive.getRenderRule().asText();

			String text = textPrimitive.getText();
			Color color = textRenderRule.getTextColor();
			int alpha = textRenderRule.getAlpha();

			if (first) {
				constColor = color;
				constAlpha = alpha;
				first = false;
			} else if (constColor != null
				&& (!constColor.equals(color) || constAlpha != alpha)) {
				constColor = null;
				constAlpha = -1;
			}

			m_vertexCount += 4 * m_glFont.getLength(text);
		}

		if (constColor != null)
			m_color = ColorConverter.toFloatArray(constColor, constAlpha, null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#cleanup(Graphics3D,
	 *      org.eclipse.draw3d.graphics3d.ILodHelper)
	 */
	@Override
	protected void cleanup(Graphics3D i_g3d, ILodHelper i_lodContext) {

		GL11.glPopAttrib();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#doRender(Graphics3D,
	 *      ILodHelper)
	 */
	@Override
	protected void doRender(Graphics3D i_g3d, ILodHelper i_lodContext) {

		if (m_color != null)
			i_g3d.glColor4f(m_color);

		GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
		GL11.glDrawArrays(GL11.GL_QUADS, 0, m_vertexCount);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#getBuffer(org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO.BufferType)
	 */
	@Override
	protected Buffer getBuffer(BufferType i_type) {

		initBuffers();

		switch (i_type) {
		case VERTEX:
			return m_vertexBuffer;
		case COLOR:
			return m_colorBuffer;
		case TEXTURE_COORDINATES:
			return m_texCoordBuffer;
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#getBufferInfo(org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO.BufferType)
	 */
	@Override
	protected BufferInfo getBufferInfo(BufferType i_type) {

		switch (i_type) {
		case VERTEX:
			return new BufferInfo(GL11.GL_FLOAT, GL15.GL_STREAM_READ, 2, 0, 0);
		case COLOR:
			return new BufferInfo(GL11.GL_BYTE, GL15.GL_STREAM_READ, 4, 0, 0);
		case TEXTURE_COORDINATES:
			return new BufferInfo(GL11.GL_FLOAT, GL15.GL_STREAM_READ, 2, 0, 0);
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#hasBuffer(org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO.BufferType)
	 */
	@Override
	protected boolean hasBuffer(BufferType i_type) {

		switch (i_type) {
		case VERTEX:
		case TEXTURE_COORDINATES:
			return true;
		case COLOR:
			return m_color == null;
		}

		return false;
	}

	private void initBuffers() {

		if (m_buffersInitialized)
			return;

		m_vertexBuffer = BufferUtils.createFloatBuffer(2 * m_vertexCount);
		m_texCoordBuffer = BufferUtils.createFloatBuffer(2 * m_vertexCount);

		if (m_color == null)
			m_colorBuffer = BufferUtils.createByteBuffer(4 * m_vertexCount);

		byte[] c = new byte[4];
		for (Primitive primitive : m_primitives.getPrimitives()) {
			TextPrimitive textPrimitive = (TextPrimitive) primitive;
			
			if (m_color == null) {
				TextRenderRule textRenderRule =
					textPrimitive.getRenderRule().asText();

				Color color = textRenderRule.getTextColor();
				int alpha = textRenderRule.getAlpha();

				m_colorBuffer.put(ColorConverter.toByteArray(color, alpha, c));
			}
		}

		m_buffersInitialized = true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#prepare(Graphics3D,
	 *      ILodHelper)
	 */
	@Override
	protected void prepare(Graphics3D i_g3d, ILodHelper i_lodContext) {

		GL11.glPushAttrib(GL11.GL_TEXTURE_BIT);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, m_glFont.getTextureId());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#stateChanged(org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO.State,
	 *      org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO.State)
	 */
	@Override
	protected void stateChanged(State i_oldState, State i_newState) {

		super.stateChanged(i_oldState, i_newState);

		if (i_newState == State.READY) {
			m_primitives = null;
			m_vertexBuffer = null;
			m_texCoordBuffer = null;
			m_colorBuffer = null;
		}
	}
}
