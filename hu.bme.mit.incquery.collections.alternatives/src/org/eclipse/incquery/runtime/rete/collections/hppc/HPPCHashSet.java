/*******************************************************************************
 * Copyright (c) 2010-2013, istvanrath, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   istvanrath - initial API and implementation
 *******************************************************************************/
package org.eclipse.incquery.runtime.rete.collections.hppc;


import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import com.carrotsearch.hppc.ObjectOpenHashSet;
import com.carrotsearch.hppc.cursors.ObjectCursor;

/**
 * @author istvanrath
 * 
 */
public class HPPCHashSet<E> implements Set<E> {

    ObjectOpenHashSet<E> internal = new ObjectOpenHashSet<E>();

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Set#add(java.lang.Object)
     */
    @Override
    public boolean add(E e) {
        return internal.add(e);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Set#addAll(java.util.Collection)
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean r=true;
        for (E e: c) {
            r&=internal.add(e);
        }
        return r;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Set#clear()
     */
    @Override
    public void clear() {
        internal.clear();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Set#contains(java.lang.Object)
     */
    @Override
    public boolean contains(Object o) {
        return internal.contains((E)o);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Set#containsAll(java.util.Collection)
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        boolean r=true;
        for (Object e: c) {
            r&=internal.contains((E)e);
        }
        return r;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Set#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return internal.isEmpty();
    }

    class HPPCIterator<I> implements Iterator<I> {

        Iterator<ObjectCursor<I>> _it;
        
        /**
         * 
         */
        public HPPCIterator(Iterator<ObjectCursor<I>> it) {
            _it=it;
        }
        
        /* (non-Javadoc)
         * @see java.util.Iterator#hasNext()
         */
        @Override
        public boolean hasNext() {
            return _it.hasNext();
        }

        /* (non-Javadoc)
         * @see java.util.Iterator#next()
         */
        @Override
        public I next() {
            return _it.next().value;
        }

        /* (non-Javadoc)
         * @see java.util.Iterator#remove()
         */
        @Override
        public void remove() {
            _it.remove();
        }
        
    }
    
    
    /*
     * (non-Javadoc)
     * 
     * @see java.util.Set#iterator()
     */
    @Override
    public Iterator<E> iterator() {
        return new HPPCIterator<E>(internal.iterator());
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Set#remove(java.lang.Object)
     */
    @Override
    public boolean remove(Object o) {
        return internal.remove((E)o);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Set#removeAll(java.util.Collection)
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean r=true;
        for (Object e: c) {
            r&=internal.remove((E)e);
        }
        return r;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Set#retainAll(java.util.Collection)
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        ObjectOpenHashSet<E> n = new ObjectOpenHashSet<E>();
        boolean r=true;
        for (Object e: c) {
            if (internal.contains((E)e)) {
                r&=n.add((E)e);
            }
        }
        internal=n;
        return r;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Set#size()
     */
    @Override
    public int size() {
        return internal.size();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Set#toArray()
     */
    @Override
    public Object[] toArray() {
        return internal.toArray();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Set#toArray(T[])
     */
    @Override
    public <T> T[] toArray(T[] a) {
        return (T[])internal.toArray();
    }

}
