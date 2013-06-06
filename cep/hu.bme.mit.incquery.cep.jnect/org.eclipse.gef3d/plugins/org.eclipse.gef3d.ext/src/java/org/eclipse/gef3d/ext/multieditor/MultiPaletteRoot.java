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

package org.eclipse.gef3d.ext.multieditor;

import java.util.logging.Level;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;

/**
 * Palette root of a multi editor, its entries are dynamically added when
 * nested editors are added. All drawers are to be identifiable via id, label
 * or at least description. When a drawer is already found in the palette, it
 * is not added twice but instead a reference counter is incremented. So, when
 * a drawer is removed, it is only removed if no more nested editors require
 * that drawer.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 15.01.2008
 */
public class MultiPaletteRoot extends PaletteRoot {

	static class ReferenceCounter<T> {
		T ref;

		int counter;

		/**
		 * @param i_ref
		 */
		public ReferenceCounter(T i_ref) {
			ref = i_ref;
			counter = 1;
		}

	}

	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(MultiPaletteRoot.class.getName());

	protected Map<String, ReferenceCounter<PaletteEntry>> m_nestedPaletteEntries;

	/**
	 * 
	 */
	public MultiPaletteRoot() {
		m_nestedPaletteEntries =
			new HashMap<String, ReferenceCounter<PaletteEntry>>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.palette.PaletteContainer#add(org.eclipse.gef.palette.PaletteEntry)
	 */
	@Override
	public void add(PaletteEntry i_entry) {

		if (i_entry instanceof PaletteContainer) {
			PaletteContainer container = (PaletteContainer) i_entry;
			boolean onlyDrawers = true;
			for (int i = 0; i < container.getChildren().size(); i++) {
				if (!(container.getChildren().get(i) instanceof PaletteDrawer)) {
					onlyDrawers = false;
					break;
				}
			}
			if (onlyDrawers) {
				for (int i = 0; i < container.getChildren().size(); i++) {
					add((PaletteEntry) container.getChildren().get(i));
				}
				return;
			}
		}

		String key = getKey(i_entry);
		if (key == null) {
			throw new IllegalArgumentException("Cannot add palette entry, " + //$NON-NLS-1$
				"no key can be calculated (need ID, Label or Descroption), " + //$NON-NLS-1$
				"entry=" + i_entry); //$NON-NLS-1$

		}
		ReferenceCounter<PaletteEntry> entry = m_nestedPaletteEntries.get(key);
		if (entry == null) {
			entry = new ReferenceCounter<PaletteEntry>(i_entry);
			super.add(i_entry);
			m_nestedPaletteEntries.put(key, entry);
			

			if (log.isLoggable(Level.INFO)) {
				log.info(String.format("entry %s newly added", key)); //$NON-NLS-1$
			}
		} else {
			entry.counter++;
			if (log.isLoggable(Level.INFO)) {
				log.info(String.format("entry %s already present, counter is %d", key, entry.counter)); //$NON-NLS-1$
			}
		}
	}

	public void remove(PaletteEntry i_entry) {
		if (i_entry instanceof PaletteContainer) {
			PaletteContainer container = (PaletteContainer) i_entry;
			boolean onlyDrawers = true;
			for (int i = 0; i < container.getChildren().size(); i++) {
				if (!(container.getChildren().get(i) instanceof PaletteDrawer)) {
					onlyDrawers = false;
					break;
				}
			}
			if (onlyDrawers) {
				for (int i = 0; i < container.getChildren().size(); i++) {
					remove((PaletteEntry) container.getChildren().get(i));
				}
				return;
			}
		}

		String key = getKey(i_entry);
		if (key == null) {
			// no exception here, entry could not have been inserted before
			return;
		}
		
		ReferenceCounter<PaletteEntry> entry = m_nestedPaletteEntries.get(key);
		if (entry != null) {
			entry.counter--;
			if (entry.counter==0) {
				m_nestedPaletteEntries.remove(key);	
				super.remove(i_entry);	
			}
		}

	}

	
	public static String getKey(PaletteEntry entry) {
		if (entry == null)
			return null;
		if (entry.getId() != null && entry.getId().length()>0)
			return "id_" + entry.getId();
		if (entry.getLabel() != null  && entry.getLabel().length()>0)
			return "label_" + entry.getLabel();
		if (entry.getDescription() != null  && entry.getDescription().length()>0)
			return "descr_" + entry.getLabel();
		return null;
	}

}
