/*******************************************************************************
 * Copyright (c) 2009 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthias Thiele - initial API and implementation
 ******************************************************************************/

package org.eclipse.draw3d;

import java.util.Arrays;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.Graphics3DDescriptor;
import org.eclipse.draw3d.graphics3d.Graphics3DRegistry;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.widgets.Display;

/**
 * Exports a diagram into a file using a specified export renderer, i.e.
 * {@link Graphics3D} instance.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since Mar 16 2009
 */
public class Export3DOperation {

	final IFigure3D rootFigure;

	final String rendererID;

	final String exportfilename;

	/**
	 * @param i_exportfilename
	 * @param i_rendererID
	 * @param i_rootFigure
	 */
	public Export3DOperation(String i_exportfilename, String i_rendererID,
			IFigure3D i_rootFigure) {
		super();
		exportfilename = i_exportfilename;
		rendererID = i_rendererID;
		rootFigure = i_rootFigure;
	}

	/**
	 * Exports the diagram represented by its root figure using the given
	 * renderer to a file.
	 */
	public void run() {
		RenderContext renderContext = rootFigure.getRenderContext();
		Graphics3D g3dSave = renderContext.getGraphics3D();

		try {

			Graphics3DDescriptor descr =
				Graphics3DRegistry.getRenderer(rendererID);
			Graphics3D g3dExport = descr.createInstance(null);
			g3dExport.setProperty("exportfile", exportfilename);

			renderContext.setGraphics3D(g3dExport);

			Graphics dummy = createDummyGraphics();
			rootFigure.invalidateTree(); // invalidate everything
			rootFigure.paint(dummy);
		} finally {
			renderContext.setGraphics3D(g3dSave);
		}
	}

	private Graphics createDummyGraphics() {
		int width = 100;
		int height = 100;
		int size = width * height;
		int alpha = 255;
		byte[] data = new byte[size * 3];

		PaletteData pal = new PaletteData(0xFF0000, 0x00FF00, 0x0000FF);
		ImageData imageData = new ImageData(width, height, 24, pal, 1, data);
		imageData.alphaData = new byte[size];
		Arrays.fill(imageData.alphaData, (byte) alpha);

		Image image = new Image(Display.getCurrent(), imageData);

		GC gc = new GC(image);
		SWTGraphics dummyGraphics = new SWTGraphics(gc);

		return dummyGraphics;
	}
}
