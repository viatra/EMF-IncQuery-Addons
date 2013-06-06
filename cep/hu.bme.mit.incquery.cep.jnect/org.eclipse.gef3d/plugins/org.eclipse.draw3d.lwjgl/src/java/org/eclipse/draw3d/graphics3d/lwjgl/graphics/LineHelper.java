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

import java.nio.FloatBuffer;

import org.eclipse.draw3d.graphics.optimizer.primitive.OutlineRenderRule;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.swt.SWT;
import org.lwjgl.opengl.GL11;

/**
 * LineHelper There should really be more documentation here.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 12.01.2010
 */
public class LineHelper {

	private float m_lineWidth;

	private int m_lineStyle;

	private int[] m_lineDash;

	private LwjglLinePattern m_linePattern;

	private int m_vertexLength;

	private int m_coordOffset;

	public boolean isTextured() {

		return m_lineStyle == SWT.LINE_CUSTOM;
	}

	public LineHelper(OutlineRenderRule i_renderRule) {

		m_lineWidth = i_renderRule.getLineWidth();
		m_lineStyle = i_renderRule.getLineStyle();

		if (isTextured())
			throw new IllegalArgumentException(
				"must set vertex length and offset for custom line patterns");
	}

	public LineHelper(OutlineRenderRule i_renderRule, int i_vertexLength,
			int i_coordOffset) {

		m_lineWidth = i_renderRule.getLineWidth();
		m_lineStyle = i_renderRule.getLineStyle();
		m_lineDash = i_renderRule.getLineDash();

		if (isTextured() && m_lineDash == null)
			throw new IllegalArgumentException(
				"cannot create custom line pattern without a dash pattern");
	}

	public void addTextureCoordinate(float i_x1, float i_y1, float i_x2,
		float i_y2, FloatBuffer i_buffer) {

		if (!isTextured())
			return;

		if (i_buffer == null)
			throw new NullPointerException("i_buffer must not be null");

		i_buffer.put(m_linePattern.getS(i_x1, i_y1, i_x2, i_y2));
	}

	public void initialize(Graphics3D i_g3d) {

		if (isTextured()) {
			m_linePattern =
				new LwjglLinePattern(m_lineDash, i_g3d.getDisplayListManager());
			m_lineDash = null;
		}
	}

	public void dispose() {

		if (m_linePattern != null) {
			m_linePattern.dispose();
			m_linePattern = null;
		}
	}

	public void prepare(Graphics3D i_g3d) {

		switch (m_lineStyle) {
		case SWT.LINE_DASH:
			GL11.glEnable(GL11.GL_LINE_STIPPLE);
			GL11.glLineStipple(3, (short) 0x3F3F);
			break;
		case SWT.LINE_DOT:
			GL11.glEnable(GL11.GL_LINE_STIPPLE);
			GL11.glLineStipple(3, (short) 0x3333);
			break;
		case SWT.LINE_DASHDOT:
			GL11.glEnable(GL11.GL_LINE_STIPPLE);
			GL11.glLineStipple(3, (short) 0x6F6F);
			break;
		case SWT.LINE_DASHDOTDOT:
			GL11.glEnable(GL11.GL_LINE_STIPPLE);
			GL11.glLineStipple(3, (short) 0x5757);
			break;
		case SWT.LINE_CUSTOM:
			m_linePattern.activate();
			GL11.glEnableClientState(GL11.GL_TEXTURE_COORD_ARRAY);
			GL11.glTexCoordPointer(1, GL11.GL_FLOAT, m_vertexLength,
				m_coordOffset * 4);
			break;
		}

		GL11.glLineWidth(m_lineWidth);
	}

	public void cleanup(Graphics3D i_g3d) {

		switch (m_lineStyle) {
		case SWT.LINE_DASH:
		case SWT.LINE_DOT:
		case SWT.LINE_DASHDOT:
		case SWT.LINE_DASHDOTDOT:
			GL11.glDisable(GL11.GL_LINE_STIPPLE);
			break;
		case SWT.LINE_CUSTOM:
			GL11.glDisableClientState(GL11.GL_TEXTURE_COORD_ARRAY);
			m_linePattern.deactivate();
			break;
		}
	}

}
