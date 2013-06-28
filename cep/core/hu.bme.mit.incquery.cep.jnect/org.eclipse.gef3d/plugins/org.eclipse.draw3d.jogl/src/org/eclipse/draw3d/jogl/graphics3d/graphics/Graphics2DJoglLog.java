/*******************************************************************************
 * Copyright (c) 2009-2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 *    Madhu Samuel   - Implementation
 ******************************************************************************/

package org.eclipse.draw3d.jogl.graphics3d.graphics;

import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import javax.media.opengl.GL;

import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.jogl.graphics3d.font.JoglFontManager;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.graphics.TextLayout;

/**
 * An extension of LwjglGraphics that logs all calls that change the
 * state of the graphics object.
 * 
 * @author Madhu Samuel
 * @version $Revision$
 * @since 24.08.2009
 */
public class Graphics2DJoglLog extends Graphics2DJogl {

	private final Logger log;

	/**
	 * @param i_width
	 * @param i_height
	 */
	public Graphics2DJoglLog(int i_width, int i_height, JoglFontManager fontManager, GL gl) {

		super(i_width, i_height, fontManager, gl);

		log = Logger.getLogger(Graphics2DJoglLog.class.getName());
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
					"caught exception while configuring LwjglGraphicsLog"
							+ ex);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#clipRect(org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	public void clipRect(Rectangle i_r) {

