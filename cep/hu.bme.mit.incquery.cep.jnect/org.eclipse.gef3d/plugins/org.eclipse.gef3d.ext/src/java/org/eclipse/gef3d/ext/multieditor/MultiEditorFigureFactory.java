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
package org.eclipse.gef3d.ext.multieditor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gef3d.factories.DisplayMode;
import org.eclipse.gef3d.factories.IFigureFactory;
import org.eclipse.gef3d.factories.IFigureFactoryProvider;

/**
 * Multi figure factory used by multi editors. Similar to the
 * {@link MultiEditorPartFactory}, it nests {@link IFigureFactory} registered by
 * nested editors in
 * {@link INestableEditor#initializeAsNested(org.eclipse.gef.GraphicalViewer, MultiEditorPartFactory, MultiEditorModelContainer)}
 * . Instead of registering the {@link IFigureFactory} in
 * {@link GraphicalEditor#configureGraphicalViewer()}, it is to be registered in
 * {@link INestableEditor#initializeAsNested(org.eclipse.gef.GraphicalViewer, MultiEditorPartFactory, MultiEditorModelContainer)}
 * .
 * {@link #prepareNestedFigureFactory(GraphicalViewer, Object, IFigureFactory)}
 * can be used there to simplify the registration.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since Jun 13, 2011
 */
public class MultiEditorFigureFactory implements IFigureFactory {

	private DisplayMode mode;

	protected Map<EditPart, IFigureFactory> nestedFigureFactories;

	protected Map<Object, IFigureFactory> preparedFigureFactories;

	/**
	 * 
	 */
	public MultiEditorFigureFactory(DisplayMode i_mode) {
		nestedFigureFactories = new HashMap<EditPart, IFigureFactory>();
		preparedFigureFactories = new HashMap<Object, IFigureFactory>();
		mode = i_mode;
	}

	/**
	 * To be called in
	 * {@link INestableEditor#initializeAsNested(GraphicalViewer, MultiEditorPartFactory, MultiEditorModelContainer)}
	 * .
	 * 
	 * @param i_graphicalViewer the viewer, must be an instance of
	 *            {@link IFigureFactoryProvider}
	 * @param model the (root) model of the nested editor, usually the diagram
	 * @param nestedFigureFactory the nested figure factory
	 * @throws IllegalArgumentException if viewer provides no
	 *             {@link MultiEditorFigureFactory}.
	 */
	public static void prepareNestedFigureFactory(
		GraphicalViewer i_graphicalViewer, Object model,
		IFigureFactory nestedFigureFactory) {

		if (i_graphicalViewer instanceof IFigureFactoryProvider) {
			IFigureFactory figureFactory =
				((IFigureFactoryProvider) i_graphicalViewer).getFigureFactory();
			if (figureFactory instanceof MultiEditorFigureFactory) {
				((MultiEditorFigureFactory) figureFactory)
					.prepareNestedFigureFactory(model, nestedFigureFactory);
			} else {
				throw new IllegalArgumentException(
					"Viewer's figure factory must be a MultiEditorFigureFactory, was "
						+ figureFactory);
			}
		} else {
			throw new IllegalArgumentException(
				"Viewer must be an IFigureFactoryProvider");
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.factories.IDisplayModeSensitive#getMode()
	 */
	public DisplayMode getMode() {
		return mode;
	}

	/**
	 * Adds a new figure factory. Similar to {@link MultiEditorPartFactory}, the
	 * edit part to be used as key for retrieving the figure factory has not
	 * been created when initializing the factory. Thus, its model element is
	 * used to prepare the factory.
	 * 
	 * @param model usually the model of the diagram
	 * @param nestedFigureFactory
	 */
	public void prepareNestedFigureFactory(Object model,
		IFigureFactory nestedFigureFactory) {
		preparedFigureFactories.put(model, nestedFigureFactory);
	}

	/**
	 * Removes a figure factory.
	 * 
	 * @param rootEditPart
	 */
	public void removeNestedFigureFactory(EditPart rootEditPart) {
		nestedFigureFactories.remove(rootEditPart);
	}

	/**
	 * {@inheritDoc}.
	 * 
	 * @see org.eclipse.gef3d.factories.IFigureFactory#createFigure(org.eclipse.gef.GraphicalEditPart,
	 *      java.lang.Object)
	 */
	public IFigure createFigure(GraphicalEditPart i_controller, Object i_hint) {
		IFigureFactory figureFactory = null;
		EditPart ep = i_controller;
		while (figureFactory == null && ep != null) {
			figureFactory = nestedFigureFactories.get(ep);
			ep = ep.getParent();
		}
		if (figureFactory == null) {
			Object model = i_controller.getModel();
			figureFactory = preparedFigureFactories.get(model);
			if (figureFactory != null) {
				nestedFigureFactories.put(i_controller, figureFactory);
				preparedFigureFactories.remove(model);
			}
		}
		if (figureFactory == null && i_controller instanceof ConnectionEditPart) {
			ep = ((ConnectionEditPart)i_controller).getSource();
			while (figureFactory == null && ep != null) {
				figureFactory = nestedFigureFactories.get(ep);
				ep = ep.getParent();
			}
			if (figureFactory==null) {
				ep = ((ConnectionEditPart)i_controller).getTarget();
				while (figureFactory == null && ep != null) {
					figureFactory = nestedFigureFactories.get(ep);
					ep = ep.getParent();
				}	
			}
		}
		if (figureFactory == null) {
			throw new IllegalStateException(
				"No nested figure factory found for " + i_controller);
		}
		return figureFactory.createFigure(i_controller, i_hint);
	}

}
