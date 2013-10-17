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
package org.eclipse.gef3d.ext.reverselookup;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Logger;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.parts.GraphicalEditor;

/**
 * Manager for finding notation elements by given domain elements. This is a
 * general implementation of a reverse lookup, with parameterised notation type
 * (usually EditParts), and dynamically installable lookup strategies. A kind of
 * special solution of that problem is the map managed by the edit part viewer
 * {@link EditPartViewer#getEditPartRegistry()}, this special case is used as
 * the default lookup strategy.
 * <p>
 * Three lookup strategies are provided:
 * <ol>
 * <li>{@link EditPartRegistryLookupStrategy}, uses
 * {@link EditPartViewer#getEditPartRegistry()}</li>
 * <li>
 * <code>org.eclipse.gef3d.gmf.ext.reverselookup.GMFEditPartMapLookupStrategy</code>
 * (in plugin org.eclipse.gef3d.gmf) for GMF editors using GMF's notation model</li>
 * <li>{@link ModelPathFinderStrategy}, GEF3D's multi purpose reverse
 * lookup method</li>
 * </ol>
 * The first one, {@link EditPartRegistryLookupStrategy} is installed by default
 * if the lookup manager is lazily created in
 * {@link #getEditPartLookupManager(EditPartViewer)}.
 * </p>
 * <p>
 * Lookup strategies can be installed by priority, which defines the order in
 * which they are used for finding an edit part. The priority only defined the
 * order, in general all registered strategies are used as long as no matching
 * edit part has been found.
 * </p>
 * <p>
 * If you need to configure the {@link ReverseLookupManager}, you probably want
 * to do that in the editor, e.g., <br/>
 * <code><pre>
 * protected void initializeGraphicalViewer() {
 * 	...
 * 	super.initializeGraphicalViewer();
 * 	ReverseLookupManager<EditPart> rlm =
 * 		ReverseLookupManager.getEditPartLookupManager(getGraphicalViewer());
 * 		// EditPartRegistryLookupStrategy already installed with prio=0
 * 	// add GMF strategy:
 * 	if (getGraphicalViewer() instanceof IDiagramGraphicalViewer) {
 * 		rlm.addLookupStrategy(1, new GMFEditPartMapLookupStrategy(
 * 		(IDiagramGraphicalViewer) getGraphicalViewer()));
 * 	} else {
 * 		ModelPathFinderStrategy<EditPart> gef3DStrategy =
 * 			new ModelPathFinderStrategy<EditPart>(
 * 		getGraphicalViewer().getContents());
 * 		gef3DStrategy.addNotationAdapter(GMFEditPartNotationAdapter.INSTANCE);
 * 		// gef3DStrategy.addNotationAdapter(EditPartNotationAdapter.INSTANCE);
 * 		gef3DStrategy.addModelPathFinder(EObjectPathFinder.INSTANCE);
 * 		rlm.addLookupStrategy(1, gef3DStrategy);
 * 	}
 * }
 * </pre></code> <br/>
 * Later, an edit part can easily be retrieved in an {@link EditPart}
 * (independent of its editor and lookup strategy) via <code><pre>
 * ReverseLookupManager<EditPart> rlm = (ReverseLookupManager<EditPart>) getViewer().getProperty(
 * 				ReverseLookupManager.RLM_ID);
 * EditPart editPart = rlm.findNotationElementForDomainElement(modelElement);
 * </pre></code>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 23, 2009
 */
public class ReverseLookupManager<NotationType> {

	/**
	 * Key used for viewer properties.
	 */
	public final static String RLM_ID = "ReverseLookupManager<EditPart>";

	protected SortedMap<Integer, Set<ILookupStrategy<NotationType>>> lookupStrategies =
		new TreeMap<Integer, Set<ILookupStrategy<NotationType>>>();

	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(ReverseLookupManager.class.getName());

