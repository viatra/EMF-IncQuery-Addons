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

import java.nio.Buffer;
import java.nio.ByteBuffer;

import org.eclipse.draw3d.graphics.optimizer.PrimitiveSet;
import org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass;
import org.eclipse.draw3d.graphics.optimizer.primitive.GradientRenderRule;
import org.eclipse.draw3d.graphics.optimizer.primitive.Primitive;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.ILodHelper;
import org.eclipse.draw3d.util.ColorConverter;
import org.eclipse.swt.graphics.Color;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;

/**
 * Vertex Buffer Object that renders solid quadrilaterals with individual
 * gradients.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 21.12.2009
 */
public class LwjglGradientQuadVBO extends LwjglVertexPrimitiveVBO {

	/**
	 * Creates a new VBO that renders the given primitives.
	 * 
	 * @param i_primitives the primitives to render
	 * @throws NullPointerException if the given primitive set is
	 *             <code>null</code>
	 * @throws IllegalArgumentException if the given primitive set is empty or
	 *             if the given primitive set does not contain gradient
	 *             quadrilaterals
	 */
	public LwjglGradientQuadVBO(PrimitiveSet i_primitives) {

		super(i_primitives);

		PrimitiveClass primitiveClass = i_primitives.getPrimitiveClass();
		if (!primitiveClass.isGradient() || !primitiveClass.isQuad())
			throw new IllegalArgumentException(i_primitives
				+ " does not contain gradient quads");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#cleanup(Graphics3D,
	 *      ILodHelper)
	 */
	@Override
	protected void cleanup(Graphics3D i_g3d, ILodHelper i_lodContext) {

		super.cleanup(i_g3d, i_lodContext);
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

		GL11.glDrawArrays(GL11.GL_QUADS, 0, getVertexCount());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#getBuffer(org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO.BufferType)
	 */
	@Override
	protected Buffer getBuffer(BufferType i_type) {

		if (i_type == BufferType.COLOR) {
			ByteBuffer colorBuffer =
				BufferUtils.createByteBuffer(getVertexCount() * 4);

			byte[] c = new byte[4];
			for (Primitive primitive : getPrimitives().getPrimitives()) {
				GradientRenderRule renderRule =
					primitive.getRenderRule().asGradient();

				Color fromColor = renderRule.getFromColor();
				Color toColor = renderRule.getToColor();
				int alpha = renderRule.getAlpha();

				ColorConverter.toByteArray(fromColor, alpha, c);
				colorBuffer.put(c);
				colorBuffer.put(c);

				ColorConverter.toByteArray(toColor, alpha, c);
				colorBuffer.put(c);
				colorBuffer.put(c);
			}

			return colorBuffer;
		}

		return super.getBuffer(i_type);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#getBufferInfo(org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO.BufferType)
	 */
	@Override
	protected BufferInfo getBufferInfo(BufferType i_type) {

		if (i_type == BufferType.COLOR)
			return new BufferInfo(GL11.GL_UNSIGNED_BYTE, GL15.GL_STREAM_READ,
				4, 0, 0);

		return super.getBufferInfo(i_type);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#hasBuffer(org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO.BufferType)
	 */
	@Override
	protected boolean hasBuffer(BufferType i_type) {

		if (i_type == BufferType.COLOR)
			return true;

		return super.hasBuffer(i_type);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#prepare(Graphics3D,
	 *      org.eclipse.draw3d.graphics3d.ILodHelper)
	 */
	@Override
	protected void prepare(Graphics3D i_g3d, ILodHelper i_lodContext) {

		GL11.glPushAttrib(GL11.GL_LIGHTING_BIT);
		GL11.glShadeModel(GL11.GL_SMOOTH);

		super.prepare(i_g3d, i_lodContext);
	}
}
