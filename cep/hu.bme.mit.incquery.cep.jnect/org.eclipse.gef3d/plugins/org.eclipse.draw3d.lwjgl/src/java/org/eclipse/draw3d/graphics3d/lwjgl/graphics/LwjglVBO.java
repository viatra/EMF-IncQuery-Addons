/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
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
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.ILodHelper;
import org.eclipse.draw3d.graphics3d.RenderImage;
import org.eclipse.draw3d.util.Draw3DCache;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;

/**
 * Abstract base class for vertex buffer objects.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 21.12.2009
 */
public abstract class LwjglVBO implements RenderImage {

	protected static class BufferInfo {
		private int m_dataType;

		private int m_offset;

		private int m_size;

		private int m_stride;

		private int m_usage;

		public BufferInfo(int i_dataType, int i_usage, int i_size,
				int i_stride, int i_offset) {
			super();
			m_dataType = i_dataType;
			m_usage = i_usage;
			m_size = i_size;
			m_stride = i_stride;
			m_offset = i_offset;
		}

		public int getDataType() {
			return m_dataType;
		}

		public int getOffset() {
			return m_offset;
		}

		public int getSize() {
			return m_size;
		}

		public int getStride() {
			return m_stride;
		}

		public int getUsage() {
			return m_usage;
		}
	}

	protected enum BufferType {
		COLOR, TEXTURE_COORDINATES, VERTEX
	}

	protected enum State {
		DISPOSED, INITIAL, READY
	}

	private int m_bufferCount;

	private int m_colorBufferId;

	private BufferInfo m_colorBufferInfo;

	private State m_state = State.INITIAL;

	private int m_texCoordBufferId;

	private BufferInfo m_texCoordBufferInfo;

	private int m_vertexBufferId;

	private BufferInfo m_vertexBufferInfo;

	/**
	 * Called after this VBO was executed.
	 * 
	 * @param i_g3d the Graphics3D instance
	 */
	protected abstract void cleanup(Graphics3D i_g3d, ILodHelper i_lodContext);

	/**
	 * Disposes the ressources associated with this VBO.
	 */
	public void dispose() {

		if (getState() == State.DISPOSED)
			throw new IllegalStateException(this + " is already disposed");

		if (m_state == State.READY) {
			IntBuffer idBuffer = Draw3DCache.getIntBuffer(m_bufferCount);
			try {
				idBuffer.rewind();
				idBuffer.put(m_vertexBufferId);

				if (hasBuffer(BufferType.COLOR))
					idBuffer.put(m_colorBufferId);

				if (hasBuffer(BufferType.TEXTURE_COORDINATES))
					idBuffer.put(m_texCoordBufferId);

				idBuffer.rewind();
				GL15.glDeleteBuffers(idBuffer);

				m_vertexBufferId = 0;
				m_colorBufferId = 0;
				m_texCoordBufferId = 0;

				setState(State.DISPOSED);
			} finally {
				Draw3DCache.returnIntBuffer(idBuffer);
			}
		}
	}

	/**
	 * Executes the drawing code for this VBO.
	 * 
	 * @param i_g3d the Graphics3D instance
	 */
	protected abstract void doRender(Graphics3D i_g3d, ILodHelper i_lodContext);

	protected abstract Buffer getBuffer(BufferType i_type);

	protected abstract BufferInfo getBufferInfo(BufferType i_type);

	protected State getState() {

		return m_state;
	}

	protected void stateChanged(State i_oldState, State i_newState) {

		// nothing to do
	}

	private void setState(State i_newState) {

		State oldState = m_state;
		m_state = i_newState;

		stateChanged(oldState, i_newState);
	}

	protected abstract boolean hasBuffer(BufferType i_type);

