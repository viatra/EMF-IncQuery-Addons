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
package org.eclipse.draw3d.ui.preferences.dialog;

import static org.eclipse.draw3d.ui.preferences.PrefNames.*;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.draw3d.ui.Draw3DUIPlugin;
import org.eclipse.draw3d.ui.preferences.ScenePreferenceDistributor;
import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/**
 * Initializes the preference store.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 4.3.2008
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	private String getSequence(int keyCode) {

		KeyStroke keyStroke = KeyStroke.getInstance(keyCode);
		KeySequence keySequence = KeySequence.getInstance(keyStroke);

		return keySequence.toString();
	}

	@Override
	public void initializeDefaultPreferences() {

		IPreferenceStore store =
			Draw3DUIPlugin.getDefault().getPreferenceStore();

		store.setDefault(LWS_CAMERA_TYPE,
			ScenePreferenceDistributor.DEFAULT_CAMERA_TYPE);

		Display display = Display.getCurrent();
		Color backgroundColor = display.getSystemColor(SWT.COLOR_GRAY);

		store.setDefault(LWS_BACKGROUND,
			StringConverter.asString(backgroundColor.getRGB()));

		store.setDefault(LWS_FONT_AA, FONT_AA_EDITOR);

		store.setDefault(LWS_DEBUG, false);
		store.setDefault(LWS_DRAW_AXES, true);
		store.setDefault(MOUSE_SENSITIVITY, 10);

		store.setDefault(KEY_FORWARD, getSequence('+'));
		store.setDefault(KEY_BACKWARD, getSequence('-'));

		store.setDefault(KEY_UP, getSequence(SWT.ARROW_UP));
		store.setDefault(KEY_DOWN, getSequence(SWT.ARROW_DOWN));

		store.setDefault(KEY_LEFT, getSequence(SWT.ARROW_LEFT));
		store.setDefault(KEY_RIGHT, getSequence(SWT.ARROW_RIGHT));

		store.setDefault(KEY_ROLL_CCW, getSequence('Y'));
		store.setDefault(KEY_ROLL_CW, getSequence('X'));

		store.setDefault(KEY_CENTER, getSequence(SWT.ESC));
		store.setDefault(MOD_ORBIT, SWT.ALT);
	}
}