		log.info("clipRect(" + newRectangle(i_r) + ");");
		super.clipRect(i_r);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#dispose()
	 */
	@Override
	public void dispose() {

		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawArc(int, int, int, int, int, int)
	 */
	@Override
	public void drawArc(int i_x, int i_y, int i_w, int i_h, int i_offset,
			int i_length) {

		log.info("drawArc(" + intArgs(i_x, i_y, i_w, i_h, i_offset, i_length)
				+ ");");

		super.drawArc(i_x, i_y, i_w, i_h, i_offset, i_length);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawFocus(int, int, int, int)
	 */
	@Override
	public void drawFocus(int i_x, int i_y, int i_w, int i_h) {

		log.info("drawFocus(" + intArgs(i_x, i_y, i_w, i_h) + ");");

		super.drawFocus(i_x, i_y, i_w, i_h);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawImage(org.eclipse.swt.graphics.Image,
	 *      int, int)
	 */
	@Override
	public void drawImage(Image i_srcImage, int i_x, int i_y) {

		log.info("drawImage(<image>, " + intArgs(i_x, i_y) + ");");

		super.drawImage(i_srcImage, i_x, i_y);
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

		log.info("drawImage(<image>, "
				+ intArgs(i_x1, i_y1, i_w1, i_h1, i_x2, i_y2, i_w2, i_h2)
				+ ");");

		super.drawImage(i_srcImage, i_x1, i_y1, i_w1, i_h1, i_x2, i_y2, i_w2,
				i_h2);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawLine(int, int, int, int)
	 */
	@Override
	public void drawLine(int i_x1, int i_y1, int i_x2, int i_y2) {

		log.info("drawLine(" + intArgs(i_x1, i_y1, i_x2, i_y2) + ");");

		super.drawLine(i_x1, i_y1, i_x2, i_y2);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawOval(int, int, int, int)
	 */
	@Override
	public void drawOval(int i_x, int i_y, int i_w, int i_h) {

		log.info("drawOval(" + intArgs(i_x, i_y, i_w, i_h) + ");");

		super.drawOval(i_x, i_y, i_w, i_h);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawPath(org.eclipse.swt.graphics.Path)
	 */
	@Override
	public void drawPath(Path i_path) {

		log.info("drawPath(<path>);");

		super.drawPath(i_path);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawPolygon(org.eclipse.draw2d.geometry.PointList)
	 */
	@Override
	public void drawPolygon(PointList i_points) {

		log.info("drawPolygon(" + newPointList(i_points) + ");");

		super.drawPolygon(i_points);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawPolyline(org.eclipse.draw2d.geometry.PointList)
	 */
	@Override
	public void drawPolyline(PointList i_points) {

		log.info("drawPolyline(" + newPointList(i_points) + ");");

		super.drawPolyline(i_points);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawRectangle(int, int, int, int)
	 */
	@Override
	public void drawRectangle(int i_x, int i_y, int i_width, int i_height) {

		log
				.info("drawRectangle(" + intArgs(i_x, i_y, i_width, i_height)
						+ ");");

		super.drawRectangle(i_x, i_y, i_width, i_height);
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

		log.info("drawRoundRectangle(" + newRectangle(i_r) + ", "
				+ intArgs(i_arcWidth, i_arcHeight) + ");");

		super.drawRoundRectangle(i_r, i_arcWidth, i_arcHeight);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawString(java.lang.String, int, int)
	 */
	@Override
	public void drawString(String i_s, int i_x, int i_y) {

		log.info("drawString(" + string(i_s) + ", " + intArgs(i_x, i_y) + ");");

		super.drawString(i_s, i_x, i_y);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawText(java.lang.String, int, int)
	 */
	@Override
	public void drawText(String i_s, int i_x, int i_y) {

		log.info("drawText(" + string(i_s) + ", " + intArgs(i_x, i_y) + ");");

		super.drawText(i_s, i_x, i_y);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawText(java.lang.String, int, int,
	 *      int)
	 */
	@Override
	public void drawText(String i_s, int i_x, int i_y, int i_style) {

		log.info("drawText(" + string(i_s) + ", " + intArgs(i_x, i_y, i_style)
				+ ");");

		super.drawText(i_s, i_x, i_y, i_style);
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

		log.info("drawTextLayout(<layout>, "
				+ intArgs(i_x, i_y, i_selectionStart, i_selectionEnd) + ", "
				+ newColor(i_selectionForeground) + ", "
				+ newColor(i_selectionBackground) + ");");

		super.drawTextLayout(i_layout, i_x, i_y, i_selectionStart,
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

		log.info("fillArc(" + intArgs(i_x, i_y, i_w, i_h, i_offset, i_length)
				+ ");");

		super.fillArc(i_x, i_y, i_w, i_h, i_offset, i_length);
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

		log.info("fillGradient(" + intArgs(i_x, i_y, i_w, i_h) + ", "
				+ i_vertical + ");");

		super.fillGradient(i_x, i_y, i_w, i_h, i_vertical);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillOval(int, int, int, int)
	 */
	@Override
	public void fillOval(int i_x, int i_y, int i_w, int i_h) {

		log.info("fillOval(" + intArgs(i_x, i_y, i_w, i_h) + ");");

		super.fillOval(i_x, i_y, i_w, i_h);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillPath(org.eclipse.swt.graphics.Path)
	 */
	@Override
	public void fillPath(Path i_path) {

		log.info("fillPath(<path>);");

		super.fillPath(i_path);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillPolygon(org.eclipse.draw2d.geometry.PointList)
	 */
	@Override
	public void fillPolygon(PointList i_points) {

		log.info("fillPolygon(" + newPointList(i_points) + ");");

		super.fillPolygon(i_points);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillRectangle(int, int, int, int)
	 */
	@Override
	public void fillRectangle(int i_x, int i_y, int i_width, int i_height) {

		log
				.info("fillRectangle(" + intArgs(i_x, i_y, i_width, i_height)
						+ ");");

		super.fillRectangle(i_x, i_y, i_width, i_height);
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

		log.info("fillRoundRectangle(" + newRectangle(i_r) + ", "
				+ intArgs(i_arcWidth, i_arcHeight) + ");");

		super.fillRoundRectangle(i_r, i_arcWidth, i_arcHeight);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillString(java.lang.String, int, int)
	 */
	@Override
	public void fillString(String i_s, int i_x, int i_y) {

		log.info("fillString(" + string(i_s) + ", " + intArgs(i_x, i_y) + ");");

		super.fillString(i_s, i_x, i_y);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillText(java.lang.String, int, int)
	 */
	@Override
	public void fillText(String i_s, int i_x, int i_y) {

		log.info("fillText(" + string(i_s) + ", " + intArgs(i_x, i_y) + ");");

		super.fillText(i_s, i_x, i_y);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglGraphics#getAlpha()
	 */
	@Override
	public int getAlpha() {

		return super.getAlpha();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getAntialias()
	 */
	@Override
	public int getAntialias() {

		return super.getAntialias();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getBackgroundColor()
	 */
	@Override
	public Color getBackgroundColor() {

		return super.getBackgroundColor();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getClip(org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	public Rectangle getClip(Rectangle i_rect) {

		return super.getClip(i_rect);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getFillRule()
	 */
	@Override
	public int getFillRule() {

		return super.getFillRule();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getFont()
	 */
	@Override
	public Font getFont() {

		return super.getFont();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getFontMetrics()
	 */
	@Override
	public FontMetrics getFontMetrics() {

		return super.getFontMetrics();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getForegroundColor()
	 */
	@Override
	public Color getForegroundColor() {

		return super.getForegroundColor();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getInterpolation()
	 */
	@Override
	public int getInterpolation() {

		return super.getInterpolation();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineCap()
	 */
	@Override
	public int getLineCap() {

		return super.getLineCap();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineJoin()
	 */
	@Override
	public int getLineJoin() {

		return super.getLineJoin();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineStyle()
	 */
	@Override
	public int getLineStyle() {

		return super.getLineStyle();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getLineWidth()
	 */
	@Override
	public int getLineWidth() {

		return super.getLineWidth();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getTextAntialias()
	 */
	@Override
	public int getTextAntialias() {

		return super.getTextAntialias();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#getXORMode()
	 */
	@Override
	public boolean getXORMode() {

		return super.getXORMode();
	}

	private String intArgs(int... args) {

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < args.length; i++) {
			builder.append(args[i]);
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

	private String newIntArray(int[] i_array) {

		StringBuilder builder = new StringBuilder();

		builder.append("(int[]) [");
		for (int i = 0; i < i_array.length; i++) {
			builder.append(i_array[i]);
			if (i < i_array.length - 1)
				builder.append(", ");
		}
		builder.append("]");

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

		log.info("popState()");

		super.popState();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#pushState()
	 */
	@Override
	public void pushState() {

		log.info("pushState();");

		super.pushState();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#restoreState()
	 */
	@Override
	public void restoreState() {

		log.info("restoreState();");

		super.restoreState();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#rotate(float)
	 */
	@Override
	public void rotate(float i_degrees) {

		log.info("rotate(" + i_degrees + "f);");

		super.rotate(i_degrees);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#scale(double)
	 */
	@Override
	public void scale(double i_amount) {

		log.info("scale(" + i_amount + "d);");

		super.scale(i_amount);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#scale(float, float)
	 */
	@Override
	public void scale(float i_horizontal, float i_vertical) {

		log.info("scale(" + i_horizontal + "f, " + i_vertical + "f);");

		super.scale(i_horizontal, i_vertical);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglGraphics#setAlpha(int)
	 */
	@Override
	public void setAlpha(int i_alpha) {

		log.info("setAlpha(" + i_alpha + ");");

		super.setAlpha(i_alpha);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setAntialias(int)
	 */
	@Override
	public void setAntialias(int i_value) {

		log.info("setAntialias(" + i_value + ");");

		super.setAntialias(i_value);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setBackgroundColor(org.eclipse.swt.graphics.Color)
	 */
	@Override
	public void setBackgroundColor(Color i_rgb) {

		log.info("setBackgroundColor(" + newColor(i_rgb) + ");");

		super.setBackgroundColor(i_rgb);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setBackgroundPattern(org.eclipse.swt.graphics.Pattern)
	 */
	@Override
	public void setBackgroundPattern(Pattern i_pattern) {

		log.info("setBackgroundPattern(<pattern>);");

		super.setBackgroundPattern(i_pattern);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setClip(org.eclipse.swt.graphics.Path)
	 */
	@Override
	public void setClip(Path i_path) {

		log.info("setClip(<path>);");

		super.setClip(i_path);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setClip(org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	public void setClip(Rectangle i_r) {

		log.info("setClip(" + newRectangle(i_r) + ");");

		super.setClip(i_r);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setFillRule(int)
	 */
	@Override
	public void setFillRule(int i_rule) {

		log.info("setFillRule(" + i_rule + ");");

		super.setFillRule(i_rule);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setFont(org.eclipse.swt.graphics.Font)
	 */
	@Override
	public void setFont(Font i_f) {

		FontData[] fontData = i_f.getFontData();

		StringBuilder builder = new StringBuilder();
		builder.append("new org.eclipse.swt.graphics.Font(display, ");
		builder.append("(org.eclipse.swt.graphics.FontData[]) [");
		for (int i = 0; i < fontData.length; i++) {
			builder.append("new org.eclipse.swt.graphics.FontData(");
			builder.append(string(fontData[i].getName()));
			builder.append(", ");
			builder.append(fontData[i].getHeight());
			builder.append(", ");
			builder.append(fontData[i].getStyle());
			builder.append(")");
			if (i < fontData.length - 1)
				builder.append(", ");
		}

		builder.append("])");

		log.info("setFont(" + builder.toString() + ");");

		super.setFont(i_f);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setForegroundColor(org.eclipse.swt.graphics.Color)
	 */
	@Override
	public void setForegroundColor(Color i_rgb) {

		log.info("setForegroundColor(" + newColor(i_rgb) + ");");

		super.setForegroundColor(i_rgb);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setForegroundPattern(org.eclipse.swt.graphics.Pattern)
	 */
	@Override
	public void setForegroundPattern(Pattern i_pattern) {

		log.info("setForegroundPattern(<pattern>);");

		super.setForegroundPattern(i_pattern);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setInterpolation(int)
	 */
	@Override
	public void setInterpolation(int i_interpolation) {

		log.info("setInterpolation(" + i_interpolation + ");");

		super.setInterpolation(i_interpolation);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineCap(int)
	 */
	@Override
	public void setLineCap(int i_cap) {

		log.info("setLineCap(" + i_cap + ");");

		super.setLineCap(i_cap);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglGraphics#setLineDash(int[])
	 */
	@Override
	public void setLineDash(int[] i_dash) {

		log.info("setLineDash(" + newIntArray(i_dash) + ");");

		super.setLineDash(i_dash);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineJoin(int)
	 */
	@Override
	public void setLineJoin(int i_join) {

		log.info("setLineJoin(" + i_join + ");");

		super.setLineJoin(i_join);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineStyle(int)
	 */
	@Override
	public void setLineStyle(int i_style) {

		log.info("setLineStyle(" + i_style + ");");

		super.setLineStyle(i_style);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setLineWidth(int)
	 */
	@Override
	public void setLineWidth(int i_width) {

		log.info("setLineWidth(" + i_width + ");");

		super.setLineWidth(i_width);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setTextAntialias(int)
	 */
	@Override
	public void setTextAntialias(int i_value) {

		log.info("setTextAntialias(" + i_value + ");");

		super.setTextAntialias(i_value);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setXORMode(boolean)
	 */
	@Override
	public void setXORMode(boolean i_b) {

		log.info("setXORMode(" + i_b + ");");

		super.setXORMode(i_b);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#shear(float, float)
	 */
	@Override
	public void shear(float i_horz, float i_vert) {

		log.info("shear(" + i_horz + "f, " + i_vert + "f);");

		super.shear(i_horz, i_vert);
	}

	private String string(String i_str) {

		return "\"" + i_str + "\"";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#translate(float, float)
	 */
	@Override
	public void translate(float i_dx, float i_dy) {

		log.info("translate(" + i_dx + "f, " + i_dy + "f);");

		super.translate(i_dx, i_dy);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#translate(int, int)
	 */
	@Override
	public void translate(int i_dx, int i_dy) {

		log.info("translate(" + intArgs(i_dx, i_dy) + ");");

		super.translate(i_dx, i_dy);
	}

}
