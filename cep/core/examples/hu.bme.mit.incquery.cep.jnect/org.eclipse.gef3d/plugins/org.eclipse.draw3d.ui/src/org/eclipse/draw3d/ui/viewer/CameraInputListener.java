/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.ui.viewer;

import org.eclipse.draw3d.ui.camera.CameraInputHandler;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseWheelListener;

/**
 * Distributes input events to a {@link CameraInputHandler}.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 03.06.2009
 */
public class CameraInputListener implements KeyListener, MouseListener,
		MouseMoveListener, MouseWheelListener {

	private CameraInputHandler m_handler;

	/**
	 * Creates a new camera input listener that dispatches events to the given
	 * camera input handler.
	 * 
	 * @param i_handler
	 *            the handler
	 * 
	 * @throws NullPointerException
	 *             if the given handler is <code>null</code>
	 */
	public CameraInputListener(CameraInputHandler i_handler) {

		if (i_handler == null)
			throw new NullPointerException("i_handler must not be null");

		m_handler = i_handler;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.events.KeyListener#keyPressed(org.eclipse.swt.events.KeyEvent)
	 */
	public void keyPressed(KeyEvent i_event) {

		m_handler.keyDown(i_event);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.events.KeyListener#keyReleased(org.eclipse.swt.events.KeyEvent)
	 */
	public void keyReleased(KeyEvent i_event) {

		m_handler.keyUp(i_event);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.events.MouseListener#mouseDoubleClick(org.eclipse.swt.events.MouseEvent)
	 */
	public void mouseDoubleClick(MouseEvent i_e) {

		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.events.MouseListener#mouseDown(org.eclipse.swt.events.MouseEvent)
	 */
	public void mouseDown(MouseEvent i_event) {

		m_handler.buttonDown(i_event.button, i_event.stateMask, i_event.x,
				i_event.y);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.events.MouseMoveListener#mouseMove(org.eclipse.swt.events.MouseEvent)
	 */
	public void mouseMove(MouseEvent i_event) {

		m_handler.mouseMove(i_event.stateMask, i_event.x, i_event.y);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.events.MouseWheelListener#mouseScrolled(org.eclipse.swt.events.MouseEvent)
	 */
	public void mouseScrolled(MouseEvent i_mouseEvent) {

		m_handler.mouseWheelScrolled(i_mouseEvent.count);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.events.MouseListener#mouseUp(org.eclipse.swt.events.MouseEvent)
	 */
	public void mouseUp(MouseEvent i_event) {

		m_handler.buttonUp(i_event.button, i_event.stateMask, i_event.x,
				i_event.y);
	}
}
