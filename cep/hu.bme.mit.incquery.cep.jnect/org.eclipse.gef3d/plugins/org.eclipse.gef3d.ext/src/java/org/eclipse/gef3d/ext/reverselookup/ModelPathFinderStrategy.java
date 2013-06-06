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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.gef.EditPartViewer;

/**
 * General lookup strategy in case no other strategy can be used. This strategy
 * makes the following assumption:
 * <ol>
 * <li>If a predecessor of a given domain element is linked to some notation
 * element, then the searched notation element is contained in the subtree of
 * the notation element.</li>
 * </ol>
 * The algorithm for finding a notation element by its referenced domain element
 * is a combination of a width- and depth-first tree search.
 * <p>
 * The idea of the algorithm for finding an notation element is as follows:
 * Instead of simply searching for a notation element referencing a domain
 * model, we try to find notation elements referencing an element of the path
 * which is defined from the domain model to its root (assuming the domain model
 * is organized as (containment) tree, somehow. As long as no notation element
 * is found which references an element of the domain model path, a width-first
 * search is performed on the notation model tree. But if a notation model
 * element is found, which references to an element in the domain model path,
 * then the search strategy is changed and a depth-first search on the children
 * of this notation model is performed, always searching for domain elements in
 * the domain model path. If this fails, the children of the firstly found
 * notation element are searched via width-first again.
 * </p>
 * <p>
 * The following figure illustrates the idea:
 * 
 * <pre>
 *    ___1____
 *   /  / \   \
 *  2   3  4-p 5 
 *  |   |  |   |
 *  .   .  6-p .
 * </pre>
 * 
 * The figure shows the notation tree, the "p"s repreent the domain model graph.
 * Nodes 2, 3, and 4 are traversed via width-first. In 4, the path is found, now
 * depth-first is used for finding 6 (i.e. 5 is not tested).
 * </p>
 * <p>
 * In order to retrieve the domain model path and notation model children and
 * their references domain model elements, {@link IModelPathFinder} and
 * {@link INotationAdapter} instances are used. These helpers are registers via
 * the {@link #addModelPathFinder(IModelPathFinder)} and
 * {@link #addNotationAdapter(INotationAdapter)}. If am object is handled by
 * several helpers, the helper with the highest matching result is used.
 * </p>
 * <p>
 * In order to use a reverse lookup manager for finding elements, at least one
 * {@link INotationAdapter} must be added, e.g. {@link EditPartNotationAdapter},
 * and the default notation root ({@link #setDefaultNotationRoot(Object)}) must
 * be set. For improving search speed, {@link IModelPathFinder} should be added.
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Sep 28, 2009
 */
