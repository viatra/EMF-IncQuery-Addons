/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthias Thiele - initial API and implementation
 ******************************************************************************/

package org.eclipse.draw3d.graphics3d;

/**
 * Graphics3DException wraps exceptions thrown by the Graphics3D implementor, in
 * order to avoid dependencies via these exception types.
 * 
 * @author Matthias Thiele
 * @version $Revision$
 * @since 07.11.2008
 */
public class Graphics3DException extends RuntimeException {
	/**
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	

	/**
	 * @param message
	 * @param cause
	 */
	public Graphics3DException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @see java.lang.Exception#Exception(Throwable)
	 */
	public Graphics3DException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param i_message
	 */
	public Graphics3DException(String i_message) {
		super(i_message);
	}
	
	
}
