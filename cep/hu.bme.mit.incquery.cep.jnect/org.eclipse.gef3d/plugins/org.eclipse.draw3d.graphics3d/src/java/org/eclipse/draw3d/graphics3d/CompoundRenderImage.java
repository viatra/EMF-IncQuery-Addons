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
package org.eclipse.draw3d.graphics3d;

import java.util.List;

/**
 * A render image that is composed of other render images.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 10.12.2009
 */
public class CompoundRenderImage implements RenderImage {

	private List<RenderImage> m_images;

	/**
	 * Creates a new render image that is composed of the given list of render
	 * images. The given list is not copied, so that subsequent changes to it
	 * are reflected in this image.
	 * 
	 * @param i_images the images that compose this render image
	 * @throws NullPointerException if the given list is <code>null</code>
	 */
	public CompoundRenderImage(List<RenderImage> i_images) {

		if (i_images == null)
			throw new NullPointerException("i_images must not be null");

		m_images = i_images;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.RenderImage#dispose()
	 */
	public void dispose() {

		for (RenderImage image : m_images)
			image.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.RenderImage#initialize(org.eclipse.draw3d.graphics3d.Graphics3D)
	 */
	public void initialize(Graphics3D i_g3d) {

		for (RenderImage image : m_images)
			image.initialize(i_g3d);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.RenderImage#render(org.eclipse.draw3d.graphics3d.Graphics3D,
	 *      org.eclipse.draw3d.graphics3d.ILodHelper)
	 */
	public void render(Graphics3D i_g3d, ILodHelper i_lodContext) {

		for (RenderImage image : m_images)
			image.render(i_g3d, i_lodContext);
	}
}
