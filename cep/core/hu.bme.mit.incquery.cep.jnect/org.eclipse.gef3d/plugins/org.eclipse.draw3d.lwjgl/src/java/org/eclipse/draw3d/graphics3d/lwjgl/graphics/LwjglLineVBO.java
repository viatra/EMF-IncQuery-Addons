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

import org.eclipse.draw3d.graphics.optimizer.PrimitiveSet;
import org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass;
import org.eclipse.draw3d.graphics.optimizer.primitive.OutlineRenderRule;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.ILodHelper;
import org.eclipse.draw3d.util.ColorConverter;
import org.lwjgl.opengl.GL11;

/**
 * Vertex buffer object that renders individual lines.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 21.12.2009
 */
public class LwjglLineVBO extends LwjglVertexPrimitiveVBO {

	private float[] m_color = new float[4];

	/**
	 * Creates a new VBO that renders the given line primitives.
	 * 
	 * @param i_primitives the primitives to render
	 * @throws NullPointerException if the given primitive set is
	 *             <code>null</code>
	 * @throws IllegalArgumentException if the given primitive set is empty or
	 *             does not contain line primitives
	 */
	public LwjglLineVBO(PrimitiveSet i_primitives) {

		super(i_primitives);

		PrimitiveClass primitiveClass = i_primitives.getPrimitiveClass();
		if (!primitiveClass.isLine() || !primitiveClass.isOutline())
			throw new IllegalArgumentException(i_primitives
				+ " does not contain lines");

		OutlineRenderRule renderRule =
			primitiveClass.getRenderRule().asOutline();

		ColorConverter.toFloatArray(renderRule.getColor(),
			renderRule.getAlpha(), m_color);
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
		GL11.glDrawArrays(GL11.GL_LINES, 0, getVertexCount());
	}
}
