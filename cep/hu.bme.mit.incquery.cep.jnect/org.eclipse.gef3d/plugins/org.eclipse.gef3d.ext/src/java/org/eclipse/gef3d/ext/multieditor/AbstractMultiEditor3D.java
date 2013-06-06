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

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef3d.editparts.ScalableFreeformRootEditPart3D;
import org.eclipse.gef3d.ext.assimilator.BorgEditPartFactory;
import org.eclipse.gef3d.ext.multieditor.INestedEditorInfo.State;
import org.eclipse.gef3d.ext.multieditor.MultiEditorChangeEvent.Type;
import org.eclipse.gef3d.ext.multieditor.NestedEditorInfo.NestedEditorInfoList;
import org.eclipse.gef3d.ext.multieditor.dnd.EditorInputDropPolicy;
import org.eclipse.gef3d.ext.multieditor.dnd.EditorInputTransferDropTargetListener;
import org.eclipse.gef3d.factories.DisplayMode;
import org.eclipse.gef3d.factories.IFigureFactoryProvider;
import org.eclipse.gef3d.tools.CameraTool;
import org.eclipse.gef3d.ui.parts.GraphicalEditor3DWithFlyoutPalette;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.AbstractMultiEditor;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.osgi.framework.Bundle;

/**
 * This is an abstract base class for multi editors with GEF3D. All nested
 * editors are to be instances of {@link INestableEditor}, in case of
 * {@link INestableEditorWithResourceSet} a {@link ResourceSet} is used for all
 * nested editors. A {@link MultiEditorPartFactory} is used to combine all
 * nested factories, subclasses can combine this factory with other patterns,
 * such as the {@link BorgEditPartFactory}. Subclasses have to implement
 * {@link IMultiEditor#acceptsInput(IEditorInput)}, this method is called during
 * droping a file onto the 3D scene. Nested editors are retrieved by searching
 * the Eclipse extension registry, if other strategies are to be used,
 * {@link #createNestedEditor(IEditorInput)} has to be overridden.
 * <p>
 * In contrast to {@link AbstractMultiEditor}, editors in an 3D editor share the
 * same view.
 * </p>
 * <p>
 * You may override the {@link #acceptsInput(org.eclipse.ui.IEditorInput)}
 * method, which by default accepts all input for which a nestable editor can be
 * retrieved, see
 * {@link AbstractMultiEditor3D#acceptsInput(org.eclipse.ui.IEditorInput)}.
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Sep 22, 2009
 */
