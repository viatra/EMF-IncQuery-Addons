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
 * DisplayMode of editor, that is 2D, 2.5D (2D content is projected on planes in
 * a 3D scene), or 3D.
 * <p>
 * The different modes are discussed in detail in the following article:
 * <dt>[Pilgrim08c]</dt>
 * <dd>Jens von Pilgrim and Kristian Duske: GEF3D -- a Framework for
 * Two-, Two-and-a-Half-, and Three-Dimensional Graphical Editors. In:
 * Hundhausen, Christopher and Telea, Alexandru and Koschke, Rainer (ed.)
 * SoftVis '08: Proceedings of the 4th ACM Symposium on Software Visualization,
 * pp 95--104, ACM Press,New York, NY, USA, September, 2008, ISBN
 * 978-1-60558-112-5, URL: <a
 * href="http://doi.acm.org/10.1145/1409720.1409737">
 * http://doi.acm.org/10.1145/1409720.1409737</a></dd> 
 * </dl>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 22, 2008
 */
public enum DisplayMode {

	TwoDimensional, Projected, ThreeDimensional;

}
