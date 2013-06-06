/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/

package org.eclipse.draw3d.util;

import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.graphics.TextLayout;

/**
 * An wrapper graphics object that logs all calls that change the state of the
 * graphics object.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 18.06.2008
 */
public class LogGraphics extends Graphics {

	private final Logger log;

	private Graphics m_graphics;

	private String m_prefix = "";

	/**
	 * Creates a new instance that delegates to the given graphics instance.
	 * 
	 * @param i_graphics
	 *            the graphics object to delegate to
	 * @throws NullPointerException
	 *             if the given graphics instance is <code>null</code>
	 */
	public LogGraphics(Graphics i_graphics) {

		this(i_graphics, null);
	}

	/**
	 * Creates a new instance that delegates to the given graphics instance.
	 * 
	 * @param i_graphics
	 *            the graphics object to delegate to
	 * @param i_prefix
	 *            the prefix for all logged operations
	 * @throws NullPointerException
	 *             if the given graphics instance is <code>null</code>
	 */
	public LogGraphics(Graphics i_graphics, String i_prefix) {

		if (i_graphics == null)
			throw new NullPointerException("i_graphics must not be null");

		log = Logger.getLogger(LogGraphics.class.getName());
		log.setUseParentHandlers(false);

		Handler[] handlers = log.getHandlers();
		for (int i = 0; i < handlers.length; i++)
			log.removeHandler(handlers[i]);

		try {
			String logFile = "/%h/logGraphics.%u.%g.log";
			FileHandler handler = new FileHandler(logFile, true);
			handler.setFormatter(new Formatter() {

				@Override
				public String format(LogRecord i_record) {

					return i_record.getMessage() + "\n";
				}
			});

			log.addHandler(handler);
		} catch (Exception ex) {
			log.warning(ex.getMessage());
			throw new RuntimeException(
					"caught exception while configuring LogGraphics" + ex);
		}

		m_graphics = i_graphics;
		if (i_prefix != null)
			m_prefix = i_prefix;

		log.info("// ======== LogGraphics initialized ========");
	}

	private String boolArgs(boolean... args) {

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < args.length; i++) {
			builder.append(Boolean.toString(args[i]));
			if (i < args.length - 1)
				builder.append(", ");
		}

		return builder.toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#clipRect(org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	public void clipRect(Rectangle i_r) {

		log.info(m_prefix + "clipRect(" + newRectangle(i_r) + ")");

		m_graphics.clipRect(i_r);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#dispose()
	 */
	@Override
	public void dispose() {

		m_graphics.dispose();
	}

	private String doubleArgs(double... args) {

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < args.length; i++) {
			builder.append(Double.toString(args[i])).append("d");
			if (i < args.length - 1)
				builder.append(", ");
		}

