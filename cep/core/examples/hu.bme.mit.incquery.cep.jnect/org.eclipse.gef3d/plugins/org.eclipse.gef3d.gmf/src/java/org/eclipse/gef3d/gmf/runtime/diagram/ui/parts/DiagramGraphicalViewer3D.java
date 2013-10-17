/*******************************************************************************
 * Copyright (c) 2009 Kristian Duske and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.gmf.runtime.diagram.ui.parts;

import java.util.Collection;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw3d.LightweightSystem3D;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef3d.factories.IFigureFactory;
import org.eclipse.gef3d.factories.IFigureFactoryProvider;
import org.eclipse.gef3d.gmf.runtime.core.service.IProviderAcceptorProvider;
import org.eclipse.gef3d.gmf.runtime.core.service.ProviderAcceptor;
import org.eclipse.gef3d.ui.parts.GraphicalViewer3D;
import org.eclipse.gef3d.ui.parts.GraphicalViewer3DHelper;
import org.eclipse.gmf.runtime.common.ui.services.editor.IEditorProvider;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * 3D diagram graphical viewer. It also implements
 * {@link org.eclipse.gef3d.factories.IFigureFactoryProvider.Mutable} for
 * convenience reasons.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since Apr 7, 2009
 */
public class DiagramGraphicalViewer3D extends DiagramGraphicalViewer implements
		GraphicalViewer3D, IProviderAcceptorProvider,
		IFigureFactoryProvider.Mutable {

	/**
	 * Helper, implementing most methods needed in this implementation. The
	 * methods in this class delegate to the helper methods.
	 */
	protected GraphicalViewer3DHelper m_ViewerHelper;

	/**
	 * The figure factory.
	 */
	protected IFigureFactory m_FigureFactory = null;

	/**
	 * Creates this viewer and adds a {@link ProviderAcceptor} to its
	 * properties. This provider selector is also attached as viewer to the
	 * diagram, in order to be accessible via {@link IEditorProvider}, see
	 * {@link IProviderSelector} for details.
	 */
	public DiagramGraphicalViewer3D() {
		this(new ProviderAcceptor(true));

	}

	/**
	 * Creates this viewer and adds the given provider selector to is
	 * properties.
	 * 
	 * @param providerAcceptor
	 */
	public DiagramGraphicalViewer3D(ProviderAcceptor providerAcceptor) {
		if (m_ViewerHelper == null) {
			m_ViewerHelper = new GraphicalViewer3DHelper(this);
		}
		setProperty(ProviderAcceptor.PROVIDER_ACCEPTOR_PROPERTY_KEY,
			providerAcceptor);
	}

	/**
	 * Always returns false as no 3D version of
	 * {@link org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer.LightweightSystemWithUpdateToggle}
	 * is available yet.
	 * 
	 * @todo implement 3D version of LightweightSystemWithUpdateToggle
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer#areUpdatesDisabled()
	 */
	@Override
	public boolean areUpdatesDisabled() {

		return false;
	}

	/**
	 * Creates a new GL canvas, sets it as this viewer's control and returns it.
	 * 
	 * @param i_composite the parent composite
	 * @return the GL canvas
	 */
	public Control createControl3D(Composite i_composite) {
		return m_ViewerHelper.createControl3D(i_composite,
			getLightweightSystem3D());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer#createLightweightSystem()
	 */
	@Override
	protected LightweightSystem createLightweightSystem() {
		if (m_ViewerHelper == null) {
			m_ViewerHelper = new GraphicalViewer3DHelper(this);
		}
		return m_ViewerHelper.createLightweightSystem();
	}

	/**
	 * Does nothing yet as no 3D version of
	 * {@link org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer.LightweightSystemWithUpdateToggle}
	 * is available yet.
	 * 
	 * @todo implement 3D version of LightweightSystemWithUpdateToggle
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer#enableUpdates(boolean)
	 */
	@Override
	public void enableUpdates(boolean i_enable) {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalViewerImpl#findHandleAt(org.eclipse.draw2d.geometry.Point)
	 */
	@Override
	public Handle findHandleAt(Point i_sLocation) {
		return m_ViewerHelper.findHandleAt(i_sLocation);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalViewerImpl#findObjectAtExcluding(org.eclipse.draw2d.geometry.Point,
	 *      java.util.Collection, org.eclipse.gef.EditPartViewer.Conditional)
	 */
	@Override
	public EditPart findObjectAtExcluding(Point i_sLocation,
		Collection i_exclude, final Conditional i_condition) {
		return m_ViewerHelper.findObjectAtExcluding(i_sLocation, i_exclude,
			i_condition);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.parts.ScrollingGraphicalViewer#getFigureCanvas()
	 */
	@Override
	protected FigureCanvas getFigureCanvas() {

		return null;
	}

	/**
	 * Returns the 3D lightweight system if there is one.
	 * 
	 * @return the 3D lightweight system or <code>null</code> if the current
	 *         lightweight system is not 3D
	 * @see org.eclipse.gef3d.ui.parts.GraphicalViewer3D#getLightweightSystem3D()
	 */
	public LightweightSystem3D getLightweightSystem3D() {

		LightweightSystem lws = getLightweightSystem();
		if (!(lws instanceof LightweightSystem3D))
			return null;

		return (LightweightSystem3D) lws;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.gmf.runtime.core.service.IProviderAcceptorProvider#getProviderAcceptor()
	 */
	public ProviderAcceptor getProviderAcceptor() {

		return (ProviderAcceptor) getProperty(ProviderAcceptor.PROVIDER_ACCEPTOR_PROPERTY_KEY);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.parts.ScrollingGraphicalViewer#reveal(org.eclipse.gef.EditPart)
	 */
	@Override
	public void reveal(EditPart i_part) {

		// TODO: implement this properly
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.parts.AbstractEditPartViewer#setContents(java.lang.Object)
	 */
	@Override
	public void setContents(Object contents) {

		if (contents instanceof EObject) {
			EObject eobj = (EObject) contents;
			ProviderAcceptor providerSelector = getProviderAcceptor();
			eobj.eAdapters().add(providerSelector);

		}
		super.setContents(contents);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.parts.ScrollingGraphicalViewer#setRootFigure(org.eclipse.draw2d.IFigure)
	 */
	@Override
	protected void setRootFigure(IFigure i_figure) {

		super.setRootFigure(i_figure);
		getLightweightSystem().setContents(i_figure);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.factories.IFigureFactoryProvider.Mutable#setFigureFactory(org.eclipse.gef3d.factories.IFigureFactory)
	 */
	public void setFigureFactory(IFigureFactory i_factory) {
		m_FigureFactory = i_factory;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.factories.IFigureFactoryProvider#getFigureFactory()
	 */
	public IFigureFactory getFigureFactory() {
		return m_FigureFactory;
	}

}
