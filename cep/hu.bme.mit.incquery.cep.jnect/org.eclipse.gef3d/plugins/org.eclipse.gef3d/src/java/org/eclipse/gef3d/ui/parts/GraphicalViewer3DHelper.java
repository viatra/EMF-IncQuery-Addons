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
package org.eclipse.gef3d.ui.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.ExclusionSearch;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw3d.Draw3DCanvas;
import org.eclipse.draw3d.IFigure3D;
import org.eclipse.draw3d.ISurface;
import org.eclipse.draw3d.LightweightSystem3D;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.picking.Hit;
import org.eclipse.draw3d.picking.Picker;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.EditPartViewer.Conditional;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gef3d.SurfaceSearch;
import org.eclipse.swt.SWT;
import org.eclipse.swt.opengl.GLCanvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Helper class implementing methods used by different {@link GraphicalViewer3D}
 * implementations, such as {@link GraphicalViewer3DImpl}.
 * <p>
 * The helper can be used by different implementations which are not necessarily
 * derived from {@link GraphicalViewer3DImpl}, such as 3D versions of GMF
 * viewers. The following methods should be called by host:
 * <ul>
 * <li>{@link #createControl3D(Composite, LightweightSystem3D)}</li>
 * <li>{@link #createLightweightSystem()}</li>
 * <li>{@link #findHandleAt(Point)}</li>
 * <li>{@link #findObjectAtExcluding(Point, Collection, Conditional)}</li>
 * </ul>
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Aug 5, 2009
 */
public class GraphicalViewer3DHelper {

	class ConditionalTreeSearch extends ExclusionSearch {

		final Conditional condition;

		ConditionalTreeSearch(Collection coll, Conditional condition) {
			super(coll);
			this.condition = condition;
		}

		@Override
		public boolean accept(IFigure i_figure) {

			IFigure current = i_figure;
			EditPart editpart = null;
			while (editpart == null && current != null) {
				editpart = (EditPart) viewer.getVisualPartMap().get(current);
				current = current.getParent();
			}

			return editpart != null
				&& (condition == null || condition.evaluate(editpart));
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder result = new StringBuilder("ConditionalTreeSearch [");
			result.append("condition: ").append(String.valueOf(condition));
			result.append("]");
			return result.toString();
		}

	}

	/**
	 * The viewer which uses this helper.
	 */
	protected GraphicalViewer3D viewer;

	/**
	 * Creates this helper, the given parameter is the host of this helper.
	 * 
	 * @param viewer3D the viewer which uses this helper, must not be null
	 */
	public GraphicalViewer3DHelper(GraphicalViewer3D viewer3D) {
		super();

		if (viewer3D == null) // parameter precondition
			throw new NullPointerException("viewer3D must not be null");

		this.viewer = viewer3D;
	}

	/**
	 * Delegated method, called by host's method
	 * {@link GraphicalViewer3DImpl#findHandleAt(Point)}.
	 * <p>
	 * This method was copied and subsequently modified.
	 * </p>
	 * 
	 * @author hudsonr (original implementation)
	 * @author Kristian Duske
	 * @see org.eclipse.gef.ui.parts.GraphicalViewerImpl#findHandleAt(org.eclipse.draw2d.geometry.Point)
	 */
	public Handle findHandleAt(Point i_sLocation) {

		LayerManager layermanager =
			(LayerManager) viewer.getEditPartRegistry().get(LayerManager.ID);

		if (layermanager == null)
			return null;

		Vector3f point = Draw3DCache.getVector3f();
		try {
			List<IFigure> ignore = new ArrayList<IFigure>(3);
			ignore.add(layermanager.getLayer(LayerConstants.PRIMARY_LAYER));
			ignore.add(layermanager.getLayer(LayerConstants.CONNECTION_LAYER));
			ignore.add(layermanager.getLayer(LayerConstants.FEEDBACK_LAYER));
			TreeSearch search = new ExclusionSearch(ignore);

			LightweightSystem3D lws = viewer.getLightweightSystem3D();
			Picker picker = lws.getPicker();

			ISurface surface = picker.getCurrentSurface();
			surface.getWorldLocation(i_sLocation, point);

			Hit hit = picker.getHit(point, search);
			if (hit == null)
				return null;

			IFigure3D figure3D = hit.getFigure3D();
			if (figure3D instanceof Handle)
				return (Handle) figure3D;

			// there are only 3D handles
			return null;
		} finally {
			Draw3DCache.returnVector3f(point);
		}
	}

	/**
	 * Delegated method, called by host's method
	 * {@link GraphicalViewer3DImpl#findObjectAtExcluding(Point, Collection, Conditional)}
	 * .
	 * <p>
	 * This method was copied and subsequently modified.
	 * </p>
	 * 
	 * @author hudsonr (original implementation)
	 * @author Kristian Duske
	 * @see org.eclipse.gef.ui.parts.GraphicalViewerImpl#findObjectAtExcluding(org.eclipse.draw2d.geometry.Point,
	 *      java.util.Collection, org.eclipse.gef.EditPartViewer.Conditional)
	 */
	@SuppressWarnings("unchecked")
	public EditPart findObjectAtExcluding(Point i_sLocation,
		Collection i_exclude, final Conditional i_condition) {

		Vector3f point = Draw3DCache.getVector3f();
		Point figureSLocation = Draw3DCache.getPoint();
		try {

			LightweightSystem3D lws = viewer.getLightweightSystem3D();
			Picker picker = lws.getPicker();

			ISurface surface = picker.getCurrentSurface();
			surface.getWorldLocation(i_sLocation, point);

			TreeSearch search =
				new ConditionalTreeSearch(i_exclude, i_condition);
			Hit hit = picker.getHit(point, search);

			EditPart part = null;
			if (hit != null) {
				IFigure figure = hit.getSearchResult();

				while (part == null && figure != null) {
					part = (EditPart) viewer.getVisualPartMap().get(figure);
					figure = figure.getParent();
				}
			}

			if (part == null)
				return viewer.getContents();

			return part;
		} finally {
			Draw3DCache.returnVector3f(point);
			Draw3DCache.returnPoint(figureSLocation);
		}
	}

	/**
	 * Delegated method, called by host's method
	 * {@link org.eclipse.gef.ui.parts.GraphicalViewerImpl#createLightweightSystem()}
	 * . Here, a {@link LightweightSystem3D} is created.
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalViewerImpl#createLightweightSystem()
	 */
	public LightweightSystem createLightweightSystem() {

		LightweightSystem3D lws3D = new LightweightSystem3D();
		lws3D.getPicker().setSurfaceSearch(new SurfaceSearch(viewer));

		return lws3D;
	}

	/**
	 * Delegated method, called by host's method
	 * {@link GraphicalViewer3D#createControl3D(Composite)} Creates a GLCanvas.
	 * Here, a {@link GLCanvas} is created (with double buffer). The viewer
	 * itself doesn't do much, but it's a container for all that other things:
	 * <ul>
	 * <li>The lightweight system manages the drawing process (and its root
	 * figure can display a coordinate system)</li>
	 * <li>The root edit part and its figure manage the layers</li>
	 * </ul>
	 * Internal Note: Fixed depth buffer problem on Mac OS X, thanks to Nicolas
	 * Richeton
	 * 
	 * @see "http://nricheton.homeip.net/?p=53"
	 * @see org.eclipse.gef3d.ui.parts.GraphicalViewer3D#createControl3D(org.eclipse.swt.widgets.Composite)
	 */
	public Control createControl3D(Composite i_composite,
		LightweightSystem3D lightweightSystem3D) {

		final GLCanvas canvas =
			Draw3DCanvas.createCanvas(i_composite, SWT.NONE,
				lightweightSystem3D);

		viewer.setControl(canvas);
		return viewer.getControl();
	}

}
