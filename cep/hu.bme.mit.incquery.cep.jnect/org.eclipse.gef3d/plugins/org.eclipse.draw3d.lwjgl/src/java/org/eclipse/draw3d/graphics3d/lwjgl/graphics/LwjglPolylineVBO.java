/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.graphics3d.lwjgl.graphics;

import java.nio.IntBuffer;

import org.eclipse.draw3d.graphics.optimizer.PrimitiveSet;
import org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass;
import org.eclipse.draw3d.graphics.optimizer.primitive.OutlineRenderRule;
import org.eclipse.draw3d.graphics.optimizer.primitive.PolylinePrimitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.Primitive;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.ILodHelper;
import org.eclipse.draw3d.util.ColorConverter;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;

/**
 * Vertex buffer object that renders polylines.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 21.12.2009
 */
public class LwjglPolylineVBO extends LwjglVertexPrimitiveVBO {

	private float[] m_color = new float[4];

	private IntBuffer m_indexBuffer;

	private IntBuffer m_countBuffer;

	/**
	 * Creates a new VBO that renders the given polyline primitives.
	 * 
	 * @param i_primitives the primitives to render
	 * @throws NullPointerException if the given primitive set is
	 *             <code>null</code>
	 * @throws IllegalArgumentException if the given primitive set is empty or
	 *             if it does not contain polyline primitives
	 */
	public LwjglPolylineVBO(PrimitiveSet i_primitives) {

		super(i_primitives);

		PrimitiveClass clazz = i_primitives.getPrimitiveClass();
		if (!clazz.isPolyline())
			throw new IllegalArgumentException(i_primitives
				+ " does not contain polylines");

		int count = i_primitives.getSize();
		if (count > 1) {
			m_indexBuffer = BufferUtils.createIntBuffer(count);
			m_countBuffer = BufferUtils.createIntBuffer(count);

			int index = 0;
			for (Primitive primitive : i_primitives.getPrimitives()) {
				PolylinePrimitive polyline = (PolylinePrimitive) primitive;

				int vertexCount = polyline.getVertexCount();
				m_countBuffer.put(vertexCount);
				m_indexBuffer.put(index);
				index += vertexCount;
			}

			m_indexBuffer.rewind();
			m_countBuffer.rewind();
		}

		OutlineRenderRule rule = clazz.getRenderRule().asOutline();
		ColorConverter.toFloatArray(rule.getColor(), rule.getAlpha(), m_color);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#dispose()
	 */
	@Override
	public void dispose() {

		m_indexBuffer = null;
		m_countBuffer = null;

		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#doRender(Graphics3D,
	 *      org.eclipse.draw3d.graphics3d.ILodHelper)
	 */
	@Override
	protected void doRender(Graphics3D i_g3d, ILodHelper i_lodContext) {

		i_g3d.glColor4f(m_color);

		GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_LINE);

		if (m_indexBuffer != null && m_countBuffer != null)
			GL14.glMultiDrawArrays(GL11.GL_LINE_STRIP, m_indexBuffer,
				m_countBuffer);
		else
			GL11.glDrawArrays(GL11.GL_LINE_STRIP, 0, getVertexCount());
	}
}
