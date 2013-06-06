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

package org.eclipse.draw3d.graphics3d.lwjgl.font;

import java.nio.FloatBuffer;

import org.eclipse.draw3d.geometry.IMatrix4f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.util.Draw3DCache;
import org.lwjgl.opengl.GL11;

/**
 * Holds information about a single GL font character.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 09.06.2008
 */
public class LwjglFontChar {

	private char m_char;

	/**
	 * The font height.
	 */
	private final int m_height;

	/**
	 * The S texture coordinate of the upper left corner of this character.
	 */
	private float m_s1;

	/**
	 * The S texture coordinate of the lower right corner of this character.
	 */
	private float m_s2;

	/**
	 * The T texture coordinate of the upper left corner of this character.
	 */
	private float m_t1;

	/**
	 * The T texture coordinate of the lower right corner of this character.
	 */
	private float m_t2;

	/**
	 * The width of this character.
	 */
	private final int m_width;

	/**
	 * Creates a new character with the given width and height.
	 * 
	 * @param i_char the character
	 * @param i_width the width of this character
	 * @param i_height the height of the font this character belongs to
	 */
	public LwjglFontChar(char i_char, int i_width, int i_height) {

		m_char = i_char;
		m_width = i_width;
		m_height = i_height;
	}

	/**
	 * Returns the width of this character.
	 * 
	 * @return the width of this character
	 */
	public int getWidth() {

		return m_width;
	}

	/**
	 * Renders this character at the given coordinates by adding the vertices
	 * and texture coordinates to the given buffers.
	 * 
	 * @param i_transformation the transformation to apply to the vertices - can
	 *            be <code>null</code>
	 * @param i_x the X coordinate
	 * @param i_y the Y coordinate
	 * @param i_vertexBuffer the vertex buffer
	 * @param i_coordBuffer the texture coordinate buffer
	 */
	public void render(IMatrix4f i_transformation, float i_x, float i_y,
		FloatBuffer i_vertexBuffer, FloatBuffer i_coordBuffer) {

		if (i_transformation == null
			|| IMatrix4f.IDENTITY.equals(i_transformation)) {
			i_vertexBuffer.put(i_x);
			i_vertexBuffer.put(i_y);
			i_coordBuffer.put(m_s1);
			i_coordBuffer.put(m_t1);

			i_vertexBuffer.put(i_x);
			i_vertexBuffer.put(i_y + m_height);
			i_coordBuffer.put(m_s1);
			i_coordBuffer.put(m_t2);

			i_vertexBuffer.put(i_x + m_width);
			i_vertexBuffer.put(i_y + m_height);
			i_coordBuffer.put(m_s2);
			i_coordBuffer.put(m_t2);

			i_vertexBuffer.put(i_x + m_width);
			i_vertexBuffer.put(i_y);
			i_coordBuffer.put(m_s2);
			i_coordBuffer.put(m_t1);
		} else {
			Vector3f v = Draw3DCache.getVector3f();
			try {
				v.set(i_x, i_y, 0);
				Math3D.transform(v, i_transformation, v);
				i_vertexBuffer.put(v.getX());
				i_vertexBuffer.put(v.getY());
				i_coordBuffer.put(m_s1);
				i_coordBuffer.put(m_t1);

				v.set(i_x, i_y + m_height, 0);
				Math3D.transform(v, i_transformation, v);
				i_vertexBuffer.put(v.getX());
				i_vertexBuffer.put(v.getY());
				i_coordBuffer.put(m_s1);
				i_coordBuffer.put(m_t2);

				v.set(i_x + m_width, i_y + m_height, 0);
				Math3D.transform(v, i_transformation, v);
				i_vertexBuffer.put(v.getX());
				i_vertexBuffer.put(v.getY());
				i_coordBuffer.put(m_s2);
				i_coordBuffer.put(m_t2);

				v.set(i_x + m_width, i_y, 0);
				Math3D.transform(v, i_transformation, v);
				i_vertexBuffer.put(v.getX());
				i_vertexBuffer.put(v.getY());
				i_coordBuffer.put(m_s2);
				i_coordBuffer.put(m_t1);
			} finally {
				Draw3DCache.returnVector3f(v);
			}
		}
	}

	/**
	 * Renders this character directly in immediate mode.
	 */
	public void render() {

		GL11.glBegin(GL11.GL_QUADS);

		GL11.glTexCoord2f(m_s1, m_t1);
		GL11.glVertex2f(0, 0);
		GL11.glTexCoord2f(m_s1, m_t2);
		GL11.glVertex2f(0, m_height);
		GL11.glTexCoord2f(m_s2, m_t2);
		GL11.glVertex2f(m_width, m_height);
		GL11.glTexCoord2f(m_s2, m_t1);
		GL11.glVertex2f(m_width, 0);

		GL11.glEnd();
	}

	/**
	 * Sets the texture coordinates of this character.
	 * 
	 * @param i_s1 the S coordinate of the upper left corner
	 * @param i_t1 the T coordinate of the upper left corner
	 * @param i_s2 the S coordinate of the lower right corner
	 * @param i_t2 the T coordinate of the lower right corner
	 */
	public void setTextureCoords(float i_s1, float i_t1, float i_s2, float i_t2) {

		m_s1 = i_s1;
		m_t1 = i_t1;
		m_s2 = i_s2;
		m_t2 = i_t2;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return Character.toString(m_char);
	}
}
