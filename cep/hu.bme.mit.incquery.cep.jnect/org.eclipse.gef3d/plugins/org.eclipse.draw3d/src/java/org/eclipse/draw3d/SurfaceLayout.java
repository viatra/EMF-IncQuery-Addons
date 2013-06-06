/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthias Thiele - initial API and implementation
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw3d.geometry.IVector3f;
import org.eclipse.draw3d.geometry.Position3D;
import org.eclipse.draw3d.geometry.Vector3fImpl;

/**
 * This layout manager moves all 3D children of a 3D figure along the Z axis of
 * the parent so that they are on top of the figure's front face.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 03.03.2008
 */
public class SurfaceLayout extends XYLayout implements DelegatingLayoutManager {

	/**
	 * Constraints for the surface layout.
	 * 
	 * @author Kristian Duske
	 * @version $Revision$
	 * @since 28.04.2008
	 * @see $HeadURL$
	 */
	public static class SurfaceConstraint {
		/**
		 * Indicates whether the Z position of a figure should be corrected.
		 */
		public boolean doZCorrection = true;
	}

	/**
	 * Convenience method to set the layout delegate of a given figure. If the
	 * given figure has no layout manager set, a surface layout is created and
	 * the given delegate layout is set. If the given figure does indeed have a
	 * layout manager and it is an instance of {@link DelegatingLayoutManager},
	 * the delegate is set. If the given figure's layout manager is not an
	 * instance of {@link DelegatingLayoutManager}, nothing happens.
	 * 
	 * @param io_figure the figure whose layout delegate should be set
	 * @param i_delegate the delegate
	 * @return <code>true</code> if the given figure's delegate could be set
	 *         and <code>false</code> otherwise
	 * @throws NullPointerException if the given figure is <code>null</code>
	 */
	public static boolean setDelegate(IFigure3D io_figure,
			LayoutManager i_delegate) {

		if (io_figure == null)
			throw new NullPointerException("io_figure must not be null");

		LayoutManager layoutManager = io_figure.getLayoutManager();
		if (layoutManager == null) {

			if (i_delegate == null)
				return true;

			layoutManager = new SurfaceLayout();
			io_figure.setLayoutManager(layoutManager);
		}

		if (layoutManager instanceof DelegatingLayoutManager) {
			DelegatingLayoutManager delegatingLayout = (DelegatingLayoutManager) layoutManager;
			delegatingLayout.setDelegate(i_delegate);

			return true;
		}

		return false;
	}

	private Map<IFigure, SurfaceConstraint> m_constraints = new HashMap<IFigure, SurfaceConstraint>();

	private LayoutManager m_delegate;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.LayoutManager#getConstraint(org.eclipse.draw2d.IFigure)
	 */
	@Override
	public Object getConstraint(IFigure i_child) {

		if (m_delegate == null)
			return null;

		return m_delegate.getConstraint(i_child);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.DelegatingLayoutManager#getDelegate()
	 */
	public LayoutManager getDelegate() {

		return m_delegate;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.LayoutManager#getMinimumSize(org.eclipse.draw2d.IFigure,
	 *      int, int)
	 */
	@Override
	public Dimension getMinimumSize(IFigure i_container, int i_hint, int i_hint2) {

		if (m_delegate == null)
			return new Dimension(i_hint, i_hint2);

		return m_delegate.getMinimumSize(i_container, i_hint, i_hint2);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.LayoutManager#getPreferredSize(org.eclipse.draw2d.IFigure,
	 *      int, int)
	 */
	@Override
	public Dimension getPreferredSize(IFigure i_container, int i_hint,
			int i_hint2) {

		if (m_delegate == null)
			return new Dimension(i_hint, i_hint2);

		return m_delegate.getPreferredSize(i_container, i_hint, i_hint2);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.LayoutManager#invalidate()
	 */
	@Override
	public void invalidate() {

		if (m_delegate != null)
			m_delegate.invalidate();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.LayoutManager#layout(org.eclipse.draw2d.IFigure)
	 */
	@Override
	public void layout(IFigure i_container) {

		if (m_delegate != null)
			m_delegate.layout(i_container);

		if (i_container instanceof IFigure3D) {
			List<?> children = i_container.getChildren();
			for (Object child : children) {
				if (child instanceof IFigure3D) {

					SurfaceConstraint constraint = m_constraints.get(child);
					if (constraint != null && !constraint.doZCorrection)
						continue;

					IFigure3D child3D = (IFigure3D) child;
					Position3D position3d = child3D.getPosition3D();
					IVector3f childLocation = position3d.getLocation3D();

					float depth = position3d.getSize3D().getZ();

					Vector3fImpl newLocation = new Vector3fImpl(childLocation);
					newLocation.z = -1 * depth;

					position3d.setLocation3D(newLocation);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.LayoutManager#remove(org.eclipse.draw2d.IFigure)
	 */
	@Override
	public void remove(IFigure i_child) {

		if (m_delegate != null)
			m_delegate.remove(i_child);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.LayoutManager#setConstraint(org.eclipse.draw2d.IFigure,
	 *      java.lang.Object)
	 */
	@Override
	public void setConstraint(IFigure i_child, Object i_constraint) {

		if (i_constraint instanceof SurfaceConstraint) {
			SurfaceConstraint surfaceConstraint = (SurfaceConstraint) i_constraint;
			m_constraints.put(i_child, surfaceConstraint);
		} else if (m_delegate != null)
			m_delegate.setConstraint(i_child, i_constraint);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.DelegatingLayoutManager#setDelegate(LayoutManager)
	 */
	public void setDelegate(LayoutManager i_delegate) {

		m_delegate = i_delegate;
	}

}
