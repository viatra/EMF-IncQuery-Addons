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
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.ClassType;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EClassifierConstraint;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.ReferenceType;
import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.EntityType;
import org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionConstraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionHead;
import org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionTail;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.Type;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.base.api.NavigationHelper;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.MatcherFactoryRegistry;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * @author Bergmann Gabor
 *
 */
public class QueryOnModelMetrics {
	
	public static int calcCountMatches(Pattern patt, IncQueryEngine engine) throws IncQueryException {
		return MatcherFactoryRegistry.getOrCreateMatcherFactory(patt).getMatcher(engine).countMatches();
	}
	
	/**
	 * query selectivity: találatok száma / összes triple száma
	 *  SPLODGE: Systematic Generation of SPARQL Benchmark Queries for Linked Open Data 
	 */
	public static double calcSplodgeSelectivityMetric(Pattern patt, IncQueryEngine engine) throws IncQueryException {
		final int countMatches = calcCountMatches(patt, engine);
		int countTriples = ModelOnlyMetrics.calcCountTriples(engine);

		return countMatches / (countTriples + 1.0);
	}


	/**
	 * saját query difficulty: ln(PROD<minden_felsorolható_constraintre>(#illeszkedések) / #minta_illeszkedések)
     * korrekció: #illeszkedések + 1 mindenhol 
     * nevező csak akkor szerepel, ha relative == true
	 * diszjunktív minta relative esetben tiltott, egyébként max body számít
	 * TODO filterRedundants minta + inference
	 */
	public static double calcGabenMetricWithAllDependencies(Set<Pattern> userQueries, IncQueryEngine engine, boolean relative, boolean filterRedundants) throws IncQueryException {
		double acc = 0.0;
		final Set<Pattern> withAllDependencies = QueryOnlyMetrics.withAllDependencies(userQueries);
		for (Pattern pattern : withAllDependencies) {
			acc += calcGabenMetric(pattern, engine, relative, filterRedundants);
		}
		return acc;
	}

	/**
	 * saját query difficulty: ln(PROD<minden_felsorolható_constraintre>(#illeszkedések))
     * korrekció: #illeszkedések + 1 mindenhol 
     * nevező csak akkor szerepel, ha relative == true
	 * diszjunktív minta relative esetben tiltott, egyébként max body számít
	 * TODO filterRedundants minta + inference
	 */
	public static double calcGabenMetric(Pattern patt, IncQueryEngine engine, boolean relative, boolean filterRedundants) throws IncQueryException {
		final EList<PatternBody> bodies = patt.getBodies();
		if (relative && bodies.size() > 1) 
			throw new IllegalArgumentException();
		
		double max = Double.MIN_VALUE;
				
		final NavigationHelper baseIndex = engine.getBaseIndex();

		for (PatternBody patternBody : bodies) {
			double acc = 0.0;
			
			final Multimap<Variable,EClassifier> deferredClassifiers = HashMultimap.create();
			final Multimap<Variable,EClassifier> inferredClassifiers = HashMultimap.create();
			final EList<Constraint> constraints = patternBody.getConstraints();
			for (Constraint constraint : constraints) {
				if (constraint instanceof PatternCompositionConstraint) {
					final PatternCompositionConstraint compo = (PatternCompositionConstraint) constraint;
					if (!compo.isNegative()) {
						final PatternCall call = compo.getCall();
						final Pattern patternRef = call.getPatternRef();
						if (!call.isTransitive()) {
							final int count = MatcherFactoryRegistry.getOrCreateMatcherFactory(patternRef).getMatcher(engine).countMatches();
							acc += Math.log(nonZero(count));
						} else {
							throw new UnsupportedOperationException("transitive closure estimate not supported yet");
						}
					}				
				} else if (constraint instanceof EClassifierConstraint) {
					final EClassifierConstraint classifierConstraint = (EClassifierConstraint) constraint;
					final Variable variable = classifierConstraint.getVar().getVariable();
					final EntityType type = classifierConstraint.getType();
					if (type instanceof ClassType) {
						final EClassifier classifier = ((ClassType) type).getClassname();
						deferredClassifiers.put(variable, classifier);
					} else throw new UnsupportedOperationException("unknown entity type " + type.toString());	
				} else if (constraint instanceof PathExpressionConstraint) {
					final PathExpressionHead head = ((PathExpressionConstraint) constraint).getHead();
					for (PathExpressionTail tail = head.getTail(); tail != null; tail = tail.getTail()) {
						final Type type = tail.getType();
						if (type instanceof ReferenceType) {
				            EStructuralFeature feature = ((ReferenceType) type).getRefname();
							if (!baseIndex.isInWildcardMode()) 
								baseIndex.registerEStructuralFeatures(Collections.singleton(feature));
							int count = 0;
							final Collection<EObject> holders = baseIndex.getHoldersOfFeature(feature);
							for (EObject source : holders) {
								count += baseIndex.getFeatureTargets(source, feature).size();
							}
							acc += Math.log(nonZero(count));
							
							// inference
							if (tail == head.getTail()) {
								final Variable variable = head.getSrc().getVariable();
								final EClass eContainingClass = feature.getEContainingClass();
								inferredClassifiers.put(variable, eContainingClass);
								final EList<EClass> eAllSuperTypes = eContainingClass.getEAllSuperTypes();
								for (EClass superType : eAllSuperTypes) {
									inferredClassifiers.put(variable, superType);
								}
							}
							if (tail.getTail() == null) {
								final ValueReference dst = head.getDst();
								if (dst instanceof VariableReference) {
									final Variable variable = ((VariableReference) dst).getVariable();
									final EClassifier eType = feature.getEType();
									inferredClassifiers.put(variable, eType);
									if (eType instanceof EClass) for (EClass superType : ((EClass) eType).getEAllSuperTypes()) {
										inferredClassifiers.put(variable, superType);
									}

								}
							}
						} else throw new UnsupportedOperationException("unknown path expression feature type: " + type.getClass().getSimpleName());
					}
				}
			}
			
			for (Entry<Variable,EClassifier> entry : deferredClassifiers.entries()) {
				final Variable variable = entry.getKey();
				final EClassifier classifier = entry.getValue();
				if (filterRedundants && inferredClassifiers.containsEntry(variable, classifier)) continue;
				if (classifier instanceof EClass) {
					final EClass clazz = (EClass)classifier;
					if (!baseIndex.isInWildcardMode()) 
						baseIndex.registerEClasses(Collections.singleton(clazz));
					final int count = baseIndex.getAllInstances(clazz).size();
					acc += Math.log(nonZero(count));
				} else if (classifier instanceof EDataType) {
					final EDataType datatType = (EDataType)classifier;
					if (!baseIndex.isInWildcardMode()) 
						baseIndex.registerEDataTypes(Collections.singleton(datatType));
					final int count = baseIndex.getDataTypeInstances(datatType).size();
					acc += Math.log(nonZero(count));
				} else throw new UnsupportedOperationException("unknown classifier type in ClassType: " + classifier.getClass().getSimpleName());	
			}
			
			
			
			if (max < acc) max = acc;
		}
		
		if (relative) {
			final int countMatches = calcCountMatches(patt, engine);
			double base = -Math.log(nonZero(countMatches));
			return base + max;
		} else return max;
		
	}
	
	private static double nonZero(final int count) {
		return 1.0 + count; // guaranteed to be an overestimate of the Varró metric (adjusted with match set and logarithmically)
		// return count == 0 ? 1 : count;
	}

}
