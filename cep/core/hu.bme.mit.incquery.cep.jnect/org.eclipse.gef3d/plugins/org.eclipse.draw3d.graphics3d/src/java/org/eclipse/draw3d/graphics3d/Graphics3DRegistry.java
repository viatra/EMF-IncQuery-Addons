/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthias Thiele - initial API and implementation
 *    Kristian Duske - initial API and implementation
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package org.eclipse.draw3d.graphics3d;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

/**
 * Graphics3DRegistry is aware of the existing Graphics3D implementors and can
 * create instances of them. Please note, that the Graphics3DRegistry does not
 * manage the Graphics3D instances. Once created and returned, the
 * Graphics3DRegistry does not store any reference to them any more.
 * <p>
 * Plugins implementing the {@link Graphics3D} interface register themselves
 * using the extension point {@value #GRAPHICS3D_EP}. The plugin registry is
 * evaluated if no descripters were found so far, the result is cached and maybe
 * resetted using {@link #resetDescriptors()}.
 * </p>
 * 
 * @author Matthias Thiele, Jens von Pilgrim
 * @version $Revision$
 * @since 16.12.2008
 */
public class Graphics3DRegistry {
	/**
	 * Logger for this class
	 */
	private static final Logger log =
		Logger.getLogger(Graphics3DRegistry.class.getName());

	private final static List<Graphics3DDescriptor> descriptors =
		new Vector<Graphics3DDescriptor>();

	public static final String GRAPHICS3D_EP = "org.eclipse.draw3d.graphics3d";

	/**
	 * Returns the descriptor for the default screen renderer, i.e. the first
	 * screen renderer found.
	 * <p>
	 * The descriptors are retrieved from the plugin registry and cached. In
	 * order to force the registry to be evaluated again, call
	 * {@link #resetDescriptors()}.
	 * </p>
	 * 
	 * @return the descriptor or null, if no such descriptor was found
	 */
	public static Graphics3DDescriptor getDefaultScreenRenderer() {
		updateDescriptors();
		for (Graphics3DDescriptor descr : descriptors) {
			if (descr.getType() == Graphics3DType.SCREEN) {
				return descr;
			}
		}
		log.severe("No screen renderer not found"); //$NON-NLS-1$
		return null;
	}

	/**
	 * Returns the descritor of a {@link Graphics3D} implementation with the
	 * given ID.
	 * <p>
	 * The descriptors are retrieved from the plugin registry and cached. In
	 * order to force the registry to be evaluated again, call
	 * {@link #resetDescriptors()}.
	 * </p>
	 * 
	 * @param i_rendererID
	 * @return the descriptor or null, if no such descriptor was found
	 */
	public static Graphics3DDescriptor getRenderer(String i_rendererID) {
		updateDescriptors();
		for (Graphics3DDescriptor descr : descriptors) {
			if (descr.getRendererID().equals(i_rendererID)) {
				return descr;
			}
		}

		log.warning("Renderer with id " + i_rendererID + " not found"); //$NON-NLS-1$ //$NON-NLS-1$

		return null;
	}

	/**
	 * Returns a list of descriptors of {@link Graphics3D} implementations for a
	 * given {@link Graphics3DType}.
	 * <p>
	 * The descriptors are retrieved from the plugin registry and cached. In
	 * order to force the registry to be evaluated again, call
	 * {@link #resetDescriptors()}.
	 * </p>
	 * 
	 * @param type
	 * @return the list with descriptors, may be empty
	 */
	public static List<Graphics3DDescriptor> getRenderersForType(
		Graphics3DType type) {
		updateDescriptors();
		List<Graphics3DDescriptor> result =
			new ArrayList<Graphics3DDescriptor>();
		for (Graphics3DDescriptor descr : descriptors) {
			if (descr.getType() == type) {
				result.add(descr);
			}
		}
		return result;
	}

	/**
	 * Reset internal cached list of Graphics3D descriptors. The next time a
	 * renderer is requested, the descriptor list is updated.
	 */
	public static void resetDescriptors() {
		descriptors.clear();
	}

	/**
	 * Lazily reads and caches a list of descriptors. All getter methods call
	 * this method to ensure the descriptors have been read. With
	 * {@link #resetDescriptors()}, the cache can be cleared in order to re-read
	 * the descriptors.
	 */
	private static void updateDescriptors() {
		synchronized (descriptors) {
			if (descriptors.size() > 0)
				return;

			IExtensionRegistry registry = Platform.getExtensionRegistry();
			IExtensionPoint point = registry.getExtensionPoint(GRAPHICS3D_EP);
			if (point == null) {
				log.severe("Extension point '" + GRAPHICS3D_EP + "' not found"); //$NON-NLS-1$
				return;
			}
			IExtension[] extensions = point.getExtensions();

			for (IExtension extension : extensions) {
				String strContributorName =
					extension.getContributor().getName();
				if (log.isLoggable(Level.INFO)) {
					log.info("Extension found: " + extension
						+ ", Contributor: " + strContributorName); //$NON-NLS-1$
				}

				IConfigurationElement[] ices =
					extension.getConfigurationElements();
				for (IConfigurationElement element : ices) {
					if (element.getName().equals("renderer")) {
						Graphics3DDescriptor descriptor =
							new Graphics3DDescriptor();
						descriptor.setContributorName(strContributorName);
						descriptor.setRendererID(element.getAttribute("id"));
						descriptor.setClassname(element.getAttribute("class"));
						descriptor.setType(Graphics3DType.valueOf(element
							.getAttribute("type")));

						IConfigurationElement name =
							element.getChildren("name")[0];
						descriptor.setName(name.getValue());
						IConfigurationElement descr =
							element.getChildren("description")[0];
						descriptor.setDescription(descr.getValue());

						IConfigurationElement[] params =
							element.getChildren("parameter");
						if (params != null) {
							for (IConfigurationElement param : params) {
								descriptor.getParameters().setProperty(
									param.getAttribute("name"),
									param.getAttribute("value"));
							}
						}

						descriptors.add(descriptor);

					}
				}

			}
		}

		if (descriptors.size() == 0) {
			log.severe("No plugins for extension point '" //$NON-NLS-1$
				+ GRAPHICS3D_EP + "' found"); //$NON-NLS-1$
			return;

		}

	}

}
