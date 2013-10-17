/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/

package org.eclipse.draw3d;

import java.util.logging.Logger;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw3d.picking.GeometryPicker;
import org.eclipse.draw3d.picking.Picker;

/**
 * Does the actual picking for 3D figures by using a color picker, see
 * {@link ColorPicker}.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 13.12.2007
 */
public class PickingUpdateManager3D extends DeferredUpdateManager3D {

	@SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(PickingUpdateManager3D.class.getName());

	private GeometryPicker m_picker;

	/**
	 * Creates a new picking update manager for the given scene.
	 * 
	 * @param i_scene the scene
	 * @throws NullPointerException if the given scene is <code>null</code>
	 */
	public PickingUpdateManager3D(IScene i_scene) {

		if (i_scene == null)
			throw new NullPointerException("i_scene must not be null");

		m_picker = new GeometryPicker(i_scene);
	}

	/**
	 * Indicates whether picking is enabled.
	 */
	boolean pickingEnabled = true;

	/**
	 * Returns the picker.
	 * 
	 * @return the picker
	 */
	public Picker getPicker() {

		return m_picker;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.DeferredUpdateManager3D#repairDamage()
	 */
	@Override
	protected void repairDamage() {

		pickingEnabled = false;
		super.repairDamage();
		pickingEnabled = true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.DeferredUpdateManager3D#setRoot(org.eclipse.draw2d.IFigure)
	 */
	@Override
	public void setRoot(IFigure i_figure) {

		super.setRoot(i_figure);
		m_picker.setRootFigure(Figure3DHelper.getAncestor3D(i_figure));
	}
}
