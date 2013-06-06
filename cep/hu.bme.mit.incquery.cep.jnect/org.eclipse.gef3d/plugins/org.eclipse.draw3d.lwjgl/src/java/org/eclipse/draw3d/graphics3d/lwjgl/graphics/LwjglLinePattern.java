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
package org.eclipse.draw3d.graphics3d.lwjgl.graphics;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw3d.graphics3d.DisplayListManager;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.draw3d.util.converter.ColorBufferInfo;
import org.eclipse.draw3d.util.converter.ImageConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.lwjgl.opengl.GL11;

/**
 * An OpenGL line pattern is used to render lines according to a given SWT
 * dashing pattern. The line pattern is rendered using a 1D texture.
 * 
 * @see Graphics#setLineDash(int[])
 * @author Kristian Duske
 * @since 17.06.2008
 */
public class LwjglLinePattern {

	/**
	 * Returns a key that uniquely identifies the given dashing pattern.
	 * 
	 * @param i_dashPattern the dashing pattern
	 * @return the unique key
	 */
	public static Object getKey(int[] i_dashPattern) {

		int hashCode = 17;
		for (int i = 0; i < i_dashPattern.length; i++)
			hashCode = 37 * hashCode + i_dashPattern[i];

		return hashCode;
	}

	private boolean m_disposed = false;

	private int m_length;

	private int m_textureId = -1;

