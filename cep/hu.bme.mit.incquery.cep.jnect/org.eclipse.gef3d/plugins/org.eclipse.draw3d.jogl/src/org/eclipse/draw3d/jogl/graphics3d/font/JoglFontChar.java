/*******************************************************************************
 * Copyright (c) 2009-2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 *    Madhu Samuel   - JOGL Implementation
 ******************************************************************************/

package org.eclipse.draw3d.jogl.graphics3d.font;

import javax.media.opengl.GL;

/**
 * Holds information about a single GL font character.
 * 
 * @author Madhu Samuel
 * @version $Revision$
 * @since 24.08.2009
 */
public class JoglFontChar {

	/**
	 * The font height.
	 */
	private final int m_height;

	/**
	 * The id of the display list that renders this character.
	 */
	private int m_listId = -1;

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
	 * The gl instance
	 */
	private GL gl;

	/**
	 * Creates a new character with the given width and height.
	 * 
	 * @param i_width the width of this character
	 * @param i_height the height of the font this character belongs to
	 */
	public JoglFontChar(int i_width, int i_height, GL gl) {
		if (gl == null)
			throw new NullPointerException("gl must not be null");
		
		m_width = i_width;
		m_height = i_height;
		this.gl = gl;
	}

	/**
	 * Builds a display list for this character.
	 * 
	 * @param i_listId the id of the display list to build
	 * @param i_width the width of the character texture
	 * @param i_height the height of the character texture
	 */
	public void buildList(int i_listId, int i_width, int i_height) {

		gl.glNewList(i_listId, GL.GL_COMPILE);
		gl.glBegin(GL.GL_QUADS);

		gl.glTexCoord2f(m_s1, m_t1);
		gl.glVertex2f(0, 0);
		gl.glTexCoord2f(m_s1, m_t2);
		gl.glVertex2f(0, m_height);
		gl.glTexCoord2f(m_s2, m_t2);
		gl.glVertex2f(m_width, m_height);
		gl.glTexCoord2f(m_s2, m_t1);
		gl.glVertex2f(m_width, 0);

		gl.glEnd();
		gl.glEndList();

		m_listId = i_listId;
	}

	/**
	 * Returns the id of the display list that renders this character.
	 * 
	 * @return the list id
	 */
	public int getListId() {

		return m_listId;
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
}
