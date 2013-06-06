/*******************************************************************************
 * Copyright (c) 2010 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.gef3d.ext.multieditor;

/**
 * Event sent to {@link IMultiEditorListener}s by {@link IMultiEditor} when
 * editors were newly nested or removed.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 4, 2010
 */
public class MultiEditorChangeEvent {

	public static enum Type {
		added, removed
	}

	protected IMultiEditor multiEditor;

	protected INestableEditor nestedEditor;

	protected Object content;

	protected Type eventType;

	/**
	 * @param i_multiEditor
	 * @param i_nestedEditor
	 * @param i_content
	 * @param i_eventType
	 */
	public MultiEditorChangeEvent(IMultiEditor i_multiEditor,
			INestableEditor i_nestedEditor, Object i_content, Type i_eventType) {
		super();
		multiEditor = i_multiEditor;
		nestedEditor = i_nestedEditor;
		content = i_content;
		eventType = i_eventType;
	}

	/**
	 * @return the multiEditor
	 */
	public IMultiEditor getMultiEditor() {
		return multiEditor;
	}

	/**
	 * @return the nestedEditor
	 */
	public INestableEditor getNestedEditor() {
		return nestedEditor;
	}

	/**
	 * @return the content
	 */
	public Object getContent() {
		return content;
	}

	/**
	 * @return the eventType
	 */
	public Type getEventType() {
		return eventType;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MultiEditorChangeEvent [content=").append(content)
			.append(", eventType=").append(eventType).append(", multiEditor=")
			.append(multiEditor).append(", nestedEditor=").append(nestedEditor)
			.append("]");
		return builder.toString();
	}

}
