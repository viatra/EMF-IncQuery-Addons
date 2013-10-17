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

/**
 * Type of a renderer. Screen renderers, such as OpenGL based ones, are expected
 * to perform rendering on a screen. Export renderers are expected to save the
 * diagram into a file, the are supposed to support a property called
 * "exportfile". Print renderers are expected to print the diagram.
 * <p>
 * A single renderer instance, i.e. a {@link Graphics3D} instance, can only
 * represent one type. If a renderer can serve for different types, multiple
 * instances must be created, each one with its unique
 * {@link Graphics3DDescriptor}.
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Mar 16, 2009
 */
public enum Graphics3DType {
	SCREEN, EXPORT, PRINT
}
