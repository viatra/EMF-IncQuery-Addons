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
package org.eclipse.draw3d.graphics.optimizer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.graphics.StatefulGraphics;
import org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass;
import org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClassifier;
import org.eclipse.draw3d.graphics.optimizer.primitive.ImagePrimitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.LinePrimitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.PolygonPrimitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.PolylinePrimitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.Primitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.QuadPrimitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.TextPrimitive;
import org.eclipse.draw3d.util.ArcHelper;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.widgets.Display;

/**
 * An implementation of {@link Graphics} that collects {@link Primitive
 * primitives} and organizes them in {@link PrimitiveSet primitive sets}.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 18.11.2009
 */
public class RecordingGraphics extends StatefulGraphics {

	private static final float ARC_PREC = 0.5f;

	private static final float PI = (float) Math.PI;

	private static final float PI_2 = (float) (Math.PI / 2);

	private static final float PI_32 = (float) (3 * Math.PI / 2);

	private PrimitiveClassifier m_classifier;

	private GC m_fontGC;

	private Image m_fontImage;

	private PrimitiveSet m_primitives;

	/**
	 * Creates a new instance that uses the given classifier.
	 * 
	 * @param i_classifier the classifier to use
	 * @throws NullPointerException if the given classifier is <code>null</code>
	 */
	public RecordingGraphics(PrimitiveClassifier i_classifier) {

		if (i_classifier == null)
			throw new NullPointerException("i_classifier must not be null");

		m_classifier = i_classifier;
	}

