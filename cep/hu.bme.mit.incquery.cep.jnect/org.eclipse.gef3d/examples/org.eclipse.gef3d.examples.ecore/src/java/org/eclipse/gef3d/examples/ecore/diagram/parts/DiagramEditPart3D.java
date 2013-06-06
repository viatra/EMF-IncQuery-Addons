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
package org.eclipse.gef3d.examples.ecore.diagram.parts;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.Figure3D;
import org.eclipse.draw3d.IFigure3D;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClass2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataType2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataTypeEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnum2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnumEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EPackage2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EPackageEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EReferenceEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.policies.EPackageCanonicalEditPolicy;
import org.eclipse.emf.ecoretools.diagram.edit.policies.EcoretoolsEditPolicyRoles;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramUpdater;
import org.eclipse.emf.ecoretools.diagram.part.EcoreLinkDescriptor;
import org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gef.tools.DeselectAllTracker;
import org.eclipse.gef3d.gmf.runtime.diagram.ui.figures.DiagramFigure3D;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/**
 * 3D plane for displaying ecore diagrams in 3D, 3D version of
 * {@link DiagramEditPart}. Plane is automatically resized to fit its content.
 * <p>
 * This edit part keeps model and diagram partially synchronized, i.e. nodes are
 * created if new classes, enumerations or data types are created.
 * </p>
 * 
 * @todo sync feature should be configurable via properties or preferences
 *       (however, this is an Ecore Tools problem)
 * @see http://www.eclipse.org/forums/index.php?t=msg&th=168993&start=0&
 * @author Kristian Duske
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 02.09.2009
 */
@SuppressWarnings({ "restriction", "unchecked", "rawtypes" })
public class DiagramEditPart3D extends EPackageEditPart { // DiagramEditPart {

