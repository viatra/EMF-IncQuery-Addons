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

/**
 * Abstract base implementation of the {@link RenderRule} interface.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 23.12.2009
 */
public abstract class AbstractRenderRule implements RenderRule {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.RenderRule#asGradient()
	 */
	public GradientRenderRule asGradient() {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.RenderRule#asImage()
	 */
	public ImageRenderRule asImage() {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.RenderRule#asOutline()
	 */
	public OutlineRenderRule asOutline() {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.RenderRule#asSolid()
	 */
	public SolidRenderRule asSolid() {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.RenderRule#asText()
	 */
	public TextRenderRule asText() {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.RenderRule#isGradient()
	 */
	public boolean isGradient() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.RenderRule#isImage()
	 */
	public boolean isImage() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.RenderRule#isOutline()
	 */
	public boolean isOutline() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.RenderRule#isSolid()
	 */
	public boolean isSolid() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.RenderRule#isText()
	 */
	public boolean isText() {
		return false;
	}
}
