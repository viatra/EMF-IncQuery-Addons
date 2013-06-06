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
package org.eclipse.draw3d.graphics.optimizer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw3d.graphics.optimizer.classification.PrimitiveClass;
import org.eclipse.draw3d.graphics.optimizer.primitive.Primitive;
import org.eclipse.draw3d.graphics.optimizer.primitive.VertexPrimitive;

/**
 * A primitive set contains only {@link Primitive primitives} that belong to the
 * same {@link PrimitiveClass class}.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 18.11.2009
 */
public class PrimitiveSet {

	private PrimitiveSet m_parent;

	private PrimitiveClass m_primitiveClass;

	private List<Primitive> m_primitives = new LinkedList<Primitive>();

	private int m_vertexCount;

	/**
	 * Creates a new primitive set that contains only primitives that belong to
	 * the given class.
	 * 
	 * @param i_primitiveClass the class of this set
	 * @throws NullPointerException if the the given primitive class is
	 *             <code>null</code>
	 */
	public PrimitiveSet(PrimitiveClass i_primitiveClass) {

		if (i_primitiveClass == null)
			throw new NullPointerException("i_primitiveClass must not be null");

		m_primitiveClass = i_primitiveClass;
	}

	/**
	 * Creates a new primitive set that contains only primitives that belong to
	 * the given class.
	 * 
	 * @param i_parent the parent class
	 * @param i_primitiveClass the primitive class of this set
	 * @throws NullPointerException if either of the given arguments is
	 *             <code>null</code>
	 */
	protected PrimitiveSet(PrimitiveSet i_parent,
			PrimitiveClass i_primitiveClass) {

		this(i_primitiveClass);

		if (i_parent == null)
			throw new NullPointerException("i_parent must not be null");

		m_parent = i_parent;
	}

	/**
	 * Adds the given primitive to this class or one of its parents if possible.
	 * If the given primitive has the same class as this set, it is added to
	 * this set. If this set has a parent set and the given primitive does not
	 * intersect with any primitive in this set, it is added to the parent set.
	 * 
	 * @param i_primitive the primitive to add
	 * @return <code>true</code> if the given primitive was added to this set or
	 *         any of its parents and <code>false</code> otherwise
	 * @throws NullPointerException if the given primitive is <code>null</code>
	 */
	public boolean add(Primitive i_primitive) {

		if (i_primitive == null)
			throw new NullPointerException("i_primitive must not be null");

		if (!m_primitiveClass.contains(i_primitive))
			if (m_parent != null && !overlaps(i_primitive))
				return m_parent.add(i_primitive);
			else
				return false;

		m_primitives.add(i_primitive);

		if (i_primitive instanceof VertexPrimitive) {
			VertexPrimitive vertexPrimitive = (VertexPrimitive) i_primitive;
			m_vertexCount += vertexPrimitive.getVertexCount();
		}

		return true;
	}

	/**
	 * Returns the class of all the primitives in this set.
	 * 
	 * @return the primitive class
	 */
	public PrimitiveClass getPrimitiveClass() {

		return m_primitiveClass;
	}

	/**
	 * Returns an unmodifiable list containing all primitives in this set in the
	 * order in which they were added.
	 * 
	 * @return a list containing the primitives
	 */
	@SuppressWarnings("unchecked")
	public <T extends Primitive> List<T> getPrimitives() {

		return (List<T>) Collections.unmodifiableList(m_primitives);
	}

	/**
	 * Adds all parent sets and this set to the given list. The sets are added
	 * in the order of their distance from this set (furthest set first, this
	 * set last).
	 * 
	 * @param io_result the result list, if <code>null</code>, a new list will
	 *            be created
	 * @return the list
	 */
	public List<PrimitiveSet> getSets(List<PrimitiveSet> io_result) {

		List<PrimitiveSet> result = io_result;
		if (result == null)
			result = new LinkedList<PrimitiveSet>();

		if (m_parent != null)
			result = m_parent.getSets(result);

		result.add(this);
		return result;
	}

	/**
	 * Returns the number of primitives in this set.
	 * 
	 * @return the number of primitives in this set
	 */
	public int getSize() {

		return m_primitives.size();
	}

	/**
	 * Returns the number of vertices of all primitives in this set.
	 * 
	 * @return the number of vertices if applicable, <code>0</code> otherwise
	 */
	public int getVertexCount() {

		return m_vertexCount;
	}

	/**
	 * Indicates whether the given primitive intersects with any of the
	 * primitives in this set.
	 * 
	 * @param i_candidate the primitive to check
	 * @return <code>true</code> if the given primitive intersects with any of
	 *         the primitives in this set and <code>false</code> otherwise
	 */
	protected boolean overlaps(Primitive i_candidate) {

		if (i_candidate == null)
			throw new NullPointerException("i_candidate must not be null");

		for (Primitive primitive : m_primitives)
			if (primitive.intersects(i_candidate))
				return true;

		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "PrimitiveSet [class=" + m_primitiveClass + ", primitives="
			+ m_primitives.size() + "]";
	}
}
