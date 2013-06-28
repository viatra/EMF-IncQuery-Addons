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

import java.util.logging.Logger;

import org.eclipse.draw3d.IScene;
import org.eclipse.draw3d.IScene.FontAntialias;
import org.eclipse.draw3d.camera.FirstPersonCamera;
import org.eclipse.draw3d.camera.ICamera;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * Distributes preference changes to the scene.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 02.06.2009
 */
public class ScenePreferenceDistributor extends Draw3DPreferenceDistributor
		implements PrefNames {

	/**
	 * The default camera type.
	 */
	public static final String DEFAULT_CAMERA_TYPE =
		FirstPersonCamera.class.getName();

	private static final Logger log =
		Logger.getLogger(ScenePreferenceDistributor.class.getName());

	private IScene m_scene;

	/**
	 * Creates a new instance that distributes preference changes to the given
	 * scene.
	 * 
	 * @param i_scene the scene
	 * @param i_store the preference store
	 */
	public ScenePreferenceDistributor(IScene i_scene) {

		m_scene = i_scene;
	}

	/**
	 * Returns the camera of the given type or the default camera type if the
	 * given type is unavailable.
	 * 
	 * @param type the type name of the camera to return
	 * @return the camera of the given type
	 * @throws NullPointerException if the given type is <code>null</code>
	 * @throws IllegalArgumentException if the given type is the default camera
	 *             type, but it cannot be loaded
	 */
	private ICamera getCamera(String type) {

		if (type == null)
			throw new NullPointerException("type must not be null");

		try {
			Class<?> clazz = Class.forName(type);
			return (ICamera) clazz.newInstance();
		} catch (Exception ex) {
			if (DEFAULT_CAMERA_TYPE.equals(type))
				throw new IllegalArgumentException("Default camera type "
					+ DEFAULT_CAMERA_TYPE + " is unavailable", ex);

			log.severe("Unable to load camera type " + type);
			return getCamera(DEFAULT_CAMERA_TYPE);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ui.preferences.Draw3DPreferenceDistributor#init(IPreferenceStore)
	 */
	@Override
	public void init(IPreferenceStore i_store) {

		m_scene.setDrawAxes(i_store.getBoolean(LWS_DRAW_AXES));
		m_scene.setDebug(i_store.getBoolean(LWS_DEBUG));
		setSceneBackgroundColor(i_store.getString(LWS_BACKGROUND));
		setSceneCamera(i_store.getString(LWS_CAMERA_TYPE));
		setSceneFontAntialias(i_store.getString(LWS_FONT_AA));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.ui.preferences.Draw3DPreferenceDistributor#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
	 */
	@Override
	public void propertyChange(PropertyChangeEvent i_event) {

		String name = i_event.getProperty();
		String newValue = i_event.getNewValue().toString();

		if (name == null || newValue == null)
			return;

		if (newValue.equals(i_event.getOldValue()))
			return;

		if (name.equals(LWS_DRAW_AXES))
			m_scene.setDrawAxes(StringConverter.asBoolean(newValue));
		else if (name.equals(LWS_DEBUG))
			m_scene.setDebug(StringConverter.asBoolean(newValue));
		else if (name.equals(LWS_BACKGROUND))
			setSceneBackgroundColor(newValue);
		else if (name.equals(LWS_CAMERA_TYPE))
			setSceneCamera(newValue);
		else if (name.equals(LWS_FONT_AA)) {
			setSceneFontAntialias(newValue);
		}

		m_scene.render(name.equals(LWS_FONT_AA));
	}

	private void setSceneFontAntialias(String i_value) {

		if (i_value.equals(FONT_AA_ON))
			m_scene.setFontAntialias(FontAntialias.ON);
		else if (i_value.equals(FONT_AA_OFF))
			m_scene.setFontAntialias(FontAntialias.OFF);
		else
			m_scene.setFontAntialias(FontAntialias.EDITOR);
	}

	private void setSceneBackgroundColor(String i_value) {

		RGB rgb = StringConverter.asRGB(i_value);

		// TODO: this needs to be disposed!
		Color color = new Color(Display.getCurrent(), rgb);
		m_scene.setBackgroundColor(color);
	}

	private void setSceneCamera(String i_value) {

		ICamera newCamera = getCamera(i_value);
		ICamera currentCamera = m_scene.getCamera();

		if (currentCamera != null
			&& !currentCamera.getClass().equals(newCamera.getClass()))
			m_scene.setCamera(newCamera);
	}

}
