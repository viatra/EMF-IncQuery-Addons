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

import java.util.Arrays;

import org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass;
import org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClassifier;
import org.eclipse.draw3d.graphics.optimizer.primitive.GradientRenderRule;
import org.eclipse.draw3d.graphics.optimizer.primitive.ImageRenderRule;
import org.eclipse.draw3d.graphics.optimizer.primitive.LinePrimitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.OutlineRenderRule;
import org.eclipse.draw3d.graphics.optimizer.primitive.PolygonPrimitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.PolylinePrimitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.Primitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.QuadPrimitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.RenderRule;
import org.eclipse.draw3d.graphics.optimizer.primitive.SolidRenderRule;
import org.eclipse.draw3d.graphics.optimizer.primitive.TextRenderRule;

/**
 * Classifies primitives according to their Java class and their render rule. A
 * primitive is considered to be contained in a class if the primitive's Java
 * type is the same or a sub type of the type defined in the primitive class and
 * if the class's render rule is equal to the primitive's render rule.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 27.12.2009
 */
public class LwjglPrimitiveClassifier implements PrimitiveClassifier {

	private static class LwjglPrimitiveClass implements PrimitiveClass {

		private Class<? extends Primitive> m_primitiveType;

		private RenderRule m_renderRule;

		public LwjglPrimitiveClass(Class<? extends Primitive> i_primitiveType,
				RenderRule i_renderRule) {

			m_primitiveType = i_primitiveType;
			m_renderRule = i_renderRule;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass#contains(org.eclipse.draw3d.graphics.optimizer.primitive.Primitive)
		 */
		public boolean contains(Primitive i_primitive) {

			if (!m_primitiveType.isAssignableFrom(i_primitive.getClass()))
				return false;

			return equals(m_renderRule, i_primitive.getRenderRule());
		}

		private boolean equals(RenderRule i_rule1, RenderRule i_rule2) {

			if (i_rule1 instanceof OutlineRenderRule) {
				if (!(i_rule2 instanceof OutlineRenderRule))
					return false;

				OutlineRenderRule outline1 = (OutlineRenderRule) i_rule1;
				OutlineRenderRule outline2 = (OutlineRenderRule) i_rule2;

				if (outline1.getAlpha() != outline2.getAlpha())
					return false;

				if (!outline1.getColor().equals(outline2.getColor()))
					return false;

				// if (outline1.getLineCap() != outline2.getLineCap()) return
				// false;

				if (!Arrays.equals(outline1.getLineDash(),
					outline1.getLineDash()))
					return false;

				// if (outline1.getLineJoin() != outline2.getLineJoin()) return
				// false;

				if (outline1.getLineStyle() != outline2.getLineStyle())
					return false;

				if (outline1.getLineWidth() != outline2.getLineWidth())
					return false;
			} else if (i_rule1 instanceof SolidRenderRule) {
				if (!(i_rule2 instanceof SolidRenderRule))
					return false;

				SolidRenderRule solid1 = (SolidRenderRule) i_rule1;
				SolidRenderRule solid2 = (SolidRenderRule) i_rule2;

				if (solid1.getAlpha() != solid2.getAlpha())
					return false;

				if (!solid1.getColor().equals(solid2.getColor()))
					return false;

				if (solid1.getFillRule() != solid2.getFillRule())
					return false;

				if (solid1.isXorMode() != solid2.isXorMode())
					return false;
			} else if (i_rule1 instanceof GradientRenderRule) {
				if (!(i_rule2 instanceof GradientRenderRule))
					return false;

				GradientRenderRule gradient1 = (GradientRenderRule) i_rule1;
				GradientRenderRule gradient2 = (GradientRenderRule) i_rule2;

				if (gradient1.getAlpha() != gradient2.getAlpha())
					return false;

				if (gradient1.getFillRule() != gradient2.getFillRule())
					return false;

				if (!gradient1.getFromColor().equals(gradient2.getFromColor()))
					return false;

				if (!gradient1.getToColor().equals(gradient2.getToColor()))
					return false;

				if (gradient1.isXorMode() != gradient2.isXorMode())
					return false;
			} else if (i_rule1 instanceof ImageRenderRule) {
				if (!(i_rule2 instanceof ImageRenderRule))
					return false;

				ImageRenderRule image1 = (ImageRenderRule) i_rule1;
				ImageRenderRule image2 = (ImageRenderRule) i_rule2;

				if (image1.getAlpha() != image2.getAlpha())
					return false;
			} else if (i_rule1 instanceof TextRenderRule) {
				if (!(i_rule2 instanceof TextRenderRule))
					return false;

				TextRenderRule text1 = (TextRenderRule) i_rule1;
				TextRenderRule text2 = (TextRenderRule) i_rule2;

				if (text1.getAlpha() != text1.getAlpha())
					return false;

				if (!text1.getFont().equals(text2.getFont()))
					return false;

				if (!text1.getTextColor().equals(text2.getTextColor()))
					return false;
			}

			return true;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass#getRenderRule()
		 */
		public RenderRule getRenderRule() {

			return m_renderRule;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass#isGradient()
		 */
		public boolean isGradient() {

			return m_renderRule.isGradient();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass#isImage()
		 */
		public boolean isImage() {

			return m_renderRule.isImage();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass#isLine()
		 */
		public boolean isLine() {

			return LinePrimitive.class.isAssignableFrom(m_primitiveType);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass#isOutline()
		 */
		public boolean isOutline() {

			return m_renderRule.isOutline();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass#isPolygon()
		 */
		public boolean isPolygon() {

			return PolygonPrimitive.class.isAssignableFrom(m_primitiveType);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass#isPolyline()
		 */
		public boolean isPolyline() {

			return PolylinePrimitive.class.isAssignableFrom(m_primitiveType);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass#isQuad()
		 */
		public boolean isQuad() {

			return QuadPrimitive.class.isAssignableFrom(m_primitiveType);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass#isSolid()
		 */
		public boolean isSolid() {

			return m_renderRule.isSolid();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass#isText()
		 */
		public boolean isText() {

			return m_renderRule.isText();
		}

		@Override
		public String toString() {
			return "PrimitiveClassImpl [m_primitiveClass=" + m_primitiveType
				+ ", m_renderRule=" + m_renderRule + "]";
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClassifier#classify(org.eclipse.draw3d.graphics.optimizer.primitive.Primitive)
	 */
	public PrimitiveClass classify(Primitive i_primitive) {

		Class<? extends Primitive> clazz = i_primitive.getClass();
		RenderRule renderRule = i_primitive.getRenderRule();

		return new LwjglPrimitiveClass(clazz, renderRule);
	}
}
