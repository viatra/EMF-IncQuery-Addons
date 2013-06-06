/*******************************************************************************
 * Copyright (c) 2010 Jens von Pilgrim and others.
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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.IPageBookViewPage;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.properties.IPropertySheetPage;

/**
 * Property sheet page used by {@link AbstractMultiEditor3D} in order to display
 * different property pages for nested editors. This property sheet page
 * automatically creates new property sheet pages as needed. The current editor
 * is retrieved using {@link IMultiEditor#findEditorByEditPart(EditPart)}. If
 * {@link AbstractMultiEditor3D} is used, nothing has to be configured.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 4, 2010
 */
public class MultiEditorPropertySheetPage implements IPropertySheetPage,
		IPageBookViewPage {
	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(MultiEditorPropertySheetPage.class.getName());

	Composite root;

	IMultiEditor m_multiEditor;

	IPropertySheetPage defaultPage;

	Map<INestableEditor, IPropertySheetPage> cachedPages;

	IPropertySheetPage currentPage;

	private IActionBars m_actionBars;

	private StackLayout stackLayout;

	private IPageSite pageSite;

	private Composite main;

	/**
	 * 
	 */
	public MultiEditorPropertySheetPage(IMultiEditor multiEditor) {
		m_multiEditor = multiEditor;
		cachedPages = new HashMap<INestableEditor, IPropertySheetPage>();
		defaultPage = createDefaultPage();

		currentPage = defaultPage;

		// // return new PropertiesBrowserPage(this);
		// for (INestableEditor nestedEditor : nestedEditors) {
		// if (nestedEditor instanceof IAdaptable) {
		// Object result =
		// ((IAdaptable) nestedEditor).getAdapter(type);
		// if (result != null)
		// return result;
		// }
		// }
		// return new PropertiesBrowserPage(this);

	}

	/**
	 * Creates a simple label, maybe overridden by subclasses.
	 * @return
	 */
	protected IPropertySheetPage createDefaultPage() {
		return new IPropertySheetPage() {
			Label label;

			public void selectionChanged(IWorkbenchPart i_part,
				ISelection i_selection) {
			}

			public void setFocus() {
				label.setFocus();
			}

			public void setActionBars(IActionBars i_actionBars) {
			}

			public Control getControl() {
				return label;
			}

			public void dispose() {
				label.dispose();
			}

			public void createControl(Composite i_parent) {
				label = new Label(i_parent, SWT.None);
				label.setText("No properties available");
			}
		};
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.IPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite i_parent) {
		main = new Composite(i_parent, SWT.None);
		main.setLayout(new GridLayout());
		main.setLayoutData(new GridData(GridData.FILL_BOTH));

		root = new Composite(main, SWT.None);
		root.setLayoutData(new GridData(GridData.FILL_BOTH));
		stackLayout = new StackLayout();
		root.setLayout(stackLayout);
		defaultPage.createControl(root);
		setCurrent(defaultPage);

	}

	/**
	 * @param i_defaultPage
	 */
	private void setCurrent(IPropertySheetPage newCurrent) {
		// if (newCurrent != currentPage) {
		if (currentPage != null)
			currentPage.getControl().setVisible(false);
		currentPage = newCurrent;
		currentPage.getControl().setVisible(true);
		stackLayout.topControl = currentPage.getControl();
		root.layout();
		// }
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.IPage#getControl()
	 */
	public Control getControl() {
		return main;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.IPage#setFocus()
	 */
	public void setFocus() {
		if (!root.isDisposed())
			root.setFocus();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IWorkbenchPart i_part, ISelection i_selection) {
		if (log.isLoggable(Level.INFO)) {
			log.info("Part: " + i_part + ", Selection: " + i_selection); //$NON-NLS-1$
		}

		if (i_part == m_multiEditor
			&& i_selection instanceof StructuredSelection) {
			StructuredSelection structuredSelection =
				(StructuredSelection) i_selection;
			if (structuredSelection.getFirstElement() instanceof EditPart) {
				EditPart part =
					(EditPart) structuredSelection.getFirstElement();
				INestableEditor editor =
					m_multiEditor.findEditorByEditPart(part);
				if (editor != null) {
					IPropertySheetPage page = cachedPages.get(editor);
					if (page == null) {
						if (editor instanceof IAdaptable) {
							page =
								(IPropertySheetPage) ((IAdaptable) editor)
									.getAdapter(IPropertySheetPage.class);
							if (page != null) {
								cachedPages.put(editor, page);
								if (page instanceof IPageBookViewPage)
									try {
										((IPageBookViewPage) page)
											.init(getSite());
									} catch (PartInitException ex) {
										log.warning("Error initializing page: "
											+ ex);
										ex.printStackTrace();
									}
								page.createControl(root);
								if (m_actionBars != null)
									page.setActionBars(m_actionBars);
							}
						}
					}
					if (page != null) {
						setCurrent(page);
						page.selectionChanged(i_part, structuredSelection);
						return;
					}
				}
			}
			setCurrent(defaultPage);
			defaultPage.selectionChanged(i_part, structuredSelection);
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.IPage#dispose()
	 */
	public void dispose() {
		root.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.IPage#setActionBars(org.eclipse.ui.IActionBars)
	 */
	public void setActionBars(IActionBars i_actionBars) {
		m_actionBars = i_actionBars;
		for (IPropertySheetPage pages : cachedPages.values()) {
			pages.setActionBars(i_actionBars);
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.IPageBookViewPage#getSite()
	 */
	public IPageSite getSite() {
		return pageSite;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.IPageBookViewPage#init(org.eclipse.ui.part.IPageSite)
	 */
	public void init(IPageSite i_site) throws PartInitException {
		pageSite = i_site;
		if (defaultPage instanceof IPageBookViewPage)
			((IPageBookViewPage) defaultPage).init(i_site);
		for (IPropertySheetPage page : cachedPages.values()) {
			if (page instanceof IPageBookViewPage)
				((IPageBookViewPage) page).init(i_site);
		}

	}

}
