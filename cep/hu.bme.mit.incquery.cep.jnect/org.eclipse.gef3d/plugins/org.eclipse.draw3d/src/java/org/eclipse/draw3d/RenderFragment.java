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
package org.eclipse.draw3d;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A render fragment is an object that can render itself. Render fragments are
 * collected during painting of figures, are then ordered so that they are
 * rendered in the following order:
 * <ol>
 * <li>opaque fragments, unordered</li>
 * <li>transparent fragments, ordered by their distance to the camera, decending
 * </li>
 * <li>superimposed fragments, ordered by their distance to the camera,
 * descending</li>
 * </ol>
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 15.08.2009
 */
public interface RenderFragment {

	/**
	 * Enumerates the possible render types.
	 * 
	 * @author Kristian Duske
	 * @version $Revision$
	 * @since 16.08.2009
	 */
	public enum RenderType {
		/**
		 * Ignore - fragments with this type are not rendered at all.
		 */
		IGNORE,
		/**
		 * Fragments with this type are rendered opaque.
		 */
		OPAQUE,
		/**
		 * Fragments with this type are superimposed on top of fragments with
		 * any other type.
		 */
		SUPERIMPOSED,
		/**
		 * Fragments with this type are rendered with transparency.
		 */
		TRANSPARENT;

		/**
		 * Sorts render fragments by their depth measure. The depth measure is
		 * cached because calculating it may be expensive, so do not reuse
		 * instances of this.
		 * 
		 * @author Kristian Duske
		 * @version $Revision$
		 * @since 16.08.2009
		 */
		private static class FragmentComparator implements
				Comparator<RenderFragment> {

			private Map<RenderFragment, Float> m_cache =
				new HashMap<RenderFragment, Float>();

			private RenderContext m_renderContext;

			public FragmentComparator(RenderContext i_renderContext) {

				m_renderContext = i_renderContext;
			}

			public int compare(RenderFragment i_f1, RenderFragment i_f2) {

				float d1 = getDistanceMeasure(i_f1);
				float d2 = getDistanceMeasure(i_f2);

				return Float.compare(d2, d1);
			}

			private float getDistanceMeasure(RenderFragment i_f) {

				if (m_cache.containsKey(i_f))
					return m_cache.get(i_f);

				float d = i_f.getDistanceMeasure(m_renderContext);
				m_cache.put(i_f, d);

				return d;
			}
		}

		/**
		 * Returns the render type for a fragment with the given attributes.
		 * 
		 * @param i_alpha the alpha value of the fragment
		 * @param i_superimposed the superimposed flag of the fragment
		 * @return the render type for the fragment
		 */
		public static RenderType getRenderType(int i_alpha,
			boolean i_superimposed) {

			if (i_superimposed)
				return SUPERIMPOSED;

			if (i_alpha < 0xFF)
				return TRANSPARENT;

			return OPAQUE;
		}

		/**
		 * Orders the given fragments according to the render type, which must
		 * be the same for all fragments in the given list.
		 * <ol>
		 * <li>Fragments of type {@link #OPAQUE} or {@link #IGNORE} are not
		 * ordered at all.</li>
		 * <li>Fragments of type {@link #TRANSPARENT} or {@link #SUPERIMPOSED}
		 * are ordered by their depth measure, ascending.</li>
		 * </ol>
		 * 
		 * @param i_renderContext the current render context
		 * @param i_fragments the fragments to sort
		 * @throws NullPointerException if any of the given arguments is
		 *             <code>null</code>
		 */
		public void orderFragments(RenderContext i_renderContext,
			List<RenderFragment> i_fragments) {

			if (i_renderContext == null)
				throw new NullPointerException(
					"i_renderContext must not be null");

			if (i_fragments == null)
				throw new NullPointerException("i_fragments must not be null");

			switch (this) {
			case OPAQUE:
			case IGNORE:
				return;
			case TRANSPARENT:
			case SUPERIMPOSED:
				Collections.sort(i_fragments, new FragmentComparator(
					i_renderContext));
			}
		}
	}

	/**
	 * Returns the a measure for the distance between the view point and this
	 * fragment. This does not have to be the actual distance, but can also be a
	 * function of the distance. You have to make sure however that all
	 * fragments use the same function. The builtin shapes use the square of the
	 * distance.
	 * 
	 * @param i_renderContext the current render context
	 * @return the render context
	 */
	public float getDistanceMeasure(RenderContext i_renderContext);

	/**
	 * Returns the render type of this fragment.
	 * 
	 * @return the render type of this fragment
	 */
	public RenderType getRenderType();

	/**
	 * Actually renders this fragment.
	 * 
	 * @param i_renderContext the current render context
	 */
	public void render(RenderContext i_renderContext);
}