public class ModelPathFinderStrategy<NotationType> implements
		ILookupStrategy<NotationType> {
	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(ModelPathFinderStrategy.class.getName());

	/**
	 * Set of model element path finders.
	 */
	protected Set<IModelPathFinder> modelElementPathFinders =
		new LinkedHashSet<IModelPathFinder>();

	/**
	 * Set of notation adapters.
	 */
	protected Set<ILookupHelper> notationAdapters =
		new LinkedHashSet<ILookupHelper>();

	/**
	 * The default root, used in
	 * {@link #findNotationByDomain(Object)}
	 */
	protected NotationType defaultNotationRoot;
	
	
	/**
	 * Creates this lookup strategy, the notation root is usually the content
	 * of the graphical viewer, i.e. {@link EditPartViewer#getContents()}.
	 * 
	 * 
	 * @param i_defaultNotationRoot, must not be null
	 */
	public ModelPathFinderStrategy(NotationType i_defaultNotationRoot) {
		if (i_defaultNotationRoot == null) // parameter precondition
			throw new NullPointerException("i_defaultNotationRoot must not be null");
		
		defaultNotationRoot = i_defaultNotationRoot;
	}
	

	/*--------------------------------------------------------------------------
	 * ILookupStrategy
	 * -----------------------------------------------------------------------*/

	

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef3d.ext.reverselookup.ILookupStrategy#findNotationByDomain(java.lang.Object)
	 */
	public NotationType findNotationByDomain(
		Object i_domainElement) {
		return findNotationElementForDomainElement(getDefaultNotationRoot(),
			i_domainElement);
	}

	/**
	 * Returns the maximum value of {@link #handlesElement(Object)} of registered
	 * {@link IModelPathFinder}s.
	 * 
	 * @see org.eclipse.gef3d.ext.reverselookup.ILookupHelper#handlesElement(java.lang.Object)
	 */
	public int handlesElement(Object i_modelElement) {
		int max = 0;
		int v;
		for (IModelPathFinder mpf: modelElementPathFinders) {
			v = mpf.handlesElement(i_modelElement);
			max = Math.max(max, v);
		}
		return max;
	}

	/*--------------------------------------------------------------------------
	 * Configuration
	 * -----------------------------------------------------------------------*/

	/**
	 * Adds a model path finder. Actually, no model path finder is required, in
	 * this case the calculated path only contains the searched element.
	 * 
	 * @param modelPathFinder, must not be null
	 */
	public void addModelPathFinder(IModelPathFinder modelPathFinder) {
		if (modelPathFinder == null) // parameter precondition
			throw new NullPointerException("modelPathFinder must not be null");

		modelElementPathFinders.add(modelPathFinder);
	}

	/**
	 * Adds a notation adapter, at least one notation adapter is required in
	 * order to make the lookup work.
	 * 
	 * @param notationAdpater, must not be null
	 */
	public void addNotationAdapter(
		INotationAdapter<NotationType> notationAdpater) {
		if (notationAdpater == null) // parameter precondition
			throw new NullPointerException("notationAdpater must not be null");

		notationAdapters.add(notationAdpater);
	}

	/**
	 * Returns the default root used in {@link #findNotationChildren(Object)}.
	 * 
	 * @return the defaultNotationRoot
	 */
	public NotationType getDefaultNotationRoot() {
		return defaultNotationRoot;
	}

	/*--------------------------------------------------------------------------
	 * Implementation
	 * -----------------------------------------------------------------------*/

	/**
	 * Finds a notation element by its referenced domain element. Note that the
	 * given notationRoot has not necessarily to be the real root of the
	 * notation tree, but may be the root of a subtree in order to optimize the
	 * search.
	 * 
	 * @param notationRoot the root of the notation element tree
	 * @param domainElement domainElement domain element which is referenced
	 * @return notation element referencing given domainElement, or null if no
	 *         such element is found
	 */
	public NotationType findNotationElementForDomainElement(
		NotationType notationRoot, Object domainElement) {
		if (notationRoot == null) {
			log.warning("No notation root specified, cannot start search."); //$NON-NLS-1$
			return null;
		}

		// create path
		List domainPath = findPath(domainElement);

		Queue<NotationType> queue = new LinkedList<NotationType>();
		queue.add(notationRoot);
		return findNotationElementWidthFirst(queue, domainPath);
	}

	/**
	 * First part of algorithm, performing a width-first search on the notation
	 * tree. This method calls itself recursively as long as no domain element
	 * of the path was found. In the latter case, the search strategy is
	 * switched to depth-first (
	 * {@link #findNotationChildrenDepthFirst(List, List)}.
	 * 
	 * @param notationElements the queued notation elements to be searched
	 * @param domainPath the domain path, the searched element must be at index
	 *            0
	 * @return notation element referencing given domainElement, or null if no
	 *         such element is found
	 */
	protected NotationType findNotationElementWidthFirst(
		Queue<NotationType> notationElements, List domainPath) {
		if (notationElements.isEmpty())
			return null;

		NotationType currentNotationElement = notationElements.poll();

		Object currentDomainElement = getDomainElement(currentNotationElement);
		int pathIndex =
			(currentDomainElement == null) ? -1 : domainPath
				.indexOf(currentDomainElement);
		if (pathIndex == 0) { // found
			return currentNotationElement;
		}

		List<NotationType> notationChildren =
			findNotationChildren(currentNotationElement);

		if (pathIndex > 0) { // in index, switch to depth first
			domainPath = domainPath.subList(0, pathIndex);
			return findNotationChildrenDepthFirst(notationChildren, domainPath);
		} else { // width-first search:
			notationElements.addAll(notationChildren);
			return findNotationElementWidthFirst(notationElements, domainPath);
		}

	}

	/**
	 * Searches the domain element using a depth-first search algorithm. If the
	 * domain element is not found this way, the search is continued with
	 * widht-first search.
	 * 
	 * @param notationChildren a list of notation elements which are depth-first
	 *            searched
	 * @param domainPath the domain path, the searched element must be at index
	 *            0
	 * @return notation element referencing given domainElement, or null if no
	 *         such element is found
	 */
	protected NotationType findNotationChildrenDepthFirst(
		List<NotationType> notationChildren, List domainPath) {

		for (NotationType currentNotationElement : notationChildren) {
			Object currentDomainElement =
				getDomainElement(currentNotationElement);
			int pathIndex = domainPath.indexOf(currentDomainElement);
			if (pathIndex == 0) {
				return currentNotationElement;
			} else if (pathIndex > 0) { // in index, proceed with depth first
				domainPath = domainPath.subList(0, pathIndex);
				notationChildren = findNotationChildren(currentNotationElement);
				return findNotationChildrenDepthFirst(notationChildren,
					domainPath);
			}
		}

		// uups, not found, let's switch to width-first search of this subtree
		Queue<NotationType> queue = new LinkedList<NotationType>();
		for (NotationType currentNotationElement : notationChildren) {
			queue.addAll(findNotationChildren(currentNotationElement));
		}
		return findNotationElementWidthFirst(queue, domainPath);
	}

	/**
	 * Finds the children of a notation element, for that registered
	 * {@link INotationAdapter} are used.
	 * 
	 * @param notationElement
	 * @return list of children, this list may be empty but never null
	 */
	protected List<NotationType> findNotationChildren(
		NotationType notationElement) {
		INotationAdapter<NotationType> notationAdapter =
			getNotationAdapter(notationElement);
		List<NotationType> notationChildren = null;
		if (notationAdapter != null) {
			notationChildren =
				notationAdapter.getNotationChildren(notationElement);
		}
		if (notationChildren == null)
			notationChildren = Collections.emptyList();

		return notationChildren;
	}

	/**
	 * Returns the domain element referenced by a given notatoin element, using
	 * {@link INotationAdapter}s. If no notation adapters are registered, this
	 * method returns null.
	 * 
	 * @param notationElement
	 * @return domain element referenced by given notation element, or null, if
	 *         no element is referenced
	 */
	protected Object getDomainElement(NotationType notationElement) {
		INotationAdapter<NotationType> notationAdapter =
			getNotationAdapter(notationElement);
		Object domainElement = null;
		if (notationAdapter != null) {
			domainElement = notationAdapter.getDomainObject(notationElement);
		}
		return domainElement;
	}

	/**
	 * Returns the path of given domain element (at path index 0) to its root in
	 * an assumed domain model tree. The path is calculated by registered
	 * {@link IModelPathFinder}s, if no such finders are registered, a path
	 * containing only the given element is returned.
	 * 
	 * @param domainElement
	 * @return returns the path, this path contains at least the given element
	 */
	protected List findPath(Object domainElement) {
		IModelPathFinder modelPathFinder =
			(IModelPathFinder) getBestMatchingHelper(modelElementPathFinders,
				domainElement);
		List path = null;
		if (modelPathFinder == null) {
			if (log.isLoggable(Level.INFO)) {
				log.info("No model path finder found for " + domainElement); //$NON-NLS-1$
			}
		} else {
			path = modelPathFinder.findPath(domainElement);
		}
		if (path == null) {
			path = new ArrayList(1);
			path.add(domainElement);
		}
		return path;
	}

	/**
	 * Internal helper method, returns notation adapter or null, if no adapter
	 * was found for given notation element type. If no adapter was found, a
	 * warning is logged.
	 * 
	 * @param notationElement
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected INotationAdapter<NotationType> getNotationAdapter(
		NotationType notationElement) {
		INotationAdapter<NotationType> notationAdapter =
			(INotationAdapter<NotationType>) getBestMatchingHelper(
				notationAdapters, notationElement);
		if (notationAdapter == null) {
			if (log.isLoggable(Level.INFO)) {
				log
					.info("No notation adapter found for  " + notationElement + ", registered helpers: " + notationAdapters); //$NON-NLS-1$
			}
		}
		return notationAdapter;
	}

	/**
	 * Internal helper method, returning best matching {@link ILookupHelper},
	 * i.e. {@link INotationAdapter} or {@link IModelPathFinder} for given
	 * element.
	 * 
	 * @param helpers
	 * @param obj
	 * @return
	 */
	protected ILookupHelper getBestMatchingHelper(Set<? extends ILookupHelper> helpers,
		Object obj) {
		int match = 0;
		int maxMatch = 0;
		ILookupHelper bestHelper = null;
		for (ILookupHelper helper : helpers) {
			match = helper.handlesElement(obj);
			if (match > maxMatch) {
				maxMatch = match;
				bestHelper = helper;
			}
		}
		return bestHelper;
	}

	/** 
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ModelPathFinderStrategy [defaultNotationRoot="
			+ defaultNotationRoot + ", modelElementPathFinders="
			+ modelElementPathFinders + ", notationAdapters="
			+ notationAdapters + "]";
	}
	
	

}
