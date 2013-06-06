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

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw3d.geometry.IMatrix3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Vector2f;
import org.eclipse.draw3d.graphics.GraphicsState;
import org.eclipse.draw3d.graphics.optimizer.PrimitiveBounds;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;

/**
 * A primitive that represents text.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 23.12.2009
 */
public class TextPrimitive extends AbstractPrimitive {

	private boolean m_expand;

	private Point m_position;

	private String m_text;

	/**
	 * Creates a new text primitive.
	 * 
	 * @param i_state the current graphics state
	 * @param i_text the text
	 * @param i_expand whether to expand tab and newline characters
	 * @param i_position the position of the text
	 * @throws NullPointerException if the given state, text or position is
	 *             <code>null</code>
	 */
	public TextPrimitive(GraphicsState i_state, String i_text,
			boolean i_expand, Point i_position) {

		super(i_state.getTransformation(), new TextRenderRule(i_state));

		if (i_text == null)
			throw new NullPointerException("i_text must not be null");

		if (i_position == null)
			throw new NullPointerException("i_position must not be null");

		m_text = i_text;
		m_expand = i_expand;
		m_position = i_position;
	}

	private Dimension m_extent;

	/**
	 * Returns the extent of the text.
	 * 
	 * @return the extent of the text
	 */
	public Dimension getExtent() {

		if (m_extent == null) {
			Device device =
				((TextRenderRule) getRenderRule()).getFont().getDevice();
			Image image = new Image(device, 1, 1);
			GC gc = new GC(image);

			try {
				org.eclipse.swt.graphics.Point extent =
					gc.textExtent(m_text, m_expand ? SWT.DRAW_DELIMITER
						| SWT.DRAW_TAB : 0);
				int w = extent.x;
				int h = extent.y;

				m_extent = new Dimension(w, h);
			} finally {
				gc.dispose();
				image.dispose();
			}
		}

		return m_extent;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.primitive.AbstractPrimitive#calculateBounds()
	 */
	@Override
	protected PrimitiveBounds calculateBounds() {

		Dimension extent = getExtent();

		float[] vertices =
			getTransformedVertices(m_position.x, m_position.y, extent.width,
				extent.height);

		return new PrimitiveBounds(vertices);
	}

	/**
	 * Returns the position of this text primitive (with no transformation
	 * applied).
	 * 
	 * @return the position
	 */
	public Point getPosition() {

		return m_position;
	}

	/**
	 * Returns the text.
	 * 
	 * @return the text
	 */
	public String getText() {

		return m_text;
	}

	private float[] getTransformedVertices(int i_x, int i_y, int i_w, int i_h) {

		IMatrix3f t = getTransformation();
		float[] vertices = new float[8];

		if (t != null && !IMatrix3f.IDENTITY.equals(t)) {
			Vector2f v = Draw3DCache.getVector2f();
			try {
				v.set(i_x, i_y);
				Math3D.transform(v, t, v);
				vertices[0] = v.getX();
				vertices[1] = v.getY();

				v.set(i_x, i_y + i_h);
				Math3D.transform(v, t, v);
				vertices[2] = v.getX();
				vertices[3] = v.getY();

				v.set(i_x + i_w, i_y + i_h);
				Math3D.transform(v, t, v);
				vertices[4] = v.getX();
				vertices[5] = v.getY();

				v.set(i_x + i_w, i_y);
				Math3D.transform(v, t, v);
				vertices[6] = v.getX();
				vertices[7] = v.getY();
			} finally {
				Draw3DCache.returnVector2f(v);
			}
		} else {
			vertices[0] = i_x;
			vertices[1] = i_y;
			vertices[2] = i_x;
			vertices[3] = i_y + i_h;
			vertices[4] = i_x + i_w;
			vertices[5] = i_y + i_h;
			vertices[6] = i_x + i_h;
			vertices[7] = i_y;
		}

		return vertices;
	}

	/**
	 * Indicates whether tab and newline characters should be expanded.
	 * 
	 * @return <code>true</code> if such characters should be expanded and
	 *         <code>false</code> otherwise
	 */
	public boolean isExpand() {

		return m_expand;
	}

	@Override
	public String toString() {
		return "TextPrimitive [m_expand=" + m_expand + ", m_position="
			+ m_position + ", m_text=" + m_text + "]";
	}

}
