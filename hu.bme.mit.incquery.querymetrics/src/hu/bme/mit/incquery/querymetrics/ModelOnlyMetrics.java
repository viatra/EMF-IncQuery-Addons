/*******************************************************************************
 * Copyright (c) 2010-2013, Bergmann Gabor, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Bergmann Gabor - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.incquery.querymetrics;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.base.api.NavigationHelper;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * @author Bergmann Gabor
 *
 */
public class ModelOnlyMetrics {

	/**
	 * #triples = #model_elements = #nodes + #edges + #attribute-assignments 
	 * Analyses of RDF Triples in Sample Datasets (COLD 2012) 
	 */
	public static int calcCountTriples(IncQueryEngine engine) throws IncQueryException {
		return calcCountNodes(engine) + calcCountEdges(engine) + calcCountValueAssignments(engine);
	}

	/**
	 * #nodes
	 * Analyses of RDF Triples in Sample Datasets (COLD 2012) 
	 */
	public static int calcCountNodes(IncQueryEngine engine)
			throws IncQueryException {
		final Collection<EObject> eObjects = getAllEObjects(engine);
		return eObjects.size();
	}

	/**
	 * #edges
	 * Analyses of RDF Triples in Sample Datasets (COLD 2012) 
	 */
	public static int calcCountEdges(IncQueryEngine engine) throws IncQueryException {
		final Collection<EObject> eObjects = getAllEObjects(engine);
		
		int countTriples = 0;
		for (EObject eObject : eObjects) {
			countTriples += countOutDegree(eObject, EdgeType.E_REFERENCE);
		}
		return countTriples;
	}
	/**
	 * #attribute-assignments
	 * Analyses of RDF Triples in Sample Datasets (COLD 2012) 
	 */
	public static int calcCountValueAssignments(IncQueryEngine engine) throws IncQueryException {
		final Collection<EObject> eObjects = getAllEObjects(engine);
		
		int countTriples = 0;
		for (EObject eObject : eObjects) {
			countTriples += countOutDegree(eObject, EdgeType.E_ATTRIBUTE);
		}
		return countTriples;
	}
	private static Collection<EObject> getAllEObjects(IncQueryEngine engine)
			throws IncQueryException {
		final NavigationHelper baseIndex = engine.getBaseIndex();
		
		final EClass eObject = EcorePackage.eINSTANCE.getEObject();
		if (!baseIndex.isInWildcardMode()) 
			baseIndex.registerEClasses(Collections.singleton(eObject));
		final Collection<EObject> eObjects = baseIndex.getAllInstances(eObject);
		
		return eObjects;
	}


	/**
	 * #node-types
	 * Apples and Oranges 
	 */
	public static int calcCountTypes(IncQueryEngine engine) throws IncQueryException {
		return getAllUsedEClasses(engine).size();
	}
	private static Set<EClass> getAllUsedEClasses(IncQueryEngine engine) throws IncQueryException {
		Set<EClass> allEClasses = new HashSet<EClass>();
		final Collection<EObject> allEObjects = getAllEObjects(engine);
		for (EObject eObject : allEObjects) {
			allEClasses.add(eObject.eClass());
		}
		return allEClasses;
	}
	

	public static enum EdgeType {E_REFERENCE, E_ATTRIBUTE, E_STRUCTURAL_FEATURE}
	/**
	 * kifok
	 */
	public static int countOutDegree(EObject eObject, EdgeType edgeType) {
		final EClass eClass = eObject.eClass();
		switch (edgeType) {
		case E_ATTRIBUTE:
			return countFeatureInstances(eObject, eClass.getEAllAttributes());
		case E_REFERENCE:
			return countFeatureInstances(eObject, eClass.getEAllReferences());
		case E_STRUCTURAL_FEATURE:
			return countFeatureInstances(eObject, eClass.getEAllStructuralFeatures());
		default:
			throw new IllegalArgumentException();			
		}
	}
	private static int countFeatureInstances(EObject eObject, final List<? extends EStructuralFeature> features) {
		int countTriples = 0;
		for (EStructuralFeature feature : features) {
			final Object value = eObject.eGet(feature);
			if (feature.isMany()) {
				countTriples += ((Collection)value).size();
			} else {
				if (value!= null) countTriples++;
			}
				
		}
		return countTriples;
	}
	
	/**
	 * befok
	 */
	public static int countInDegree(IncQueryEngine engine, Object value) throws IncQueryException {
		final NavigationHelper baseIndex = engine.getBaseIndex();
		if (!baseIndex.isInWildcardMode()) throw new IllegalStateException("works only in wildcard mode");

		int result = 0;
		if (value instanceof EObject) {
			result += baseIndex.getInverseReferences((EObject)value).size();
		} else {
			result += baseIndex.findByAttributeValue(value).size();
		}
		return result;
	}
	
	/**
	 * ~In-degree, out-degree distribution
	 * Analyses of RDF Triples in Sample Datasets (COLD 2012) 
	 */
	public static int calcMaxEReferenceDegree(IncQueryEngine engine, boolean inDegree) throws IncQueryException {
		int maxDegree = Integer.MIN_VALUE;
		final Collection<EObject> allEObjects = getAllEObjects(engine);
		for (EObject eObject : allEObjects) {
			int degree = inDegree ? countInDegree(engine, eObject) : countOutDegree(eObject, EdgeType.E_REFERENCE);
			if (degree > maxDegree) maxDegree = degree;
		}
		return maxDegree;
	}

	/**
	 * ~In-degree, out-degree distribution
	 * Analyses of RDF Triples in Sample Datasets (COLD 2012) 
	 */
	public static double calcAverageEReferenceDegree(IncQueryEngine engine, boolean inDegree) throws IncQueryException {
		int sumDegree = 0;
		final Collection<EObject> allEObjects = getAllEObjects(engine);
		for (EObject eObject : allEObjects) {
			int degree = inDegree ? countInDegree(engine, eObject) : countOutDegree(eObject, EdgeType.E_REFERENCE);
			sumDegree += degree;
		}
		return sumDegree/((double)allEObjects.size());
	}

	
	
}
