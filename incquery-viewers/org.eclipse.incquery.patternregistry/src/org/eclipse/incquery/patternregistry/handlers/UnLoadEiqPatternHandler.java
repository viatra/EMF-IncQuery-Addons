package org.eclipse.incquery.patternregistry.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.incquery.patternregistry.util.PatternRegistry;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

public class UnLoadEiqPatternHandler extends AbstractHandler {

	@Inject
	IResourceSetProvider resSetProvider;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			IFile file = (IFile) HandlerUtil.getActiveEditorInput(event).getAdapter(IFile.class);
			if (file != null) {
				PatternRegistry.getInstance().unRegisterEiqFile(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
