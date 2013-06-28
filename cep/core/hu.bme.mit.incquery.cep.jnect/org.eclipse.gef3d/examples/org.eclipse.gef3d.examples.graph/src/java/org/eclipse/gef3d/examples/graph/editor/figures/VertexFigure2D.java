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
package org.eclipse.gef3d.examples.graph.editor.figures;

import java.util.logging.Logger;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/**
 * VertexFigure2D There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 19.12.2007
 */
public class VertexFigure2D extends Figure {
	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(VertexFigure2D.class.getName());

	static int counter = 1;

	/**
	 * 
	 */
	public VertexFigure2D() {
		setBorder(new LineBorder());
		// this.setLayoutManager(new FlowLayout());
		this.setLayoutManager(new ToolbarLayout());
		Color c = Display.getCurrent().getSystemColor(SWT.COLOR_RED);
		this.setBackgroundColor(c);
		this.setOpaque(true);
		add(new Label("Node " + counter));
		// number = counter;
		counter++;
//		add(new Label("---------"));
//		add(new Label("+ someAttrib"));
//		add(new Label("---------"));
//		add(new Label("+ someOp()"));
	}

//	/** 
//	 * ONLY FOR DEBUGGING, CAN BE REMOVED
//	 * {@inheritDoc}
//	 * @see org.eclipse.draw2d.Figure#setBounds(org.eclipse.draw2d.geometry.Rectangle)
//	 */
//	@Override
//	public void setBounds(Rectangle i_rect) {
//		dumpListeners();
//		super.setBounds(i_rect);
//	}
//
//	/**
//	 * ONLY FOR DEBUGGING, CAN BE REMOVED
//	 */
//	private void dumpListeners() {
//		for (Iterator iter = getListeners(FigureListener.class); iter.hasNext(); ) {
//			Object obj = iter.next();
//			if (log.isLoggable(Level.INFO)) {
//				log.info("Figure Listener: " + obj); //$NON-NLS-1$
//			}
//		}
//	}

//	/** 
//	 * ONLY FOR DEBUGGING, CAN BE REMOVED
//	 * {@inheritDoc}
//	 * @see org.eclipse.draw2d.Figure#addFigureListener(org.eclipse.draw2d.FigureListener)
//	 */
//	@Override
//	public void addFigureListener(FigureListener i_listener) {
//		super.addFigureListener(i_listener);
//	}
	
	
	/** 
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + " label=" + ((Label)(getChildren().get(0))).getText();
	}
	

}
