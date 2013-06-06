/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthias Thiele - initial API and implementation
 *    Kristian Duske - initial API and implementation
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/

/**
 * This package defines the Graphics3D interface and provides the management
 * between the available implementations in the Graphics3DRegistry. The following
 * figure shows the interfaces and classes defined in this package:
 * <img src="doc-files/cd_package.svg" width="100%" />
 * <p>
 * The interface consists of several interface types:
 * </p>
 * <p>
 * The two basic interfaces for 3D drawing are shown: Graphics3DUtil and Graphics3DDraw. While 
 * Graphics3DDraw provides common 3D drawing methods does Graphics3DUtil provide higher 
 * functions of 3D drawing which may not be available in all Graphics3D implementations. 
 * </p><p>
 * Graphics3DOffscreenBuffers and Graphics3DOffscreenBufferConfig wraps the possibility
 * of certain rendering implementations to render the offscreen content more efficient than
 * on-screen content. 
 * </p><p>
 * All interface parts are summarized in interface type Graphics3D. It extends Graphics3DUtil as
 * well as Graphics3DDraw, provides methods to create instances of the OffscreenBuffers and OffscreenBufferConfig
 * and can also manage 2D Graphics object to draw 2D figures into a 3D environment.
 * </p>
 * <p>
 * The Graphics3DRegistry is the class which knows all Graphics3D implementations and provides
 * capabilities to create instances of them. Please note, that the Graphics3DRegistry does not
 * manage the Graphics3D instances. Once created and returned, the
 * Graphics3DRegistry does not store any reference to them any more.
 * </p><p>
 * To retrieve information about the Graphics3D interface and its implementors, one can use
 * the Graphics3DMetaData class.
 * </p><p>
 * Graphics3DException and maybe more descendants, may be used by the implementations
 * to wrap more specific exceptions.
 * </p>
 * 
 * <h2>Internal Note</h2>
 * <p>This package is provided in a separate plugin, i.e. not in draw3d, since
 * it defines extension points and hence must be declared "singleton". Draw3D is
 * not a singleton plugin and should not be defined as a singleton for two reasons:
 * Draw2D is not a singleton and Draw3D was not developed with this restriction in
 * mind.</p>
 * 
 * @author Matthias Thiele
 * @version $Revision$
 * @since 29.11.2008
 */
package org.eclipse.draw3d.graphics3d;