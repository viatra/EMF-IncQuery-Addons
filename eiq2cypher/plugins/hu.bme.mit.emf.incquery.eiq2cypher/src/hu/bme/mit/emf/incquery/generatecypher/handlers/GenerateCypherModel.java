package hu.bme.mit.emf.incquery.generatecypher.handlers;

import hu.bme.mit.emf.incquery.generatecypher.handlers.Transform;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider.Registry;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

public class GenerateCypherModel extends AbstractHandler {

	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String messagePrefix = "[CYPHER_QUERY_GENERATOR] ";

		System.out.println(messagePrefix + "Execution started...");
		
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		// Selection should contain only a single eiq file - enforced by
		// plugin.xml conditions
		IFile file = (IFile) ((StructuredSelection) selection)
				.getFirstElement();
		
		String myOutletPath = file.getProject().getFolder("src-gen").getLocation().toOSString();
		
		ResourceSet resourceSet = resourceSetProvider.get(file.getProject());
		Resource resource = resourceSet.getResource(
				URI.createPlatformPluginURI(file.getFullPath().toOSString(), false), true);
		
		IEncodingProvider encodingProvider = new IEncodingProvider.Runtime();
		Registry registry = IResourceServiceProvider.Registry.INSTANCE;
		JavaIoFileSystemAccess fsa = new JavaIoFileSystemAccess(registry, encodingProvider);
		
		JavaIoFileSystemAccess javaIoFileSystemAccess = new JavaIoFileSystemAccess();
		javaIoFileSystemAccess.setOutputPath("/");
		Map<String, OutputConfiguration> outputs = fsa.getOutputConfigurations();
		
		OutputConfiguration out = new OutputConfiguration(JavaIoFileSystemAccess.DEFAULT_OUTPUT);
		out.setOutputDirectory(myOutletPath);
		outputs.put(JavaIoFileSystemAccess.DEFAULT_OUTPUT, out);
				
		fsa.setOutputConfigurations(outputs);				
		Transform trf = new Transform(); 
		try {
			System.out.println(messagePrefix + "Generating Cypher query...");
			trf.doGenerate(resource, fsa);
		} catch (Exception E) {
			E.printStackTrace();
		}
		
		System.out.println(messagePrefix  + "Done.");        
		return null;
	}
}