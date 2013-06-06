/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.graphics3d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manages display lists during a render operation in the current GL context.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 24.05.2008
 */
public class DisplayListManager {

	private static class DisplayList {
		private int m_id;

		private int[] m_subIds;

		public DisplayList(int i_id, Collection<Integer> i_subIds) {

			m_id = i_id;

			if (i_subIds != null && !i_subIds.isEmpty()) {
				m_subIds = new int[i_subIds.size()];

				int i = 0;
				for (Integer subId : i_subIds)
					m_subIds[i++] = subId;
			}
		}

		public int getId() {

			return m_id;
		}

		public int[] getSubIds() {

			return m_subIds;
		}
	}

	// @SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(DisplayListManager.class
		.getName());

	private static final int RANGE = 10;

	private boolean m_active = false;

	private List<Integer> m_baseIds = new ArrayList<Integer>();

	private LinkedList<LinkedList<Integer>> m_creationStack =
		new LinkedList<LinkedList<Integer>>();

	private Map<Object, DisplayList> m_displayLists =
		new HashMap<Object, DisplayList>();

	private final boolean m_disposed = false;

	private Queue<Integer> m_freeIds = new LinkedList<Integer>();

	private Graphics3D m_graphics3D;

	private int m_index = RANGE;

	/**
	 * Creates a new display list manager for the given graphics3D object.
	 * 
	 * @param i_graphics3D the graphics3D object that contains this manager
	 */
	public DisplayListManager(Graphics3D i_graphics3D) {

		if (i_graphics3D == null)
			throw new NullPointerException("i_graphics3D must not be null");

		m_graphics3D = i_graphics3D;
	}

	/**
	 * Clears all displays lists in this manager.
	 * 
	 * @throws IllegalStateException if this display list manager is disposed
	 */
	public void clear() {

		if (m_disposed)
			throw new IllegalStateException("display list manager is disposed");

		for (int baseId : m_baseIds)
			m_graphics3D.glDeleteLists(baseId, RANGE);

		m_index = RANGE;
		m_baseIds.clear();
		m_displayLists.clear();
		m_freeIds.clear();
		m_creationStack.clear();
		m_active = false;

		// log.fine("display list manager cleared");
	}

	/**
	 * Creates a new display lists with the given key. The display lists will
	 * contain the GL commands that are executed by the given runnable. If there
	 * already is a display list with the given key, it will be overwritten.
	 * 
	 * @param i_key the key of the new display list
	 * @param i_runnable the code that generates the GL commands for the display
	 *            list
	 * @throws NullPointerException if either of the given arguments is
	 *             <code>null</code>
	 * @throws IllegalStateException if this display list manager is disposed
	 */
	public void createDisplayList(Object i_key, Runnable i_runnable) {

		if (m_disposed)
			throw new IllegalStateException("display list manager is disposed");

		if (i_key == null)
			throw new NullPointerException("i_key must not be null");

		if (i_runnable == null)
			throw new NullPointerException("i_runnable must not be null");

		if (m_active)
			throw new IllegalStateException(
				"cannot create a display list while another list is being created");

		// if (log.isLoggable(Level.FINE))
		// log.fine("creating display list with key '" + i_key + "'");

		// DisplayList list = 
		doCreateDisplayList(i_key, i_runnable);

		// if (log.isLoggable(Level.FINE))
		// log.fine("display list with key '" + i_key + "' created under id "
		// + list.getId());
	}

	public void createDisplayLists(Map<Object, Runnable> i_requests) {

		if (i_requests == null)
			throw new NullPointerException("i_requests must not be null");

		if (m_active)
			throw new IllegalStateException(
				"cannot create a display list while another list is being created");

		// if (log.isLoggable(Level.FINE))
		// log.fine("creating " + i_requests.size()
		// + " display lists with keys '" + i_requests.keySet() + "'");

		for (Entry<Object, Runnable> entry : i_requests.entrySet())
			doCreateDisplayList(entry.getKey(), entry.getValue());

		// if (log.isLoggable(Level.FINE))
		// log.fine(i_requests.size() + " display lists created");
	}

	/**
	 * Disposes all ressources associated with this display list manager.
	 */
	public void dispose() {

		if (m_disposed)
			return;

		// if (log.isLoggable(Level.FINE))
		// log.info("disposing display list manager " + this);

		clear();
		m_baseIds = null;
		m_displayLists = null;
		m_creationStack = null;
	}

	private DisplayList doCreateDisplayList(Object i_key, Runnable i_runnable) {

		if (m_displayLists.containsKey(i_key))
			deleteDisplayLists(i_key);

		Integer id = getNewId();

		LinkedList<Integer> subListIds = new LinkedList<Integer>();
		subListIds.add(id);
		m_creationStack.addLast(subListIds);

		m_active = true;
		m_graphics3D.glNewList(id, Graphics3DDraw.GL_COMPILE);
		i_runnable.run();
		m_graphics3D.glEndList();
		m_active = false;

		if (subListIds.size() > 1) {
			id = getNewId();

			// if (log.isLoggable(Level.FINE))
			// log.fine("merging " + subListIds.size()
			// + " display lists with ids " + subListIds
			// + " into one list with key '" + i_key + "' and id " + id);

			m_graphics3D.glNewList(id, Graphics3DDraw.GL_COMPILE);
			for (Integer subListId : subListIds)
				m_graphics3D.glCallList(subListId);
			m_graphics3D.glEndList();
		}

		DisplayList list = new DisplayList(id, subListIds);
		m_displayLists.put(i_key, list);
		m_creationStack.removeLast();

		return list;
	}

	private void deleteDisplayList(Integer id) {

		m_graphics3D.glDeleteLists(id, 1);
		m_freeIds.offer(id);
	}

	public void deleteDisplayLists(Object... i_keys) {

		for (Object key : i_keys) {
			DisplayList list = m_displayLists.get(key);
			if (list == null)
				throw new IllegalArgumentException("list with key '"
					+ Arrays.toString(i_keys) + "' does not exist");

			// if (log.isLoggable(Level.FINE))
			// log.fine("deleting display list with key '" + key + "'");

			deleteDisplayList(list.getId());
			int[] subIds = list.getSubIds();
			if (subIds != null)
				for (int i = 0; i < subIds.length; i++)
					deleteDisplayList(subIds[i]);

			m_displayLists.remove(key);
		}
	}

	/**
	 * Executes the display list with the given key.
	 * 
	 * @param i_key the key of the display list to execute
	 * @throws NullPointerException if the given name is <code>null</code>
	 * @throws IllegalArgumentException if there is no display list with the
	 *             given name
	 * @throws IllegalStateException if the display list with the given name was
	 *             created before, but has since been discarded
	 * @throws IllegalStateException if this display list manager is disposed
	 */
	public void executeDisplayList(Object i_key) {

		if (m_disposed)
			throw new IllegalStateException("display list manager is disposed");

		if (i_key == null)
			throw new NullPointerException("i_key must not be null");

		DisplayList list = m_displayLists.get(i_key);
		if (list == null)
			throw new IllegalArgumentException("unknown display list: " + i_key);

		m_graphics3D.glCallList(list.getId());
	}

	/**
	 * Returns an unused display list ID.
	 * 
	 * @return an unused display list ID
	 * @throws IllegalStateException if this display list manager is disposed
	 */
	private int getNewId() {

		if (m_disposed)
			throw new IllegalStateException("display list manager is disposed");

		if (!m_freeIds.isEmpty())
			return m_freeIds.poll();

		if (m_index == RANGE) {
			int baseId = m_graphics3D.glGenLists(RANGE);
			m_baseIds.add(baseId);
			m_index = 0;
		}

		int baseId = m_baseIds.get(m_baseIds.size() - 1);
		return baseId + m_index++;
	}

	public void interruptDisplayList() {

		if (!m_creationStack.isEmpty()) {
			if (log.isLoggable(Level.FINE))
				log.fine("interrupting creation of display list with id "
					+ m_creationStack.getLast().getLast());
			m_graphics3D.glEndList();

			m_active = false;
		}
	}

	/**
	 * Indicates whether a number of display lists have been registered with
	 * this manager.
	 * 
	 * @param i_keys the keys of the display lists to check for
	 * @return <code>true</code> if all display lists with the given keys are
	 *         ready to use or <code>false</code> otherwise
	 * @throws IllegalStateException if this display list manager is disposed
	 */
	public boolean isDisplayList(Object... i_keys) {

		if (m_disposed)
			throw new IllegalStateException("display list manager is disposed");

		if (i_keys != null && i_keys.length > 0)
			for (Object key : i_keys)
				if (!m_displayLists.containsKey(key))
					return false;

		return true;
	}

	public void resumeDisplayList() {

		if (!m_creationStack.isEmpty()) {
			Integer id = getNewId();

			// if (log.isLoggable(Level.FINE))
			// log.fine("resuming creation of display list with id "
			// + m_creationStack.getLast().getLast() + " under new id "
			// + id);

			m_creationStack.getLast().add(id);
			m_graphics3D.glNewList(id, Graphics3DDraw.GL_COMPILE);

			m_active = true;
		}
	}

}
