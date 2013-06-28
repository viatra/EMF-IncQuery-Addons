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
package org.eclipse.gef3d.ext.intermodel;

import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef3d.editparts.AbstractConnectionEditPart3D;
import org.eclipse.gef3d.ext.reverselookup.ReverseLookupManager;

/**
 * Edit part for unidirectional connections. In GEF, a connection is only drawn
 * if both, source and target node edit part, support the connection. This is a
 * problem especially in case of inter-diagram-connections, as these connections
 * are often drawn between embedded (formerly) 2D editors, and their edit parts
 * do not now anything about the inter-diagram-connections. This special
 * connection edit part solves that problem by retrieving the source, the target
 * or both edit parts from the model, using a reverse lookup.
 * <p>
 * Subclasses must implement the two abstract methods for retrieving the source
 * and or target model elements from the connection model. One of these methods
 * may return null, if this is the side for which the edit part is known.
 * </p>
 * <p>
 * This class can be used instead of using the connected element adapter
 * pattern.
 * </p>
 * <p>
 * In most cases, the source edit part will be set by the client and only the
 * target edit part is to be looked up. That is, usually this class is
 * initialized via {@link #UndirectConnectionEditPart3D(false, true)}, this is
 * equal to calling the empty constructor.
 * </p>
 * 
 * @todo reconnect not implemented yet!
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Sep 25, 2009
 */
