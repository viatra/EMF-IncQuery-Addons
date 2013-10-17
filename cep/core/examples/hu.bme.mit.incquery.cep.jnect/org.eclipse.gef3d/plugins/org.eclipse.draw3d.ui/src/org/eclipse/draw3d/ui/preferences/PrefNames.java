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
package org.eclipse.draw3d.ui.preferences;

/**
 * Constants for the GEF 3D preferences.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 4.3.2008
 */
public interface PrefNames {

	/**
	 * Preference value to indiciate that the font antialiasing setting is
	 * determined by the editor.
	 */
	public static final String FONT_AA_EDITOR = "editor";

	/**
	 * Preference value to indiciate that the font antialiasing setting is
	 * overridden to be always on.
	 */
	public static final String FONT_AA_ON = "on";

	/**
	 * Preference value to indiciate that the font antialiasing setting is
	 * overridden to be always off.
	 */
	public static final String FONT_AA_OFF = "off";

	/**
	 * Preference name for the backward key binding.
	 */
	public static final String KEY_BACKWARD = "moveBackwardKey";

	/**
	 * Preferencename for the center key binding.
	 */
	public static final String KEY_CENTER = "centerKey";

	/**
	 * Preference name for the down key binding.
	 */
	public static final String KEY_DOWN = "downKey";

	/**
	 * Preference name for the forward key binding.
	 */
	public static final String KEY_FORWARD = "moveForwardKey";

	/**
	 * Preference name for the left key binding.
	 */
	public static final String KEY_LEFT = "leftKey";

	/**
	 * Preference name for the right key binding.
	 */
	public static final String KEY_RIGHT = "rightKey";

	/**
	 * Preference name for the roll left key binding.
	 */
	public static final String KEY_ROLL_CCW = "rollLeftKey";

	/**
	 * Preference name for the roll right key binding.
	 */
	public static final String KEY_ROLL_CW = "rollRightKey";

	/**
	 * Preference name for the up key binding.
	 */
	public static final String KEY_UP = "upKey";

	/**
	 * Preferences name for the lightweight system background color.
	 */
	public static final String LWS_BACKGROUND = "lwsBackgroundColor";

	/**
	 * Preference name for the lightweight system camera type.
	 */
	public static final String LWS_CAMERA_TYPE = "lwsCameraType";

	/**
	 * Preference name for the lightweight system debug flag.
	 */
	public static final String LWS_DEBUG = "lwsDebug";

	/**
	 * Preference name for whether the lightweight system should display
	 * coordinate axes.
	 */
	public static final String LWS_DRAW_AXES = "lwsDrawCoordinateAxes";

	/**
	 * Preference name for the font antialasing value.
	 */
	public static final String LWS_FONT_AA = "lwsFontAntialias";

	/**
	 * Preference name for the modifier key for camera orbit mode.
	 */
	public static final String MOD_ORBIT = "cameraOrbitMode";

	/**
	 * Preference name for the mouse sensitivity value.
	 */
	public static final String MOUSE_SENSITIVITY = "mouseSensitivity";
	
	/**
	 * Preference name for the default screen renderer.
	 */
	public static final String DEFAULT_SCREEN_RENDERER = "defaultScreenRenderer";
}
