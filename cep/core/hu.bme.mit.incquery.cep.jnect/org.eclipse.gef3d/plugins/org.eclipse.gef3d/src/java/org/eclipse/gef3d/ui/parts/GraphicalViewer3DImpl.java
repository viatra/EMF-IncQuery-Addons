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
package org.eclipse.gef3d.ui.parts;

import java.util.Collection;
import java.util.logging.Logger;

import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw3d.LightweightSystem3D;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.ui.parts.GraphicalViewerImpl;
import org.eclipse.gef3d.factories.IFigureFactory;
import org.eclipse.gef3d.factories.IFigureFactoryProvider;
import org.eclipse.swt.opengl.GLCanvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Creates GLCanvas, RootEditPart, and LightweightSystem. Here, 3D versions of
 * these objects are created.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 16.11.2007
 */
public class GraphicalViewer3DImpl extends GraphicalViewerImpl implements
		GraphicalViewer3D, IFigureFactoryProvider.Mutable {

	@SuppressWarnings("unused")
	private static final Logger log = Logger
		.getLogger(GraphicalViewer3DImpl.class.getName());

	protected IFigureFactory m_FigureFactory = null;

	/**
	 * Helper, implementing most methods needed in this implementation. The
	 * methods in this class delegate to the helper methods.
	 */
	protected GraphicalViewer3DHelper m_ViewerHelper;

	/**
	 * 
	 */
	public GraphicalViewer3DImpl() {
		if (m_ViewerHelper == null) {
			m_ViewerHelper = new GraphicalViewer3DHelper(this);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalViewerImpl#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public Control createControl(Composite i_composite) {

		return createControl3D(i_composite);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ui.parts.GraphicalViewer3D#createControl3D(org.eclipse.swt.widgets.Composite)
	 */
	public Control createControl3D(Composite i_composite) {
		return m_ViewerHelper.createControl3D(i_composite,
			getLightweightSystem3D());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalViewerImpl#createDefaultRoot()
	 */
	@Override
	protected void createDefaultRoot() {

		setRootEditPart(new ScalableRootEditPart());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalViewerImpl#createLightweightSystem()
	 */
	@Override
	protected LightweightSystem createLightweightSystem() {
		if (m_ViewerHelper == null) {
			m_ViewerHelper = new GraphicalViewer3DHelper(this);
		}
		return m_ViewerHelper.createLightweightSystem();
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
	 * Returns the 3D lightweight system.
	 * 
	 * @return the 3D lightweightsystem or <code>null</code> if the lightweight
	 *         system is not 3D capable
	 */
	public LightweightSystem3D getLightweightSystem3D() {

		LightweightSystem lightweightSystem = getLightweightSystem();
		if (lightweightSystem instanceof LightweightSystem3D)
			return (LightweightSystem3D) lightweightSystem;

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.ui.parts.AbstractEditPartViewer#setContents(java.lang.Object)
	 */
	@Override
	public void setContents(Object i_contents) {

		try {
			super.setContents(i_contents);
		} catch (RuntimeException ex) {

			// Mac OS X Leopard issue:
			// dispose GLd3d canvas, otherwise Eclipse will crash
			GLCanvas canvas = (GLCanvas) getControl();
			// canvas.dispose();
			setControl(null);

			throw ex;

		}
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
