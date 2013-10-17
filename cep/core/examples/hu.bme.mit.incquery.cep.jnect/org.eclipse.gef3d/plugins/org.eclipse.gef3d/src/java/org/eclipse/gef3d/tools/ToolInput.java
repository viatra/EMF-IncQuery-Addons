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
package org.eclipse.gef3d.tools;

/**
 * Allows tools to access the user input.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 24.06.2009
 */
public class ToolInput {

	private boolean m_verifyMouseButtons;

	/**
	 * Specifies whether the mouse buttons must be verified when new mouse input
	 * is received.
	 * 
	 * @param i_verifyMouseButtons
	 *            <code>true</code> indicates that the mouse buttons must be
	 *            verified
	 */
	public void setVerifyMouseButtons(boolean i_verifyMouseButtons) {

		m_verifyMouseButtons = i_verifyMouseButtons;
	}
}
