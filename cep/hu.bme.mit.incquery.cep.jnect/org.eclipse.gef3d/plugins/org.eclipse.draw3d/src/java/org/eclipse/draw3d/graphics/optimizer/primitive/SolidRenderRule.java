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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw3d.graphics.GraphicsState;
import org.eclipse.swt.graphics.Color;

/**
 * A render rule that contains the primitives of a solid primitive.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 23.12.2009
 */
public class SolidRenderRule extends AbstractRenderRule {

	private int m_alpha;

	private Color m_color;

	private int m_fillRule;

	private boolean m_xorMode;

	/**
	 * Creates a new solid render rule using the given graphics state.
	 * 
	 * @param i_state the graphics state from which to obtain the properties of
	 *            this render rule
	 */
	public SolidRenderRule(GraphicsState i_state) {

		m_alpha = i_state.getAlpha();
		m_color = i_state.getBackgroundColor();
		m_fillRule = i_state.getFillRule();
		m_xorMode = i_state.getXORMode();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.AbstractRenderRule#asSolid()
	 */
	@Override
	public SolidRenderRule asSolid() {

		return this;
	}

	/**
	 * Returns the alpha value.
	 * 
	 * @return the alpha value
	 */
	public int getAlpha() {

		return m_alpha;
	}

	/**
	 * Returns the fill color.
	 * 
	 * @return the fill color
	 */
	public Color getColor() {

		return m_color;
	}

	/**
	 * Returns the fill rule.
	 * 
	 * @return the fill rule
	 * @see Graphics#setFillRule(int)
	 */
	public int getFillRule() {

		return m_fillRule;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.AbstractRenderRule#isSolid()
	 */
	@Override
	public boolean isSolid() {

		return true;
	}

	/**
	 * Indicates whether XOR mode painting is enabled.
	 * 
	 * @return <code>true</code> if XOR mode painting is enabled and
	 *         <code>false</code> otherwise
	 */
	public boolean isXorMode() {

		return m_xorMode;
	}

	@Override
	public String toString() {
		return "SolidRenderRule [m_alpha=" + m_alpha + ", m_color=" + m_color
			+ ", m_fillRule=" + m_fillRule + ", m_xorMode=" + m_xorMode + "]";
	}
}
