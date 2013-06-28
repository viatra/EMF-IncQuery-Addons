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
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

/**
 * A render rule that contains the properties of a text primitive.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 23.12.2009
 */
public class TextRenderRule extends AbstractRenderRule {

	private int m_alpha;

	private Font m_font;

	private boolean m_fontAntialias;

	private Color m_textColor;

	/**
	 * Creates a new render rule using the given graphics state.
	 * 
	 * @param i_state the graphics state from which to obtain the properties of
	 *            this render rule
	 */
	public TextRenderRule(GraphicsState i_state) {

		m_font = i_state.getFont();
		m_textColor = i_state.getForegroundColor();
		m_alpha = i_state.getAlpha();
		m_fontAntialias = i_state.getAntialias() == SWT.ON;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.AbstractRenderRule#asText()
	 */
	@Override
	public TextRenderRule asText() {

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
	 * Returns the font.
	 * 
	 * @return the font
	 */
	public Font getFont() {

		return m_font;
	}

	/**
	 * Returns the color.
	 * 
	 * @return the color
	 */
	public Color getTextColor() {

		return m_textColor;
	}

	/**
	 * Indicates whether font antialiasing is enabled.
	 * 
	 * @return <code>true</code> if font antialiasing is enabled and
	 *         <code>false</code> otherwise
	 */
	public boolean isFontAntialias() {

		return m_fontAntialias;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.AbstractRenderRule#isText()
	 */
	@Override
	public boolean isText() {

		return true;
	}

	@Override
	public String toString() {
		return "TextRenderRule [m_alpha=" + m_alpha + ", m_font=" + m_font
			+ ", m_fontAntialias=" + m_fontAntialias + ", m_textColor="
			+ m_textColor + "]";
	}
}
