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
package org.eclipse.draw3d.camera;

/**
 * Listens to camera events.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 19.11.2007
 */
public interface ICameraListener {

    /**
     * Fired whenever any camera parameter (position, view direction or
     * viewport) has been changed.
     */
    public void cameraChanged();
}
