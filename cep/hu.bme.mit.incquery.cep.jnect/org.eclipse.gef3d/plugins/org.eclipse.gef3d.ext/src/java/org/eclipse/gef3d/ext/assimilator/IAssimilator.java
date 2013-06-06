/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/

package org.eclipse.gef3d.ext.assimilator;

import org.eclipse.gef.EditPartFactory;
import org.eclipse.ui.part.EditorPart;

/**
 * Interface and some default implementations for assimilators modifying an
 * object after it was created by some factory. It is used here in conjunction
 * with {@link BorgEditPartFactory} (i.e. {@link EditPartFactory}) to modify
 * {@link EditorPart}s after construction.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 17.01.2008
 * @see BorgEditPartFactory
 */
public interface IAssimilator<T> {

	/**
	 * Superclass for assimilators matching a certain type.
	 * 
	 * @author Jens von Pilgrim
	 * @version $Revision$
	 * @since 17.01.2008
		 */
	public static abstract class TypedAssimilator<T> implements IAssimilator<T> {
		@SuppressWarnings("unchecked")
		protected Class type;

		/**
		 * @param i_type, must not be null
		 */
		@SuppressWarnings("unchecked")
		public TypedAssimilator(Class i_type) {
			if (i_type == null) {
				throw new NullPointerException(
						"Type must not be null for type assimilators");
			}
			type = i_type;
		}
		
		
	}

	/**
	 * Superclass for assimilators which can modify objects beeing an instance
	 * of a certain type.
	 * 
	 * @author Jens von Pilgrim
	 * @version $Revision$
	 * @since 17.01.2008
		 */
	public static abstract class InstanceOf<T> extends TypedAssimilator<T> {

		/**
		 * @param i_type
		 */
		@SuppressWarnings("unchecked")
		public InstanceOf(Class i_type) {
			super(i_type);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.gef3d.ext.assimilator.IPolicyAssimilator#match(java.lang.Object)
		 */
		public boolean match(T io_object) {
			return type.isInstance(io_object);
		}

	};

	/**
	 * Superclass for assimilators which can modify objects of an exact type.
	 * ExactTypeAssimilator
	 * 
	 * @author Jens von Pilgrim
	 * @version $Revision$
	 * @since 17.01.2008
		 */
	public static abstract class ExactType<T> extends TypedAssimilator<T> {

		/**
		 * @param i_type
		 */
		@SuppressWarnings("unchecked")
		public ExactType(Class i_type) {
			super(i_type);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.gef3d.ext.assimilator.IPolicyAssimilator#match(java.lang.Object)
		 */
		public boolean match(T io_object) {
			return io_object != null && io_object.getClass().equals(type);
		}

	};

	/**
	 * Returns true if and only if the assimilator can modify the given object.
	 * 
	 * @param i_object
	 * @return
	 */
	boolean match(T i_object);

	/**
	 * Modifies the given object by this assimilator. The given object must
	 * match this assimilator, i.e. {@link #match(Object)} must return true
	 * (otherwise a {@link ClassCastException} would be thrown probably). The
	 * returned value is usually the modified object, null must not be returned.
	 * 
	 * @param io_object
	 * @return the modified object or even a new object replacing the old one
	 */
	T assimilate(T io_object);
}
