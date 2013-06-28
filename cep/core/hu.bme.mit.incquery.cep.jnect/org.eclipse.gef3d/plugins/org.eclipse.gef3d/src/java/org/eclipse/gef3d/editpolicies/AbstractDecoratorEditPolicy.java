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
package org.eclipse.gef3d.editpolicies;

import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;

/**
 * A base class for edit policies that decorate their children with satellite
 * edit policies.
 * <p>
 * This policy only decorates the children of its host. In order to recursively
 * decorate all edit parts in the tree (with the current host as root),
 * {@link #createChildEditPolicies(EditPart)} should return two edit policies:
 * one policy with the original new decorating functionality, and a second one,
 * which is an instance of the same class as the one adding the first decoration
 * (i.e. the concrete subclass of this class). This technique is used in
 * {@link Handles3DEditPolicy}.
 * </p>
 * 
 * @author Kristian Duske, Jens von Pilgrim
 * @version $Revision$
 * @since 07.09.2009
 */
public abstract class AbstractDecoratorEditPolicy extends AbstractEditPolicy {

	/**
	 * Listener attached to host in order to get notified when new children are
	 * added (or children removed), see {@link #activate()} and
	 * {@link #createChildListener()}.
	 */
	private EditPartListener m_listener;

	/**
	 * Creates the edit policies to decorate the given child edit part.
	 * 
	 * @param i_child the child edit part to decorate
	 * @return the edit policies to decorate the given child
	 */
	protected abstract EditPolicy[] createChildEditPolicies(EditPart i_child);

	/**
	 * Returns the role for the given decoration edit policy.
	 * 
	 * @param i_editPolicy the decoration edit policy
	 * @return the role for the given decoration edit policy
	 */
	protected abstract Object getRole(EditPolicy i_editPolicy);

	/**
	 * Decorates the children of this policies host and attaches a listener to
	 * this host in order to decorate newly added children later on.
	 * 
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#activate()
	 */
	@Override
	public void activate() {
		setListener(createChildListener());
		decorateChildren();
		super.activate();
	}

	/**
	 * Extends activate() to allow proper decoration of children.
	 * 
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#deactivate()
	 */
	@Override
	public void deactivate() {
		setListener(null);
		super.deactivate();
	}

	/**
	 * Decorates the children of this edit part. This method is called upon
	 * activation.
	 */
	protected void decorateChildren() {
		List children = getHost().getChildren();
		for (Iterator iterator = children.iterator(); iterator.hasNext();) {
			EditPart child = (EditPart) iterator.next();
			decorateChild(child);
		}
	}

	/**
	 * Decorates the given child with a new instance of this edit policy. This
	 * method is called by {@link #decorateChildren()}.
	 * 
	 * @param i_child the child onto which new policies are installed.
	 */
	protected void decorateChild(EditPart i_child) {

		EditPolicy[] policies = createChildEditPolicies(i_child);
		for (EditPolicy policy : policies) {
			Object role = getRole(policy);
			i_child.installEditPolicy(role, policy);
		}
	}

	/**
	 * Sets host and updates listener (i.e. remove from old, add to new host).
	 * 
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#setHost(org.eclipse.gef.EditPart)
	 */
	@Override
	public void setHost(EditPart i_host) {
		EditPart oldHost = i_host;
		super.setHost(i_host);
		if (oldHost != null && oldHost != getHost() && m_listener != null) {
			oldHost.removeEditPartListener(m_listener);
			if (getHost() != null) {
				getHost().addEditPartListener(m_listener);
			}
		}
	}

	/**
	 * Sets the edit part listener and registers the listener to the polcies
	 * host. The given listener is responsible for decorating any newly created
	 * children.
	 * 
	 * @param i_listener the listener to set
	 */
	protected void setListener(EditPartListener i_listener) {
		if (m_listener != null && getHost() != null)
			getHost().removeEditPartListener(m_listener);
		m_listener = i_listener;
		if (m_listener != null && getHost() != null)
			getHost().addEditPartListener(m_listener);
	}

	/**
	 * Returns the edit part listener.
	 * 
	 * @return the listener or null, if no listener has been created yet.
	 */
	protected EditPartListener getListener() {
		return m_listener;
	}

	/**
	 * Creates an edit part listener that decorates all newly added children.
	 * This method is called by {@link #activate()}.
	 * 
	 * @return the listener
	 */
	protected EditPartListener createChildListener() {

		return new EditPartListener.Stub() {
			@Override
			public void childAdded(EditPart i_child, int i_index) {
				decorateChild(i_child);
			}
		};
	}

}
