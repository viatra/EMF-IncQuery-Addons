/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.factories;

/**
 * Classes implementing this interface are display mode sensitive, i.e. their
 * behavior differs based on a given display mode.
 *
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Apr 22, 2008
 */
public interface IDisplayModeSensitive {
	
	/**
	 * Returns display mode.
	 * @return
	 */
	DisplayMode getMode();

}
