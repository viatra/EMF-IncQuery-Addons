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

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.collections.CollectionsFactory;

import com.carrotsearch.hppc.ObjectObjectOpenHashMap;
import com.carrotsearch.hppc.cursors.ObjectObjectCursor;

/**
 * @author istvanrath
 * WORK IN PROGRESS - doesn't work yet.
 */
public class HPPCHashMap<K, V> implements Map<K, V> {

    ObjectObjectOpenHashMap<K, V> internal = new ObjectObjectOpenHashMap<K, V>();

    
    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#values()
     */
    @Override
    public Collection<V> values() {
        return Arrays.asList(internal.values);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#entrySet()
     */
    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        //HPPCHashSet<java.util.Map.Entry<K, V>> r = new HPPCHashSet<Map.Entry<K,V>>();
        Set<java.util.Map.Entry<K, V>> r = CollectionsFactory.getSet();
        Iterator<ObjectObjectCursor<K,V>> it = internal.iterator();
        while (it.hasNext()) {
            final ObjectObjectCursor<K, V> c = it.next();
            r.add(new Entry<K, V>() {

                @Override
                public K getKey() {
                    return c.key;
                }

                @Override
                public V getValue() {
                    return c.value;
                }

                @Override
                public V setValue(V value) {
                    System.out.println("Unsupported entrySet::entry::setValue() called on HPPCHashMap");
                    return value;
                }
                
            });
        }
        return r;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#keySet()
     */
    @Override
    public Set<K> keySet() {
        Set<K> r = CollectionsFactory.getSet();
        for (K k : internal.keys) {
            r.add(k);
        }
        return r;
    }
    
    
    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#clear()
     */
    @Override
    public void clear() {
        internal.clear();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#containsKey(java.lang.Object)
     */
    @Override
    public boolean containsKey(Object key) {
        return internal.containsKey((K) key);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#containsValue(java.lang.Object)
     */
    @Override
    public boolean containsValue(Object value) {
        return internal.values().contains((V) value);
    }



    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#get(java.lang.Object)
     */
    @Override
    public V get(Object key) {
        return internal.get((K) key);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return internal.isEmpty();
    }



    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#put(java.lang.Object, java.lang.Object)
     */
    @Override
    public V put(K key, V value) {
        return internal.put((K) key, (V) value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#putAll(java.util.Map)
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Object k : m.keySet()) {
            internal.put((K)k, m.get(k));
        }
        /*
        for (java.util.Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
            internal.put(e.getKey(), e.getValue());
        }
        */
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#remove(java.lang.Object)
     */
    @Override
    public V remove(Object key) {
        return internal.remove((K) key);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#size()
     */
    @Override
    public int size() {
        return internal.size();
    }



}