public abstract class AbstractMultiEditor3D extends
		GraphicalEditor3DWithFlyoutPalette implements IMultiEditor {
	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger
		.getLogger(AbstractMultiEditor3D.class.getName());

	protected MultiEditorModelContainer m_container;

	protected MultiEditorPartFactory m_multiFactory;

	protected NestedEditorInfoList nestedEditors;

	protected Set<IMultiEditorListener> multiEditorListeners;

	protected MultiEditorPropertySheetPage m_multiEditorSheetPage;

	/**
	 * This set is used in {@link #addEditor(IEditorInput)} for temporarliy
	 * storing new editor input elements right before or while the according
	 * nested editor is created. This prevents similar editor inputs to be added
	 * multiple times. This may happen in case of cross references (inter-model
	 * connecdtions), when the referenced models are automatically resolved and
	 * their visualization loaded into the editor.
	 */
	// protected Set<IEditorInput> m_addingInput = new HashSet<IEditorInput>();

	/**
	 * 
	 */
	public AbstractMultiEditor3D() {

		setEditDomain(new DefaultEditDomain(this));
		nestedEditors = new NestedEditorInfoList();
		multiEditorListeners = new HashSet<IMultiEditorListener>();
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * This method is not intended to be overridden. If you need to adjust the
	 * creation of nested editors, you may want to override
	 * {@link #createNestedEditor(IEditorInput)} or
	 * {@link #configureNestableEditor(INestableEditor)}. If you really need to
	 * override, think about calling this method before or after your specific
	 * code (via <code>super.addEditor(i_editorInput)</code>).
	 * </p>
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.IMultiEditor#addEditor(org.eclipse.ui.IEditorInput)
	 */
	public boolean addEditor(IEditorInput i_editorInput) {
		if (i_editorInput == null)
			return false;

		NestedEditorInfo info = new NestedEditorInfo(i_editorInput, this);
		if (!nestedEditors.add(info)) { // input already added
			return false;
		}

		try {

			// find appropriate editor
			INestableEditor nestedEditor = createNestedEditor(i_editorInput);

			if (nestedEditor == null) {
				if (log.isLoggable(Level.INFO)) {
					log.info("No nestable editor found for input " //$NON-NLS-1$
						+ i_editorInput);
				}
				return false;
			}
			info.setNestableEditor(nestedEditor);
			nestedEditor.setMultiEditor(this);
			configureNestableEditor(nestedEditor);

			String id = info.getEditorID();
			if (id == null) {
				id = getEditorSite().getId();
				info.setEditorID(id);
			}

			IEditorSite nestedEditorSiteProxy =
				NestedEditorSite.createNestedEditorSite(id, getEditorSite());
			info.setEditorSite(nestedEditorSiteProxy);

			try {
				nestedEditor.init(nestedEditorSiteProxy, i_editorInput);
				Object editorContent =
					nestedEditor.initializeAsNested(getGraphicalViewer(),
						m_multiFactory, m_container);
				info.setContents(editorContent);

				addNestedPalette(nestedEditor.createPaletteDrawer());
				fireMultiEditorChangeEvent(new MultiEditorChangeEvent(this,
					nestedEditor, editorContent, Type.added));

			} catch (PartInitException ex) {
				log.warning("IEditorInput - exception: " + ex); //$NON-NLS-1$
				return false;
			}
			info.setState(State.active);
			return true;

		} finally {
			if (info.getState() != State.active)
				nestedEditors.remove(info);
		}
	}

	/**
	 * Configures nested editor right after it has been created and right before
	 * it is initialized. This method is intended to be overridden by subclasses
	 * in order set additional attributes, such as a shared {@link ResourceSet},
	 * an editing domain id or an
	 * {@link org.eclipse.emf.edit.domain.EditingDomain}.
	 */
	protected void configureNestableEditor(INestableEditor nestedEditor) {
	}

	/**
	 * @param i_createPaletteDrawer
	 */
	protected void addNestedPalette(PaletteDrawer drawer) {

		if (drawer != null)
			getPaletteRoot().add(drawer);
	}

	/**
	 * {@inheritDoc}.
	 * <p>
	 * A {@link MultiEditorPartFactory} and a {@link MultiEditorFigureFactory}
	 * are registered to the graphical viewer.
	 * 
	 * @see org.eclipse.gef3d.examples.graph.editor.GraphEditor3D#configureGraphicalViewer()
	 */
	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		getGraphicalViewer().setProperty(IMultiEditor.class.getName(), this);

		RootEditPart root = createRootEditPart();
		getGraphicalViewer().setRootEditPart(root);

		if (getGraphicalViewer() instanceof IFigureFactoryProvider.Mutable) {
			((IFigureFactoryProvider.Mutable) getGraphicalViewer())
				.setFigureFactory(new MultiEditorFigureFactory(
					DisplayMode.Projected));
		}

		m_multiFactory = createMultiFactory();
		getGraphicalViewer().setEditPartFactory(m_multiFactory);

	}

	/**
	 * 
	 */
	protected MultiEditorPartFactory createMultiFactory() {
		return new MultiEditorPartFactory();
	}

	/**
	 * Searches matching editor for given input (in extension registry) and
	 * returns an instance of that editor. This method is called by
	 * {@link #addEditor(IEditorInput)}.
	 * <p>
	 * If this method is overloaded, ensure to put the nested editor ID to
	 * {@link #nestedEditorIDs}, as this is used later on (in
	 * {@link #addEditor(IEditorInput)} to create an {@link NestedEditorSite}.
	 * This is necessary in order to let GMF providers support the nested
	 * editor.
	 * 
	 * @param i_editorInput
	 * @return the nestable editor, or null if no matching editor was found
	 */
	protected INestableEditor createNestedEditor(IEditorInput i_editorInput) {
		Map<String, Class> editorClasses =
			findNestableEditorClasses(i_editorInput);
		Class clazz = null;
		String id = null;

		for (Entry<String, Class> editorClass : editorClasses.entrySet()) {
			id = editorClass.getKey();
			clazz = editorClass.getValue();

			try {
				INestableEditor editor = (INestableEditor) clazz.newInstance();
				NestedEditorInfo info =
					nestedEditors.getByEditorInput(i_editorInput);
				if (info != null)
					info.setEditorID(id);
				return editor;
			} catch (InstantiationException ex) {
				log.warning("Cannot create nested editor " //$NON-NLS-1$
					+ clazz.toString() + ", ex=" + ex); //$NON-NLS-1$
			} catch (IllegalAccessException ex) {
				log.warning("Cannot create nested editor " //$NON-NLS-1$
					+ clazz.toString() + ", ex=" + ex); //$NON-NLS-1$
			}
		}
		return null;
	}

	/**
	 * Called by {@link #getPaletteRoot()} to lazily create the palette.
	 * 
	 * @return
	 */
	protected PaletteRoot createPaletteRoot() {
		PaletteRoot root;
		root = new MultiPaletteRoot();
		PaletteDrawer drawer = new PaletteDrawer("GEF3D");
		drawer.setDescription("General Multi Editor 3D Tools");

		drawer.add(new ToolEntry("Camera", "Camera Tool", null, null,
			CameraTool.class) {
			// nothing to implement
		});

		root.add(drawer);
		return root;
	}

	/**
	 * Default implementation returns a {@link ScalableFreeformRootEditPart3D},
	 * called from {@link #configureGraphicalViewer()}.
	 * 
	 * @return
	 */
	protected RootEditPart createRootEditPart() {
		// we need a special 3D root edit part for connections and feedback
		return new ScalableFreeformRootEditPart3D();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		for (NestedEditorInfo info : nestedEditors) {
			info.getNestableEditor().doSave(monitor);
		}
	}

	/**
	 * Returns a list of classes implementing {@link INestableEditor} which are
	 * registered for this editor input.
	 * 
	 * @param i_editorInput
	 * @return map, keys are the ids of the editors, values the classes.
	 */
	protected Map<String, Class> findNestableEditorClasses(
		IEditorInput i_editorInput) {
		String strName = i_editorInput.getName();
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point =
			registry.getExtensionPoint("org.eclipse.ui.editors");
		if (point == null)
			return null;
		IExtension[] extensions = point.getExtensions();

		Map<String, Class> editorClasses = new HashMap<String, Class>();

		for (IExtension extension : extensions) {
			String strContributorName = extension.getContributor().getName();
			// if (log.isLoggable(Level.INFO)) {
			// log.info("Extension found: " + extension
			//					+ ", Contributor: " + strContributorName); //$NON-NLS-1$
			// }

			IConfigurationElement[] ices = extension.getConfigurationElements();
			String ext, token;
			StringTokenizer strt;
			for (IConfigurationElement element : ices) {
				if (element.getName().equals("editor")) {
					ext = element.getAttribute("extensions");
					if (ext != null) {
						strt = new StringTokenizer(ext, ",");
						while (strt.hasMoreTokens()) {
							token = strt.nextToken();
							if (strName.endsWith("." + token)) {
								Bundle bundle =
									Platform.getBundle(strContributorName);
								String strClassname =
									element.getAttribute("class");
								String strID = element.getAttribute("id");
								if (strID == null || strID.isEmpty()) {
									strID = strClassname;
								}

								Class clazz;
								try {
									clazz = bundle.loadClass(strClassname);
									if (INestableEditor.class
										.isAssignableFrom(clazz)) {
										if (isCompatibleEditor(i_editorInput,
											element, clazz))
											editorClasses.put(strID, clazz);
									}
								} catch (ClassNotFoundException ex) {
									log.warning("Cannot create nested editor " //$NON-NLS-1$
										+ strClassname + ", ex=" + ex); //$NON-NLS-1$
									ex.printStackTrace();
								}

							}
						}
					}
				}
			}
		}
		return editorClasses;
	}

	/**
	 * @return the container
	 */
	public MultiEditorModelContainer getContainer() {
		return m_container;
	}

	/**
	 * @return the multiFactory
	 */
	protected MultiEditorPartFactory getMultiFactory() {
		return m_multiFactory;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#getPaletteRoot()
	 */
	protected PaletteRoot getPaletteRoot() {
		PaletteRoot root = null;
		if (getEditDomain() != null
			&& getEditDomain().getPaletteViewer() != null) {
			root = getEditDomain().getPaletteViewer().getPaletteRoot();
		}
		if (root == null) {
			root = createPaletteRoot();
		}
		return root;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#initializeGraphicalViewer()
	 */
	@Override
	protected void initializeGraphicalViewer() {
		m_container = new MultiEditorModelContainer();
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setContents(m_container);

		installDragAndDrop();

		addEditor(getEditorInput());
	}

	/**
	 * 
	 */
	protected void installDragAndDrop() {
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.addDropTargetListener(new EditorInputTransferDropTargetListener(
			this));
		viewer.getContents().installEditPolicy(
			EditorInputDropPolicy.EDITOR_INPUT_ROLE,
			new EditorInputDropPolicy());
	}

	/**
	 * Indicates whether an editor that was discovered using the plugin registry
	 * is compatible with the given editor input. Subclasses can override this
	 * method to customize the selection of editors
	 * 
	 * @param i_editorInput the editor input
	 * @param i_element the configuration element that represents the extension
	 *            point
	 * @param i_clazz the editor class
	 * @return <code>true</code> if the given editor is compatible or
	 *         <code>false</code> otherwise
	 */
	protected boolean isCompatibleEditor(IEditorInput i_editorInput,
		IConfigurationElement i_element, Class i_clazz) {

		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#isDirty()
	 */
	@Override
	public boolean isDirty() {
		for (INestedEditorInfo info : nestedEditors) {
			if (info.getNestableEditor().isDirty())
				return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.IMultiEditor#findEditorByEditPart(org.eclipse.gef.EditPart)
	 */
	public INestableEditor findEditorByEditPart(EditPart part) {
		if (part == null)
			return null;

		INestedEditorInfo info = nestedEditors.getByContents(part.getModel());
		if (info != null)
			return info.getNestableEditor();

		INestableEditor editor = findEditorByEditPart(part.getParent());
		if (editor == null && part instanceof ConnectionEditPart) {
			editor =
				findEditorByEditPart(((ConnectionEditPart) part).getSource());
		}
		return editor;
	}

	/**
	 * Returns the content edit part of the given nested editor. This method is
	 * rather expensive (however, usually there are not too much editors
	 * nested).
	 * 
	 * @param m_nestableEditor
	 * @return
	 */
	public EditPart findNestedEditorContent(INestableEditor nestableEditor) {
		if (nestableEditor == null)
			return null;

		List parts = getGraphicalViewer().getContents().getChildren();
		int count = parts.size();
		for (int i = 0; i < count; i++) {
			EditPart part = (EditPart) parts.get(i);
			if (findEditorByEditPart(part) == nestableEditor) {
				return part;
			}
		}
		return null;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.IMultiEditor#addMultiEditorListener(org.eclipse.gef3d.ext.multieditor.IMultiEditorListener)
	 */
	public void addMultiEditorListener(
		IMultiEditorListener i_multiEditorListener) {
		multiEditorListeners.add(i_multiEditorListener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.IMultiEditor#removeMultiEditorListener(org.eclipse.gef3d.ext.multieditor.IMultiEditorListener)
	 */
	public void removeMultiEditorListener(
		IMultiEditorListener i_multiEditorListener) {
		multiEditorListeners.remove(i_multiEditorListener);
	}

	protected void fireMultiEditorChangeEvent(MultiEditorChangeEvent event) {
		for (IMultiEditorListener listener : multiEditorListeners) {
			listener.multiEditorChanged(event);
		}
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * {@link AbstractMultiEditor} supports the following types:
	 * <ul>
	 * <li>{@link IPropertySheetPage} -- see {@link #createPropertySheetPage()}</li>
	 * </ul>
	 * </p>
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class type) {
		if (type == IPropertySheetPage.class) {
			if (m_multiEditorSheetPage == null) {
				m_multiEditorSheetPage = createPropertySheetPage();
			}
			return m_multiEditorSheetPage;
		}

		return super.getAdapter(type);
	}

	/**
	 * Creates a {@link MultiEditorPropertySheetPage}, maybe overridden by
	 * subclasses. This method is called by {@link #getAdapter(Class)} if class
	 * is {@link IPropertySheetPage}.
	 * 
	 * @return
	 */
	protected MultiEditorPropertySheetPage createPropertySheetPage() {
		MultiEditorPropertySheetPage page =
			new MultiEditorPropertySheetPage(this);
		return page;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Accepts input if a nesteable editor is found in the plug-in registry
	 * </p>
	 * 
	 * @see org.eclipse.gef3d.ext.multieditor.IMultiEditor#acceptsInput(org.eclipse.ui.IEditorInput)
	 */
	public boolean acceptsInput(IEditorInput i_editorInput) {
		return !findNestableEditorClasses(i_editorInput).isEmpty();
	}

}