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
package org.eclipse.gef3d.ui.parts;

import java.util.LinkedList;
import java.util.logging.Logger;

import org.eclipse.draw3d.ISceneListener;
import org.eclipse.draw3d.RenderContext;
import org.eclipse.draw3d.camera.ICamera;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.StatusLineLayoutData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * Displays FPS information in the Eclipse status bar.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 22.05.2008
 */
public class FpsStatusLineItem extends ContributionItem implements
        ISceneListener {

    private static final int CHAR_WIDTH = 8;

    private static final int INDENT = 3;

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(FpsStatusLineItem.class.getName());

    private static final int NUM_FRAMES = 20;

    private static final long TIMEOUT = 50;

    private int m_fixedHeight = -1;

    private int m_fixedWidth = -1;

    private LinkedList<Long> m_frames = new LinkedList<Long>();

    private CLabel m_label;

    private long m_lastFrame = -1;

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.draw3d.ISceneListener#cameraChanged(org.eclipse.draw3d.camera.ICamera,
     *      org.eclipse.draw3d.camera.ICamera)
     */
    public void cameraChanged(ICamera i_oldCamera, ICamera i_newCamera) {

        // nothing to do
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.jface.action.ContributionItem#fill(org.eclipse.swt.widgets.Composite)
     */
    @Override
    public void fill(Composite i_parent) {

        Label sep = new Label(i_parent, SWT.SEPARATOR);
        m_label = new CLabel(i_parent, SWT.SHADOW_NONE);

        StatusLineLayoutData data = new StatusLineLayoutData();
        data.widthHint = getWidthHint(i_parent);
        m_label.setLayoutData(data);

        data = new StatusLineLayoutData();
        data.heightHint = getHeightHint(i_parent);
        sep.setLayoutData(data);

        updateCounter();
    }

    private int getHeightHint(Composite control) {

        if (m_fixedHeight < 0) {
            GC gc = new GC(control);
            gc.setFont(control.getFont());
            m_fixedHeight = gc.getFontMetrics().getHeight();
            gc.dispose();
        }
        return m_fixedHeight;
    }

    private int getWidthHint(Composite control) {

        if (m_fixedWidth < 0) {
            GC gc = new GC(control);
            gc.setFont(control.getFont());
            m_fixedWidth = gc.getFontMetrics().getAverageCharWidth()
                    * CHAR_WIDTH;
            m_fixedWidth += INDENT * 2;
            gc.dispose();
        }
        return m_fixedWidth;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.draw3d.ISceneListener#renderPassFinished()
     */
    public void renderPassFinished(RenderContext renderContext) {

        long time = System.currentTimeMillis();
        if (m_lastFrame == -1) {
            m_lastFrame = time;
            return;
        }

        long frameTime = time - m_lastFrame;
        m_lastFrame = time;

        if (frameTime <= TIMEOUT) {
            if (m_frames.size() == NUM_FRAMES)
                m_frames.removeLast();

            m_frames.addFirst(frameTime);
        }

        updateCounter();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.draw3d.ISceneListener#renderPassStarted()
     */
    public void renderPassStarted(RenderContext renderContext) {

        // nothing to do
    }

    private void updateCounter() {

        long fps = 0;
        if (m_frames.size() > 0) {
            double avg = 0;
            for (long frameTime : m_frames)
                avg += frameTime;

            avg /= m_frames.size();
            fps = (long) (1000 / avg);
        }

        if (m_label != null && !m_label.isDisposed())
            m_label.setText(fps + " FPS");
    }
}
