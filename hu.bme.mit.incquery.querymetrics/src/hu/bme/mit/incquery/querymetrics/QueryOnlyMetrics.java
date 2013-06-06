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

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.patternlanguage.patternLanguage.CheckConstraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionConstraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint;

/**
 * @author Bergmann Gabor
 *
 */
public class QueryOnlyMetrics {
	/**
	 * nested NAC depth
	 */
	public static int nestedNacDepth(Pattern pattern) {
		int result = 0;
		final EList<PatternBody> bodies = pattern.getBodies();
		for (PatternBody body : bodies) {
			final EList<Constraint> constraints = body.getConstraints();
			for (Constraint constraint : constraints) {
				if (constraint instanceof PatternCompositionConstraint) {
					final PatternCompositionConstraint compo = (PatternCompositionConstraint) constraint;
					final PatternCall call = compo.getCall();
					final Pattern patternRef = call.getPatternRef();
					
					final int auxResult = nestedNacDepth(patternRef) + (compo.isNegative() ? 1 : 0);
					if (auxResult > result) result = auxResult;
				}
			}
		}
		return result;
	}
	
	/**
	 * Number of: ...
	 */
	public static int numberOfParameters(Pattern pattern) {
		return pattern.getParameters().size();
	}
	
	/**
	 * Number of: ...
	 */
	public static Map<PatternBody,Integer> numberOfLocalVariables(Pattern pattern) {
		Map<PatternBody, Integer> results = new HashMap<PatternBody, Integer>(); 
		final EList<PatternBody> bodies = pattern.getBodies();
		for (PatternBody patternBody : bodies) {
			results.put(patternBody, patternBody.getVariables().size());
		}
		return results;
	}	
	
	/**
	 * Number of: ...
	 */
	public static Map<PatternBody,Integer> numberOfAttributeChecks(Pattern pattern) {
		Map<PatternBody, Integer> results = new HashMap<PatternBody, Integer>(); 
		final EList<PatternBody> bodies = pattern.getBodies();
		for (PatternBody patternBody : bodies) {
			int count = 0;
			final EList<Constraint> constraints = patternBody.getConstraints();
			for (Constraint constraint : constraints) {
				if (constraint instanceof CheckConstraint)
					count++;
			}
			results.put(patternBody, count);
		}
		return results;
	}	
	
//	/**
//	 * Number of: ...
//	 */
//	public static Map<PatternBody,Integer> numberOfEnumerableConstraints(Pattern pattern) {
//		Map<PatternBody, Integer> results = new HashMap<PatternBody, Integer>(); 
//		final EList<PatternBody> bodies = pattern.getBodies();
//		for (PatternBody patternBody : bodies) {
//			int count = 0;
//			final EList<Constraint> constraints = patternBody.getConstraints();
//			for (Constraint constraint : constraints) {
//				if (constraint instanceof EClassifierConstraint ||
//						constraint instanceof PathExpressionConstraint ||
//						constraint instanceof PatternCompositionConstraint)
//					count++;
//			}
//			results.put(patternBody, count);
//		}
//		return results;
//	}	
	
	/**
	 * Number of: ...
	 */
	public static Map<PatternBody,Integer> numberOfEdgeConstraints(Pattern pattern) {
		Map<PatternBody, Integer> results = new HashMap<PatternBody, Integer>(); 
		final EList<PatternBody> bodies = pattern.getBodies();
		for (PatternBody patternBody : bodies) {
			int count = 0;
			final EList<Constraint> constraints = patternBody.getConstraints();
			for (Constraint constraint : constraints) {
				if (constraint instanceof PathExpressionConstraint)
					count++;
			}
			results.put(patternBody, count);
		}
		return results;
	}	
	
	public static Set<Pattern> withAllDependencies(Set<Pattern> userQueries) {
		Set<Pattern> result = new HashSet<Pattern>(userQueries);
		Queue<Pattern> todo = new ArrayDeque<Pattern>(userQueries);

		while(!todo.isEmpty()) {
			final Pattern pattern = todo.poll();
			final TreeIterator<EObject> eAllContents = pattern.eAllContents();
			while (eAllContents.hasNext()) {
				final EObject next = eAllContents.next();
				if (next instanceof PatternCall) {
					final Pattern called = ((PatternCall) next).getPatternRef();
					if (result.add(called)) 
						todo.add(called);
				}
			}
		}
		return result;
	}
}
