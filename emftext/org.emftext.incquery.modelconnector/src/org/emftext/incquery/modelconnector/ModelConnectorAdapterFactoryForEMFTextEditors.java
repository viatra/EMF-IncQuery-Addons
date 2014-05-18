/*******************************************************************************
 * Copyright (c) 2006-2013
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.incquery.modelconnector;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.incquery.tooling.ui.queryexplorer.IModelConnector;
import org.eclipse.ui.texteditor.ITextEditor;
import org.emftext.access.EMFTextAccessProxy;
import org.emftext.access.resource.IEditor;

public class ModelConnectorAdapterFactoryForEMFTextEditors implements IAdapterFactory {

    @SuppressWarnings("rawtypes")
    @Override
    public Object getAdapter(Object adaptableObject, Class adapterType) {
        if (adapterType.equals(IModelConnector.class) && adaptableObject instanceof ITextEditor) {
            if (EMFTextAccessProxy.isAccessibleWith(adaptableObject.getClass(), IEditor.class)) {
                IEditor emftextEditor = (IEditor) EMFTextAccessProxy.get(adaptableObject, IEditor.class);
                return new EMFTextModelConnector((ITextEditor) adaptableObject, emftextEditor);
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