		return builder.toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawArc(int, int, int, int, int, int)
	 */
	@Override
	public void drawArc(int i_x, int i_y, int i_w, int i_h, int i_offset,
			int i_length) {

		log.info(m_prefix + "drawArc("
				+ intArgs(i_x, i_y, i_w, i_h, i_offset, i_length) + ")");

		m_graphics.drawArc(i_x, i_y, i_w, i_h, i_offset, i_length);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawFocus(int, int, int, int)
	 */
	@Override
	public void drawFocus(int i_x, int i_y, int i_w, int i_h) {

		log.info(m_prefix + "drawFocus(" + intArgs(i_x, i_y, i_w, i_h) + ")");

		m_graphics.drawFocus(i_x, i_y, i_w, i_h);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawImage(org.eclipse.swt.graphics.Image,
	 *      int, int)
	 */
	@Override
	public void drawImage(Image i_srcImage, int i_x, int i_y) {

		log.info(m_prefix + "drawImage(<image>, " + intArgs(i_x, i_y) + ")");

		m_graphics.drawImage(i_srcImage, i_x, i_y);
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

		log
				.info(m_prefix
						+ "drawImage(<image>, "
						+ intArgs(i_x1, i_y1, i_w1, i_h1, i_x2, i_y2, i_w2,
								i_h2) + ")");

		m_graphics.drawImage(i_srcImage, i_x1, i_y1, i_w1, i_h1, i_x2, i_y2,
				i_w2, i_h2);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawLine(int, int, int, int)
	 */
	@Override
	public void drawLine(int i_x1, int i_y1, int i_x2, int i_y2) {

		log
				.info(m_prefix + "drawLine(" + intArgs(i_x1, i_y1, i_x2, i_y2)
						+ ")");

		m_graphics.drawLine(i_x1, i_y1, i_x2, i_y2);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawOval(int, int, int, int)
	 */
	@Override
	public void drawOval(int i_x, int i_y, int i_w, int i_h) {

		log.info(m_prefix + "drawOval(" + intArgs(i_x, i_y, i_w, i_h) + ")");

		m_graphics.drawOval(i_x, i_y, i_w, i_h);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawPath(org.eclipse.swt.graphics.Path)
	 */
	@Override
	public void drawPath(Path i_path) {

		log.info(m_prefix + "drawPath(<path>)");

		m_graphics.drawPath(i_path);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawPolygon(org.eclipse.draw2d.geometry.PointList)
	 */
	@Override
	public void drawPolygon(PointList i_points) {

		log.info(m_prefix + "drawPolygon(" + newPointList(i_points) + ")");

		m_graphics.drawPolygon(i_points);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawPolyline(org.eclipse.draw2d.geometry.PointList)
	 */
	@Override
	public void drawPolyline(PointList i_points) {

		log.info(m_prefix + "drawPolyline(" + newPointList(i_points) + ")");

		m_graphics.drawPolyline(i_points);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawRectangle(int, int, int, int)
	 */
	@Override
	public void drawRectangle(int i_x, int i_y, int i_width, int i_height) {

		log.info(m_prefix + "drawRectangle("
				+ intArgs(i_x, i_y, i_width, i_height) + ")");

		m_graphics.drawRectangle(i_x, i_y, i_width, i_height);
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

		log.info(m_prefix + "drawRoundRectangle(" + newRectangle(i_r) + ", "
				+ intArgs(i_arcWidth, i_arcHeight) + ")");

		m_graphics.drawRoundRectangle(i_r, i_arcWidth, i_arcHeight);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawString(java.lang.String, int, int)
	 */
	@Override
	public void drawString(String i_s, int i_x, int i_y) {

		log.info(m_prefix + "drawString(" + stringArg(i_s) + ", "
				+ intArgs(i_x, i_y) + ")");

		m_graphics.drawString(i_s, i_x, i_y);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawText(java.lang.String, int, int)
	 */
	@Override
	public void drawText(String i_s, int i_x, int i_y) {

		log.info(m_prefix + "drawText(" + stringArg(i_s) + ", "
				+ intArgs(i_x, i_y) + ")");

		m_graphics.drawText(i_s, i_x, i_y);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawText(java.lang.String, int, int,
	 *      int)
	 */
	@Override
	public void drawText(String i_s, int i_x, int i_y, int i_style) {

		log.info(m_prefix + "drawText(" + stringArg(i_s) + ", "
				+ intArgs(i_x, i_y, i_style) + ")");

		m_graphics.drawText(i_s, i_x, i_y, i_style);
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

		log.info(m_prefix + "drawTextLayout(<layout>, "
				+ intArgs(i_x, i_y, i_selectionStart, i_selectionEnd) + ", "
				+ newColor(i_selectionForeground) + ", "
				+ newColor(i_selectionBackground) + ")");

		m_graphics.drawTextLayout(i_layout, i_x, i_y, i_selectionStart,
				i_selectionEnd, i_selectionForeground, i_selectionBackground);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillArc(int, int, int, int, int, int)
	 */
	@Override
	public void fillArc(int i_x, int i_y, int i_w, int i_h, int i_offset,
			int i_length) {

		log.info(m_prefix + "fillArc("
				+ intArgs(i_x, i_y, i_w, i_h, i_offset, i_length) + ")");

		m_graphics.fillArc(i_x, i_y, i_w, i_h, i_offset, i_length);
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

		log.info(m_prefix + "fillGradient(" + intArgs(i_x, i_y, i_w, i_h)
				+ ", " + boolArgs(i_vertical) + ")");

		m_graphics.fillGradient(i_x, i_y, i_w, i_h, i_vertical);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillOval(int, int, int, int)
	 */
	@Override
	public void fillOval(int i_x, int i_y, int i_w, int i_h) {

		log.info(m_prefix + "fillOval(" + intArgs(i_x, i_y, i_w, i_h) + ")");

		m_graphics.fillOval(i_x, i_y, i_w, i_h);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillPath(org.eclipse.swt.graphics.Path)
	 */
	@Override
	public void fillPath(Path i_path) {

		log.info(m_prefix + "fillPath(<path>)");

		m_graphics.fillPath(i_path);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillPolygon(org.eclipse.draw2d.geometry.PointList)
	 */
	@Override
	public void fillPolygon(PointList i_points) {

		log.info(m_prefix + "fillPolygon(" + newPointList(i_points) + ")");

		m_graphics.fillPolygon(i_points);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillRectangle(int, int, int, int)
	 */
	@Override
	public void fillRectangle(int i_x, int i_y, int i_width, int i_height) {

		log.info(m_prefix + "fillRectangle("
				+ intArgs(i_x, i_y, i_width, i_height) + ")");

		m_graphics.fillRectangle(i_x, i_y, i_width, i_height);
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

		log.info(m_prefix + "fillRoundRectangle(" + newRectangle(i_r) + ", "
				+ intArgs(i_arcWidth, i_arcHeight) + ")");

		m_graphics.fillRoundRectangle(i_r, i_arcWidth, i_arcHeight);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillString(java.lang.String, int, int)
	 */
	@Override
	public void fillString(String i_s, int i_x, int i_y) {

		log.info(m_prefix + "fillString(" + stringArg(i_s) + ", "
				+ intArgs(i_x, i_y) + ")");

		m_graphics.fillString(i_s, i_x, i_y);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillText(java.lang.String, int, int)
	 */
	@Override
	public void fillText(String i_s, int i_x, int i_y) {

		log.info(m_prefix + "fillText(" + stringArg(i_s) + ", "
				+ intArgs(i_x, i_y) + ")");

		m_graphics.fillText(i_s, i_x, i_y);
	}

	private String floatArgs(float... args) {

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < args.length; i++) {
			builder.append(Float.toString(args[i])).append("f");
			if (i < args.length - 1)
				builder.append(", ");
		}

		return builder.toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getAdvanced()
	 */
	@Override
	public boolean getAdvanced() {

		return m_graphics.getAdvanced();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see Graphics#getAlpha()
	 */
	@Override
	public int getAlpha() {

		return m_graphics.getAlpha();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getAntialias()
	 */
	@Override
	public int getAntialias() {

		return m_graphics.getAntialias();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getBackgroundColor()
	 */
	@Override
	public Color getBackgroundColor() {

		return m_graphics.getBackgroundColor();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getClip(org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	public Rectangle getClip(Rectangle i_rect) {

		return m_graphics.getClip(i_rect);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getFillRule()
	 */
	@Override
	public int getFillRule() {

		return m_graphics.getFillRule();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getFont()
	 */
	@Override
	public Font getFont() {

		return m_graphics.getFont();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getFontMetrics()
	 */
	@Override
	public FontMetrics getFontMetrics() {

		return m_graphics.getFontMetrics();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getForegroundColor()
	 */
	@Override
	public Color getForegroundColor() {

		return m_graphics.getForegroundColor();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getInterpolation()
	 */
	@Override
	public int getInterpolation() {

		return m_graphics.getInterpolation();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineAttributes()
	 */
	@Override
	public LineAttributes getLineAttributes() {

		return m_graphics.getLineAttributes();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineCap()
	 */
	@Override
	public int getLineCap() {

		return m_graphics.getLineCap();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineJoin()
	 */
	@Override
	public int getLineJoin() {

		return m_graphics.getLineJoin();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineMiterLimit()
	 */
	@Override
	public float getLineMiterLimit() {

		return m_graphics.getLineMiterLimit();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineStyle()
	 */
	@Override
	public int getLineStyle() {

		return m_graphics.getLineStyle();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineWidth()
	 */
	@Override
	public int getLineWidth() {

		return m_graphics.getLineWidth();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineWidthFloat()
	 */
	@Override
	public float getLineWidthFloat() {

		return m_graphics.getLineWidthFloat();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getTextAntialias()
	 */
	@Override
	public int getTextAntialias() {

		return m_graphics.getTextAntialias();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getXORMode()
	 */
	@Override
	public boolean getXORMode() {

		return m_graphics.getXORMode();
	}

	private String intArgs(int... args) {

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < args.length; i++) {
			builder.append(Integer.toString(args[i]));
			if (i < args.length - 1)
				builder.append(", ");
		}

		return builder.toString();
	}

	private String newColor(Color i_rgb) {

		return "new org.eclipse.swt.graphics.Color(display, "
				+ intArgs(i_rgb.getRed(), i_rgb.getGreen(), i_rgb.getBlue())
				+ ")";
	}

	private String newFloatArray(float[] i_array) {

		if (i_array == null)
			return null;

		StringBuilder builder = new StringBuilder();

		builder.append("(float[]) [");
		for (int i = 0; i < i_array.length; i++) {
			builder.append(Float.toString(i_array[i])).append("f");
			if (i < i_array.length - 1)
				builder.append(", ");
		}
		builder.append("]");

		return builder.toString();
	}

	private String newFont(Font i_font) {

		FontData[] fontData = i_font.getFontData();

		StringBuilder builder = new StringBuilder();
		builder.append("new org.eclipse.swt.graphics.Font(display, ");
		builder.append("(org.eclipse.swt.graphics.FontData[]) [");

		for (int i = 0; i < fontData.length; i++) {
			builder.append("new org.eclipse.swt.graphics.FontData(");
			builder.append(stringArg(fontData[i].getName())).append(", ");
			builder.append(intArgs(fontData[i].getHeight(), fontData[i]
					.getStyle()));
			builder.append(")");
			if (i < fontData.length - 1)
				builder.append(", ");
		}

		builder.append("])");

		String s = builder.toString();
		return s;
	}

	private String newIntArray(int[] i_array) {

		if (i_array == null)
			return "null";

		StringBuilder builder = new StringBuilder();

		builder.append("(int[]) [");
		for (int i = 0; i < i_array.length; i++) {
			builder.append(Integer.toString(i_array[i]));
			if (i < i_array.length - 1)
				builder.append(", ");
		}
		builder.append("]");

		return builder.toString();
	}

	/**
	 * @param i_attributes
	 * @return
	 */
	private String newLineAttributes(LineAttributes i_attributes) {

		StringBuilder builder = new StringBuilder();

		builder.append("new org.eclipse.swt.graphics.LineAttributes(");
		builder.append(floatArgs(i_attributes.width)).append(", ");
		String cjs = intArgs(i_attributes.cap, i_attributes.join,
				i_attributes.style);
		builder.append(cjs).append(", ");
		builder.append(newFloatArray(i_attributes.dash)).append(", ");
		builder.append(floatArgs(i_attributes.dashOffset,
				i_attributes.miterLimit));
		builder.append(")");

		return builder.toString();
	}

	private String newPointList(PointList i_points) {

		StringBuilder builder = new StringBuilder();

		builder.append("new org.eclipse.draw2d.geometry.PointList(");
		builder.append(newIntArray(i_points.toIntArray()));
		builder.append(")");

		return builder.toString();
	}

	private String newRectangle(Rectangle i_r) {

		return "new org.eclipse.draw2d.geometry.Rectangle("
				+ intArgs(i_r.x, i_r.y, i_r.width, i_r.height) + ")";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#popState()
	 */
	@Override
	public void popState() {

		log.info(m_prefix + "popState()");

		m_graphics.popState();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#pushState()
	 */
	@Override
	public void pushState() {

		log.info(m_prefix + "pushState()");

		m_graphics.pushState();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#restoreState()
	 */
	@Override
	public void restoreState() {

		log.info(m_prefix + "restoreState()");

		m_graphics.restoreState();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#rotate(float)
	 */
	@Override
	public void rotate(float i_degrees) {

		log.info(m_prefix + "rotate(" + floatArgs(i_degrees) + ")");

		m_graphics.rotate(i_degrees);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#scale(double)
	 */
	@Override
	public void scale(double i_amount) {

		log.info(m_prefix + "scale(" + doubleArgs(i_amount) + ")");

		m_graphics.scale(i_amount);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#scale(float, float)
	 */
	@Override
	public void scale(float i_horizontal, float i_vertical) {

		log.info(m_prefix + "scale(" + floatArgs(i_horizontal, i_vertical)
				+ ")");

		m_graphics.scale(i_horizontal, i_vertical);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setAdvanced(boolean)
	 */
	@Override
	public void setAdvanced(boolean i_advanced) {

		log.info(m_prefix + "setAdvanced(" + boolArgs(i_advanced) + ")");

		m_graphics.setAdvanced(i_advanced);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setAlpha(int)
	 */
	@Override
	public void setAlpha(int i_alpha) {

		log.info(m_prefix + "setAlpha(" + intArgs(i_alpha) + ")");

		m_graphics.setAlpha(i_alpha);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setAntialias(int)
	 */
	@Override
	public void setAntialias(int i_value) {

		log.info(m_prefix + "setAntialias(" + intArgs(i_value) + ")");

		m_graphics.setAntialias(i_value);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setBackgroundColor(org.eclipse.swt.graphics.Color)
	 */
	@Override
	public void setBackgroundColor(Color i_rgb) {

		log.info(m_prefix + "setBackgroundColor(" + newColor(i_rgb) + ")");

		m_graphics.setBackgroundColor(i_rgb);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setBackgroundPattern(org.eclipse.swt.graphics.Pattern)
	 */
	@Override
	public void setBackgroundPattern(Pattern i_pattern) {

		log.info(m_prefix + "setBackgroundPattern(<pattern>)");

		m_graphics.setBackgroundPattern(i_pattern);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setClip(org.eclipse.swt.graphics.Path)
	 */
	@Override
	public void setClip(Path i_path) {

		log.info(m_prefix + "setClip(<path>)");

		m_graphics.setClip(i_path);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setClip(org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	public void setClip(Rectangle i_r) {

		log.info(m_prefix + "setClip(" + newRectangle(i_r) + ")");

		m_graphics.setClip(i_r);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setFillRule(int)
	 */
	@Override
	public void setFillRule(int i_rule) {

		log.info(m_prefix + "setFillRule(" + intArgs(i_rule) + ")");

		m_graphics.setFillRule(i_rule);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setFont(org.eclipse.swt.graphics.Font)
	 */
	@Override
	public void setFont(Font i_f) {

		log.info(m_prefix + "setFont(" + newFont(i_f) + ")");

		m_graphics.setFont(i_f);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setForegroundColor(org.eclipse.swt.graphics.Color)
	 */
	@Override
	public void setForegroundColor(Color i_rgb) {

		log.info(m_prefix + "setForegroundColor(" + newColor(i_rgb) + ")");

		m_graphics.setForegroundColor(i_rgb);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setForegroundPattern(org.eclipse.swt.graphics.Pattern)
	 */
	@Override
	public void setForegroundPattern(Pattern i_pattern) {

		log.info(m_prefix + "setForegroundPattern(<pattern>)");

		m_graphics.setForegroundPattern(i_pattern);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setInterpolation(int)
	 */
	@Override
	public void setInterpolation(int i_interpolation) {

		log.info(m_prefix + "setInterpolation(" + intArgs(i_interpolation)
				+ ")");

		m_graphics.setInterpolation(i_interpolation);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineAttributes(org.eclipse.swt.graphics.LineAttributes)
	 */
	@Override
	public void setLineAttributes(LineAttributes i_attributes) {

		log.info(m_prefix + "setLineAttributes("
				+ newLineAttributes(i_attributes) + ")");

		m_graphics.setLineAttributes(i_attributes);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineCap(int)
	 */
	@Override
	public void setLineCap(int i_cap) {

		log.info(m_prefix + "setLineCap(" + intArgs(i_cap) + ")");

		m_graphics.setLineCap(i_cap);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineDash(float[])
	 */
	@Override
	public void setLineDash(float[] i_dash) {

		log.info(m_prefix + "setLineDash(" + newFloatArray(i_dash) + ")");

		m_graphics.setLineDash(i_dash);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineDash(int[])
	 */
	@Override
	public void setLineDash(int[] i_dash) {

		log.info(m_prefix + "setLineDash(" + newIntArray(i_dash) + ")");

		m_graphics.setLineDash(i_dash);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineJoin(int)
	 */
	@Override
	public void setLineJoin(int i_join) {

		log.info(m_prefix + "setLineJoin(" + intArgs(i_join) + ")");

		m_graphics.setLineJoin(i_join);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineMiterLimit(float)
	 */
	@Override
	public void setLineMiterLimit(float i_miterLimit) {

		log.info(m_prefix + "setLineMiterLimit(" + floatArgs(i_miterLimit)
				+ ")");

		m_graphics.setLineMiterLimit(i_miterLimit);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineStyle(int)
	 */
	@Override
	public void setLineStyle(int i_style) {

		log.info(m_prefix + "setLineStyle(" + intArgs(i_style) + ")");

		m_graphics.setLineStyle(i_style);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineWidth(int)
	 */
	@Override
	public void setLineWidth(int i_width) {

		log.info(m_prefix + "setLineWidth(" + intArgs(i_width) + ")");

		m_graphics.setLineWidth(i_width);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineWidthFloat(float)
	 */
	@Override
	public void setLineWidthFloat(float i_width) {

		log.info(m_prefix + "setLineWidthFloat(" + floatArgs(i_width) + ")");

		m_graphics.setLineWidthFloat(i_width);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setTextAntialias(int)
	 */
	@Override
	public void setTextAntialias(int i_value) {

		log.info(m_prefix + "setTextAntialias(" + intArgs(i_value) + ")");

		m_graphics.setTextAntialias(i_value);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setXORMode(boolean)
	 */
	@Override
	public void setXORMode(boolean i_b) {

		log.info(m_prefix + "setXORMode(" + boolArgs(i_b) + ")");

		m_graphics.setXORMode(i_b);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#shear(float, float)
	 */
	@Override
	public void shear(float i_horz, float i_vert) {

		log.info(m_prefix + "shear(" + floatArgs(i_horz, i_vert) + ")");

		m_graphics.shear(i_horz, i_vert);
	}

	private String stringArg(String i_str) {

		return "\"" + i_str + "\"";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#translate(float, float)
	 */
	@Override
	public void translate(float i_dx, float i_dy) {

		log.info(m_prefix + "translate(" + floatArgs(i_dx, i_dy) + ")");

		m_graphics.translate(i_dx, i_dy);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#translate(int, int)
	 */
	@Override
	public void translate(int i_dx, int i_dy) {

		log.info(m_prefix + "translate(" + intArgs(i_dx, i_dy) + ")");

		m_graphics.translate(i_dx, i_dy);
	}

}
