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

import org.eclipse.draw3d.ui.Draw3DUIPlugin;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

/**
 * Abstract base class for preference distributors.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 02.06.2009
 */
public abstract class Draw3DPreferenceDistributor implements
		IPropertyChangeListener {

	/**
	 * Initializes the client objects.
	 * 
	 * @param i_store
	 *            the preference store containing the configuration
	 */
	public abstract void init(IPreferenceStore i_store);

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
	 */
	public abstract void propertyChange(PropertyChangeEvent i_event);

	/**
	 * Initializes the client objects and starts listening to preference
	 * changes.
	 */
	public void start() {

		Draw3DUIPlugin plugin = Draw3DUIPlugin.getDefault();
		IPreferenceStore store = plugin.getPreferenceStore();

		init(store);
		store.addPropertyChangeListener(this);
	}

	/**
	 * Stops listening to preference changes.
	 */
	public void stop() {

		Draw3DUIPlugin plugin = Draw3DUIPlugin.getDefault();
		IPreferenceStore store = plugin.getPreferenceStore();

		store.removePropertyChangeListener(this);
	}
}
