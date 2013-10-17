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
package org.eclipse.gef3d.gmf.runtime.core.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gef3d.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer3D;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.ui.services.editor.IEditorProvider;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.ContributeToPaletteOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;

/**
 * Helper class indicating whether a provider should become active for a given
 * editor. Providers are always used globally, that is a provider registers and
 * then all GMF-based editors use this provider. The problem is that especially
 * GEF3D providers are only to be used in 3D environments, and even then it
 * might be possible that a given provider is not useful.
 * <p>
 * To overcome that problem, a provider acceptor can be attached to a viewer.
 * GEF3D providers ask the viewer whether it should become active or not. The
 * editor, represented by its viewer, can then accept or reject the provider. If
 * the editor cannot decide whether to use the provider, i.e. it is not
 * explicitly accepted or rejected, the editor can let the provider decide. In
 * order to help the provider by its decision, some meta information can be
 * provided by via this interface. Since the acceptor is also often required by
 * {@link IEditorProvider}, it is also registered as listener to a viewer's
 * content (in {@link DiagramGraphicalViewer3D#setContents(Object)}. A static
 * convencience method retrieves the provider acceptor from a given
 * {@link Diagram} or even a {@link IOperation}. For that reason, the acceptor
 * implements the {@link Adapter} interface.
 * </p>
 * <p>
 * Depending on the provider the provider rejects a request if no acceptor is
 * found. If a selctor is found, the provider firstly calls
 * {@link #acceptProvider(IProvider)}, and can then request further information
 * if this method returned {@link ACCEPTANCE#AUTO}.
 * </p>
 * Default implementation of {@link IProviderSelector}, an instance of this
 * class is usually attached to a {@link EditPartViewer} as a property and can
 * be retrieved via {@link EditPartViewer#getProperty(String)} using
 * {@link IProviderSelector#PROVIDER_ACCEPTOR_PROPERTY_KEY} as key.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 26, 2009
 * @see https://bugs.eclipse.org/278066
 */
public class ProviderAcceptor implements Adapter {

	public static class NullProviderAcceptor extends ProviderAcceptor {
		NullProviderAcceptor() {
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.gef3d.gmf.runtime.core.service.ProviderAcceptor#setProperty(java.lang.String,
		 *      java.lang.Object)
		 */
		@Override
		public Object setProperty(String i_key, Object i_value) {
			throw new UnsupportedOperationException(
				"Properties must not be set for NullProviderAcceptor");
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.gef3d.gmf.runtime.core.service.ProviderAcceptor#setTarget(org.eclipse.emf.common.notify.Notifier)
		 */
		@Override
		public void setTarget(Notifier i_newTarget) {
			throw new UnsupportedOperationException(
				"Notifier must not be set for NullProviderAcceptor");
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "NULL ProviderAcceptor";
		}

	}

	public final static NullProviderAcceptor NULLPROVIDERACCEPTOR =
		new NullProviderAcceptor();

	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(ProviderAcceptor.class.getName());

	public final static String PROVIDER_ACCEPTOR_PROPERTY_KEY =
		"org.eclipse.gef3d.gmf.runtime.core.service.ProviderAcceptor";

	/**
	 * Key for property indicating whether an editor is a GEF3D editor.
	 */
	public final static String IS_GEF3D = "IS_GEF3D";

	/**
	 * Key used to define a graphical editor a provider is restricted to.
	 */
	public final static String GRAPHICAL_EDITOR = "GRAPHICAL_EDITOR";

	public enum ACCEPTANCE {
		ACCEPT_PROVIDER, REJECT_PROVIDER, AUTO
	}

	/**
	 * Convenience method to be used in providers for GEF3D editors. This method
	 * returns true if if GEF3D providers are accepted.
	 * 
	 * @param provider
	 * @param operation
	 * @return
	 */
	public static boolean evaluate3DAcceptance(IProvider provider,
		IOperation operation) {
		ProviderAcceptor providerAcceptor =
			ProviderAcceptor.retrieveProviderAcceptor(operation);
		if (providerAcceptor == null) {
			throw new IllegalStateException(
				"Provider Acceptor must not be null when get by retrieve operation");
		}

		if (providerAcceptor == NULLPROVIDERACCEPTOR) {
			return false;
		}
		return providerAcceptor.isGEF3D();
	}

