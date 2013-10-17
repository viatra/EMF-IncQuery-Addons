/*******************************************************************************
 * Copyright (c) 2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial implementation
 ******************************************************************************/
package org.eclipse.draw3d.graphics3d;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;


/**
 * Graphics3DPlugin, provides logging functions
 *
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Dec 21, 2010
 */	
public class Graphics3DPlugin extends Plugin {

	// The shared instance
	private static Graphics3DPlugin plugin;

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.gef3d.graphics3d";
	
	
	/**
	 * The constructor
	 */
	public Graphics3DPlugin() {
	}

	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Graphics3DPlugin getDefault() {
		return plugin;
	}

		
	public static void logInfo(String msg) {
		getDefault().getLog().log(new Status(Status.INFO, PLUGIN_ID, msg));
	}
	
	public static void logError(String msg, Exception e) {
	    getDefault().getLog().log(new Status(Status.ERROR, PLUGIN_ID, Status.OK, msg, e));
	 }
}
