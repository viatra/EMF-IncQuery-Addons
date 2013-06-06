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
package org.eclipse.draw3d.graphics3d.lwjgl.texture;

import org.eclipse.draw2d.Graphics;
import org.eclipse.swt.graphics.Color;

/**
 * LwjglTexture defines an interface for managing a texture, which is
 * implemented renderer-specific.
 * 
 * @author Kristian Duske
 * @since 06.08.2008
 * @version $Revision$
 */
public interface LwjglTexture {

	/**
	 * Activates this texture for rendering.
	 * 
	 * @throws IllegalStateException if this texture is disposed
	 */
	public void activate();

	/**
	 * Clears the texture using the given color and alpha value.
	 * 
	 * @param i_color the clear color
	 * @param i_alpha the clear alpha value
	 * @throws NullPointerException if the given color is <code>null</code>
	 */
	public void clear(Color i_color, int i_alpha);

	/**
	 * Deactivates this texture and restores the previous OpenGL state.
	 * 
	 * @throws IllegalStateException if this texture is disposed
	 */
	public void deactivate();

	/**
	 * Disposes all resources associated with this texture.
	 */
	public void dispose();

	/**
	 * Returns a graphics object that can be used to render this texture.
	 * 
	 * @return a graphics object
	 */
	public Graphics getGraphics();

	/**
	 * Returns the OpenGL texture ID of this texture.
	 * 
	 * @return the texture ID or 0 if no texture has been created yet
	 * @throws IllegalStateException if this texture has been disposed
	 */
	public int getTextureId();

	/**
	 * Sets the dimensions of this texture.
	 * 
	 * @param i_width the new width
	 * @param i_height the new height
	 * @throws IllegalArgumentException if the given width or height is not
	 *             positive
	 * @throws IllegalStateException if this texture has been disposed
	 */
	public void setDimensions(int i_width, int i_height);

}