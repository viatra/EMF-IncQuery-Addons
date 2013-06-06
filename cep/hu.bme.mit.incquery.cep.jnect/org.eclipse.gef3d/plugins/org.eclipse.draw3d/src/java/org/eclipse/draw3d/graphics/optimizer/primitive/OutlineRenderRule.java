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

import java.util.Arrays;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw3d.graphics.GraphicsState;
import org.eclipse.swt.graphics.Color;

/**
 * A render rule that contains the properties of a line or outline primitive.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 23.12.2009
 */
public class OutlineRenderRule extends AbstractRenderRule {

	private int m_alpha;

	private Color m_color;

	private int m_lineCap;

	private int[] m_lineDash;

	private int m_lineJoin;

	private int m_lineStyle;

	private float m_lineWidth;

	/**
	 * Creates a new outline render rule using the given graphics state.
	 * 
	 * @param i_state the graphics state from which to obtain the properties of
	 *            this render rule
	 */
	public OutlineRenderRule(GraphicsState i_state) {

		m_alpha = i_state.getAlpha();
		m_color = i_state.getForegroundColor();
		m_lineCap = i_state.getLineCap();
		m_lineDash = i_state.getLineDash();
		m_lineJoin = i_state.getLineJoin();
		m_lineStyle = i_state.getLineStyle();
		m_lineWidth = i_state.getLineWidth();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.AbstractRenderRule#asOutline()
	 */
	@Override
	public OutlineRenderRule asOutline() {

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
	 * Returns the color.
	 * 
	 * @return the color
	 */
	public Color getColor() {

		return m_color;
	}

	/**
	 * Returns the line cap setting.
	 * 
	 * @return the line cap setting
	 * @see Graphics#setLineCap(int)
	 */
	public int getLineCap() {

		return m_lineCap;
	}

	/**
	 * Returns the line dash pattern.
	 * 
	 * @return the line dash pattern or <code>null</code> if there is no dash
	 *         pattern
	 */
	public int[] getLineDash() {

		return m_lineDash;
	}

	/**
	 * Returns the line join setting.
	 * 
	 * @return the line join setting
	 * @see Graphics#setLineJoin(int)
	 */
	public int getLineJoin() {

		return m_lineJoin;
	}

	/**
	 * Returns the line style.
	 * 
	 * @return the line style
	 * @see Graphics#setLineStyle(int)
	 */
	public int getLineStyle() {

		return m_lineStyle;
	}

	/**
	 * Returns the line width.
	 * 
	 * @return the line width
	 */
	public float getLineWidth() {

		return m_lineWidth;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.AbstractRenderRule#isOutline()
	 */
	@Override
	public boolean isOutline() {

		return true;
	}

	@Override
	public String toString() {

		return "OutlineRenderRule [m_alpha=" + m_alpha + ", m_color=" + m_color
			+ ", m_lineCap=" + m_lineCap + ", m_lineDash="
			+ Arrays.toString(m_lineDash) + ", m_lineJoin=" + m_lineJoin
			+ ", m_lineStyle=" + m_lineStyle + ", m_lineWidth=" + m_lineWidth
			+ "]";
	}
}
