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
package org.eclipse.draw3d.ui.preferences;

import org.eclipse.draw3d.ui.camera.CameraInputHandler;
import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.bindings.keys.ParseException;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.util.PropertyChangeEvent;

/**
 * Distributes Draw3D preferences to the camera and scene.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 01.06.2009
 */
public class CameraPreferenceDistributor extends Draw3DPreferenceDistributor
		implements PrefNames {

	private CameraInputHandler m_handler;

	/**
	 * Creates a new distributor and initializes the given camera input handler
	 * and scene with the values from the preference store.
	 * 
	 * @param i_handler
	 *            the camera input handler
	 */
	public CameraPreferenceDistributor(CameraInputHandler i_handler) {

		m_handler = i_handler;
	}

	private KeySequence getSequence(String i_string) {

		try {
			return KeySequence.getInstance(i_string);
		} catch (ParseException ex) {
			throw new RuntimeException("Error while updating from preferences",
					ex);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ui.preferences.Draw3DPreferenceDistributor#init(IPreferenceStore)
	 */
	@Override
	public void init(IPreferenceStore i_store) {

		m_handler
				.setMoveForwardKey(getSequence(i_store.getString(KEY_FORWARD)));
		m_handler.setMoveBackwardKey(getSequence(i_store
				.getString(KEY_BACKWARD)));
		m_handler.setMoveUpKey(getSequence(i_store.getString(KEY_UP)));
		m_handler.setMoveDownKey(getSequence(i_store.getString(KEY_DOWN)));
		m_handler.setMoveLeftKey(getSequence(i_store.getString(KEY_LEFT)));
		m_handler.setMoveRightKey(getSequence(i_store.getString(KEY_RIGHT)));
		m_handler.setRollCCWKey(getSequence(i_store.getString(KEY_ROLL_CCW)));
		m_handler.setRollCWKey(getSequence(i_store.getString(KEY_ROLL_CW)));
		m_handler.setCenterKey(getSequence(i_store.getString(KEY_CENTER)));
		m_handler.setOrbitModifiers(i_store.getInt(MOD_ORBIT));
		m_handler.setSensitivity(i_store.getInt(MOUSE_SENSITIVITY));

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
	 */
	@Override
	public void propertyChange(PropertyChangeEvent i_event) {

		String name = i_event.getProperty();
		String newValue = i_event.getNewValue().toString();

		if (name == null || newValue == null)
			return;

		if (newValue.equals(i_event.getOldValue()))
			return;

		if (name.equals(KEY_FORWARD))
			m_handler.setMoveForwardKey(getSequence(newValue));
		else if (name.equals(KEY_BACKWARD))
			m_handler.setMoveBackwardKey(getSequence(newValue));
		else if (name.equals(KEY_UP))
			m_handler.setMoveUpKey(getSequence(newValue));
		else if (name.equals(KEY_DOWN))
			m_handler.setMoveDownKey(getSequence(newValue));
		else if (name.equals(KEY_LEFT))
			m_handler.setMoveLeftKey(getSequence(newValue));
		else if (name.equals(KEY_RIGHT))
			m_handler.setMoveRightKey(getSequence(newValue));
		else if (name.equals(KEY_ROLL_CCW))
			m_handler.setRollCCWKey(getSequence(newValue));
		else if (name.equals(KEY_ROLL_CW))
			m_handler.setRollCWKey(getSequence(newValue));
		else if (name.equals(KEY_CENTER))
			m_handler.setCenterKey(getSequence(newValue));
		else if (name.equals(MOD_ORBIT))
			m_handler.setOrbitModifiers(StringConverter.asInt(newValue));
		else if (name.equals(MOUSE_SENSITIVITY))
			m_handler.setSensitivity(StringConverter.asInt(newValue));
	}
}