	private void addPrimitive(Primitive i_primitive) {

		if (m_primitives == null) {
			PrimitiveClass primitiveClass = m_classifier.classify(i_primitive);
			m_primitives = new PrimitiveSet(primitiveClass);
		}

		if (!m_primitives.add(i_primitive)) {
			PrimitiveClass primitiveClass = m_classifier.classify(i_primitive);
			m_primitives = new PrimitiveSet(m_primitives, primitiveClass);
			if (!m_primitives.add(i_primitive))
				throw new AssertionError("cannot add primitive " + i_primitive);
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.StatefulGraphics#dispose()
	 */
	@Override
	public void dispose() {

		if (m_fontGC != null) {
			m_fontGC.dispose();
			m_fontGC = null;
		}

		if (m_fontImage != null) {
			m_fontImage.dispose();
			m_fontImage = null;
		}

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

		float rOffset = (float) Math.toRadians(i_offset + i_length);
		float rLength = (float) Math.toRadians(-i_length);

		ArcHelper helper =
			new ArcHelper(ARC_PREC, i_x, i_y, i_w, i_h, rOffset, rLength, false);

		float[] vertices = helper.getArray();
		addPrimitive(new PolylinePrimitive(getState(), vertices));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawFocus(int, int, int, int)
	 */
	@Override
	public void drawFocus(int i_x, int i_y, int i_w, int i_h) {

		pushState();
		try {
			Device dev = Display.getCurrent();
			Color c = dev.getSystemColor(SWT.COLOR_LIST_SELECTION);
			setForegroundColor(c);
			setLineStyle(SWT.LINE_SOLID);
			setLineWidth(2);
			drawRectangle(i_x, i_y, i_w, i_h);
		} finally {
			popState();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawImage(org.eclipse.swt.graphics.Image,
	 *      int, int)
	 */
	@Override
	public void drawImage(Image i_image, int i_x, int i_y) {

		int w = i_image.getBounds().width;
		int h = i_image.getBounds().height;
		drawImage(i_image, 0, 0, w, h, i_x, i_y, w, h);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawImage(org.eclipse.swt.graphics.Image,
	 *      int, int, int, int, int, int, int, int)
	 */
	@Override
	public void drawImage(Image i_image, int i_x1, int i_y1, int i_w1,
		int i_h1, int i_x2, int i_y2, int i_w2, int i_h2) {

		Rectangle source = new Rectangle(i_x1, i_y1, i_w1, i_h1);
		Rectangle target = new Rectangle(i_x2, i_y2, i_w2, i_h2);

		addPrimitive(new ImagePrimitive(getState(), i_image, source, target));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawLine(int, int, int, int)
	 */
	@Override
	public void drawLine(int i_x1, int i_y1, int i_x2, int i_y2) {

		addPrimitive(new LinePrimitive(getState(), i_x1, i_y1, i_x2, i_y2));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawOval(int, int, int, int)
	 */
	@Override
	public void drawOval(int i_x, int i_y, int i_w, int i_h) {

		drawArc(i_x, i_y, i_w, i_h, 0, 360);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawPolygon(org.eclipse.draw2d.geometry.PointList)
	 */
	@Override
	public void drawPolygon(PointList i_points) {

		addPrimitive(new PolygonPrimitive(getState(), i_points, false));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawPolyline(org.eclipse.draw2d.geometry.PointList)
	 */
	@Override
	public void drawPolyline(PointList i_points) {

		if (i_points.size() == 2) {
			Point p = Draw3DCache.getPoint();
			try {
				i_points.getPoint(p, 0);
				int x1 = p.x;
				int y1 = p.y;

				i_points.getPoint(p, 1);
				int x2 = p.x;
				int y2 = p.y;

				drawLine(x1, y1, x2, y2);
			} finally {
				Draw3DCache.returnPoint(p);
			}
		} else {
			addPrimitive(new PolylinePrimitive(getState(), i_points));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawRectangle(int, int, int, int)
	 */
	@Override
	public void drawRectangle(int i_x, int i_y, int i_width, int i_height) {

		addPrimitive(QuadPrimitive.createOutlineQuad(getState(), i_x, i_y,
			i_width, i_height));
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

		roundRectangle(i_r, i_arcWidth, i_arcHeight, false);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawString(java.lang.String, int, int)
	 */
	@Override
	public void drawString(String i_s, int i_x, int i_y) {

		addPrimitive(new TextPrimitive(getState(), i_s, false, new Point(i_x,
			i_y)));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawText(java.lang.String, int, int)
	 */
	@Override
	public void drawText(String i_s, int i_x, int i_y) {

		addPrimitive(new TextPrimitive(getState(), i_s, true, new Point(i_x,
			i_y)));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillArc(int, int, int, int, int, int)
	 */
	@Override
	public void fillArc(int i_x, int i_y, int i_w, int i_h, int i_offset,
		int i_length) {

		ArcHelper helper =
			new ArcHelper(ARC_PREC, i_x, i_y, i_w, i_h, i_offset + i_length,
				-i_length, false);

		float[] vertices = new float[2 * (helper.getNumVertices() + 1)];
		helper.getArray(vertices);

		vertices[vertices.length - 2] = i_x + i_w;
		vertices[vertices.length - 1] = i_y + i_h;

		addPrimitive(new PolygonPrimitive(getState(), vertices, true));
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

		addPrimitive(QuadPrimitive.createGradientQuad(getState(), i_x, i_y,
			i_w, i_h, i_vertical));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillOval(int, int, int, int)
	 */
	@Override
	public void fillOval(int i_x, int i_y, int i_w, int i_h) {

		ArcHelper helper =
			new ArcHelper(ARC_PREC, i_x, i_y, i_w, i_h, 0, 2 * PI, true);

		float[] vertices = helper.getArray();
		addPrimitive(new PolygonPrimitive(getState(), vertices, true));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillPolygon(org.eclipse.draw2d.geometry.PointList)
	 */
	@Override
	public void fillPolygon(PointList i_points) {

		addPrimitive(new PolygonPrimitive(getState(), i_points, true));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillRectangle(int, int, int, int)
	 */
	@Override
	public void fillRectangle(int i_x, int i_y, int i_width, int i_height) {

		addPrimitive(QuadPrimitive.createSolidQuad(getState(), i_x, i_y,
			i_width, i_height));
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

		roundRectangle(i_r, i_arcWidth, i_arcHeight, true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillString(java.lang.String, int, int)
	 */
	@Override
	public void fillString(String i_s, int i_x, int i_y) {

		fillText(i_s, false, i_x, i_y);
	}

	private void fillText(String i_s, boolean expand, int i_x, int i_y) {
		TextPrimitive textPrimitive =
			new TextPrimitive(getState(), i_s, expand, new Point(i_x, i_y));

		Dimension extent = textPrimitive.getExtent();
		QuadPrimitive quadPrimitive =
			QuadPrimitive.createSolidQuad(getState(), i_x, i_y, extent.width,
				extent.height);

		addPrimitive(quadPrimitive);
		addPrimitive(textPrimitive);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillText(java.lang.String, int, int)
	 */
	@Override
	public void fillText(String i_s, int i_x, int i_y) {

		fillText(i_s, true, i_x, i_y);
	}

	/**
	 * Returns the primitive sets created by this recorder.
	 * 
	 * @return the primitive sets
	 */
	public List<PrimitiveSet> getPrimiveSets() {

		if (m_primitives == null)
			return Collections.emptyList();

		List<PrimitiveSet> result = new LinkedList<PrimitiveSet>();
		m_primitives.getSets(result);

		return result;
	}

	private void roundRectangle(Rectangle i_r, int i_arcWidth, int i_arcHeight,
		boolean i_fill) {

		float x1 = i_r.x;
		float y1 = i_r.y;
		float x2 = x1 + i_r.width;
		float y2 = y1 + i_r.height;
		float w = 2 * i_arcWidth;
		float h = 2 * i_arcHeight;

		ArcHelper h1, h2, h3, h4;

		h1 = new ArcHelper(ARC_PREC, x1, y1, w, h, PI_2, PI_2, false);
		h2 = new ArcHelper(ARC_PREC, x1, y2 - h, w, h, PI, PI_2, false);
		h3 = new ArcHelper(ARC_PREC, x2 - w, y2 - h, w, h, PI_32, PI_2, false);
		h4 = new ArcHelper(ARC_PREC, x2 - w, y1, w, h, 0, PI_2, false);

		int n1 = 2 * h1.getNumVertices();
		int n2 = 2 * h2.getNumVertices();
		int n3 = 2 * h3.getNumVertices();
		int n4 = 2 * h4.getNumVertices();

		float[] vertices = new float[n1 + n2 + n3 + n4];
		h1.getArray(vertices, 0);
		h2.getArray(vertices, n1);
		h3.getArray(vertices, n1 + n2);
		h4.getArray(vertices, n1 + n2 + n3);

		addPrimitive(new PolygonPrimitive(getState(), vertices, i_fill));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#fillPath(org.eclipse.swt.graphics.Path)
	 */
	@Override
	public void fillPath(Path i_path) {
		if (i_path == null) // parameter precondition
			throw new NullPointerException("i_path must not be null");
		
		// TODO improve that, this is just a quick hack to avoid exceptions
		PointList pointList = pathToPointList(i_path);
		fillPolygon(pointList);
	}

	/**
	 * @todo this is a dirty hack, and is more a placeholder than a real implementation
	 * @param i_path
	 * @return
	 */
	private PointList pathToPointList(Path i_path) {
		float[] points = i_path.getPathData().points;
		
		PointList pointList  = new PointList(points.length/2);
		
		for (int i=0; i<points.length-1; i+=2) {
			pointList.addPoint(new Point((int)points[i], (int)points[i+1]));
		}
		
		return pointList;
	}

	

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#clipPath(org.eclipse.swt.graphics.Path)
	 */
	//	@Override
	public void clipPath(Path i_path) {
		if (i_path == null) // parameter precondition
			throw new NullPointerException("i_path must not be null");

		// TODO improve that, this is just a quick hack to avoid exceptions
		PointList pointList = pathToPointList(i_path);
		// TODO improve that, this is just a quick hack to avoid exceptions
		Rectangle rect = pointList.getBounds();
		clipRect(rect);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setClip(org.eclipse.swt.graphics.Path)
	 */
	@Override
	public void setClip(Path i_path) {
		// TODO implement method RecordingGraphics.setClip

		// super.setClip(i_path);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawPath(org.eclipse.swt.graphics.Path)
	 */
	@Override
	public void drawPath(Path i_path) {
		if (i_path == null) // parameter precondition
			throw new NullPointerException("i_path must not be null");
		
		// TODO improve that, this is just a quick hack to avoid exceptions
		PointList pointList = pathToPointList(i_path);
		drawPolygon(pointList);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#drawText(java.lang.String, int, int,
	 *      int)
	 */
	@Override
	public void drawText(String i_s, int i_x, int i_y, int i_style) {
		// TODO style is ignored at the moment
		drawText(i_s, i_x, i_y);
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
		int i_selectionStart, int i_selectionEnd, Color i_selectionForeground,
		Color i_selectionBackground) {

		// TODO style is ignored at the moment

		String s = i_layout.getText();
		int adjustedX = i_x;
		int adjustedSelectionEnd = Math.min(s.length(), i_selectionEnd);
		if (i_selectionStart > 0) {
			String s0 = s.substring(0, i_selectionStart);

			TextPrimitive p0 =
				new TextPrimitive(getState(), s0, false, new Point(adjustedX, i_y));
			addPrimitive(p0);
			adjustedX += p0.getExtent().width;
		}

		if (i_selectionStart < adjustedSelectionEnd) {
			Color background = getBackgroundColor();
			Color foreground = getForegroundColor();
			setBackgroundColor(i_selectionBackground);
			setForegroundColor(i_selectionForeground);

			String s1 = s.substring(i_selectionStart, adjustedSelectionEnd);
			TextPrimitive p1 =
				new TextPrimitive(getState(), s1, false, new Point(adjustedX, i_y));
			addPrimitive(p1);
			adjustedX += p1.getExtent().width;

			setBackgroundColor(background);
			setForegroundColor(foreground);
		}

		if (adjustedSelectionEnd < s.length()) {
			String s2 = s.substring(i_selectionStart, adjustedSelectionEnd);
			TextPrimitive p2 =
				new TextPrimitive(getState(), s2, false, new Point(adjustedX, i_y));
			addPrimitive(p2);
			// i_x += p2.getExtent().width;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Graphics#setForegroundPattern(org.eclipse.swt.graphics.Pattern)
	 */
	@Override
	public void setForegroundPattern(Pattern i_pattern) {
		// TODO implement method RecordingGraphics.setForegroundPattern
		// super.setForegroundPattern(i_pattern);
	}

}
