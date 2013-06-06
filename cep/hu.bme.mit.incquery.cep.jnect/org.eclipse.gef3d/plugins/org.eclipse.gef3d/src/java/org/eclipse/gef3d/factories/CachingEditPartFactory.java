/*******************************************************************************
 * Copyright (c) 2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.factories;

import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

/**
 * A simple edit part factory wrapper that caches edit parts in a weak hash map.
 * This is useful for situations in which an edit part may be created twice for
 * a given model element.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 23.06.2010
 */
public class CachingEditPartFactory implements EditPartFactory {

	private Map<EditPart, Map<Object, EditPart>> m_cache =
		new WeakHashMap<EditPart, Map<Object, EditPart>>();

	private EditPartFactory m_delegate;

	/**
	 * Creates a new factory that wraps the given delegate factory.
	 * 
	 * @param i_delegate the delegate factory
	 * @throws NullPointerException if the given factory is <code>null</code>
	 */
	public CachingEditPartFactory(EditPartFactory i_delegate) {
		if (i_delegate == null)
			throw new NullPointerException("i_delegate must not be null");

		m_delegate = i_delegate;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart,
	 *      java.lang.Object)
	 */
	public EditPart createEditPart(EditPart i_context, Object i_model) {

		Map<Object, EditPart> contextCache = m_cache.get(i_context);
		if (contextCache == null) {
			contextCache = new WeakHashMap<Object, EditPart>();
			m_cache.put(i_context, contextCache);
		}

		EditPart part = contextCache.get(i_model);
		if (part != null)
			return part;

		part = m_delegate.createEditPart(i_context, i_model);
		if (part != null)
			contextCache.put(i_model, part);

		return part;
	}

}
