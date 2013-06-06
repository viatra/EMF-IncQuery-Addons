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
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw3d.geometry.IVector2f;
import org.eclipse.draw3d.graphics.optimizer.primitive.OutlineRenderRule;
import org.eclipse.draw3d.graphics.optimizer.primitive.RenderRule;
import org.eclipse.draw3d.graphics.optimizer.primitive.SolidRenderRule;
import org.eclipse.draw3d.graphics.optimizer.primitive.TextRenderRule;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.ILodHelper;
import org.eclipse.draw3d.graphics3d.lwjgl.Graphics3DLwjgl;
import org.eclipse.draw3d.util.BufferUtils;
import org.eclipse.draw3d.util.ColorConverter;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL15;

/**
 * LwjglPolygonVBO2 There should really be more documentation here.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 21.01.2010
 */
public class LwjglPolygonVBO extends LwjglVBO {

	private static final int ALLOWED_TYPES =
		GL11.GL_TRIANGLE_FAN | GL11.GL_TRIANGLE_STRIP | GL11.GL_TRIANGLES
			| GL11.GL_LINE_LOOP;

	private int m_type;

	private List<float[]> m_vertices = new LinkedList<float[]>();

	private int m_vertexCount = 0;

	private IntBuffer m_indexBuffer;

	private IntBuffer m_countBuffer;

	private float[] m_color;

	private boolean m_solid;

	public LwjglPolygonVBO(int i_type, RenderRule i_renderRule) {

		if ((i_type & ALLOWED_TYPES) == 0)
			throw new IllegalArgumentException(i_type
				+ " is not a valid polygon type");

		m_type = i_type;

		if (i_renderRule.isSolid()) {
			SolidRenderRule solid = i_renderRule.asSolid();
			m_color =
				ColorConverter.toFloatArray(solid.getColor(), solid.getAlpha(),
					null);
			m_solid = true;
		} else if (i_renderRule.isOutline()) {
			OutlineRenderRule outline = i_renderRule.asOutline();
			m_color =
				ColorConverter.toFloatArray(outline.getColor(),
					outline.getAlpha(), null);
			m_solid = false;
		} else if (i_renderRule.isText()) {
			TextRenderRule text = i_renderRule.asText();
			m_color =
				ColorConverter.toFloatArray(text.getTextColor(),
					text.getAlpha(), null);
			m_solid = true;
		} else
			throw new IllegalArgumentException("cannot handle render rule "
				+ i_renderRule);
	}

	public void addPolygon(List<IVector2f> i_vertices) {

		if (i_vertices == null)
			throw new NullPointerException("i_vertices must not be null");

		float[] data = new float[2 * i_vertices.size()];
		int i = 0;

		for (IVector2f v : i_vertices)
			v.toArray(data, 2 * i++);

		m_vertices.add(data);

		m_vertexCount += i_vertices.size();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#cleanup(Graphics3D,
	 *      org.eclipse.draw3d.graphics3d.ILodHelper)
	 */
	@Override
	protected void cleanup(Graphics3D i_g3d, ILodHelper i_lodContext) {

		if (!m_solid)
			GL11.glPopMatrix();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#doRender(Graphics3D,
	 *      org.eclipse.draw3d.graphics3d.ILodHelper)
	 */
	@Override
	protected void doRender(Graphics3D i_g3d, ILodHelper i_lodContext) {

		GL14.glMultiDrawArrays(m_type, m_indexBuffer, m_countBuffer);
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
			m_vertices = null;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#getBuffer(org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO.BufferType)
	 */
	@Override
	protected Buffer getBuffer(BufferType i_type) {

		if (i_type == BufferType.VERTEX) {
			FloatBuffer vertexBuffer =
				BufferUtils.createFloatBuffer(2 * m_vertexCount);

			m_indexBuffer = BufferUtils.createIntBuffer(m_vertices.size());
			m_countBuffer = BufferUtils.createIntBuffer(m_vertices.size());

			int index = 0;
			for (float[] vertices : m_vertices) {
				vertexBuffer.put(vertices);
				m_indexBuffer.put(index);

				int vertexCount = vertices.length / 2;
				m_countBuffer.put(vertexCount);

				index += vertexCount;
			}

			m_indexBuffer.rewind();
			m_countBuffer.rewind();

			return vertexBuffer;
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

		if (i_type == BufferType.VERTEX)
			return new BufferInfo(GL11.GL_FLOAT, GL15.GL_STREAM_READ, 2, 0, 0);

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#hasBuffer(org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO.BufferType)
	 */
	@Override
	protected boolean hasBuffer(BufferType i_type) {

		return i_type == BufferType.VERTEX;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#prepare(Graphics3D,
	 *      ILodHelper)
	 */
	@Override
	protected void prepare(Graphics3D i_g3d, ILodHelper i_lodContext) {

		i_g3d.glColor4f(m_color);

		if (m_solid)
			GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
		else {
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glPushMatrix();
			GL11.glTranslatef(Graphics3DLwjgl.RASTER_OFFSET,
				Graphics3DLwjgl.RASTER_OFFSET, 0);
		}
	}
}
