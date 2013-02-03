package org.eclipse.incquery.querybasedviewers.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.incquery.querybasedviewers.zest.ZestView;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

public class LoadModelHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        try {
            IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
            if (editorPart instanceof IEditingDomainProvider) {
                IEditingDomainProvider providerEditor = (IEditingDomainProvider) editorPart;
                ResourceSet resourceSet = providerEditor.getEditingDomain().getResourceSet();
                if (resourceSet.getResources().size() > 0) {
                    EcoreEditor editor = null;
                    if (providerEditor instanceof EcoreEditor)
                        editor = (EcoreEditor) providerEditor;
                    if (ZestView.getInstance() != null)
                        ZestView.getInstance().setResourceSet(resourceSet, editor);
                }
            }
        } catch (IncQueryException e) {
            throw new ExecutionException("Error initializing pattern matcher.", e);
        }

        return null;
    }

}
