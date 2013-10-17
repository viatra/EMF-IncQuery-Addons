/*******************************************************************************
 * Copyright (c) 2011 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.camera;

import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Vector3f;

/**
 * ICameraPosition There should really be more documentation here.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since May 22, 2011
 */
public interface ICameraPosition {

	/**
	 * Returns the position, the vector is stored in the given parameter
	 * if this is not null.
	 * 
	 * @param o_result, if null, a new result object is created.
	 * @return
	 */
	IVector3f getPosition(Vector3f o_result);
	
	IVector3f getPosition();

	/**
	 * Returns the view direction, the vector is stored in the given parameter
	 * if this is not null.
	 * 
	 * @param o_result, if null, a new result object is created.
	 * @return 
	 */
	IVector3f getViewDirection(Vector3f o_result);
	
	IVector3f getViewDirection();

	/**
	 * Returns the up vector, the vector is stored in the given parameter
	 * if this is not null.
	 * 
	 * @param o_result
	 * @return
	 */
	IVector3f getUpVector(Vector3f o_result);
	
	IVector3f getUpVector();
	
	/**
	 * Returns the right vector, the vector is stored in the given parameter
	 * if this is not null.
	 * 
	 * @param o_result
	 * @return
	 */
	IVector3f getRightVector(Vector3f o_result);
	
	IVector3f getRightVector();
	

}
