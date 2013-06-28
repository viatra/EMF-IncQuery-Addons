/*******************************************************************************
 * Copyright (c) 2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.graphics3d.lwjgl.graphics;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.graphics.optimizer.PrimitiveSet;
import org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass;
import org.eclipse.draw3d.graphics.optimizer.primitive.ImagePrimitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.Primitive;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.ILodHelper;
import org.eclipse.draw3d.util.BufferUtils;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.draw3d.util.RectanglePacker;
import org.eclipse.draw3d.util.ImageConverter.ConversionSpecs;
import org.eclipse.draw3d.util.converter.ColorBufferInfo;
import org.eclipse.draw3d.util.converter.ImageConverter;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;

/**
 * Vertex buffer object that renders images as textures. The images are combined
 * into a single texture.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 05.01.2010
 */
public class LwjglImageVBO extends LwjglVertexPrimitiveVBO {

	private RectanglePacker<ImagePrimitive> m_packer;

	private int m_textureId;

	/**
	 * Creates a new VBO that renders the given image primites.
	 * 
	 * @param i_primitives the image primitives to render
	 */
	public LwjglImageVBO(PrimitiveSet i_primitives) {

		super(i_primitives);

		PrimitiveClass clazz = i_primitives.getPrimitiveClass();
		if (!clazz.isImage())
			throw new IllegalArgumentException(i_primitives
				+ " does not contain images");
	}

