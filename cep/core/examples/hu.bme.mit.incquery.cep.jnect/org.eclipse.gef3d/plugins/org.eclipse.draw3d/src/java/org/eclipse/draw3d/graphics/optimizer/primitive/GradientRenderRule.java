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
 * A render rule that contains the properties of a solid gradient.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 23.12.2009
 */
public class GradientRenderRule extends AbstractRenderRule {

	private int m_alpha;

	private int m_fillRule;

	private Color m_fromColor;

	private Color m_toColor;

	private boolean m_xorMode;

	/**
	 * Creates a new gradient render rule using the given graphics state.
	 * 
	 * @param i_state the graphics state from which to obtain the properties of
	 *            this render rule
	 */
	public GradientRenderRule(GraphicsState i_state) {

		m_alpha = i_state.getAlpha();
		m_fillRule = i_state.getFillRule();
		m_fromColor = i_state.getForegroundColor();
		m_toColor = i_state.getBackgroundColor();
		m_xorMode = i_state.getXORMode();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.AbstractRenderRule#asGradient()
	 */
	@Override
	public GradientRenderRule asGradient() {

		return this;
	}

	/**
	 * Returns the alpha value of this gradient.
	 * 
	 * @return the alpha value
	 */
	public int getAlpha() {

		return m_alpha;
	}

	/**
	 * Returns the fill rule of this gradient.
	 * 
	 * @return the fill rule
	 * @see Graphics#setFillRule(int)
	 */
	public int getFillRule() {

		return m_fillRule;
	}

	/**
	 * Returns the first color of this gradient.
	 * 
	 * @return the first color
	 */
	public Color getFromColor() {

		return m_fromColor;
	}

	/**
	 * Returns the second color of this gradient.
	 * 
	 * @return the second color
	 */
	public Color getToColor() {

		return m_toColor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.AbstractRenderRule#isGradient()
	 */
	@Override
	public boolean isGradient() {

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
		return "GradientRenderRule [m_alpha=" + m_alpha + ", m_fillRule="
			+ m_fillRule + ", m_fromColor=" + m_fromColor + ", m_toColor="
			+ m_toColor + ", m_xorMode=" + m_xorMode + "]";
	}
}
