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
package org.eclipse.gef3d.tools;

import java.util.logging.Logger;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw3d.IScene;
import org.eclipse.draw3d.ISurface;
import org.eclipse.draw3d.MouseEvent3D;
import org.eclipse.draw3d.camera.ICamera;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.picking.Picker;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Tool;
import org.eclipse.gef.tools.AbstractTool;
import org.eclipse.gef3d.ui.parts.GraphicalViewer3D;
import org.eclipse.swt.events.MouseEvent;

/**
 * Abstract base implementation for {@link Tool}s that use 3D coordinates for
 * their work.
 * 
 * @see AbstractTool
 * @author Kristian Duske
 * @version $Revision$
 * @since 23.06.2009
 */
public abstract class AbstractTool3D extends AbstractTool {

	/**
	 * 3D version of {@link Input}.
	 * 
	 * @author Kristian Duske
	 * @version $Revision$
	 * @since 24.06.2009
	 */
	public class Input3D extends Input {

		Point screenLocation = new Point();

		Point surfaceLocation = new Point();

		Vector3f wLocation = new Vector3fImpl();

		/**
		 * Returns the current location of the mouse pointer. This is what
		 * {@link #getMouseLocation()} would return in a pure 2D editor. In a 3D
		 * editor, {@link #getMouseLocation()} returns the current surface
		 * coordinates however, so we need this method to access the mouse
		 * location in mouse coordinates.
		 * 
		 * @return the current mouse location
		 */
		public Point getRealMouseLocation() {

			return screenLocation;
		}

		/**
		 * Returns the current 3D world location of the mouse pointer.
		 * 
		 * @return the current 3D world location
		 */
		public IVector3f getWorldLocation() {

			return wLocation;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.gef.tools.AbstractTool.Input#setInput(org.eclipse.swt.events.MouseEvent)
		 */
		@Override
		public void setInput(MouseEvent i_me) {

			super.setInput(i_me);

			if (i_me instanceof MouseEvent3D) {
				MouseEvent3D me3D = (MouseEvent3D) i_me;

				wLocation.set(me3D.getWorldLocation());
				surfaceLocation.x = me3D.x;
				surfaceLocation.y = me3D.y;
				screenLocation.x = me3D.getScreenLocation().x;
				screenLocation.y = me3D.getScreenLocation().y;
			} else {
				surfaceLocation.x = i_me.x;
				surfaceLocation.y = i_me.y;

				Picker picker = getScene().getPicker();
				ISurface surface = picker.getCurrentSurface();
				surface.getWorldLocation(surfaceLocation, wLocation);

				ICamera camera = getScene().getCamera();
				camera.project(wLocation, screenLocation);
			}
		}
	}

	@SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(AbstractTool3D.class.getName());

	private Input3D m_current;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.tools.AbstractTool#deactivate()
	 */
	@Override
	public void deactivate() {

		super.deactivate();
		m_current = null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.tools.AbstractTool#getCurrentInput()
	 */
	@Override
	protected Input getCurrentInput() {

		if (m_current == null)
			m_current = new Input3D();

		return m_current;
	}

	/**
	 * Returns the current 3D input.
	 * 
	 * @return the current 3D input
	 */
	protected Input3D getCurrentInput3D() {

		return (Input3D) getCurrentInput();
	}

	/**
	 * Returns the scene which contains the camera.
	 * 
	 * @return the scene
	 * @throws AssertionError if no scene is available
	 */
	protected IScene getScene() {

		EditPartViewer viewer = getCurrentViewer();
		if (!(viewer instanceof GraphicalViewer3D))
			throw new AssertionError(
				"camera tool can only be used with a 3D graphical viewer");

		return ((GraphicalViewer3D) viewer).getLightweightSystem3D();
	}

}
