/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others,
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - original 2D version 
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.ui.parts;

import org.eclipse.draw3d.IScene;
import org.eclipse.draw3d.LightweightSystem3D;
import org.eclipse.draw3d.ui.preferences.ScenePreferenceDistributor;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorSite;

/**
 * GraphicalEditor3D, overrides
 * {@link GraphicalEditor#createPartControl(org.eclipse.swt.widgets.Composite)}.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 16.11.2007
 */
public abstract class GraphicalEditor3D extends GraphicalEditor {

    /**
     * The scene preference distributor for this editor.
     */
    protected ScenePreferenceDistributor scenePreferenceDistributor;

    protected void createActionBarContribution() {

    }

    /**
     * {@inheritDoc}
     * <p>
     * This method calls several helper methods which could be overridden by
     * subclasses:
     * <ol>
     * <li>{@link #doCreateGraphicalViewer()}</li>
     * <li>{@link #doAttachFPSCounter(GraphicalViewer3D)}</li>
     * <li>{@link #doRegisterToScene(IScene)}</li>
     * </ol>
     * </p>
     * <p>
     * This method was copied from {@link GraphicalEditor3D}.
     * </p>
     * 
     * @see org.eclipse.gef.ui.parts.GraphicalEditor#createGraphicalViewer(org.eclipse.swt.widgets.Composite)
     * @author hudsonnr (original 2D version)
     * @author Jens von Pilgrim
     */
    @Override
    protected void createGraphicalViewer(Composite i_parent) {

        GraphicalViewer3D viewer = doCreateGraphicalViewer();

        // 1:1 from GraphicalEditor.createGraphicalViewer(Composite),
        // instead of createControl, createControl3D is called!
        Control control = viewer.createControl3D(i_parent);
        setGraphicalViewer(viewer);
        configureGraphicalViewer();
        hookGraphicalViewer();
        initializeGraphicalViewer();

        doAttachFPSCounter(viewer);
        control.addDisposeListener(viewer.getLightweightSystem3D());
        doRegisterToScene(viewer.getLightweightSystem3D());

        // trigger the wrapping of the edit domain now that we have a viewer
        if (getEditDomain() != null)
            setEditDomain(getEditDomain());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.gef.ui.parts.GraphicalEditor#dispose()
     */
    @Override
    public void dispose() {

        if (scenePreferenceDistributor != null)
            scenePreferenceDistributor.stop();

        super.dispose();
    }

    /**
     * Called by {@link #createGraphicalViewer(Composite)} if created viewer is
     * an instanceof {@link GraphicalViewer3D}.
     * 
     * @param viewer3D
     */
    protected void doAttachFPSCounter(GraphicalViewer3D viewer3D) {

        IEditorSite editorSite = getEditorSite();
        IActionBars actionBars = editorSite.getActionBars();
        IStatusLineManager statusLine = actionBars.getStatusLineManager();

        FpsStatusLineItem fpsCounter = new FpsStatusLineItem();
        LightweightSystem3D lightweightSystem3D = viewer3D.getLightweightSystem3D();
        lightweightSystem3D.addSceneListener(fpsCounter);
        statusLine.add(fpsCounter);
    }

    /**
     * Here, a {@link GraphicalViewer3DImpl} is created instead of a
     * ScrollingGraphicalViewer.
     * 
     * @return
     */
    protected GraphicalViewer3D doCreateGraphicalViewer() {

        GraphicalViewer3DImpl viewer = new GraphicalViewer3DImpl();
        return viewer;
    }

    /**
     * Called by {@link #createGraphicalViewer(Composite)} if created viewer is
     * an instance of {@link IScene}.
     * 
     * @param scene
     */
    protected void doRegisterToScene(IScene scene) {

        scenePreferenceDistributor = new ScenePreferenceDistributor(scene);
        scenePreferenceDistributor.start();
    }
}
