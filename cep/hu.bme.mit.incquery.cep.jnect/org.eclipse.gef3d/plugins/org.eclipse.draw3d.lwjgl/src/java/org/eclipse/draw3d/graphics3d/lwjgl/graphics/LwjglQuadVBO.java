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
import org.eclipse.draw3d.graphics.optimizer.primitive.SolidRenderRule;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.ILodHelper;
import org.eclipse.draw3d.graphics3d.lwjgl.Graphics3DLwjgl;
import org.eclipse.draw3d.util.ColorConverter;
import org.lwjgl.opengl.GL11;

/**
 * Vertex Buffer Object that draws quadrilaterals
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 21.12.2009
 */
public class LwjglQuadVBO extends LwjglVertexPrimitiveVBO {

	private float[] m_color = new float[4];

	private boolean m_solid;

	/**
	 * Creates a new VBO that renders the given primitives.
	 * 
	 * @param i_primitives the primitives to render
	 * @throws NullPointerException if the given primitive set is
	 *             <code>null</code>
	 * @throws IllegalArgumentException if the given primitive set is empty or
	 *             if the given primitive set does not contain quadrilaterals
	 */
	public LwjglQuadVBO(PrimitiveSet i_primitives) {

		super(i_primitives);

		PrimitiveClass clazz = i_primitives.getPrimitiveClass();
		if (!clazz.isQuad())
			throw new IllegalArgumentException(i_primitives
				+ " does not contain quads");

		m_solid = clazz.isSolid();

		if (m_solid) {
			SolidRenderRule rule = clazz.getRenderRule().asSolid();
			ColorConverter.toFloatArray(rule.getColor(), rule.getAlpha(),
				m_color);
		} else {
			OutlineRenderRule rule = clazz.getRenderRule().asOutline();
			ColorConverter.toFloatArray(rule.getColor(), rule.getAlpha(),
				m_color);
		}
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

		if (m_solid) {
			GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
			GL11.glDrawArrays(GL11.GL_QUADS, 0, getVertexCount());
		} else {
			GL11.glTranslatef(Graphics3DLwjgl.RASTER_OFFSET,
				Graphics3DLwjgl.RASTER_OFFSET, 0);
			GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_LINE);
			GL11.glDrawArrays(GL11.GL_QUADS, 0, getVertexCount());
		}

	}
}
