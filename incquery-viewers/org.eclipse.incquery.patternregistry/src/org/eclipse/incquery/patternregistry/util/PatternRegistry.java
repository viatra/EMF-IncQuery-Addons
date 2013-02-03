package org.eclipse.incquery.patternregistry.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.incquery.patternlanguage.helper.CorePatternLanguageHelper;
import org.eclipse.incquery.patternlanguage.patternLanguage.Annotation;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.ListMultimap;

public class PatternRegistry {

	private static PatternRegistry instance;

	private List<PatternDescriptor> registeredPatternDescriptors;

	private WritableList observePatternDescriptors;

	public PatternRegistry() {
		registeredPatternDescriptors = new ArrayList<PatternDescriptor>();
		observePatternDescriptors = new WritableList(registeredPatternDescriptors, PatternDescriptor.class);
	}

	public static synchronized PatternRegistry getInstance() {
		if (instance == null) {
			instance = new PatternRegistry();
		}
		return instance;
	}

	private static class PatternFQNFilter implements Predicate<PatternDescriptor> {

		private final String patternFQN;

		public PatternFQNFilter(String patternFQN) {
			this.patternFQN = patternFQN;
		}

		@Override
		public boolean apply(PatternDescriptor patternDescriptor) {
			return patternFQN.equals(patternDescriptor.getPatternFQN());
		}
	}

	public synchronized void registerEiqFile(IFile file, PatternModel patternModel) {
		for (Pattern newPattern : patternModel.getPatterns()) {
			String newpatternFQN = CorePatternLanguageHelper.getFullyQualifiedName(newPattern);
			Collection<PatternDescriptor> filteredPatternFQN = Collections2.filter(registeredPatternDescriptors,
					new PatternFQNFilter(newpatternFQN));

			if (!filteredPatternFQN.isEmpty()) {
				PatternDescriptor oldPatterndeDescriptor = filteredPatternFQN.iterator().next();
				if (!EcoreUtil.equals(oldPatterndeDescriptor.getPattern(), newPattern)) {
					observePatternDescriptors.remove(oldPatterndeDescriptor);
					observePatternDescriptors.add(new PatternDescriptor(newPattern, file));
				}
			} else {
				observePatternDescriptors.add(new PatternDescriptor(newPattern, file));
			}
		}
	}

	private static class FileFilter implements Predicate<PatternDescriptor> {

		private final IFile file;

		public FileFilter(IFile file) {
			this.file = file;
		}

		@Override
		public boolean apply(PatternDescriptor patternDescriptor) {
			return file.equals(patternDescriptor.getFile());
		}
	}

	private static Function<PatternDescriptor, Pattern> invokeGetPattern = new Function<PatternDescriptor, Pattern>() {
		@Override
		public Pattern apply(PatternDescriptor input) {
			return input.getPattern();
		}
	};

	public void unRegisterEiqFile(IFile file) {
		Collection<PatternDescriptor> patternsToRemove = Collections2.filter(registeredPatternDescriptors, new FileFilter(file));
		while (!patternsToRemove.isEmpty()) {
			observePatternDescriptors.remove(patternsToRemove.toArray()[0]);
		}
	}

	public List<Pattern> getRegisteredPatterns() {
		return new ArrayList<Pattern>(Collections2.transform(registeredPatternDescriptors, invokeGetPattern));
	}

	private static class AnnotationFilter implements Predicate<PatternDescriptor> {

		private final String name;

		public AnnotationFilter(String name) {
			this.name = name;
		}

		@Override
		public boolean apply(PatternDescriptor patternDescriptor) {
			return patternDescriptor.getAnnotations().contains(name);
		}
	}

	public List<Pattern> getPatternsWithAnnotation(String annotationName) {
		Collection<PatternDescriptor> annotationFilteredpatterns = Collections2.filter(registeredPatternDescriptors,
				new AnnotationFilter(annotationName));
		return new ArrayList<Pattern>(Collections2.transform(annotationFilteredpatterns, invokeGetPattern));
	}

	private static class PackageFilter implements Predicate<PatternDescriptor> {

		private final List<String> packageNameFilters;

		public PackageFilter(List<String> packageNameFilters) {
			this.packageNameFilters = packageNameFilters;
		}

		@Override
		public boolean apply(PatternDescriptor patternDescriptor) {
			return isPatternInpackage(patternDescriptor.getPattern(), packageNameFilters);
		}
	}

	public List<Pattern> getRegisteredPatternsFiltered(List<String> packageNameFilters) {
		Collection<PatternDescriptor> packageFilteredpatterns = Collections2.filter(registeredPatternDescriptors,
				new PackageFilter(packageNameFilters));
		return new ArrayList<Pattern>(Collections2.transform(packageFilteredpatterns, invokeGetPattern));
	}

	public List<Pattern> getPatternsWithAnnotationFiltered(String annotationName, List<String> packageNameFilters) {
		Collection<PatternDescriptor> packageFilteredpatterns = Collections2.filter(registeredPatternDescriptors,
				new PackageFilter(packageNameFilters));
		Collection<PatternDescriptor> annotationFilteredpatterns = Collections2.filter(packageFilteredpatterns,
				new AnnotationFilter(annotationName));
		return new ArrayList<Pattern>(Collections2.transform(annotationFilteredpatterns, invokeGetPattern));
	}

	public WritableList getObservePatternDescriptors() {
		return observePatternDescriptors;
	}

	public static List<ValueReference> getPatternAnnotationParameterValue(Pattern pattern, String annotationName,
			String parameterName) {
		List<ValueReference> parameterValues = new ArrayList<ValueReference>();
		for (Annotation annotation : CorePatternLanguageHelper.getAnnotationsByName(pattern, annotationName)) {
			Collection<ValueReference> matchParameterValues = CorePatternLanguageHelper.getAnnotationParameters(annotation)
					.asMap().get(parameterName);
			if (matchParameterValues != null)
				parameterValues.addAll(matchParameterValues);
		}
		return parameterValues;
	}

	public static ListMultimap<String, ValueReference> getPatternAnnotationParameterValuePairs(Pattern pattern,
			String annotationName) {
		ListMultimap<String, ValueReference> parameterValues = ArrayListMultimap.create();
		for (Annotation annotation : CorePatternLanguageHelper.getAnnotationsByName(pattern, annotationName)) {
			parameterValues.putAll(CorePatternLanguageHelper.getAnnotationParameters(annotation));
		}
		return parameterValues;
	}

	public static Boolean isPatternInpackage(Pattern pattern, List<String> packageNameFilter) {
		PatternModel patternModel = (PatternModel) pattern.eContainer();
		String packageName = (patternModel == null) ? null : patternModel.getPackageName();
		return (packageName != null && !packageName.isEmpty() && packageNameFilter.contains(packageName));
	}
}
