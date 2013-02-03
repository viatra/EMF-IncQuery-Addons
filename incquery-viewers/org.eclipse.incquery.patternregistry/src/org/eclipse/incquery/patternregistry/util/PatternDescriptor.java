package org.eclipse.incquery.patternregistry.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.incquery.patternlanguage.helper.CorePatternLanguageHelper;
import org.eclipse.incquery.patternlanguage.patternLanguage.Annotation;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;

public class PatternDescriptor {
	private Pattern pattern;
	private String patternFQN;
	private IFile file;
	private List<String> annotations;

	public PatternDescriptor(Pattern pattern, IFile file) {
		this.pattern = pattern;
		this.file = file;
		this.patternFQN = CorePatternLanguageHelper.getFullyQualifiedName(pattern);
		this.annotations = new ArrayList<String>();
		for (Annotation annotation : pattern.getAnnotations()) {
			this.annotations.add(annotation.getName());
		}
	}

	public Pattern getPattern() {
		return pattern;
	}

	public String getPatternFQN() {
		return patternFQN;
	}

	public IFile getFile() {
		return file;
	}

	public List<String> getAnnotations() {
		return annotations;
	}
}
