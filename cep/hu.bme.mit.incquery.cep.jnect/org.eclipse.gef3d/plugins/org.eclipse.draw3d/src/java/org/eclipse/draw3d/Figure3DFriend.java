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

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

/**
 * Abstract class used by Figure3DHelper and implemented by Figure3D (and other
 * IFigure3D implementations). For more information, see Figure3DHelper.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 21.11.2007
 * @see Figure3DHelper
 */
public abstract class Figure3DFriend {
	/**
	 * Logger for this class
	 */
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(Figure3DFriend.class
			.getName());

	/**
	 * The associated figure.
	 */
	public final IFigure3D figure;

	/**
	 * Creates a new instance that is associated with the given figure.
	 * 
	 * @param i_figure the associated figure
	 */
	public Figure3DFriend(IFigure3D i_figure) {

		figure = i_figure;
	}

	/**
	 * Returns the figure's local background color.
	 * 
	 * @return the figure's local background color
	 */
	public final Color getLocalBackgroundColor() {

		return figure.getLocalBackgroundColor();
	}

	/**
	 * Returns the figure's local font.
	 * 
	 * @return the figure's local font
	 */
	public abstract Font getLocalFont();

	/**
	 * Returns the figure's local foreground color.
	 * 
	 * @return the figure's local foreground color
	 */
	public final Color getLocalForegroundColor() {

		return figure.getLocalForegroundColor();
	}

	/**
	 * Indicates whether the 2D content of the figure should be repainted (e.g.
	 * whether it is dirty or not).<br /> <br/>Be aware that this is not equal
	 * to the 2D children being invalid, because under certain circumstances,
	 * the 2D content of a 3D figure is not the graphical representation of its
	 * 2D children. For example, a 3D figure might choose to display a textual
	 * description instead to reduce render time.
	 * 
	 * @return <code>true</code> if the 2D content is dirty or
	 *         <code>false</code> otherwise
	 */
	public abstract boolean is2DContentDirty();

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		StringBuilder strb = new StringBuilder("Dispatcher for ");
		strb.append(figure.toString());
		return strb.toString();
	}

}
