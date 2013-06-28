/*******************************************************************************
 * Copyright (c) 2011 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.commands;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.gef.commands.Command;

/**
 * Command changing the constraint of a figure used by some 
 * layout manager. This usually by-passes the edit part, thus the change
 * does not get propagated to the model.
 *
 * @author 	Jens von Pilgrim (developer@jevopi.de)
 * @version	$Revision$
 * @since 	Apr 24, 2011
 */
public class UpdateConstraintCommand extends Command {

	protected IFigure child;
	protected Object constraint;
	protected Object oldConstraint;
	protected LayoutManager layoutManager;
	/**
	 * @param i_child
	 * @param i_constraint
	 * @param i_layoutManager
	 */
	public UpdateConstraintCommand(IFigure i_child, Object i_constraint,
		LayoutManager i_layoutManager) {
		child = i_child;
		constraint = i_constraint;
		layoutManager = i_layoutManager;
		oldConstraint = null;
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		if (oldConstraint==null) {
			oldConstraint = layoutManager.getConstraint(child);
		}
		layoutManager.setConstraint(child, constraint);
		child.revalidate();
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		layoutManager.setConstraint(child, oldConstraint);
	}
	
}