	/**
	 * Retrieves a provider acceptor from a given operation. Currently, a
	 * provider can be extracted from the following operation types:
	 * <ol>
	 * <li>{@link IEditPartOperation}, if the view has a diagram. In this case,
	 * the acceptor is assumed to be added to the diagram's adpaters.</li>
	 * <li>{@link CreateEditPoliciesOperation}, if the edit part of the
	 * operation is attached to a viewer. In this case, the acceptor is assumed
	 * to be contained as a viewer's property.</li>
	 * <li>{@link ContributeToPaletteOperation}, if editor is an instance of
	 * {@link IProviderAcceptorProvider}</li>
	 * <li>If the operation is an {@link IProviderAcceptorProvider} itsself,
	 * which rarely is the case</li>
	 * </ol>
	 * 
	 * @param op
	 * @return the provider acceptor retrieved from operation, or
	 *         {@link #NULLPROVIDERACCEPTOR}
	 */
	public static ProviderAcceptor retrieveProviderAcceptor(IOperation op) {

		ProviderAcceptor providerAcceptor = NULLPROVIDERACCEPTOR;

		if (op instanceof IProviderAcceptorProvider) {
			providerAcceptor =
				((IProviderAcceptorProvider) op).getProviderAcceptor();
		} else if (op instanceof IEditPartOperation) {
			View view = ((IEditPartOperation) op).getView();
			if (view != null)
				providerAcceptor = retrieveProviderAcceptor(view.getDiagram());
		} else if (op instanceof CreateEditPoliciesOperation) {
			EditPart part = ((CreateEditPoliciesOperation) op).getEditPart();
			if (part != null) {
				EditPartViewer viewer = part.getViewer();
				if (viewer instanceof IProviderAcceptorProvider) {
					providerAcceptor =
						((IProviderAcceptorProvider) viewer)
							.getProviderAcceptor();
				} else if (viewer != null) {
					providerAcceptor =
						(ProviderAcceptor) viewer
							.getProperty(PROVIDER_ACCEPTOR_PROPERTY_KEY);
				}
			}
		} else if (op instanceof ContributeToPaletteOperation) {
			IEditorPart editor =
				((ContributeToPaletteOperation) op).getEditor();
			if (editor instanceof IProviderAcceptorProvider) {
				providerAcceptor =
					((IProviderAcceptorProvider) editor).getProviderAcceptor();
			}
		}
		return (providerAcceptor != null) ? providerAcceptor
			: NULLPROVIDERACCEPTOR;
	}

	/**
	 * Returns the provider acceptor associated with the given diagram (hidden
	 * as an adapter in the diagrams adapter list), or null if no such provider
	 * acceptor was found.
	 * 
	 * @param diagram
	 * @return the provider acceptor retrieved from diagram, or
	 *         {@link #NULLPROVIDERACCEPTOR}
	 */
	public static ProviderAcceptor retrieveProviderAcceptor(Diagram diagram) {
		if (diagram != null) {
			for (Adapter adapter : diagram.eAdapters()) {
				if (adapter instanceof ProviderAcceptor) {
					return (ProviderAcceptor) adapter;
				}
			}
		}
		return NULLPROVIDERACCEPTOR;
	}

	/**
	 * Returns a provider acceptor associated with a given viewer, i.e. the
	 * acceptor is set as a property.
	 * 
	 * @param viewer
	 * @return the provider acceptor retrieved from viewer, or
	 *         {@link #NULLPROVIDERACCEPTOR}
	 */
	public static ProviderAcceptor retrieveProviderSelector(
		EditPartViewer viewer) {
		if (viewer != null) {
			Object obj = viewer.getProperty(PROVIDER_ACCEPTOR_PROPERTY_KEY);
			if (obj instanceof ProviderAcceptor) {
				return (ProviderAcceptor) obj;
			}
		}
		return NULLPROVIDERACCEPTOR;
	}

	Map<String, Object> properties;

	/**
	 * 
	 */
	public ProviderAcceptor() {
		properties = new TreeMap<String, Object>();

	}

	/**
	 * Convenience constructor, creates the acceptor and sets the GEF3D-property
	 * (see {@link #isGEF3D()}.
	 * 
	 * @param isGEF3D
	 */
	public ProviderAcceptor(boolean isGEF3D) {
		this();
		setProperty(IS_GEF3D, isGEF3D);
	}

	/**
	 * Returns {@link ACCEPTANCE#AUTO}, override this method if another
	 * behaviour is accepted.
	 * 
	 * @see org.eclipse.gef3d.gmf.runtime.core.service.IProviderSelector#acceptProvider(org.eclipse.gmf.runtime.common.core.service.IProvider)
	 */
	public ACCEPTANCE acceptProvider(IProvider i_provider) {
		return ACCEPTANCE.AUTO;
	}

	/**
	 * Returns the value referenced by a given key.
	 * 
	 * @see org.eclipse.gef3d.gmf.runtime.core.service.IProviderSelector#getProperty(java.lang.String)
	 */
	public Object getProperty(String i_key) {
		return properties.get(i_key);
	}

	/**
	 * Returns true if a property with given key is found, is boolean and is set
	 * to true.
	 * 
	 * @see org.eclipse.gef3d.gmf.runtime.core.service.IProviderSelector#is(java.lang.String)
	 */
	public boolean is(String i_key) {
		Object obj = getProperty(i_key);
		if (obj != null && obj instanceof Boolean) {
			return ((Boolean) obj).booleanValue();
		}
		return false;
	}

	/**
	 * Returns true if the editor is a GEF3D editor. This flag is often used and
	 * for that reason, a convenience method is used here. It should return the
	 * same result as is("GEF3D").
	 * 
	 * @see org.eclipse.gef3d.gmf.runtime.core.service.IProviderSelector#isGEF3D()
	 */
	public boolean isGEF3D() {
		return is(IS_GEF3D);
	}

	/**
	 * Sets the given property with the key, if the key was mapped previously to
	 * an object, the old object is returned.
	 * 
	 * @param i_key
	 * @param value
	 * @return
	 */
	public Object setProperty(String i_key, Object value) {
		return properties.put(i_key, value);
	}

	Notifier target;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.notify.Adapter#getTarget()
	 */
	public Notifier getTarget() {
		return target;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	public boolean isAdapterForType(Object i_type) {
		if (i_type == ProviderAcceptor.class)
			return true;
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void notifyChanged(Notification i_notification) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.notify.Adapter#setTarget(org.eclipse.emf.common.notify.Notifier)
	 */
	public void setTarget(Notifier i_newTarget) {
		target = i_newTarget;

	}

}
