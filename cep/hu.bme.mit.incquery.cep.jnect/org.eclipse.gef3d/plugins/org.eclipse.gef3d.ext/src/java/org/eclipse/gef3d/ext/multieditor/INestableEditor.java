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
package org.eclipse.gef3d.ext.multieditor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

/**
 * Editors implementing this interface can be nested into a multi editor. The
 * nesting is not done automatically, the nesting, viz multi, editor has to be
 * manually created, there is no general-purpose multi editor available. This
 * interface is used in combination with an multi editor implementing
 * {@link IMultiEditor}.
 * <p>
 * An example using this interface can be found in
 * org.eclipse.gef3d.examples.uml2.
 * </p>
 * <p>
 * This is the sequence of method calls:
 * <ol>
 * <li>{@link #init(IEditorSite, IEditorInput)}</li>
 * <li>
 * {@link #initializeAsNested(GraphicalViewer, MultiEditorPartFactory, MultiEditorModelContainer)}
 * </li>
 * <li>{@link #createPaletteDrawer()}</li>
 * </ol>
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Apr 15, 2009
 * @see INestableEditorWithResourceSet
 */
public interface INestableEditor {

	/**
	 * Sets the multi editor nesting this editor. This method is called after
	 * nestable editor has been created, but before
	 * {@link #init(IEditorSite, IEditorInput)} is called.
	 * 
	 * @param multiEditor
	 */
	void setMultiEditor(IMultiEditor multiEditor);

	/**
	 * Initializes a nested editor, it replaces the call to
	 * {@link GraphicalEditor#initializeGraphicalViewer()}, which is called when
	 * the editor is used standalone. The viewer is the viewer of the nesting
	 * editor, this should be considered.
	 * <p>
	 * The nested editor is expected to set up the multi factory. The following
	 * snippet can be used as a template: <code><pre>
	 * Diagram diagram = getDiagram();
	 * EditPartFactory factory = ... // e.g. EditPartService.getInstance();
	 * i_multiEditorPartFactory.prepare(diagram, factory);
	 * i_multiEditorModelContainer.add(diagram);
	 * ...
	 * return diagram;
	 * </pre></code>
	 * </p>
	 * The returned root content element, usually the same as used in the multi
	 * factory, is used by the multi editor to distinguish between different
	 * editors, e.g., for switching the properties sheet page.
	 * <p>
	 * This method is called <em>after</em>
	 * {@link #init(IEditorSite, IEditorInput)} has been called, so editor input
	 * is already set. That also means that this method is called <em>after</em>
	 * {@link #setMultiEditor(IMultiEditor)} has been set!
	 * </p>
	 * 
	 * @param i_graphicalViewer
	 * @param i_multiFactory
	 * @param i_container
	 * @return the root content element of the nested editor
	 * @todo maybe rename this? It is confusing to have two init methods.
	 */
	Object initializeAsNested(GraphicalViewer i_graphicalViewer,
		MultiEditorPartFactory i_multiFactory,
		MultiEditorModelContainer i_container);

	/**
	 * Inits the nested editor. This method is usually present in an editor,
	 * since it is the same method as
	 * {@link EditorPart#init(IEditorSite, IEditorInput)}.
	 * 
	 * @param i_editorSite -- this is actuallyte site of the nesting editor
	 * @param i_editorInput -- new input to be presented with the nested editor
	 * @see #initializeAsNested(GraphicalViewer, MultiEditorPartFactory,
	 *      MultiEditorModelContainer)
	 */
	void init(IEditorSite i_editorSite, IEditorInput i_editorInput)
		throws PartInitException;

	/**
	 * Creates new palette drawer with all tools of this nested editor. This
	 * method is quite similar to
	 * {@link GraphicalEditorWithPalette#getPaletteRoot()}, except that a drawer
	 * is expected instead of a root. The name of the drawer is used to identify
	 * the drawer, if a drawer with the same name is already present in the
	 * nesting (multi) editor, this new drawer is not added to the palette.
	 * <p>
	 * Note that GEF3D specific tools such as a camera is usually already
	 * provided by the multi editor.
	 * </p>
	 * 
	 * @return the editor specific drawer or null, if no palette is provided.
	 */
	PaletteDrawer createPaletteDrawer();

	/**
	 * This method is already defined in {@link IEditorPart} and used by multi
	 * editor to distinguish loaded editors.
	 * 
	 * @return
	 * @see IEditorPart#getEditorInput()
	 */
	IEditorInput getEditorInput();

	/**
	 * @param monitor
	 * @see EditorPart#doSave(IProgressMonitor)
	 */
	void doSave(IProgressMonitor monitor);

	/**
	 * @see EditorPart#isDirty()
	 * @return
	 */
	boolean isDirty();
}
