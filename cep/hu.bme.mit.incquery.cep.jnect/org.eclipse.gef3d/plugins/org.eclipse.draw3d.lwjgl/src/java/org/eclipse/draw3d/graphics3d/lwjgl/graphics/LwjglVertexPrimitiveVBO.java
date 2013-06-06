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

import org.eclipse.draw3d.graphics.optimizer.PrimitiveSet;
import org.eclipse.draw3d.graphics.optimizer.primitive.Primitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.RenderRule;
import org.eclipse.draw3d.graphics.optimizer.primitive.VertexPrimitive;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.ILodHelper;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;

/**
 * Abstract base class for VBOs that obtain their vertex data from a
 * {@link PrimitiveSet set} of {@link VertexPrimitive vertex primitives}.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 06.01.2010
 */
public abstract class LwjglVertexPrimitiveVBO extends LwjglVBO {

	private LineHelper m_lineHelper;

	private PrimitiveSet m_primitives;

	private int m_vertexCount;

	protected int getVertexCount() {

		return m_vertexCount;
	}

	protected PrimitiveSet getPrimitives() {

		return m_primitives;
	}

	/**
	 * Creates a new vertex buffer using the given primitive set.
	 * 
	 * @param i_primitives the primitive set
	 * @throws NullPointerException if the given primitive set is
	 *             <code>null</code>
	 * @throws IllegalArgumentException if the given primitive set is empty
	 */
	protected LwjglVertexPrimitiveVBO(PrimitiveSet i_primitives) {

		if (i_primitives == null)
			throw new NullPointerException("i_primitives must not be null");

		if (i_primitives.getSize() == 0)
			throw new IllegalArgumentException(i_primitives
				+ " must not be empty");

		m_primitives = i_primitives;
		m_vertexCount = i_primitives.getVertexCount();

		RenderRule renderRule =
			i_primitives.getPrimitiveClass().getRenderRule();
		if (renderRule.isOutline())
			m_lineHelper = new LineHelper(renderRule.asOutline());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#cleanup(Graphics3D,
	 *      ILodHelper)
	 */
	@Override
	protected void cleanup(Graphics3D i_g3d, ILodHelper i_lodContext) {

		if (m_lineHelper != null)
			m_lineHelper.cleanup(i_g3d);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#doRender(Graphics3D,
	 *      ILodHelper)
	 */
	@Override
	protected abstract void doRender(Graphics3D i_g3d, ILodHelper i_lodContext);

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#getBuffer(org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO.BufferType)
	 */
	@Override
	protected Buffer getBuffer(BufferType i_type) {

		if (i_type == BufferType.VERTEX) {
			FloatBuffer buf =
				BufferUtils.createFloatBuffer(2 * m_primitives.getVertexCount());

			for (Primitive primitive : m_primitives.getPrimitives()) {
				VertexPrimitive vertexPrimitive = (VertexPrimitive) primitive;

				float[] vertices = vertexPrimitive.getVertices();
				if (m_lineHelper != null && m_lineHelper.isTextured()) {
					float lx = vertices[0];
					float ly = vertices[1];

					for (int i = 0; i < vertexPrimitive.getVertexCount(); i++) {
						float x = vertices[2 * i];
						float y = vertices[2 * i + 1];

						buf.put(x);
						buf.put(y);
						m_lineHelper.addTextureCoordinate(lx, ly, x, y, buf);
						lx = x;
						ly = y;
					}
				} else {
					buf.put(vertices);
				}

			}

			return buf;
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
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#initialize(org.eclipse.draw3d.graphics3d.Graphics3D)
	 */
	@Override
	public void initialize(Graphics3D i_g3d) {

		super.initialize(i_g3d);

		if (m_lineHelper != null)
			m_lineHelper.initialize(i_g3d);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#prepare(Graphics3D,
	 *      ILodHelper)
	 */
	@Override
	protected void prepare(Graphics3D i_g3d, ILodHelper i_lodContext) {

		if (m_lineHelper != null)
			m_lineHelper.prepare(i_g3d);
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

		if (i_newState == State.READY)
			m_primitives = null;
	}
}
