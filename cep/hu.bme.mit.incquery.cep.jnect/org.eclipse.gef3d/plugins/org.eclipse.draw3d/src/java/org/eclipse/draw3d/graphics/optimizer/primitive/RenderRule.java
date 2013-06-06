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
package org.eclipse.draw3d.graphics.optimizer.primitive;

/**
 * A render rule determines how a {@link Primitive primitive} should be
 * rendered.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 23.12.2009
 */
public interface RenderRule {

	/**
	 * Casts this render rule to {@link GradientRenderRule} and returns it.
	 * 
	 * @return this render rule
	 * @throws UnsupportedOperationException if this render rule cannot be cast
	 *             to {@link GradientRenderRule}
	 */
	public GradientRenderRule asGradient();

	/**
	 * Casts this render rule to {@link ImageRenderRule} and returns it.
	 * 
	 * @return this render rule
	 * @throws UnsupportedOperationException if this render rule cannot be cast
	 *             to {@link ImageRenderRule}
	 */
	public ImageRenderRule asImage();

	/**
	 * Casts this render rule to {@link OutlineRenderRule} and returns it.
	 * 
	 * @return this render rule
	 * @throws UnsupportedOperationException if this render rule cannot be cast
	 *             to {@link OutlineRenderRule}
	 */
	public OutlineRenderRule asOutline();

	/**
	 * Casts this render rule to {@link SolidRenderRule} and returns it.
	 * 
	 * @return this render rule
	 * @throws UnsupportedOperationException if this render rule cannot be cast
	 *             to {@link SolidRenderRule}
	 */
	public SolidRenderRule asSolid();

	/**
	 * Casts this render rule to {@link TextRenderRule} and returns it.
	 * 
	 * @return this render rule
	 * @throws UnsupportedOperationException if this render rule cannot be cast
	 *             to {@link TextRenderRule}
	 */
	public TextRenderRule asText();

	/**
	 * Indicates whether the primitive(s) should be rendered as a solid
	 * gradient.
	 * 
	 * @return <code>true</code> if the primitive(s) should be rendered as a
	 *         solid gradient and <code>false</code> otherwise
	 */
	public boolean isGradient();

	/**
	 * Indicates whether the primitive(s) should be rendered as an image.
	 * 
	 * @return <code>true</code> if the primitive(s) should be rendered as an
	 *         image and <code>false</code> otherwise
	 */
	public boolean isImage();

	/**
	 * Indicates whether the primitive(s) should be rendered as an outline.
	 * 
	 * @return <code>true</code> if the primitive(s) should be rendered as an
	 *         outline and <code>false</code> otherwise
	 */
	public boolean isOutline();

	/**
	 * Indicates whether the primitive(s) should be rendered as solid.
	 * 
	 * @return <code>true</code> if the primitive(s) should be rendered as solid
	 *         and <code>false</code> otherwise
	 */
	public boolean isSolid();

	/**
	 * Indicates whether the primitive(s) should be rendered as text.
	 * 
	 * @return <code>true</code> if the primitive(s) should be rendered as text
	 *         and <code>false</code> otherwise
	 */
	public boolean isText();
}
