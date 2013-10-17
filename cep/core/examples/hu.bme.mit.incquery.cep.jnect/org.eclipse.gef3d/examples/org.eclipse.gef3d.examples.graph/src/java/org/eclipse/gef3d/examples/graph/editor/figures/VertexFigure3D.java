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
package org.eclipse.gef3d.examples.graph.editor.figures;

import java.util.logging.Logger;

import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.draw3d.FigureSurface;
import org.eclipse.draw3d.ISurface;
import org.eclipse.draw3d.ShapeFigure3D;
import org.eclipse.draw3d.SurfaceLayout;
import org.eclipse.draw3d.geometry.Vector3f;
import org.eclipse.draw3d.geometry.Vector3fImpl;
import org.eclipse.draw3d.shapes.CuboidFigureShape;
import org.eclipse.draw3d.shapes.Shape;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/**
 * GraphFigure3D There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since 21.11.2007
 */
public class VertexFigure3D extends ShapeFigure3D {
	private static int counter = 1;
	
	/**
	 * The surface of this figure. This is where 2D children are placed.
	 */
	private ISurface m_surface = new FigureSurface(this);


	/**
	 * Logger for this class
	 */
	@SuppressWarnings("unused")
	private static final Logger log =
		Logger.getLogger(VertexFigure3D.class.getName());

	private int number = 0;

	public VertexFigure3D() {

		// embed 2D components into this figure
		SurfaceLayout.setDelegate(this, new FlowLayout());
		Color c = Display.getCurrent().getSystemColor(SWT.COLOR_RED);
		this.setBackgroundColor(c);
		this.setAlpha(0xBB);

		Vector3f v = new Vector3fImpl(getPosition3D().getSize3D());
		v.setZ(20);
		getPosition3D().setSize3D(v);

		add(new Label("Node " + counter));
		number = counter;
		counter++;

		// add(new Label("---------"));
		// add(new Label("+ someAttrib"));
		// add(new Label("---------"));
		// add(new Label("+ someOp()"));

	}

	// public static int loadImage(String path, int mag_filter, int min_filter)
	// {
	//
	// Image img = null;
	// int ret = 0;
	//
	// try {
	// img = new Image(Display.getCurrent(), path);
	// } catch (SWTException ex) {
	// ex.printStackTrace();
	// throw ex;
	// }
	//
	// // Create A IntBuffer For Image Address In Memory
	// IntBuffer buf;
	// try {
	// ByteBuffer scratch = Figure3DFriend
	// .imageToByteBuffer(img, true);
	//
	// buf = ByteBuffer.allocateDirect(4).order(ByteOrder.nativeOrder())
	// .asIntBuffer();
	// GL11.glGenTextures(buf); // Create Texture In OpenGL
	//
	// GL11.glBindTexture(GL11.GL_TEXTURE_2D, buf.get(0));
	// // Typical Texture Generation Using Data From The Image
	//
	// GL11.glBindTexture(GL11.GL_TEXTURE_2D, buf.get(0));
	// GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
	// GL11.GL_TEXTURE_MAG_FILTER, mag_filter);
	// GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
	// GL11.GL_TEXTURE_MIN_FILTER, min_filter);
	//
	// int width = img.getImageData().width;
	// int height = img.getImageData().height;
	//
	// GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGB, width,
	// height, 0, GL11.GL_RGB, GL11.GL_UNSIGNED_BYTE, scratch);
	//
	// ret = buf.get(0);
	// // GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
	// } catch (RuntimeException ex) {
	// ex.printStackTrace();
	// throw ex;
	// } finally {
	// // image was copied to OpenGL, dispose resources
	// img.dispose();
	// }
	// return ret;
	// }

	/**
	 * Returns a transparent cuboid figure shape (i.e. a
	 * {@link CuboidFigureShape} nested into a {@link TransparentShape}.
	 * 
	 * @see org.eclipse.draw3d.ShapeFigure3D#createShape()
	 */
	@Override
	protected Shape createShape() {

		return new CuboidFigureShape(this, false);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.Figure3D#getSurface()
	 */
	@Override
	public ISurface getSurface() {
		return m_surface;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw3d.Figure3D#toString()
	 */
	@Override
	public String toString() {
		return "Vertex " + number + ", " + super.toString();
	}

}
