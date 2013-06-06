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
package org.eclipse.draw3d.graphics.optimizer.primitive;

import org.eclipse.draw3d.graphics.GraphicsState;

/**
 * A render rule that defines the properties of an image.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 23.12.2009
 */
public class ImageRenderRule extends AbstractRenderRule {

	private int m_alpha;

	/**
	 * Creates a new instance using the given graphics state.
	 * 
	 * @param i_state the graphics state from which to obtain the properties of
	 *            this render rule
	 */
	public ImageRenderRule(GraphicsState i_state) {

		m_alpha = i_state.getAlpha();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.AbstractRenderRule#asImage()
	 */
	@Override
	public ImageRenderRule asImage() {

		return this;
	}

	/**
	 * The alpha value of this image.
	 * 
	 * @return the alpha value
	 */
	public int getAlpha() {

		return m_alpha;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.AbstractRenderRule#isImage()
	 */
	@Override
	public boolean isImage() {

		return true;
	}

	@Override
	public String toString() {
		return "ImageRenderRule [m_alpha=" + m_alpha + "]";
	}
}
