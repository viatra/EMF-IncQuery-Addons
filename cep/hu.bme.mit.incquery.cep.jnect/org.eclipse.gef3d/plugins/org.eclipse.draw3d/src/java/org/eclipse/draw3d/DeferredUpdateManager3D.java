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
package org.eclipse.draw3d;

import java.util.logging.Logger;

import org.eclipse.draw2d.DeferredUpdateManager;
import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.opengl.GLCanvas;

/**
 * Calls the figures render method.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 08.11.2007
 */
public class DeferredUpdateManager3D extends DeferredUpdateManager {

	private static Logger log =
		Logger.getLogger(DeferredUpdateManager3D.class.getName());

	/**
	 * Reference to canvas (created by GraphicalViewer3D) and passed via
	 * LightweightSystem3D, required here for swapping buffers.
	 */
	protected GLCanvas canvas;

	/**
	 * This is actually the original root figure, but we need to hold a
	 * reference here too since super class defines it private and provides no
	 * getter.
	 */
	protected IFigure3D root3D;

	public void dumpTree(IFigure fig, StringBuffer o_out, String level) {
		o_out.append("\n").append(level).append("+" + fig);
		String indentLevel = level + "  ";
		for (int i = 0; i < fig.getChildren().size(); i++) {
			dumpTree((IFigure) fig.getChildren().get(i), o_out, indentLevel);
		}
	}

	/**
	 * @return the canvas
	 */
	public GLCanvas getCanvas() {
		return canvas;
	}

	/**
	 * {@inheritDoc} Draw regions are ignored here. If |{@link #isSwapBuffers()}
	 * is true, buffers are swapped.
	 * 
	 * @see org.eclipse.draw2d.DeferredUpdateManager#repairDamage()
	 */
	@Override
	protected void repairDamage() {
		if (root3D != null && canvas != null) {

			// if (log.isLoggable(Level.INFO)) {
			// StringBuffer strb = new StringBuffer("Figures: ");
			// dumpTree(root3D, strb, "");
			// log.info(strb.toString()); //$NON-NLS-1$
			// }

			// in 3D, we render everything anyway
			root3D.paint(null);
			repairDamageFinish();

		} else {

			if (root3D == null && canvas == null)
				log
					.warning("repairDamage called, but root figure and canvas are null");
			else if (root3D == null) {
				log.warning("repairDamage called, but root figure is null");
			} else {
				log
					.warning("repairDamage called, but canvas is null. Hint: call LightweightSystem.setControl(..)");
			}
		}

	}

	/**
	 * Called after repair damage is done. Here, buffers are swapped. Override
	 * this method if buffers or other things have to be read after rendering.
	 * (Reading buffers is extremly expensive)
	 */
	protected void repairDamageFinish() {

		if (canvas.isDisposed())
			return;

		canvas.swapBuffers();
	}

	/**
	 * @param i_canvas the canvas to set
	 */
	public void setCanvas(GLCanvas i_canvas) {
		canvas = i_canvas;
	}

	/**
	 * {@inheritDoc}.
	 * 
	 * @see org.eclipse.draw2d.DeferredUpdateManager#setRoot(org.eclipse.draw2d.IFigure)
	 */
	@Override
	public void setRoot(IFigure i_figure) {
		root3D = (IFigure3D) i_figure;
		super.setRoot(i_figure);
	}

	// /**
	// * {@inheritDoc}
	// *
	// * @see
	// org.eclipse.draw2d.DeferredUpdateManager#addDirtyRegion(org.eclipse.draw2d.IFigure,
	// * int, int, int, int)
	// */
	// @Override
	// public synchronized void addDirtyRegion(IFigure i_figure, int i_x, int
	// i_y,
	// int i_w, int i_h) {
	//
	// if (log.isLoggable(Level.INFO)) {
	// log.info("addDirtyRegion(" + i_figure + ", " + i_x + ", " + i_y
	// + ", " + i_w + ", " + i_h + ")");
	// }
	//
	// super.addDirtyRegion(i_figure, i_x, i_y, i_w, i_h);
	// }
	//
	// /**
	// * {@inheritDoc}
	// *
	// * @see
	// org.eclipse.draw2d.DeferredUpdateManager#addInvalidFigure(org.eclipse.draw2d.IFigure)
	// */
	// @Override
	// public synchronized void addInvalidFigure(IFigure i_f) {
	//		
	//
	// if (log.isLoggable(Level.INFO)) {
	//			log.info("addInvalidFigure("+ i_f+")"); //$NON-NLS-1$
	// }
	//		
	// super.addInvalidFigure(i_f);
	// }
	//
}