	/**
	 * Policy for reflecting semantic model changes, extends base class in order
	 * to actually reflect these changes.
	 * 
	 * Most of this code is copied from {@link EPackageCanonicalEditPolicy},
	 * however the functions to update semantic model changes are activated 
	 * here.
	 *
	 * @author 	Jens von Pilgrim
	 * @version	$Revision$
	 * @since 	Oct 30, 2010
	 */	
	private final class EPackageCanonicalEditPolicySemanticUpdater extends
			EPackageCanonicalEditPolicy {
		/**
		 * 
		 */
		EPackageCanonicalEditPolicySemanticUpdater() {
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.ecoretools.diagram.edit.policies.EPackageCanonicalEditPolicy#refreshSemantic()
		 */
		
		@Override
		protected void refreshSemantic() {
			// delete orphans and update connections
			deleteOrphanedViews();
			
			// create views for newly added children
			List<IAdaptable> createdViews = refreshSemanticChildren();
			
			List createdConnectionViews = new LinkedList();
			createdConnectionViews.addAll(refreshSemanticConnections());
			createdConnectionViews.addAll(refreshConnections());
			makeViewsImmutable(createdConnectionViews);
			makeViewsImmutable(createdViews);
		}
		
		/**
		 * {@inheritDoc}
		 * 
		 * @see <a
		 *      href="http://www.eclipse.org/forums/index.php?t=msg&&th=162860&goto=515348#msg_515348">Sven
		 *      Krause: Re: Synchronize semantic and notation
		 *      information on editor start</a>
		 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#getFactoryHint(org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected String getFactoryHint(IAdaptable elementAdapter) {
			CanonicalElementAdapter element =
				(CanonicalElementAdapter) elementAdapter;
			int visualID =
				EcoreVisualIDRegistry.getNodeVisualID((View) getHost()
					.getModel(), (EObject) element.getRealObject());
			return EcoreVisualIDRegistry.getType(visualID);
		}
		
		/**
		 * @generated
		 */
		private Collection collectAllLinks(View view, Map domain2NotationMap) {
			if (!EPackageEditPart.MODEL_ID.equals(EcoreVisualIDRegistry.getModelID(view))) {
				return Collections.EMPTY_LIST;
			}
			Collection result = new LinkedList();
			switch (EcoreVisualIDRegistry.getVisualID(view)) {
			case EPackageEditPart.VISUAL_ID: {
				if (!domain2NotationMap.containsKey(view.getElement())) {
					result.addAll(EcoreDiagramUpdater.getEPackage_79ContainedLinks(view));
				}
				if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
					domain2NotationMap.put(view.getElement(), view);
				}
				break;
			}
			case EClassEditPart.VISUAL_ID: {
				if (!domain2NotationMap.containsKey(view.getElement())) {
					result.addAll(EcoreDiagramUpdater.getEClass_1001ContainedLinks(view));
				}
				if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
					domain2NotationMap.put(view.getElement(), view);
				}
				break;
			}
			case EPackage2EditPart.VISUAL_ID: {
				if (!domain2NotationMap.containsKey(view.getElement())) {
					result.addAll(EcoreDiagramUpdater.getEPackage_1002ContainedLinks(view));
				}
				if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
					domain2NotationMap.put(view.getElement(), view);
				}
				break;
			}
			case EAnnotationEditPart.VISUAL_ID: {
				if (!domain2NotationMap.containsKey(view.getElement())) {
					result.addAll(EcoreDiagramUpdater.getEAnnotation_1003ContainedLinks(view));
				}
				if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
					domain2NotationMap.put(view.getElement(), view);
				}
				break;
			}
			case EDataTypeEditPart.VISUAL_ID: {
				if (!domain2NotationMap.containsKey(view.getElement())) {
					result.addAll(EcoreDiagramUpdater.getEDataType_1004ContainedLinks(view));
				}
				if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
					domain2NotationMap.put(view.getElement(), view);
				}
				break;
			}
			case EEnumEditPart.VISUAL_ID: {
				if (!domain2NotationMap.containsKey(view.getElement())) {
					result.addAll(EcoreDiagramUpdater.getEEnum_1005ContainedLinks(view));
				}
				if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
					domain2NotationMap.put(view.getElement(), view);
				}
				break;
			}
			case EClass2EditPart.VISUAL_ID: {
				if (!domain2NotationMap.containsKey(view.getElement())) {
					result.addAll(EcoreDiagramUpdater.getEClass_2003ContainedLinks(view));
				}
				if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
					domain2NotationMap.put(view.getElement(), view);
				}
				break;
			}
			case EDataType2EditPart.VISUAL_ID: {
				if (!domain2NotationMap.containsKey(view.getElement())) {
					result.addAll(EcoreDiagramUpdater.getEDataType_2004ContainedLinks(view));
				}
				if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
					domain2NotationMap.put(view.getElement(), view);
				}
				break;
			}
			case EEnum2EditPart.VISUAL_ID: {
				if (!domain2NotationMap.containsKey(view.getElement())) {
					result.addAll(EcoreDiagramUpdater.getEEnum_2005ContainedLinks(view));
				}
				if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
					domain2NotationMap.put(view.getElement(), view);
				}
				break;
			}
			case EReferenceEditPart.VISUAL_ID: {
				if (!domain2NotationMap.containsKey(view.getElement())) {
					result.addAll(EcoreDiagramUpdater.getEReference_3002ContainedLinks(view));
				}
				if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
					domain2NotationMap.put(view.getElement(), view);
				}
				break;
			}
			}
			for (@SuppressWarnings("hiding")
			Iterator children = view.getChildren().iterator(); children.hasNext();) {
				result.addAll(collectAllLinks((View) children.next(), domain2NotationMap));
			}
			for (Iterator edges = view.getSourceEdges().iterator(); edges.hasNext();) {
				result.addAll(collectAllLinks((View) edges.next(), domain2NotationMap));
			}
			return result;
		}
		
		/**
		 * @generated
		 */
		private Diagram getDiagram() {
			return ((View) getHost().getModel()).getDiagram();
		}
		
		
		
		/**
		 * @generated NOT
		 */
		private Collection refreshConnections() {
			Map domain2NotationMap = new HashMap();
			Collection linkDescriptors = collectAllLinks(getDiagram(), domain2NotationMap);
			Collection existingLinks = new LinkedList(getDiagram().getEdges());
			for (Iterator linksIterator = existingLinks.iterator(); linksIterator.hasNext();) {
				Edge nextDiagramLink = (Edge) linksIterator.next();
				int diagramLinkVisualID = EcoreVisualIDRegistry.getVisualID(nextDiagramLink);
				if (diagramLinkVisualID == -1) {
					if (nextDiagramLink.getSource() != null && nextDiagramLink.getTarget() != null) {
						linksIterator.remove();
					}
					continue;
				}
				EObject diagramLinkObject = nextDiagramLink.getElement();
				EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
				EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
				for (Iterator linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator.hasNext();) {
					EcoreLinkDescriptor nextLinkDescriptor = (EcoreLinkDescriptor) linkDescriptorsIterator.next();
					if (diagramLinkObject == nextLinkDescriptor.getModelElement() && diagramLinkSrc == nextLinkDescriptor.getSource() && diagramLinkDst == nextLinkDescriptor.getDestination()
							&& diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {
						linksIterator.remove();
						linkDescriptorsIterator.remove();
					}
				}
			}
			deleteViews(existingLinks.iterator());
			return createConnections(linkDescriptors, domain2NotationMap);

//			return Collections.emptyList();
		}
		
		/**
		 * @generated
		 */
		private EditPart getEditPart(EObject domainModelElement, Map domain2NotationMap) {
			View view = (View) domain2NotationMap.get(domainModelElement);
			if (view != null) {
				return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
			}
			return null;
		}
		
		/**
		 * @generated
		 */
		private Collection createConnections(Collection linkDescriptors, Map domain2NotationMap) {
			List adapters = new LinkedList();
			for (Iterator linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator.hasNext();) {
				final EcoreLinkDescriptor nextLinkDescriptor = (EcoreLinkDescriptor) linkDescriptorsIterator.next();
				EditPart sourceEditPart = getEditPart(nextLinkDescriptor.getSource(), domain2NotationMap);
				EditPart targetEditPart = getEditPart(nextLinkDescriptor.getDestination(), domain2NotationMap);
				if (sourceEditPart == null || targetEditPart == null) {
					continue;
				}
				CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(nextLinkDescriptor.getSemanticAdapter(), null, ViewUtil.APPEND,
						false, ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint());
				CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(descriptor);
				ccr.setType(RequestConstants.REQ_CONNECTION_START);
				ccr.setSourceEditPart(sourceEditPart);
				sourceEditPart.getCommand(ccr);
				ccr.setTargetEditPart(targetEditPart);
				ccr.setType(RequestConstants.REQ_CONNECTION_END);
				Command cmd = targetEditPart.getCommand(ccr);
				if (cmd != null && cmd.canExecute()) {
					executeCommand(cmd);
					IAdaptable viewAdapter = (IAdaptable) ccr.getNewObject();
					if (viewAdapter != null) {
						adapters.add(viewAdapter);
					}
				}
			}
			return adapters;
		}
	}

	/**
	 * Creates a new edit part for the given view.
	 * 
	 * @param i_diagramView the view
	 */
	public DiagramEditPart3D(View i_diagramView) {
		super(i_diagramView);
	}

	/**
	 * {@inheritDoc} Replaces original {@link EPackageCanonicalEditPolicy} with
	 * syncing policy, i.e. views are created for newly added semantic nodes.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart#createDefaultEditPolicies()
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EcoretoolsEditPolicyRoles.PSEUDO_CANONICAL_ROLE,
			new EPackageCanonicalEditPolicySemanticUpdater());

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		IFigure3D f = new DiagramFigure3D() {
			@Override
			public void add(IFigure i_figure, Object i_constraint, int i_index) {
				super.add(i_figure, i_constraint, i_index);
				i_figure.addFigureListener(new FigureListener() {

					public void figureMoved(IFigure i_source) {
						autoResize();
					}
				});
			}
		};

		f.getPosition3D().setLocation3D(new Vector3fImpl(0, 0, 0));
		f.getPosition3D().setSize3D(new Vector3fImpl(400, 400, 30));

		f.setBackgroundColor(new Color(Display.getCurrent(), 255, 255, 255));
		f.setAlpha((byte) (255 / 2));

		return f;
	}

	/**
	 * Replaces the <code>RubberbandDragTracker</code> with an old school
	 * {@link DragEditPartsTrackerEx}, since the former performs a cast which
	 * fails.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart#getDragTracker(org.eclipse.gef.Request)
	 */
	@Override
	public DragTracker getDragTracker(Request req) {
		if (req instanceof SelectionRequest
			&& ((SelectionRequest) req).getLastButtonPressed() == 3)
			return new DeselectAllTracker(this);
		return new DragEditPartsTrackerEx(this);
	}

	/**
	 * 
	 */
	void autoResize() {
		int width = 400;
		int height = 400;
		int border = 30;
		int depth = 20;

		Rectangle rect = getChildrenBounds();
		rect.width += border;
		rect.height += border;

		if (width < rect.width)
			width = rect.width;
		if (height < rect.height)
			height = rect.height;
		((Figure3D) getFigure()).getPosition3D().setSize3D(
			new Vector3fImpl(width + border, height + border, depth));
	}
}
