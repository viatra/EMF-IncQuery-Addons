/*******************************************************************************
 * Copyright (c) 2009-2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 *    Madhu Samuel	 - Implementation
 ******************************************************************************/
package org.eclipse.draw3d.jogl.graphics3d.graphics;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import javax.media.opengl.GL;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.draw3d.util.converter.BufferInfo;
import org.eclipse.draw3d.util.converter.ImageConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * An OpenGL line pattern is used to render lines according to a given SWT
 * dashing pattern. The line pattern is rendered using a 1D texture.
 * 
 * @see Graphics#setLineDash(int[])
 * @author Madhu Samuel
 * @since 24.08.2009
 */
public class JoglLinePattern {

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
	 * The gl instance
	 */
	private GL gl;

	/**
	 * Creates a new line pattern for the given dashing pattern.
	 * 
	 * @param i_dashPattern the dashing pattern
	 * @throws NullPointerException if the given pattern is <code>null</code>
	 */
	public JoglLinePattern(int[] i_dashPattern, GL gl) {

		if (i_dashPattern == null)
			throw new NullPointerException("dashPattern must not be null");
		if (gl == null)
			throw new NullPointerException("gl must not be null");
		
		this.gl = gl;

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
			BufferInfo info =
				new BufferInfo(m_length, 1, GL.GL_LUMINANCE_ALPHA,
					GL.GL_UNSIGNED_BYTE, 1);

			ImageConverter converter = ImageConverter.getInstance();
			ByteBuffer buffer =
				converter.imageToBuffer(image, info, null, false);

			// create the texture
			gl.glPushAttrib(GL.GL_TEXTURE_BIT);
			try {
				IntBuffer intBuf = Draw3DCache.getIntBuffer(1);
				try {
					gl.glDisable(GL.GL_TEXTURE_2D);
					gl.glEnable(GL.GL_TEXTURE_1D);
					//FIXME gl.glGenTextures(intBuf); is modified as below by madhu
					gl.glGenTextures(1, intBuf);
					m_textureId = intBuf.get(0);

					gl.glBindTexture(GL.GL_TEXTURE_1D, m_textureId);
					gl.glTexParameteri(GL.GL_TEXTURE_1D,
						GL.GL_TEXTURE_WRAP_S, GL.GL_REPEAT);
					gl.glTexParameteri(GL.GL_TEXTURE_1D,
						GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
					gl.glTexParameteri(GL.GL_TEXTURE_1D,
						GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
					gl.glTexImage1D(GL.GL_TEXTURE_1D, 0,
						GL.GL_LUMINANCE_ALPHA, m_length, 0,
						GL.GL_LUMINANCE_ALPHA, GL.GL_UNSIGNED_BYTE, buffer);
				} finally {
					Draw3DCache.returnIntBuffer(intBuf);
				}
			} finally {
				gl.glPopAttrib();
				gl.glBindTexture(GL.GL_TEXTURE_1D, 0);
			}
		} finally {
			if (gc != null)
				gc.dispose();
			if (image != null)
				image.dispose();
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

		gl.glPushAttrib(GL.GL_TEXTURE_BIT);
		gl.glDisable(GL.GL_TEXTURE_2D);
		gl.glEnable(GL.GL_TEXTURE_1D);
		gl.glBindTexture(GL.GL_TEXTURE_1D, m_textureId);
		gl.glTexEnvi(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE,
			GL.GL_BLEND);
	}

	/**
	 * Deactivates this line pattern.
	 * 
	 * @throws IllegalStateException if this line pattern is disposed
	 */
	public void deactivate() {

		if (m_disposed)
			throw new IllegalStateException("line pattern is disposed");

		gl.glPopAttrib();
		gl.glBindTexture(GL.GL_TEXTURE_1D, 0);
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
				//FIXME gl.glDeleteTextures(intBuf) is modifed as below by madhu
				gl.glDeleteTextures(1, intBuf);
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
	public double getS(double i_x1, double i_y1, double i_x2, double i_y2) {

		if (m_disposed)
			throw new IllegalStateException("line pattern is disposed");

		double dX = i_x2 - i_x1;
		double dY = i_y2 - i_y1;
		double lineLength = Math.sqrt(dX * dX + dY * dY);

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
	public double getS(int i_x1, int i_y1, int i_x2, int i_y2) {

		if (m_disposed)
			throw new IllegalStateException("line pattern is disposed");

		int dX = i_x2 - i_x1;
		int dY = i_y2 - i_y1;
		double lineLength = Math.sqrt(dX * dX + dY * dY);

		return lineLength / m_length;
	}
}
