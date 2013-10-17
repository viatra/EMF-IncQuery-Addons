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

import java.util.List;

import org.eclipse.draw3d.camera.FirstPersonCamera;
import org.eclipse.draw3d.camera.RestrictedFirstPersonCamera;
import org.eclipse.draw3d.graphics3d.Graphics3DDescriptor;
import org.eclipse.draw3d.graphics3d.Graphics3DRegistry;
import org.eclipse.draw3d.graphics3d.Graphics3DType;
import org.eclipse.draw3d.ui.Draw3DUIPlugin;
import org.eclipse.draw3d.ui.preferences.PrefNames;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Preference page implementation for general Draw3D settings.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 4.3.2008
 */
public class Draw3DPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	/**
	 * Creates a new instance.
	 */
	public Draw3DPreferencePage() {
		super(GRID);
		setPreferenceStore(Draw3DUIPlugin.getDefault().getPreferenceStore());
		setDescription("Draw3D general preferences");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	@Override
	public void createFieldEditors() {
		
		
		Graphics3DRegistry.resetDescriptors();
		List<Graphics3DDescriptor> descr =  Graphics3DRegistry.getRenderersForType(Graphics3DType.SCREEN);
		String[][] renderers = new String[descr.size()][2];
		for (int i=0; i<descr.size(); i++) {
			renderers[i][0] = descr.get(i).getName();
			renderers[i][1] = descr.get(i).getRendererID();
		}
		
		ComboFieldEditor rendererCombo = new ComboFieldEditor(PrefNames.DEFAULT_SCREEN_RENDERER, "Default screen renderer", 
			renderers, getFieldEditorParent());
		addField(rendererCombo);
		
		// TODO enable
		rendererCombo.setEnabled(false, getFieldEditorParent());
		

		String[][] cameraTypes =
			new String[][] {
				{ "Default first person camera",
					FirstPersonCamera.class.getName() },
				{ "Restricted first person camera",
					RestrictedFirstPersonCamera.class.getName() } };

		addField(new RadioGroupFieldEditor(PrefNames.LWS_CAMERA_TYPE,
			"Camera type:", 1, cameraTypes, getFieldEditorParent()));

		addField(new ColorFieldEditor(PrefNames.LWS_BACKGROUND,
			"Background color", getFieldEditorParent()));

		addField(new BooleanFieldEditor(PrefNames.LWS_DRAW_AXES, "Draw axes",
			getFieldEditorParent()));

		addField(new BooleanFieldEditor(PrefNames.LWS_DEBUG, "Debug",
			getFieldEditorParent()));

		String[][] fontOptions =
			new String[][] {
				new String[] { "Editor setting", PrefNames.FONT_AA_EDITOR },
				new String[] { "Always on (ignore editor setting)",
					PrefNames.FONT_AA_ON },
				new String[] { "Always off (ignore editor setting)",
					PrefNames.FONT_AA_OFF } };
		addField(new ComboFieldEditor(PrefNames.LWS_FONT_AA,
			"Font antialiasing", fontOptions, getFieldEditorParent()));
	}

	public void init(IWorkbench workbench) {
		// nothing to do
	}
}