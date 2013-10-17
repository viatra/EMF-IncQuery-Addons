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

/**
 * Drag-n-drop support for multi editors. The classes provided by this package
 * enable opening new diagrams in a mutli editor by simply dropping the file
 * (from the eclipse package view) onto the 3D scene of the multi editor.
 * Several tasks are necessary to achieve that:
 * <ol> 
 * <li>Install listener, see {@link EditorInputTransferDropTargetListener} and 
 * {@link org.eclipse.gef3d.ext.multieditor.dnd.ResourceTransferDropTargetListener} 
 * on how to do that</li>
 * <li>Install the {@link EditorInputDropPolicy} and/or {@link ResourceDropProlicy} the content edit part of the
 * multi editor, see policy on details</li>
 * <li>The multi editor has to implement the interface 
 * {@link org.eclipse.gef3d.ext.multieditor.IMultiEditor}, this interface
 * is used by the created request and command to pass the 
 * editor input or resources to the editor or viewer.
 * </ol>
 *  
 * @see <a href="http://www.eclipse.org/articles/Article-GEF-dnd/GEF-dnd.html">
 *      www.eclipse.org/articles/Article-GEF-dnd/GEF-dnd.html</a>
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Apr 16, 2009
 */
package org.eclipse.gef3d.ext.multieditor.dnd;

