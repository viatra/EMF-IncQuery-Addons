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
package org.eclipse.draw3d.graphics;

import java.util.EmptyStackException;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Pattern;

/**
 * Abstract base class for all graphics implementations that have a state.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 06.11.2009
 */
public abstract class StatefulGraphics extends Graphics {

	private GraphicsState m_defaultState;

	private boolean m_disposed = false;

	private GraphicsState m_state;

	/**
	 * Creates and initializes a new instance.
	 */
	public StatefulGraphics() {

		m_defaultState = GraphicsState.createDefaultState();
		m_state = new GraphicsState(m_defaultState);
	}

	/**
	 * Throws an {@link IllegalStateException} if this graphics is disposed.
	 */
	protected void checkDisposed() {

		if (m_disposed)
			throw new IllegalStateException(this + " is disposed");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#clipRect(org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	public void clipRect(Rectangle i_r) {

		m_state.clipRect(i_r);
	}

	/**
	 * Converts the given float dash pattern to an int pattern.
	 * 
	 * @param i_dash the pattern to convert
	 * @return the converted pattern or <code>null</code> if the given pattern
	 *         is <code>null</code>
	 */
	protected int[] convertDash(float[] i_dash) {

		if (i_dash == null)
			return null;

		int[] result = new int[i_dash.length];
		for (int i = 0; i < i_dash.length; i++)
			result[i] = (int) i_dash[i];

		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#dispose()
	 */
	@Override
	public void dispose() {

		checkDisposed();

		m_disposed = true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getAdvanced()
	 */
	@Override
	public boolean getAdvanced() {

		checkDisposed();

		return m_state.getAdvanced();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getAlpha()
	 */
	@Override
	public int getAlpha() {

		checkDisposed();

		return m_state.getAlpha();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getAntialias()
	 */
	@Override
	public int getAntialias() {

		checkDisposed();

		return m_state.getAntialias();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getBackgroundColor()
	 */
	@Override
	public Color getBackgroundColor() {

		checkDisposed();

		return m_state.getBackgroundColor();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getClip(org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	public Rectangle getClip(Rectangle o_rect) {

		checkDisposed();

		Rectangle clip = m_state.getClip();
		o_rect.setBounds(clip);

		return o_rect;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getFillRule()
	 */
	@Override
	public int getFillRule() {

		checkDisposed();

		return m_state.getFillRule();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getFont()
	 */
	@Override
	public Font getFont() {

		checkDisposed();

		return m_state.getFont();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getFontMetrics()
	 */
	@Override
	public FontMetrics getFontMetrics() {

		checkDisposed();

		return m_state.getFontMetrics();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getForegroundColor()
	 */
	@Override
	public Color getForegroundColor() {

		checkDisposed();

		return m_state.getForegroundColor();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getInterpolation()
	 */
	@Override
	public int getInterpolation() {

		checkDisposed();

		return m_state.getInterpolation();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineAttributes()
	 */
	@Override
	public LineAttributes getLineAttributes() {

		checkDisposed();

		LineAttributes attrs = new LineAttributes(m_state.getLineWidth());
		attrs.cap = m_state.getLineCap();
		attrs.dashOffset = 0;
		attrs.join = m_state.getLineJoin();
		attrs.miterLimit = m_state.getLineMiterLimit();
		attrs.style = m_state.getLineStyle();

		int[] lineDash = m_state.getLineDash();
		if (lineDash == null)
			attrs.dash = null;
		else {
			attrs.dash = new float[lineDash.length];
			for (int i = 0; i < lineDash.length; i++)
				attrs.dash[i] = lineDash[i];
		}

		return attrs;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineCap()
	 */
	@Override
	public int getLineCap() {

		checkDisposed();

		return m_state.getLineCap();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineJoin()
	 */
	@Override
	public int getLineJoin() {

		checkDisposed();

		return m_state.getLineJoin();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineMiterLimit()
	 */
	@Override
	public float getLineMiterLimit() {

		checkDisposed();

		return m_state.getLineMiterLimit();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineStyle()
	 */
	@Override
	public int getLineStyle() {

		checkDisposed();

		return m_state.getLineStyle();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineWidth()
	 */
	@Override
	public int getLineWidth() {

		checkDisposed();

		return Math.round(m_state.getLineWidth());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineWidthFloat()
	 */
	@Override
	public float getLineWidthFloat() {

		checkDisposed();

		return m_state.getLineWidth();
	}

	/**
	 * Returns the current state.
	 * 
	 * @return the current state
	 */
	protected GraphicsState getState() {

		return m_state;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getTextAntialias()
	 */
	@Override
	public int getTextAntialias() {

		checkDisposed();

		return m_state.getTextAntialias();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getXORMode()
	 */
	@Override
	public boolean getXORMode() {

		checkDisposed();

		return m_state.getXORMode();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#popState()
	 */
	@Override
	public void popState() {

		checkDisposed();

		if (m_state.getParent() == m_defaultState)
			throw new EmptyStackException();

		m_state = m_state.getParent();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#pushState()
	 */
	@Override
	public void pushState() {

		checkDisposed();

		m_state = new GraphicsState(m_state);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#restoreState()
	 */
	@Override
	public void restoreState() {

		checkDisposed();

		m_state = new GraphicsState(m_state.getParent());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#rotate(float)
	 */
	@Override
	public void rotate(float i_degrees) {

		checkDisposed();

		if (i_degrees != 0)
			m_state.rotate(i_degrees);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#scale(double)
	 */
	@Override
	public void scale(double i_amount) {

		checkDisposed();

		if (i_amount != 0)
			m_state.scale((float) i_amount, (float) i_amount);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#scale(float, float)
	 */
	@Override
	public void scale(float i_horizontal, float i_vertical) {

		checkDisposed();

		if (i_horizontal != 0 || i_vertical != 0)
			m_state.scale(i_horizontal, i_vertical);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setAdvanced(boolean)
	 */
	@Override
	public void setAdvanced(boolean i_advanced) {

		checkDisposed();

		m_state.setAdvanced(i_advanced);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setAlpha(int)
	 */
	@Override
	public void setAlpha(int i_alpha) {

		checkDisposed();

		m_state.setAlpha(i_alpha);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setAntialias(int)
	 */
	@Override
	public void setAntialias(int i_antialias) {

		checkDisposed();

		m_state.setAntialias(i_antialias);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setBackgroundColor(org.eclipse.swt.graphics.Color)
	 */
	@Override
	public void setBackgroundColor(Color i_backgroundColor) {

		checkDisposed();

		m_state.setBackgroundColor(i_backgroundColor);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setBackgroundPattern(org.eclipse.swt.graphics.Pattern)
	 */
	@Override
	public void setBackgroundPattern(Pattern i_backgroundPattern) {

		checkDisposed();

		m_state.setBackgroundPattern(i_backgroundPattern);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setClip(org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	public void setClip(Rectangle i_r) {

		checkDisposed();

		m_state.setClip(i_r);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setFillRule(int)
	 */
	@Override
	public void setFillRule(int i_fillRule) {

		checkDisposed();

		m_state.setFillRule(i_fillRule);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setFont(org.eclipse.swt.graphics.Font)
	 */
	@Override
	public void setFont(Font i_font) {

		checkDisposed();

		m_state.setFont(i_font);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setForegroundColor(org.eclipse.swt.graphics.Color)
	 */
	@Override
	public void setForegroundColor(Color i_foregroundColor) {

		checkDisposed();

		m_state.setForegroundColor(i_foregroundColor);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setInterpolation(int)
	 */
	@Override
	public void setInterpolation(int i_interpolation) {

		checkDisposed();

		m_state.setInterpolation(i_interpolation);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineAttributes(org.eclipse.swt.graphics.LineAttributes)
	 */
	@Override
	public void setLineAttributes(LineAttributes i_attributes) {

		checkDisposed();

		if (i_attributes == null)
			return;

		m_state.setLineCap(i_attributes.cap);
		m_state.setLineJoin(i_attributes.join);
		m_state.setLineMiterLimit(i_attributes.miterLimit);
		m_state.setLineStyle(i_attributes.style);
		m_state.setLineWidth(i_attributes.width);

		m_state.setLineDash(convertDash(i_attributes.dash));
		if (i_attributes.dash != null)
			m_state.setLineStyle(SWT.LINE_CUSTOM);
		else
			m_state.setLineStyle(SWT.LINE_SOLID);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineCap(int)
	 */
	@Override
	public void setLineCap(int i_cap) {

		checkDisposed();

		m_state.setLineCap(i_cap);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineDash(float[])
	 */
	@Override
	public void setLineDash(float[] i_dash) {

		checkDisposed();

		if (i_dash != null) {
			m_state.setLineStyle(SWT.LINE_CUSTOM);
			m_state.setLineDash(convertDash(i_dash));
		} else {
			m_state.setLineStyle(SWT.LINE_SOLID);
			m_state.setLineDash(null);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineDash(int[])
	 */
	@Override
	public void setLineDash(int[] i_dash) {

		checkDisposed();

		if (i_dash != null)
			m_state.setLineStyle(SWT.LINE_CUSTOM);
		else
			m_state.setLineStyle(SWT.LINE_SOLID);

		m_state.setLineDash(i_dash);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineJoin(int)
	 */
	@Override
	public void setLineJoin(int i_lineJoin) {

		checkDisposed();

		m_state.setLineJoin(i_lineJoin);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineMiterLimit(float)
	 */
	@Override
	public void setLineMiterLimit(float i_lineMiterLimit) {

		checkDisposed();

		m_state.setLineMiterLimit(i_lineMiterLimit);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineStyle(int)
	 */
	@Override
	public void setLineStyle(int i_lineStyle) {

		checkDisposed();

		m_state.setLineStyle(i_lineStyle);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineWidth(int)
	 */
	@Override
	public void setLineWidth(int i_lineWidth) {

		checkDisposed();

		m_state.setLineWidth(i_lineWidth);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineWidthFloat(float)
	 */
	@Override
	public void setLineWidthFloat(float i_lineWidth) {

		checkDisposed();

		m_state.setLineWidth(i_lineWidth);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setTextAntialias(int)
	 */
	@Override
	public void setTextAntialias(int i_textAntialias) {

		checkDisposed();

		m_state.setTextAntialias(i_textAntialias);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setXORMode(boolean)
	 */
	@Override
	public void setXORMode(boolean i_enabled) {

		checkDisposed();

		m_state.setXORMode(i_enabled);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#shear(float, float)
	 */
	@Override
	public void shear(float i_horz, float i_vert) {

		checkDisposed();

		if (i_horz != 0 || i_vert != 0)
			m_state.shear(i_horz, i_vert);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#translate(float, float)
	 */
	@Override
	public void translate(float i_dx, float i_dy) {

		checkDisposed();

		if (i_dx != 0 || i_dy != 0)
			m_state.translate(i_dx, i_dy);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#translate(int, int)
	 */
	@Override
	public void translate(int i_dx, int i_dy) {

		checkDisposed();

		if (i_dx != 0 || i_dy != 0)
			m_state.translate(i_dx, i_dy);
	}
}
