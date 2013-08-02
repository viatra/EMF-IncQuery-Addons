package org.emftext.incquery.modelconnector;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.incquery.runtime.api.IModelConnector;
import org.eclipse.ui.IEditorPart;
import org.emftext.access.EMFTextAccessProxy;
import org.emftext.access.resource.IEditor;

public class ModelConnectorAdapterFactoryForEMFTextEditors implements IAdapterFactory {

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(adapterType.equals(IModelConnector.class) && adaptableObject instanceof IEditorPart){
			if(EMFTextAccessProxy.isAccessibleWith(adaptableObject.getClass(), IEditor.class)){
				IEditor emftextEditor = (IEditor) EMFTextAccessProxy.get(adaptableObject, IEditor.class);
				return new EMFTextModelConnector((IEditorPart) adaptableObject, emftextEditor);
			}
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class[] getAdapterList() {
		return new Class[] { IModelConnector.class };
	}

}