	/**
	 * Returns a {@link ReverseLookupManager} associated to a given edit part
	 * viewer ({@link EditPart#getViewer()},
	 * {@link GraphicalEditor#getGraphicalViewer()}). The instance is created
	 * lazily if it doesn't exists, an {@link EditPartRegistryLookupStrategy} is
	 * installed with priority 0.
	 * <p>
	 * The instance is set as a viewer's properties
	 * {@link EditPartViewer#setProperty(String, Object)} using {@link #RLM_ID}
	 * as a key.
	 * </p>
	 * 
	 * @param viewer the edit part viewer to which the instance is attached.
	 * @return
	 */
	public static ReverseLookupManager<EditPart> getEditPartLookupManager(
		EditPartViewer viewer) {
		ReverseLookupManager<EditPart> reverseLookupManager =
			(ReverseLookupManager<EditPart>) viewer.getProperty(RLM_ID);
		if (reverseLookupManager == null) {
			reverseLookupManager = new ReverseLookupManager<EditPart>();
			viewer.setProperty(RLM_ID, reverseLookupManager);
			reverseLookupManager.addLookupStrategy(0,
				new EditPartRegistryLookupStrategy(viewer));
		}
		return reverseLookupManager;
	}

	/**
	 * @param priority, must be greater or equal 0
	 * @param lookupStrategy
	 * @return true, if strategy was newly inserted, false, if strategy was
	 *         already registered and was only set to given priority
	 */
	public boolean addLookupStrategy(int priority,
		ILookupStrategy<NotationType> lookupStrategy) {
		if (priority < 0) // parameter precondition
			throw new IllegalArgumentException(
				"priority must be greater or equal 0, was  " + priority);

		// do not allow a strategy registered more then once.
		boolean bFound = removeLookupStrategy(lookupStrategy);

		Set<ILookupStrategy<NotationType>> strategies =
			lookupStrategies.get(-priority);
		if (strategies == null) {
			strategies = new LinkedHashSet<ILookupStrategy<NotationType>>();
			lookupStrategies.put(-priority, strategies);
		}

		strategies.add(lookupStrategy);
		return bFound;
	}

	/**
	 * Removes a strategy.
	 * 
	 * @param lookupStrategy
	 * @return true if strategy was removed, false if strategy was not found
	 */
	public boolean removeLookupStrategy(
		ILookupStrategy<NotationType> lookupStrategy) {
		boolean bFound = false;
		for (Set<ILookupStrategy<NotationType>> strategies : lookupStrategies
			.values()) {
			if (strategies.remove(lookupStrategy))
				bFound = true;
		}
		return bFound;
	}

	public void removeAllLookupStrategies() {
		lookupStrategies.clear();
	}

	/**
	 * Finds a notation element by its referenced domain element by using
	 * registered {@link ILookupStrategy} in the order of their priority.
	 * 
	 * @param domainElement domain element which is referenced
	 * @return notation element referencing given domainElement, or null if no
	 *         such element is found
	 */
	public NotationType findNotationByDomain(
		final Object domainElement) {
		NotationType notationType = null;
		for (Set<ILookupStrategy<NotationType>> strategies : lookupStrategies
			.values()) {

			// this set must be sorted individually for each domain element,
			// as handlesElement may return different values depending on the
			// element
			SortedSet<ILookupStrategy<NotationType>> sortedStrategies =
				new TreeSet<ILookupStrategy<NotationType>>(
					new Comparator<ILookupStrategy<NotationType>>() {

						/**
						 * ascending!
						 * 
						 * @param s1
						 * @param s2
						 * @return
						 */
						public int compare(ILookupStrategy<NotationType> s1,
							ILookupStrategy<NotationType> s2) {
							int h1 = s1.handlesElement(domainElement);
							int h2 = s2.handlesElement(domainElement);
							if (h1 < h2)
								return 1;
							return -1;

						}
					});
			sortedStrategies.addAll(strategies);

			for (ILookupStrategy<NotationType> strategy : sortedStrategies) {
				notationType =
					strategy.findNotationByDomain(domainElement);
				if (notationType != null)
					return notationType;
			}
		}
		return notationType;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder strb = new StringBuilder("ReverseLookupManager [");
		for (int prio : lookupStrategies.keySet()) {
			Set<ILookupStrategy<NotationType>> strategies =
				lookupStrategies.get(prio);
			strb.append("\n").append(-prio).append(": ");
			boolean first = true;
			for (ILookupStrategy<NotationType> strategy : strategies) {
				if (!first)
					strb.append(", ");
				else
					first = false;
				strb.append(strategy.toString());

			}
		}
		strb.append("]");
		return strb.toString();

	}
}
