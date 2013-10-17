/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.graphics3d;

import java.util.Properties;
import java.util.logging.Logger;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.opengl.GLCanvas;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.Bundle;

/**
 * Descriptor of a {@link Graphics3D} instance. Name and description may
 * presented to the user, e.g. when exporting a diagram of in the preferences.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Mar 16, 2009
 */
public class Graphics3DDescriptor {
	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger
			.getLogger(Graphics3DDescriptor.class.getName());

	Graphics3DType type;

	String strName;

	String strDescription;

	String strClassname;

	String strRendererID;
	
	String contributorName;

	/**
	 * @return the contributorName
	 */
	public String getContributorName() {
		return contributorName;
	}

	/**
	 * @param i_contributorName the contributorName to set
	 */
	void setContributorName(String i_contributorName) {
		contributorName = i_contributorName;
	}

	Properties parameters;

	/**
	 * @param i_type
	 * @param i_name
	 * @param i_description
	 */
	public Graphics3DDescriptor() {
		parameters = new Properties();
	}

	/**
	 * @return the type
	 */
	public Graphics3DType getType() {
		return type;
	}

	/**
	 * @param i_type the type to set
	 */
	void setType(Graphics3DType i_type) {
		type = i_type;
	}

	/**
	 * @return the strName
	 */
	public String getName() {
		return strName;
	}

	/**
	 * @param i_strName the strName to set
	 */
	void setName(String i_strName) {
		strName = i_strName;
	}

	/**
	 * @return the strDescription
	 */
	public String getDescription() {
		return strDescription;
	}

	/**
	 * @param i_strDescription the strDescription to set
	 */
	void setDescription(String i_strDescription) {
		strDescription = i_strDescription;
	}

	/**
	 * @return the strClassname
	 */
	public String getClassname() {
		return strClassname;
	}

	/**
	 * @param i_strClassname the strClassname to set
	 */
	void setClassname(String i_strClassname) {
		strClassname = i_strClassname;
	}

	/**
	 * @return the strRendererID
	 */
	public String getRendererID() {
		return strRendererID;
	}

	/**
	 * @param i_strRendererID the strRendererID to set
	 */
	void setRendererID(String i_strRendererID) {
		strRendererID = i_strRendererID;
	}

	/**
	 * Creates a {@link Graphics3D} instance.
	 * 
	 * @param i_context The context which the renderer should use, only required
	 *            for renders of type SCREEN
	 * @return
	 */
	public Graphics3D createInstance(GLCanvas i_context) {
		try {
			Bundle bundle = Platform.getBundle(getContributorName());
			@SuppressWarnings("unchecked")
			Class<Graphics3D> clazz = (Class<Graphics3D>) bundle.loadClass(strClassname);
			
			Graphics3D g3d = clazz.newInstance();

			g3d.setDescriptor(this);
			if (getType() == Graphics3DType.SCREEN) 
				g3d.setGLCanvas(i_context);
			
			return g3d;
		} catch (Exception e) {
			
			MessageDialog.openError(Display.getCurrent().getActiveShell(),
				"Error creating 3D renderer",
				e.getMessage() + " (see log file for details).");
			
			Graphics3DPlugin.logError("Failed creating 3D renderer " + strClassname.toString(), e);
			log.warning("Descriptor failed to create renderer: " + this +
					 ", cause: " + e);
			return null;
		}
	}

	public Properties getParameters() {
		return parameters;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(getType()).append(" ");
		result.append(getName());
		result.append(" defined in ").append(getContributorName());
		result.append(" (").append(getDescription()).append(")");
		return result.toString();
	}

}