public abstract class UndirectConnectionEditPart3D extends
		AbstractConnectionEditPart3D implements FigureListener {

	EditPart adaptedSourceEditPart;

	EditPart adaptedTargetEditPart;

	private Object lastSourceModel;

	private Object lastTargetModel;

	boolean lookupSource, lookupTarget;

	/**
	 * Creates this edit part, source edit part is expected to be set (and not
	 * looked up), while target edit part is looked up. Calling this constructor
	 * is equal to calling {@link
	 * UndirectConnectionEditPart3D#UndirectConnectionEditPart3D(false, true)}
	 */
	public UndirectConnectionEditPart3D() {
		this(false, true);
	}

	/**
	 * Creates this edit part, source and target edit part are looked up as
	 * configured by the given parameters.
	 * 
	 * @param i_lookupSource if true, source edit part is looked up based on its
	 *            model element, which is retrieved via
	 *            {@link #getSourceModel()}; otherwise the source edit part
	 *            needs to be set via {@link #setSource(EditPart)}
	 * @param i_lookupTarget if true, target edit part is looked up based on its
	 *            model element, which is retrieved via
	 *            {@link #getTargetModel()}; otherwise the target edit part
	 *            needs to be set via {@link #setTarget(EditPart)}
	 */
	public UndirectConnectionEditPart3D(boolean i_lookupSource,
			boolean i_lookupTarget) {
		lookupSource = i_lookupSource;
		lookupTarget = i_lookupTarget;
	}

	/**
	 * {@inheritDoc} Removes this edit part from the source and/or target
	 * figures.
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#deactivate()
	 */
	@Override
	public void deactivate() {
		super.deactivate();
		if (adaptedSourceEditPart != null
			&& adaptedSourceEditPart instanceof GraphicalEditPart) {
			((GraphicalEditPart) adaptedSourceEditPart).getFigure().removeFigureListener(
				this);
		}
		if (adaptedTargetEditPart != null
			&& adaptedTargetEditPart instanceof GraphicalEditPart) {
			((GraphicalEditPart) adaptedTargetEditPart).getFigure().removeFigureListener(
				this);
		}
	}

	private boolean equals(Object i_o1, Object i_o2) {

		if (i_o1 == i_o2)
			return true;

		if (i_o1 != null)
			return i_o1.equals(i_o2);

		return false;
	}

	/**
	 * Refresh the connection edit part visuals, i.e. its figure, if an observed
	 * figure, i.e. target or source figure, has been moved.
	 * 
	 * @see org.eclipse.draw2d.FigureListener#figureMoved(org.eclipse.draw2d.IFigure)
	 */
	public void figureMoved(IFigure i_source) {
		refreshVisuals();
	}

	/**
	 * Returns the reverse lookup manager, for details oin how to install this
	 * manager, see {@link ReverseLookupManager}.
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected ReverseLookupManager<EditPart> getReverseLookupManager() {

		// prevent NPE if the edit part is not yet fully initialized
		if (getParent() == null)
			return null;

		ReverseLookupManager<EditPart> reverseLookupManager =
			(ReverseLookupManager<EditPart>) getViewer().getProperty(
				ReverseLookupManager.RLM_ID);
		if (reverseLookupManager == null) {
			throw new NullPointerException(
				"ReverseLookupManager not found in viewer properies, "
					+ "check configuration");
		}
		return reverseLookupManager;
	}

	/**
	 * Get source edit part, tries to perform a reverse lookup in order to
	 * retrieve the edit part by its model if configured accordingly (see
	 * constructor for details). If source edit part is set, this method simply
	 * returns it as the original overridden method. Otherwise,
	 * {@link #getSourceModel()} is used to perform a reverse lookup for
	 * retrieving the source edit part. If the reverse lookup fails, an
	 * {@link IllegalStateException} is thrown.
	 * 
	 * @see org.eclipse.gef.editparts.AbstractConnectionEditPart#getTarget()
	 * @throws IllegalStateException if reverse lookup fails
	 */
	@Override
	public EditPart getSource() {
		EditPart part = super.getSource();
		if (part != null)
			return part;

		Object sourceModel = getSourceModel();
		if (!equals(sourceModel, lastSourceModel)
			|| (adaptedSourceEditPart == null && lookupSource)) {

			lastSourceModel = sourceModel;
			if (sourceModel == null) {
				return null;
			}

			ReverseLookupManager<EditPart> rlm = getReverseLookupManager();
			if (rlm == null)
				return null;

			adaptedSourceEditPart =
				rlm.findNotationByDomain(sourceModel);
			if (adaptedSourceEditPart == null) {
				throw new IllegalStateException("Source edit part for "
					+ sourceModel + " not found by reverse lookup, "
					+ "check reverse lookup configuration.");
			}
			if (adaptedSourceEditPart instanceof GraphicalEditPart)
				((GraphicalEditPart) adaptedSourceEditPart).getFigure().addFigureListener(
					this);

		}
		return adaptedSourceEditPart;

	}

	/**
	 * This method is to be overridden by subclasses. May return null if source
	 * edit part is known, as this method is only called in order to retrieve
	 * the edit part.
	 * 
	 * @return
	 */
	abstract public Object getSourceModel();

	/**
	 * Get target edit part, tries to perform a reverse lookup in order to
	 * retrieve the edit part by its model if configured accordingly (see
	 * constructor for details). If target edit part is set, this method simply
	 * returns it as the original overridden method. Otherwise,
	 * {@link #getTargetModel()} is used to perform a reverse lookup for
	 * retrieving the source edit part. If the reverse lookup fails, an
	 * {@link IllegalStateException} is thrown.
	 * 
	 * @see org.eclipse.gef.editparts.AbstractConnectionEditPart#getTarget()
	 * @throws IllegalStateException if reverse lookup fails
	 */
	@Override
	public EditPart getTarget() {
		EditPart part = super.getTarget();
		if (part != null)
			return part;

		Object targetModel = getTargetModel();
		if (!equals(targetModel, lastTargetModel)
			|| (adaptedTargetEditPart == null && lookupTarget)) {

			lastTargetModel = targetModel;
			if (targetModel == null) {
				return null;
			}

			ReverseLookupManager<EditPart> rlm = getReverseLookupManager();
			if (rlm == null)
				return null;

			adaptedTargetEditPart =
				rlm.findNotationByDomain(targetModel);
			if (adaptedTargetEditPart == null) {
				throw new IllegalStateException("Target edit part for "
					+ targetModel + " not found by reverse lookup, "
					+ "check reverse lookup configuration.");
			}
			if (adaptedTargetEditPart instanceof GraphicalEditPart)
				((GraphicalEditPart) adaptedTargetEditPart).getFigure().addFigureListener(
					this);

		}
		return adaptedTargetEditPart;

	}

	/**
	 * This method is to be overridden by subclasses May return null if target
	 * edit part is known, as this method is only called in order to retrieve
	 * the edit part.
	 * 
	 * @return
	 */
	abstract public Object getTargetModel();

	/**
	 * {@inheritDoc}
	 * <p>
	 * Calls super method and performs a refresh, if target and source edit part
	 * can be retrieved from the model by a reverse look up.
	 * </p>
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#setModel(java.lang.Object)
	 */
	@Override
	public void setModel(Object i_model) {
		super.setModel(i_model);
		if (getSource() != null && getTarget() != null) {
			refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Calls super method and performs a refresh, if target edit part can be
	 * retrieved from the model by a reverse look up.
	 * </p>
	 * 
	 * @see org.eclipse.gef.editparts.AbstractConnectionEditPart#setSource(org.eclipse.gef.EditPart)
	 */
	@Override
	public void setSource(EditPart i_editPart) {
		super.setSource(i_editPart);
		if (i_editPart != null && getTarget() != null) {
			refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Calls super method and performs a refresh, if source edit part can be
	 * retrieved from the model by a reverse look up.
	 * </p>
	 * 
	 * @see org.eclipse.gef.editparts.AbstractConnectionEditPart#setTarget(org.eclipse.gef.EditPart)
	 */
	@Override
	public void setTarget(EditPart i_editPart) {
		super.setTarget(i_editPart);
		if (i_editPart != null && getSource() != null) {
			refresh();
		}
	}
}