	private void addTexCoord(FloatBuffer i_buffer, int i_tw, int i_th, int i_x,
		int i_y) {

		float s = i_x / (float) i_tw;
		float t = i_y / (float) i_th;

		i_buffer.put(s);
		i_buffer.put(t);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#cleanup(Graphics3D,
	 *      ILodHelper)
	 */
	@Override
	protected void cleanup(Graphics3D i_g3d, ILodHelper i_lodContext) {

		super.cleanup(i_g3d, i_lodContext);
		GL11.glPopAttrib();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#dispose()
	 */
	@Override
	public void dispose() {

		super.dispose();

		if (m_textureId != 0) {
			IntBuffer idBuffer = Draw3DCache.getIntBuffer(1);
			try {
				idBuffer.put(0, m_textureId);
				idBuffer.rewind();
				GL11.glDeleteTextures(idBuffer);

				m_textureId = 0;
			} finally {
				Draw3DCache.returnIntBuffer(idBuffer);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#doRender(Graphics3D,
	 *      ILodHelper)
	 */
	@Override
	protected void doRender(Graphics3D i_g3d, ILodHelper i_lodContext) {

		i_g3d.glColor4f(1, 1, 1, 1);

		GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
		GL11.glDrawArrays(GL11.GL_QUADS, 0, getVertexCount());
	}

	private void drawImage(Image i_sourceImage, Rectangle i_sourceClip,
		ImageData i_targetData, Point i_targetPosition) {

		ImageData sourceData = i_sourceImage.getImageData();
		for (int y = 0; y < i_sourceClip.height; y++)
			for (int x = 0; x < i_sourceClip.width; x++) {
				int pixel =
					sourceData.getPixel(x + i_sourceClip.x, y + i_sourceClip.y);
				RGB rgb = sourceData.palette.getRGB(pixel);

				pixel = i_targetData.palette.getPixel(rgb);
				i_targetData.setPixel(i_targetPosition.x + x,
					i_targetPosition.y + y, pixel);

				int alpha = sourceData.getAlpha(x, y);
				i_targetData.setAlpha(i_targetPosition.x + x,
					i_targetPosition.y + y, alpha);
			}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#getBuffer(org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO.BufferType)
	 */
	@Override
	protected Buffer getBuffer(BufferType i_type) {

		if (i_type == BufferType.TEXTURE_COORDINATES) {

			FloatBuffer buffer =
				BufferUtils.createFloatBuffer(2 * getVertexCount());

			int tw = m_packer.getLength();
			int th = m_packer.getLength();

			Point p = Draw3DCache.getPoint();
			try {
				for (Primitive primitive : getPrimitives().getPrimitives()) {
					ImagePrimitive imagePrimitive = (ImagePrimitive) primitive;
					Rectangle s = imagePrimitive.getSource();

					m_packer.getPosition(imagePrimitive, p);

					addTexCoord(buffer, tw, th, p.x, p.y);
					addTexCoord(buffer, tw, th, p.x, p.y + s.height);
					addTexCoord(buffer, tw, th, p.x + s.width, p.y + s.height);
					addTexCoord(buffer, tw, th, p.x + s.width, p.y);
				}

				return buffer;
			} finally {
				Draw3DCache.returnPoint(p);
			}
		}

		return super.getBuffer(i_type);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#getBufferInfo(org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO.BufferType)
	 */
	@Override
	protected BufferInfo getBufferInfo(BufferType i_type) {

		if (i_type == BufferType.TEXTURE_COORDINATES)
			return new BufferInfo(GL11.GL_FLOAT, GL15.GL_STREAM_READ, 2, 0, 0);

		return super.getBufferInfo(i_type);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#hasBuffer(org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO.BufferType)
	 */
	@Override
	protected boolean hasBuffer(BufferType i_type) {

		if (i_type == BufferType.TEXTURE_COORDINATES)
			return true;

		return super.hasBuffer(i_type);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#initialize(org.eclipse.draw3d.graphics3d.Graphics3D)
	 */
	@Override
	public void initialize(Graphics3D i_g3d) {

		m_packer = new RectanglePacker<ImagePrimitive>();

		for (Primitive primitive : getPrimitives().getPrimitives()) {
			ImagePrimitive imagePrimitive = (ImagePrimitive) primitive;
			Rectangle source = imagePrimitive.getSource();

			m_packer.add(source.width, source.height, imagePrimitive);
		}

		m_packer.pack();

		Device device = Display.getCurrent();
		int tw = m_packer.getLength();
		int th = m_packer.getLength();

		ImageData textureData =
			new ImageData(tw, th, 24, new PaletteData(0xFF, 0xFF00, 0xFF0000));

		Point p = Draw3DCache.getPoint();
		try {
			for (Primitive primitive : getPrimitives().getPrimitives()) {
				ImagePrimitive imagePrimitive = (ImagePrimitive) primitive;
				Image image = imagePrimitive.getImage();
				Rectangle source = imagePrimitive.getSource();

				m_packer.getPosition(imagePrimitive, p);
				drawImage(image, source, textureData, p);
			}

			Image textureImage = new Image(device, textureData);
			m_textureId = initializeTexture(textureImage);
			textureImage.dispose();
		} finally {
			Draw3DCache.returnPoint(p);
		}

		super.initialize(i_g3d);
	}

	private int initializeTexture(Image i_texture) {

		GL11.glPushAttrib(GL11.GL_TEXTURE_BIT);
		try {
			int w = i_texture.getBounds().width;
			int h = i_texture.getBounds().height;

			ConversionSpecs specs = new ConversionSpecs();
			specs.foregroundAlpha = 255;
			specs.textureWidth = w;
			specs.textureHeight = h;
			specs.clip = new org.eclipse.swt.graphics.Rectangle(0, 0, w, h);

			ColorBufferInfo info =
				new ColorBufferInfo(w, h, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE,
					1);

			ByteBuffer buffer = Draw3DCache.getByteBuffer(info.getSize());
			IntBuffer nameBuffer = Draw3DCache.getIntBuffer(1);
			try {
				ImageConverter converter = ImageConverter.getInstance();
				buffer =
					converter.imageToBuffer(i_texture, info, buffer, false);

				nameBuffer.rewind();
				GL11.glGenTextures(nameBuffer);

				int id = nameBuffer.get(0);

				GL11.glEnable(GL11.GL_TEXTURE_2D);
				GL11.glBindTexture(GL11.GL_TEXTURE_2D, id);
				GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, w, h, 0,
					GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, buffer);

				GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
					GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
				GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
					GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
				GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
					GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
				GL11.glTexEnvi(GL11.GL_TEXTURE_ENV, GL11.GL_TEXTURE_ENV_MODE,
					GL11.GL_REPLACE);

				return id;
			} finally {
				Draw3DCache.returnIntBuffer(nameBuffer);
				Draw3DCache.returnByteBuffer(buffer);
			}
		} finally {
			GL11.glPopAttrib();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO#prepare(Graphics3D,
	 *      org.eclipse.draw3d.graphics3d.ILodHelper)
	 */
	@Override
	protected void prepare(Graphics3D i_g3d, ILodHelper i_lodContext) {

		GL11.glPushAttrib(GL11.GL_TEXTURE_BIT);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, m_textureId);

		super.prepare(i_g3d, i_lodContext);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVertexPrimitiveVBO#stateChanged(org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO.State,
	 *      org.eclipse.draw3d.graphics3d.lwjgl.graphics.LwjglVBO.State)
	 */
	@Override
	protected void stateChanged(State i_oldState, State i_newState) {

		if (i_newState == State.READY)
			m_packer = null;
	}
}
