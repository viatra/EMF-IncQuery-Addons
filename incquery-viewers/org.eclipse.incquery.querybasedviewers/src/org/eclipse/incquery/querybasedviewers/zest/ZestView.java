package org.eclipse.incquery.querybasedviewers.zest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.gef4.zest.core.viewers.AbstractZoomableViewer;
import org.eclipse.gef4.zest.core.viewers.GraphViewer;
import org.eclipse.gef4.zest.core.viewers.IZoomableWorkbenchPart;
import org.eclipse.gef4.zest.core.viewers.ZoomContributionViewItem;
import org.eclipse.gef4.zest.core.widgets.ZestStyles;
import org.eclipse.gef4.zest.layouts.LayoutAlgorithm;
import org.eclipse.gef4.zest.layouts.algorithms.TreeLayoutAlgorithm;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternregistry.util.PatternRegistry;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.viewers.runtime.IncQueryViewerSupport;
import org.eclipse.incquery.viewers.runtime.model.Edge;
import org.eclipse.incquery.viewers.runtime.model.Item;
import org.eclipse.incquery.viewers.runtime.model.ViewerDataModel;
import org.eclipse.incquery.viewers.runtime.zest.IncQueryGraphViewers;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;

public class ZestView extends ViewPart implements IZoomableWorkbenchPart, ISelectionProvider {
    public ZestView() {
    }
	public static final String ID = "org.eclipse.incquery.querybasedviewers.zest";

	private ISelection iSelection;
	private List<ISelectionChangedListener> iSelectionChangedListeners = new ArrayList<ISelectionChangedListener>();
	private ISelectionChangedListener selectionChangedListener;
	private EcoreEditor editor;

    private ListViewer listViewer;
	private GraphViewer zestviewer;
    private TreeViewer treeViewer;
	private ResourceSet resourceSet;

	public static ZestView getInstance() {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWorkbenchWindow != null && activeWorkbenchWindow.getActivePage() != null) {
			return (ZestView) activeWorkbenchWindow.getActivePage().findView(ID);
		}
		return null;
	}

	@Override
	public AbstractZoomableViewer getZoomableViewer() {
		return zestviewer;
	}

	@Override
	public void createPartControl(Composite parent) {
        CTabFolder folder = new CTabFolder(parent, SWT.TOP);

		selectionChangedListener = new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection().isEmpty()) {
					System.out.println("Nothing selected!");
					return;
				}
				setSelection(event.getSelection());
			}
		};
        // List Viewer
        CTabItem listTab = new CTabItem(folder, SWT.NONE);
        listTab.setText("List");
        listViewer = new ListViewer(folder);
        listTab.setControl(listViewer.getControl());
        // Tree Viewer
        CTabItem treeTab = new CTabItem(folder, SWT.NONE);
        treeTab.setText("Tree");
        treeViewer = new TreeViewer(folder);
        treeTab.setControl(treeViewer.getControl());
        // Graph Viewer
        CTabItem zestTab = new CTabItem(folder, SWT.NONE);
        zestTab.setText("Graph");
        zestviewer = new GraphViewer(folder, SWT.NONE);
        zestTab.setControl(zestviewer.getControl());

        zestviewer.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
        LayoutAlgorithm layout = new TreeLayoutAlgorithm(TreeLayoutAlgorithm.BOTTOM_UP);
        zestviewer.setLayoutAlgorithm(layout, true);

		zestviewer.addSelectionChangedListener(selectionChangedListener);
		fillToolBar();
		getSite().setSelectionProvider(this);
	}

	@Override
	public void setFocus() {
		if (zestviewer != null) {
			zestviewer.getControl().setFocus();
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter.equals(IPropertySheetPage.class)) {
			PropertySheetPage propertySheetPage = new PropertySheetPage();
			propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
			return propertySheetPage;
		}
		return super.getAdapter(adapter);
	}

	private void fillToolBar() {
		ZoomContributionViewItem toolbarZoomContributionViewItem = new ZoomContributionViewItem(this);
		IActionBars bars = getViewSite().getActionBars();
		bars.getMenuManager().add(toolbarZoomContributionViewItem);
	}

	@Override
	public void setSelection(ISelection selection) {
		iSelection = selection;
		if (editor != null) {
			editor.setSelectionToViewer(Arrays.asList(((StructuredSelection) selection).toArray()));
		}
		for (ISelectionChangedListener listener : iSelectionChangedListeners) {
			listener.selectionChanged(new SelectionChangedEvent(this, selection));
		}
	}

	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		iSelectionChangedListeners.remove(listener);
	}

	@Override
	public ISelection getSelection() {
		return iSelection;
	}

	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		iSelectionChangedListeners.add(listener);
	}

    public void setResourceSet(ResourceSet resourceSet, EcoreEditor editor) throws IncQueryException {
		this.resourceSet = resourceSet;
		this.editor = editor;
		if (this.resourceSet != null) {
            String[] annotations = { Item.ANNOTATION_ID, Edge.ANNOTATION_ID };
            ArrayList<Pattern> patterns = new ArrayList<Pattern>();
            for (String annotation : annotations) {
                patterns.addAll(PatternRegistry.getInstance().getPatternsWithAnnotation(annotation));
            }

            ViewerDataModel viewmodel = new ViewerDataModel(resourceSet, patterns);
            IncQueryViewerSupport.bind(listViewer, viewmodel);
            IncQueryViewerSupport.bind(treeViewer, viewmodel);
            IncQueryGraphViewers.bind(zestviewer, viewmodel);
		}
	}
}
