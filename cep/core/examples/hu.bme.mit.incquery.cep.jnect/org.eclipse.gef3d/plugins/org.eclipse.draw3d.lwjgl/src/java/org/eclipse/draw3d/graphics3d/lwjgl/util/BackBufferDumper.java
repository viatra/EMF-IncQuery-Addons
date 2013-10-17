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
package org.eclipse.draw3d.graphics3d.lwjgl.util;

import static org.lwjgl.opengl.GL11.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.eclipse.draw3d.ISceneListener;
import org.eclipse.draw3d.RenderContext;
import org.eclipse.draw3d.camera.ICamera;
import org.eclipse.draw3d.util.ImageConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.lwjgl.BufferUtils;

/**
 * Dumps the back buffer to disk once a render pass is finished.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 24.05.2009
 */
public class BackBufferDumper implements ISceneListener {

    private ByteBuffer m_pBuffer;

    private int m_pBufferSize = 0;

    private IntBuffer m_vpBuffer = BufferUtils.createIntBuffer(16);

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
     * @see org.eclipse.draw3d.ISceneListener#renderPassFinished(org.eclipse.draw3d.RenderContext)
     */
    public void renderPassFinished(RenderContext i_renderContext) {

        m_vpBuffer.rewind();
        glGetInteger(GL_VIEWPORT, m_vpBuffer);

        int x = m_vpBuffer.get(0);
        int y = m_vpBuffer.get(1);
        int width = m_vpBuffer.get(2);
        int height = m_vpBuffer.get(3);

        if (width == 0 || height == 0)
            return;

        int size = width * height * 4;
        if (m_pBuffer == null || size > m_pBufferSize) {
            m_pBuffer = BufferUtils.createByteBuffer(size);
            m_pBufferSize = size;
        } else
            m_pBuffer.limit(size);

        glReadPixels(x, y, width, height, GL_RGBA, GL_UNSIGNED_BYTE, m_pBuffer);

        ImageData imageData = ImageConverter.colorBufferToImage(m_pBuffer,
            GL_RGBA, GL_UNSIGNED_BYTE, width, height);

        ImageLoader imageLoader = new ImageLoader();
        imageLoader.data = new ImageData[] { imageData };

        String home = System.getProperty("user.home");
        String path = home + "/backbuffer_" + System.currentTimeMillis()
                + ".png";
        imageLoader.save(path, SWT.IMAGE_PNG);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.draw3d.ISceneListener#renderPassStarted(org.eclipse.draw3d.RenderContext)
     */
    public void renderPassStarted(RenderContext i_renderContext) {

        // nothing to do
    }
}
