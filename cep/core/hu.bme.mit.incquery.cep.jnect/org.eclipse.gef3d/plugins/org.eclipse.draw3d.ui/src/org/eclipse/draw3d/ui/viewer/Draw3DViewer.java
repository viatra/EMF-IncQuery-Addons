/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.ui.viewer;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw3d.Draw3DCanvas;
import org.eclipse.draw3d.IFigure3D;
import org.eclipse.draw3d.LightweightSystem3D;
import org.eclipse.draw3d.XYZLayout;
import org.eclipse.draw3d.graphics3d.Graphics3DDescriptor;
import org.eclipse.draw3d.graphics3d.Graphics3DRegistry;
import org.eclipse.draw3d.graphics3d.Graphics3DType;
import org.eclipse.draw3d.ui.camera.CameraInputHandler;
import org.eclipse.draw3d.ui.export.Export3DAction;
import org.eclipse.draw3d.ui.export.Export3DFigureProvider;
import org.eclipse.draw3d.ui.preferences.CameraPreferenceDistributor;
import org.eclipse.draw3d.ui.preferences.ScenePreferenceDistributor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

/**
 * Abstract base class for Draw3D viewers.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 01.06.2009
 */
public abstract class Draw3DViewer extends EditorPart {

    /**
     * Distributes camera preference changes.
     */
    protected CameraPreferenceDistributor m_cameraPreferenceDistributor;

    /**
     * The canvas.
     */
    protected Draw3DCanvas m_canvas;

    /**
     * The 3D export actions for this viewer.
     */
    protected Collection<Export3DAction> m_export3DActions = new HashSet<Export3DAction>();

    CameraInputListener m_inputListener;

    /**
     * The lightweight system.
     */
    protected LightweightSystem3D m_lightweightSystem;

    /**
     * Distributes scene preference changes.
     */
    protected ScenePreferenceDistributor m_scenePreferenceDistributor;

    /**
     * Creates the root figure of this viewer.
     * 
     * @return the root figure
     */
    protected abstract IFigure3D createContents();

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
     */
    @Override
    public void createPartControl(Composite i_parent) {

        Composite c = new Composite(i_parent, SWT.NONE);
        c.setLayout(new FillLayout());

        // create a Draw3DCanvas inside:
        m_lightweightSystem = new LightweightSystem3D();
        m_lightweightSystem.setDrawAxes(true);
        m_canvas = Draw3DCanvas.createCanvas(c, SWT.NONE, m_lightweightSystem);
        m_lightweightSystem.setControl(m_canvas);
        m_lightweightSystem.getRootFigure().setLayoutManager(new XYZLayout());

        IFigure3D figure = createContents();
        m_lightweightSystem.setContents(figure);

        m_canvas.addDisposeListener(m_lightweightSystem);

        m_scenePreferenceDistributor = new ScenePreferenceDistributor(
            m_lightweightSystem);

        CameraInputHandler handler = new CameraInputHandler();
        handler.setScene(m_lightweightSystem);
        m_cameraPreferenceDistributor = new CameraPreferenceDistributor(handler);

        m_scenePreferenceDistributor.start();
        m_cameraPreferenceDistributor.start();

        m_inputListener = new CameraInputListener(handler);
        m_canvas.addKeyListener(m_inputListener);
        m_canvas.addMouseListener(m_inputListener);
        m_canvas.addMouseMoveListener(m_inputListener);
        m_canvas.addMouseWheelListener(m_inputListener);

        m_canvas.addDisposeListener(new DisposeListener() {

            public void widgetDisposed(DisposeEvent i_e) {

                if (m_inputListener != null) {
                    m_canvas.removeKeyListener(m_inputListener);
                    m_canvas.removeMouseListener(m_inputListener);
                    m_canvas.removeMouseMoveListener(m_inputListener);
                    m_canvas.removeMouseWheelListener(m_inputListener);
                    m_inputListener = null;
                }
            }
        });

        Export3DFigureProvider figureProvider = new Export3DFigureProvider() {

            public IFigure3D getFigure() {

                return (IFigure3D) m_lightweightSystem.getRootFigure();
            }
        };

        for (Graphics3DDescriptor descr : Graphics3DRegistry.getRenderersForType(Graphics3DType.EXPORT)) {

            String id = descr.getRendererID();
            Export3DAction action = new Export3DAction(id, figureProvider);

            m_export3DActions.add(action);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.ui.part.WorkbenchPart#dispose()
     */
    @Override
    public void dispose() {

        if (m_scenePreferenceDistributor != null) {
            m_scenePreferenceDistributor.stop();
            m_scenePreferenceDistributor = null;
        }

        if (m_cameraPreferenceDistributor != null) {
            m_cameraPreferenceDistributor.stop();
            m_cameraPreferenceDistributor = null;
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.IProgressMonitor)
     */
    @Override
    public void doSave(IProgressMonitor i_monitor) {

        // nothing to save
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.ui.part.EditorPart#doSaveAs()
     */
    @Override
    public void doSaveAs() {

        // nothing to save
    }

    /**
     * Returns the export actions for the action bar contributor.
     * 
     * @return a collection containing the export actions
     */
    public Collection<Export3DAction> getExportActions() {

        return m_export3DActions;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.ui.part.EditorPart#init(org.eclipse.ui.IEditorSite,
     *      org.eclipse.ui.IEditorInput)
     */
    @Override
    public void init(IEditorSite i_site, IEditorInput i_input)
            throws PartInitException {

        setSite(i_site);
        setInput(i_input);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.ui.part.EditorPart#isDirty()
     */
    @Override
    public boolean isDirty() {

        return false;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.ui.part.EditorPart#isSaveAsAllowed()
     */
    @Override
    public boolean isSaveAsAllowed() {

        return false;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
     */
    @Override
    public void setFocus() {

        // nothing to do
    }
}
