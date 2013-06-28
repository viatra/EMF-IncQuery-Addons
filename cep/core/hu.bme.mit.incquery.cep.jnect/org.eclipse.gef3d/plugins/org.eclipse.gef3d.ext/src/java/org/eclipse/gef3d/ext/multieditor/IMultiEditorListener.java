/*******************************************************************************
 * Copyright (c) 2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.ext.multieditor;

/**
 * Listener interface implemented by classes interested to be notified when
 * editors are newly nested or removed from a {@link IMultiEditor}. The listener
 * has to be added to the {@link IMultiEditor} via
 * {@link IMultiEditor#addMultiEditorListener(IMultiEditorListener)} and can be
 * removed via
 * {@link IMultiEditor#removeMultiEditorListener(IMultiEditorListener)}
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 4, 2010
 */
public interface IMultiEditorListener {

	void multiEditorChanged(MultiEditorChangeEvent event);

}
