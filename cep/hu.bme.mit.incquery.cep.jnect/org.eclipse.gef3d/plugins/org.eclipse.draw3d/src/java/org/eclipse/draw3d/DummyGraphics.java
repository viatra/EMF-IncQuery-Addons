/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/

package org.eclipse.draw3d;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.widgets.Display;

/**
 * A dummy graphics instance that draws nothing.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 09.03.2008
 */
public class DummyGraphics extends Graphics {

	private double m_absoluteScale = 1;

	private boolean m_advanced = true;

	private int m_alpha = 255;

	private int m_antialias = SWT.DEFAULT;

	private Color m_backgroundColor;

	private int m_fillRule = SWT.FILL_WINDING;

	private Font m_font;

	private Color m_foregroundColor;

	private int m_interpolation = SWT.DEFAULT;

	private int m_lineCap = SWT.CAP_FLAT;

	private int m_lineJoin = SWT.JOIN_MITER;

	private float m_lineMiterLimit = 11;

	private int m_lineStyle = SWT.LINE_SOLID;

	private float m_lineWidth = 1;

	private int m_textAntialias = SWT.DEFAULT;

	private boolean m_xorMode = false;

	/**
	 * Creates a new instance.
	 */
	public DummyGraphics() {

		Display display = Display.getCurrent();
		m_backgroundColor = display.getSystemColor(SWT.COLOR_WHITE);
		m_foregroundColor = display.getSystemColor(SWT.COLOR_BLACK);
		m_font = display.getSystemFont();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#clipRect(org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	public void clipRect(Rectangle i_r) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#dispose()
	 */
	@Override
	public void dispose() {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawArc(int, int, int, int, int, int)
	 */
	@Override
	public void drawArc(int i_x, int i_y, int i_w, int i_h, int i_offset,
			int i_length) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawFocus(int, int, int, int)
	 */
	@Override
	public void drawFocus(int i_x, int i_y, int i_w, int i_h) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawImage(org.eclipse.swt.graphics.Image,
	 *      int, int)
	 */
	@Override
	public void drawImage(Image i_srcImage, int i_x, int i_y) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawImage(org.eclipse.swt.graphics.Image,
	 *      int, int, int, int, int, int, int, int)
	 */
	@Override
	public void drawImage(Image i_srcImage, int i_x1, int i_y1, int i_w1,
			int i_h1, int i_x2, int i_y2, int i_w2, int i_h2) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawLine(int, int, int, int)
	 */
	@Override
	public void drawLine(int i_x1, int i_y1, int i_x2, int i_y2) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawOval(int, int, int, int)
	 */
	@Override
	public void drawOval(int i_x, int i_y, int i_w, int i_h) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawPath(org.eclipse.swt.graphics.Path)
	 */
	@Override
	public void drawPath(Path i_path) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawPolygon(org.eclipse.draw2d.geometry.PointList)
	 */
	@Override
	public void drawPolygon(PointList i_points) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawPolyline(org.eclipse.draw2d.geometry.PointList)
	 */
	@Override
	public void drawPolyline(PointList i_points) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawRectangle(int, int, int, int)
	 */
	@Override
	public void drawRectangle(int i_x, int i_y, int i_width, int i_height) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawRoundRectangle(org.eclipse.draw2d.geometry.Rectangle,
	 *      int, int)
	 */
	@Override
	public void drawRoundRectangle(Rectangle i_r, int i_arcWidth,
			int i_arcHeight) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawString(java.lang.String, int, int)
	 */
	@Override
	public void drawString(String i_s, int i_x, int i_y) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawText(java.lang.String, int, int)
	 */
	@Override
	public void drawText(String i_s, int i_x, int i_y) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawText(java.lang.String, int, int,
	 *      int)
	 */
	@Override
	public void drawText(String i_s, int i_x, int i_y, int i_style) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawTextLayout(org.eclipse.swt.graphics.TextLayout,
	 *      int, int, int, int, org.eclipse.swt.graphics.Color,
	 *      org.eclipse.swt.graphics.Color)
	 */
	@Override
	public void drawTextLayout(TextLayout i_layout, int i_x, int i_y,
			int i_selectionStart, int i_selectionEnd,
			Color i_selectionForeground, Color i_selectionBackground) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillArc(int, int, int, int, int, int)
	 */
	@Override
	public void fillArc(int i_x, int i_y, int i_w, int i_h, int i_offset,
			int i_length) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillGradient(int, int, int, int,
	 *      boolean)
	 */
	@Override
	public void fillGradient(int i_x, int i_y, int i_w, int i_h,
			boolean i_vertical) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillOval(int, int, int, int)
	 */
	@Override
	public void fillOval(int i_x, int i_y, int i_w, int i_h) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillPath(org.eclipse.swt.graphics.Path)
	 */
	@Override
	public void fillPath(Path i_path) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillPolygon(org.eclipse.draw2d.geometry.PointList)
	 */
	@Override
	public void fillPolygon(PointList i_points) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillRectangle(int, int, int, int)
	 */
	@Override
	public void fillRectangle(int i_x, int i_y, int i_width, int i_height) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillRoundRectangle(org.eclipse.draw2d.geometry.Rectangle,
	 *      int, int)
	 */
	@Override
	public void fillRoundRectangle(Rectangle i_r, int i_arcWidth,
			int i_arcHeight) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillString(java.lang.String, int, int)
	 */
	@Override
	public void fillString(String i_s, int i_x, int i_y) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillText(java.lang.String, int, int)
	 */
	@Override
	public void fillText(String i_s, int i_x, int i_y) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getAbsoluteScale()
	 */
	@Override
	public double getAbsoluteScale() {

		return m_absoluteScale;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getAdvanced()
	 */
	@Override
	public boolean getAdvanced() {

		return m_advanced;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getAlpha()
	 */
	@Override
	public int getAlpha() {

		return m_alpha;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getAntialias()
	 */
	@Override
	public int getAntialias() {

		return m_antialias;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getBackgroundColor()
	 */
	@Override
	public Color getBackgroundColor() {

		return m_backgroundColor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getClip(org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	public Rectangle getClip(Rectangle i_rect) {

		/*
		 * i_rect.x = 0; i_rect.y = 0; i_rect.width = Integer.MAX_VALUE;
		 * i_rect.height = Integer.MAX_VALUE;
		 */

		return i_rect;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getFillRule()
	 */
	@Override
	public int getFillRule() {

		return m_fillRule;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getFont()
	 */
	@Override
	public Font getFont() {

		return m_font;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getFontMetrics()
	 */
	@Override
	public FontMetrics getFontMetrics() {

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getForegroundColor()
	 */
	@Override
	public Color getForegroundColor() {

		return m_foregroundColor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getInterpolation()
	 */
	@Override
	public int getInterpolation() {

		return m_interpolation;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineAttributes()
	 */
	@Override
	public LineAttributes getLineAttributes() {

		return new LineAttributes(m_lineWidth, m_lineCap, m_lineJoin,
				m_lineStyle, null, 0, m_lineMiterLimit);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineCap()
	 */
	@Override
	public int getLineCap() {

		return m_lineCap;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineJoin()
	 */
	@Override
	public int getLineJoin() {

		return m_lineJoin;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineMiterLimit()
	 */
	@Override
	public float getLineMiterLimit() {

		return m_lineMiterLimit;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineStyle()
	 */
	@Override
	public int getLineStyle() {

		return m_lineStyle;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineWidth()
	 */
	@Override
	public int getLineWidth() {

		return Math.round(m_lineWidth);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineWidthFloat()
	 */
	@Override
	public float getLineWidthFloat() {

		return m_lineWidth;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getTextAntialias()
	 */
	@Override
	public int getTextAntialias() {

		return m_textAntialias;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getXORMode()
	 */
	@Override
	public boolean getXORMode() {

		return m_xorMode;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#popState()
	 */
	@Override
	public void popState() {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#pushState()
	 */
	@Override
	public void pushState() {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#restoreState()
	 */
	@Override
	public void restoreState() {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#rotate(float)
	 */
	@Override
	public void rotate(float i_degrees) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#scale(double)
	 */
	@Override
	public void scale(double i_amount) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#scale(float, float)
	 */
	@Override
	public void scale(float i_horizontal, float i_vertical) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setAdvanced(boolean)
	 */
	@Override
	public void setAdvanced(boolean i_advanced) {

		m_advanced = i_advanced;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setAlpha(int)
	 */
	@Override
	public void setAlpha(int i_alpha) {

		m_alpha = i_alpha;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setAntialias(int)
	 */
	@Override
	public void setAntialias(int i_value) {

		m_antialias = i_value;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setBackgroundColor(org.eclipse.swt.graphics.Color)
	 */
	@Override
	public void setBackgroundColor(Color i_rgb) {

		m_backgroundColor = i_rgb;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setBackgroundPattern(org.eclipse.swt.graphics.Pattern)
	 */
	@Override
	public void setBackgroundPattern(Pattern i_pattern) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setClip(org.eclipse.swt.graphics.Path)
	 */
	@Override
	public void setClip(Path i_path) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setClip(org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	public void setClip(Rectangle i_r) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setFillRule(int)
	 */
	@Override
	public void setFillRule(int i_rule) {

		m_fillRule = i_rule;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setFont(org.eclipse.swt.graphics.Font)
	 */
	@Override
	public void setFont(Font i_f) {

		m_font = i_f;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setForegroundColor(org.eclipse.swt.graphics.Color)
	 */
	@Override
	public void setForegroundColor(Color i_rgb) {

		m_foregroundColor = i_rgb;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setForegroundPattern(org.eclipse.swt.graphics.Pattern)
	 */
	@Override
	public void setForegroundPattern(Pattern i_pattern) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setInterpolation(int)
	 */
	@Override
	public void setInterpolation(int i_interpolation) {

		m_interpolation = i_interpolation;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineAttributes(org.eclipse.swt.graphics.LineAttributes)
	 */
	@Override
	public void setLineAttributes(LineAttributes i_attributes) {

		m_lineCap = i_attributes.cap;
		m_lineJoin = i_attributes.join;
		m_lineMiterLimit = i_attributes.miterLimit;
		m_lineStyle = i_attributes.style;
		m_lineWidth = i_attributes.width;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineCap(int)
	 */
	@Override
	public void setLineCap(int i_cap) {

		m_lineCap = i_cap;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineDash(float[])
	 */
	@Override
	public void setLineDash(float[] i_value) {

		// ignore
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineDash(int[])
	 */
	@Override
	public void setLineDash(int[] i_dash) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineJoin(int)
	 */
	@Override
	public void setLineJoin(int i_join) {

		m_lineJoin = i_join;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineMiterLimit(float)
	 */
	@Override
	public void setLineMiterLimit(float i_miterLimit) {

		m_lineMiterLimit = i_miterLimit;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineStyle(int)
	 */
	@Override
	public void setLineStyle(int i_style) {

		m_lineStyle = i_style;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineWidth(int)
	 */
	@Override
	public void setLineWidth(int i_width) {

		m_lineWidth = i_width;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineWidthFloat(float)
	 */
	@Override
	public void setLineWidthFloat(float i_width) {

		m_lineWidth = i_width;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setTextAntialias(int)
	 */
	@Override
	public void setTextAntialias(int i_value) {

		m_textAntialias = i_value;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setXORMode(boolean)
	 */
	@Override
	public void setXORMode(boolean i_b) {

		m_xorMode = i_b;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#shear(float, float)
	 */
	@Override
	public void shear(float i_horz, float i_vert) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#translate(float, float)
	 */
	@Override
	public void translate(float i_dx, float i_dy) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#translate(int, int)
	 */
	@Override
	public void translate(int i_dx, int i_dy) {

		// nothing to do
	}
}
