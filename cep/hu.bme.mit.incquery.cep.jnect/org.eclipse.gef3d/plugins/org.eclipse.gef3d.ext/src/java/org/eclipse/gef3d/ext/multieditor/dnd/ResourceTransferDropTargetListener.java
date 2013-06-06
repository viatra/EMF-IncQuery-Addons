package org.eclipse.gef3d.ext.multieditor.dnd;

import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.Request;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gef3d.ext.multieditor.IMultiEditor;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.part.ResourceTransfer;

/**
 * Drop target listener to be used by a multi editor to enable opening new
 * diagrams (or models) in the editor by simply dropping a resource onto the 3D
 * scene. This listener is to be added to the viewer during configuration, i.e.
 * in {@link GraphicalEditor#configureGraphicalViewer()} just like that:
 * <p>
 * <code><pre>
 * getGraphicalViewer().addDropTargetListener(
 * 		new ResourceTransferDropTargetListener(this));
 * </pre></code>
 * </p>
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @version $Revision$
 * @since Jun 11, 2011
 * @see EditorInputTransferDropTargetListener
 */
public class ResourceTransferDropTargetListener extends
		AbstractDropOnMultiEditorTargetListener {
	/**
	 * Logger for this class
	 */
	// @SuppressWarnings("unused") //$NON-NLS-1$
	private static final Logger log = Logger.getLogger(ResourceTransferDropTargetListener.class.getName());

	/**
	 * @param i_multiEditor, viewer is retrieved via
	 *            {@link IAdaptable#getAdapter(Class)}
	 */
	public ResourceTransferDropTargetListener(IMultiEditor i_multiEditor) {
		super(i_multiEditor, ResourceTransfer.getInstance());
	}

	/**
	 * {@inheritDoc}. Creates an {@link ResourceDropRequest} and sets location
	 * of event if possible.
	 * 
	 * @see org.eclipse.gef.dnd.AbstractTransferDropTargetListener#createTargetRequest()
	 */
	@Override
	protected Request createTargetRequest() {
		ResourceDropRequest request = new ResourceDropRequest(getMultiEditor());
		DropTargetEvent event = getCurrentEvent();
		if (event != null) {
			request.setLocation(new Point(event.x, event.y));
		}
		return request;
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.gef3d.ext.multieditor.dnd.AbstractDropOnMultiEditorTargetListener#acceptEvent(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	protected int acceptEvent(DropTargetEvent i_event) {
		
		TransferData[] transferDatas = i_event.dataTypes;
		if (transferDatas==null || transferDatas.length==0) {
			return DND.DROP_NONE;
		}
		for (TransferData td: transferDatas) {
			if (! ResourceTransfer.getInstance().isSupportedType(td)) {
				return DND.DROP_NONE;
			}
		}
		return DND.DROP_COPY;
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.gef3d.ext.multieditor.dnd.AbstractDropOnMultiEditorTargetListener#retrieveEventData(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	protected boolean retrieveEventData(DropTargetEvent i_event) {
		if (! (getTargetRequest() instanceof ResourceDropRequest) ) {
			log.warning("Wrong request type " + getTargetRequest().getClass());
			return false;
		}
		ResourceDropRequest request = (ResourceDropRequest) getTargetRequest();
		
		Object data = i_event.data;
		
		if (data instanceof IResource[]) {
			request.setResources(Arrays.asList((IResource[]) data));
		} else if (data instanceof IResource) {
			request.setResources(Collections.singletonList((IResource) data));
		} else {
			return false;
		}
		return true;
	}

}