	/**
	 * Creates a new line pattern for the given dashing pattern.
	 * 
	 * @param i_dashPattern the dashing pattern
	 * @param i_displayListManager the display list manager
	 * @throws NullPointerException if the given pattern is <code>null</code>
	 */
	public LwjglLinePattern(int[] i_dashPattern,
			DisplayListManager i_displayListManager) {

		if (i_dashPattern == null)
			throw new NullPointerException("dashPattern must not be null");

		if (i_displayListManager == null)
			throw new NullPointerException(
				"i_displayListManager must not be null");

		i_displayListManager.interruptDisplayList();
		try {
			// calculate the total length of the pattern
			m_length = 0;
			for (int i = 0; i < i_dashPattern.length; i++)
				m_length += i_dashPattern[i];

			Device device = Display.getCurrent();
			Image image = null;
			GC gc = null;
			try {
				image = new Image(device, m_length, 1);
				gc = new GC(image);

				// paint the pattern to an image
				gc.setForeground(device.getSystemColor(SWT.COLOR_BLACK));
				gc.setBackground(device.getSystemColor(SWT.COLOR_WHITE));
				gc.fillRectangle(0, 0, m_length, 1);
				gc.setLineDash(i_dashPattern);
				gc.drawLine(0, 0, m_length, 0);

				// create a luminance alpha buffer from the image
				ColorBufferInfo info =
					new ColorBufferInfo(m_length, 1, GL11.GL_LUMINANCE_ALPHA,
						GL11.GL_UNSIGNED_BYTE, 1);

				ImageConverter converter = ImageConverter.getInstance();
				ByteBuffer buffer =
					converter.imageToBuffer(image, info, null, false);

				// create the texture
				GL11.glPushAttrib(GL11.GL_TEXTURE_BIT);
				try {
					IntBuffer intBuf = Draw3DCache.getIntBuffer(1);
					try {
						GL11.glDisable(GL11.GL_TEXTURE_2D);
						GL11.glEnable(GL11.GL_TEXTURE_1D);
						GL11.glGenTextures(intBuf);
						m_textureId = intBuf.get(0);

						GL11.glBindTexture(GL11.GL_TEXTURE_1D, m_textureId);
						GL11.glTexParameteri(GL11.GL_TEXTURE_1D,
							GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
						GL11.glTexParameteri(GL11.GL_TEXTURE_1D,
							GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
						GL11.glTexParameteri(GL11.GL_TEXTURE_1D,
							GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
						GL11.glTexImage1D(GL11.GL_TEXTURE_1D, 0,
							GL11.GL_LUMINANCE_ALPHA, m_length, 0,
							GL11.GL_LUMINANCE_ALPHA, GL11.GL_UNSIGNED_BYTE,
							buffer);
					} finally {
						Draw3DCache.returnIntBuffer(intBuf);
					}
				} finally {
					GL11.glPopAttrib();
					GL11.glBindTexture(GL11.GL_TEXTURE_1D, 0);
				}
			} finally {
				if (gc != null)
					gc.dispose();
				if (image != null)
					image.dispose();
			}
		} finally {
			i_displayListManager.resumeDisplayList();
		}
	}

	/**
	 * Activates this line pattern. Every line will be drawn with this line
	 * pattern after this method call until {@link #deactivate()} is called.
	 * 
	 * @throws IllegalStateException if this line pattern is disposed
	 */
	public void activate() {

		if (m_disposed)
			throw new IllegalStateException("line pattern is disposed");

		GL11.glPushAttrib(GL11.GL_TEXTURE_BIT);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_TEXTURE_1D);
		GL11.glBindTexture(GL11.GL_TEXTURE_1D, m_textureId);
		GL11.glTexEnvi(GL11.GL_TEXTURE_ENV, GL11.GL_TEXTURE_ENV_MODE,
			GL11.GL_BLEND);
	}

	/**
	 * Deactivates this line pattern.
	 * 
	 * @throws IllegalStateException if this line pattern is disposed
	 */
	public void deactivate() {

		if (m_disposed)
			throw new IllegalStateException("line pattern is disposed");

		GL11.glPopAttrib();
		GL11.glBindTexture(GL11.GL_TEXTURE_1D, 0);
	}

	/**
	 * Disposes all resources associated with this line pattern.
	 */
	public void dispose() {

		if (m_disposed)
			return;

		if (m_textureId != -1) {
			IntBuffer intBuf = Draw3DCache.getIntBuffer(1);
			try {
				intBuf.put(0, m_textureId);
				GL11.glDeleteTextures(intBuf);
				m_textureId = -1;
			} finally {
				Draw3DCache.returnIntBuffer(intBuf);
			}
		}

		m_disposed = true;
	}

	/**
	 * Returns the total length of this line pattern.
	 * 
	 * @return the length of this line pattern in pixels
	 * @throws IllegalStateException if this line pattern is disposed
	 */
	public int getLength() {

		if (m_disposed)
			throw new IllegalStateException("line pattern is disposed");

		return m_length;
	}

	/**
	 * Returns the S texture coordinate for the end point of a line defined by
	 * the given points.
	 * 
	 * @param i_x1 the X coordinate of the line starting point
	 * @param i_y1 the Y coordinate of the line starting point
	 * @param i_x2 the X coordinate of the line ending point
	 * @param i_y2 the Y coordinate of the line ending point
	 * @return the S texture coordinate for the line's end point
	 * @throws IllegalStateException if this line pattern is disposed
	 */
	public float getS(float i_x1, float i_y1, float i_x2, float i_y2) {

		if (m_disposed)
			throw new IllegalStateException("line pattern is disposed");

		float dX = i_x2 - i_x1;
		float dY = i_y2 - i_y1;
		float lineLength = (float) Math.sqrt(dX * dX + dY * dY);

		return lineLength / m_length;
	}

	/**
	 * Returns the S texture coordinate for the end point of a line defined by
	 * the given points.
	 * 
	 * @param i_x1 the X coordinate of the line starting point
	 * @param i_y1 the Y coordinate of the line starting point
	 * @param i_x2 the X coordinate of the line ending point
	 * @param i_y2 the Y coordinate of the line ending point
	 * @return the S texture coordinate for the line's end point
	 * @throws IllegalStateException if this line pattern is disposed
	 */
	public float getS(int i_x1, int i_y1, int i_x2, int i_y2) {

		if (m_disposed)
			throw new IllegalStateException("line pattern is disposed");

		int dX = i_x2 - i_x1;
		int dY = i_y2 - i_y1;
		float lineLength = (float) Math.sqrt(dX * dX + dY * dY);

		return lineLength / m_length;
	}
}
