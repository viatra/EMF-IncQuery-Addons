/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthias Thiele - initial API and implementation
 *    Kristian Duske - initial API
 *    Jens von Pilgrim - initial API
 ******************************************************************************/

package org.eclipse.draw3d.graphics3d;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw3d.geometry.IPosition3D;
import org.eclipse.swt.opengl.GLCanvas;

/**
 * Graphics3D This interface summarizes all properties of a renderer
 * implementation. It extends the drawing interfaces which are thematically
 * split as well as provides access to renderer specific instances which are
 * hidden behind other interface types. A renderer implementation has only to
 * implement this interface and register at the Graphics3DRegistry to become
 * available.
 * <p>
 * Note: Some classes require method {@link #hashCode()} to be implemented
 * efficiently.
 * </p>
 * 
 * @author Matthias Thiele, Jens von Pilgrim
 * @version $Revision$
 * @since 16.12.2008
 */
public interface Graphics3D extends Graphics3DDraw, Graphics3DUtil {

	/**
	 * Property name for the font antialias property. Possible values are:
	 * <ul>
	 * <li><code>Boolean.toString(true)</code> to always enable font
	 * antialiasing</li>
	 * <li><code>Boolean.toString(false)</code> to always diable font
	 * antialiasing</li>
	 * <li><code>null</code> to let the embedded editors control font
	 * antialiasing</li>
	 * </ul>
	 */
	public static final String PROP_FONT_AA = "fontAntialias";

	/**
	 * Activates a 2D graphics object that can be used to render 2D content. If
	 * a graphics object was already created for the given key object (which can
	 * e.g. be a figure), it may be re-used. Call
	 * {@link #deactivateGraphics2D()} to finish the 2D rendering and to obtain
	 * an instanceof {@link RenderImage}-
	 * 
	 * @param i_key Object associated respective to associate with the activated
	 *            graphics objects.
	 * @param i_position the position to use for setting up the transformation
	 * @param i_width desired width of the graphics object.
	 * @param i_height desired height of the graphics object.
	 * @return the activated graphics object.
	 */
	public Graphics begin2DRendering(Object i_key, IPosition3D i_position,
		int i_width, int i_height);

	/**
	 * Deactivates the currently active graphics object. The returned instance
	 * of {@link RenderImage} can be used to render the 2D image that was
	 * created using the active graphics object.
	 * 
	 * @return the image created by the active graphics object
	 */
	public RenderImage deactivateGraphics2D();

	/**
	 * Cleans up the ressources, instance is not usable afterwards any more.
	 */
	public void dispose();

	/**
	 * Returns the descriptor of this graphics 3D implementation.
	 * 
	 * @return
	 */
	public Graphics3DDescriptor getDescriptor();

	/**
	 * Returns the display list manager for this instance.
	 * 
	 * @return the display list manager
	 */
	public DisplayListManager getDisplayListManager();

	/**
	 * Gets an ID for the graphics object associated with the given key object.
	 * 
	 * @param i_key The key object.
	 * @return The ID of the graphics object associated with the key object.
	 * @throws IllegalArgumentException If there is no graphics object
	 *             associated with the key object yet.
	 */
	public int getGraphics2DId(Object i_key);

	/**
	 * Creates an offscreen buffer for the current rendering implementation.
	 * 
	 * @param i_height The height of the buffer
	 * @param i_width The width of the buffer
	 * @param i_bufferConfig The configuration for the buffer
	 * @return A new offscreen buffer instance
	 */
	public Graphics3DOffscreenBuffers getGraphics3DOffscreenBuffer(
		int i_height, int i_width,
		Graphics3DOffscreenBufferConfig i_bufferConfig);

	/**
	 * Creates a configuration for an offscreen buffer. This object may be used
	 * either to create an offscreen buffer immediately or may be saved to
	 * create several offscreen buffers of the same type.
	 * 
	 * @param i_buffers Determines which buffer possibilities to use.
	 * @param i_args Arguments for the buffer
	 * @return The created offscreen buffer configuration instance.
	 */
	public Graphics3DOffscreenBufferConfig getGraphics3DOffscreenBufferConfig(
		int i_buffers, int... i_args);

	/**
	 * Returns the ID of the Graphics3D instance, e.g. the class name. This ID
	 * is used internally only and is not presented to the user.
	 * 
	 * @return
	 */
	public String getID();

	/**
	 * Returns a property.
	 * 
	 * @param key
	 * @return
	 */
	public String getProperty(String key);

	/**
	 * Returns whether there is a graphics object associate with the given key
	 * object.
	 * 
	 * @param i_key The key object.
	 * @return <code>true</code> if there was a graphics object associated to
	 *         the key obect previously or <code>false</code> otherwise
	 */
	public boolean hasGraphics2D(Object i_key);

	/**
	 * @param i_graphics3DDescriptor
	 */
	public void setDescriptor(Graphics3DDescriptor i_graphics3DDescriptor);

	/**
	 * Called by registry after creation of the instance if type is screen.
	 * 
	 * @param canvas
	 */
	public void setGLCanvas(GLCanvas canvas);

	/**
	 * Enables logging of 2D drawing operations.
	 * 
	 * @param i_log2D <code>true</code> if 2D logging should be enabled and
	 *            <code>false</code> otherwise
	 */
	public void setLog2D(boolean i_log2D);

	/**
	 * Sets a property. Properties are set during execution and can vary from
	 * call to call.
	 * 
	 * @param key
	 * @param value
	 */
	public void setProperty(String key, String value);

}