	/**
	 * Initializes this VBO.
	 * 
	 * @param i_g3d the Graphics3D instance
	 */
	public void initialize(Graphics3D i_g3d) {

		if (getState() != State.INITIAL)
			throw new IllegalStateException(this + " was already initialized");

		Buffer vertexBuffer = getBuffer(BufferType.VERTEX);
		m_vertexBufferInfo = getBufferInfo(BufferType.VERTEX);
		m_bufferCount = 1;

		if (hasBuffer(BufferType.COLOR))
			m_bufferCount++;

		if (hasBuffer(BufferType.TEXTURE_COORDINATES))
			m_bufferCount++;

		IntBuffer idBuffer = Draw3DCache.getIntBuffer(m_bufferCount);
		try {
			idBuffer.rewind();
			GL15.glGenBuffers(idBuffer);

			idBuffer.rewind();
			m_vertexBufferId = idBuffer.get();

			uploadBuffer(m_vertexBufferId, m_vertexBufferInfo, vertexBuffer);
			vertexBuffer = null;

			if (hasBuffer(BufferType.COLOR)) {
				m_colorBufferId = idBuffer.get();

				Buffer colorBuffer = getBuffer(BufferType.COLOR);
				m_colorBufferInfo = getBufferInfo(BufferType.COLOR);

				uploadBuffer(m_colorBufferId, m_colorBufferInfo, colorBuffer);
				colorBuffer = null;
			}

			if (hasBuffer(BufferType.TEXTURE_COORDINATES)) {
				m_texCoordBufferId = idBuffer.get();

				Buffer texCoordBuffer =
					getBuffer(BufferType.TEXTURE_COORDINATES);
				m_texCoordBufferInfo =
					getBufferInfo(BufferType.TEXTURE_COORDINATES);

				uploadBuffer(m_texCoordBufferId, m_texCoordBufferInfo,
					texCoordBuffer);
				texCoordBuffer = null;
			}

			setState(State.READY);
		} finally {
			Draw3DCache.returnIntBuffer(idBuffer);
		}
	}

	/**
	 * Called before this VBO is rendered.
	 * 
	 * @param i_g3d the Graphics3D instance.
	 */
	protected abstract void prepare(Graphics3D i_g3d, ILodHelper i_lodContext);

	/**
	 * Renders this VBO.
	 * 
	 * @param i_g3d the Graphics3D instance
	 */
	public void render(Graphics3D i_g3d, ILodHelper i_lodContext) {

		if (getState() != State.READY)
			throw new IllegalStateException(this + " is not ready");

		if (hasBuffer(BufferType.COLOR)) {
			GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, m_colorBufferId);
			GL11.glEnableClientState(GL11.GL_COLOR_ARRAY);

			GL11.glColorPointer(m_colorBufferInfo.getSize(),
				m_colorBufferInfo.getDataType(), m_colorBufferInfo.getStride(),
				m_colorBufferInfo.getOffset());
		}

		if (hasBuffer(BufferType.TEXTURE_COORDINATES)) {
			GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, m_texCoordBufferId);
			GL11.glEnableClientState(GL11.GL_TEXTURE_COORD_ARRAY);

			GL11.glTexCoordPointer(m_texCoordBufferInfo.getSize(),
				m_texCoordBufferInfo.getDataType(),
				m_texCoordBufferInfo.getStride(),
				m_texCoordBufferInfo.getOffset());
		}

		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, m_vertexBufferId);
		GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);

		GL11.glVertexPointer(m_vertexBufferInfo.getSize(),
			m_vertexBufferInfo.getDataType(), m_vertexBufferInfo.getStride(),
			m_vertexBufferInfo.getOffset());

		try {
			prepare(i_g3d, i_lodContext);
			try {
				doRender(i_g3d, i_lodContext);
			} finally {
				cleanup(i_g3d, i_lodContext);
			}
		} finally {
			GL11.glDisableClientState(GL11.GL_VERTEX_ARRAY);

			if (hasBuffer(BufferType.TEXTURE_COORDINATES))
				GL11.glDisableClientState(GL11.GL_TEXTURE_COORD_ARRAY);

			if (hasBuffer(BufferType.COLOR))
				GL11.glDisableClientState(GL11.GL_COLOR_ARRAY);
		}
	}

	private void uploadBuffer(int i_id, BufferInfo i_info, Buffer i_buffer) {

		i_buffer.rewind();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, i_id);

		switch (i_info.getDataType()) {
		case GL11.GL_BYTE:
		case GL11.GL_UNSIGNED_BYTE:
			GL15.glBufferData(GL15.GL_ARRAY_BUFFER, (ByteBuffer) i_buffer,
				i_info.getUsage());
			break;
		case GL11.GL_SHORT:
		case GL11.GL_UNSIGNED_SHORT:
			GL15.glBufferData(GL15.GL_ARRAY_BUFFER, (ShortBuffer) i_buffer,
				i_info.getUsage());
			break;
		case GL11.GL_INT:
		case GL11.GL_UNSIGNED_INT:
			GL15.glBufferData(GL15.GL_ARRAY_BUFFER, (IntBuffer) i_buffer,
				i_info.getUsage());
			break;
		case GL11.GL_FLOAT:
			GL15.glBufferData(GL15.GL_ARRAY_BUFFER, (FloatBuffer) i_buffer,
				i_info.getUsage());
			break;
		case GL11.GL_DOUBLE:
			GL15.glBufferData(GL15.GL_ARRAY_BUFFER, (DoubleBuffer) i_buffer,
				i_info.getUsage());
			break;

		default:
			throw new IllegalArgumentException("unknown buffer data type: "
				+ i_info.getDataType());
		}

	}
}
