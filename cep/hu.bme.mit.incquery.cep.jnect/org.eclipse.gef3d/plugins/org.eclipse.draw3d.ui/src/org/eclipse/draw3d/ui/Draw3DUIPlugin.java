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
package org.eclipse.draw3d.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * Controls the lifecycle of the plugin.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 01.06.2009
 */
public class Draw3DUIPlugin extends AbstractUIPlugin {

	private static Draw3DUIPlugin plugin;

	/**
	 * The plug-in ID.
	 */
	public static final String PLUGIN_ID = "org.eclipse.draw3d.ui";

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Draw3DUIPlugin getDefault() {
		return plugin;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext i_context) throws Exception {

		super.start(i_context);
		plugin = this;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext i_context) throws Exception {

		plugin = null;
		super.stop(i_context);
	}
}
