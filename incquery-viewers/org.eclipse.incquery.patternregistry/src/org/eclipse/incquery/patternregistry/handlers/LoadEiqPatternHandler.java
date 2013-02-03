package org.eclipse.incquery.patternregistry.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel;
import org.eclipse.incquery.patternregistry.util.PatternRegistry;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

public class LoadEiqPatternHandler extends AbstractHandler {

	@Inject
	IResourceSetProvider resSetProvider;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			IFile file = (IFile) HandlerUtil.getActiveEditorInput(event).getAdapter(IFile.class);
			if (file != null) {
				IProject proj = file.getProject();
				ResourceSet resourceSet = resSetProvider.get(proj);
				URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), false);
				Resource resource = resourceSet.getResource(fileURI, true);
				if (resource != null) {
					if (resource.getErrors().size() > 0) {
						return null;
					}

					if (resource.getContents().size() >= 1) {
						EObject topElement = resource.getContents().get(0);
						PatternModel pm = topElement instanceof PatternModel ? (PatternModel) topElement : null;
						if (pm != null) {
							PatternRegistry.getInstance().registerEiqFile(file, pm);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
