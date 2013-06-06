/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/

/**
 * Contains the image conversion system. The main class is the singleton
 * ImageCoverter, which provides a facade to the conversion system. It manages
 * pluggable convertersion policies, and selects the appropriate policy
 * depending on the properties of the images that are to be converted.
 * <p>
 * A conversion policy should extend the abstract ConversionPolicy class and
 * must be registered manually with the ImageConverter. Conversion policies must
 * provide information about the types of images they can convert.
 * </p>
 * 
 * @author 	Kristian Duske
 * @version	$Revision$
 * @since 	Jul 15, 2008
 */
package org.eclipse.draw3d.util.converter;

