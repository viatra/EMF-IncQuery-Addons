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

package org.eclipse.draw3d.util;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.draw2d.IFigure;

/**
 * Describes a figure and its subtree.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 13.03.2008
 */
public class FigureTreeDescriber {

	private interface Printable {

		/**
		 * Print the given description.
		 * 
		 * @param i_text the description to print
		 */
		public void print(String i_text);
	}

	private static final String INDENT = "\t";

	private static final String NEW_LINE = System.getProperty("line.separator");

	private IFigure m_rootFigure;

	/**
	 * Creates a new instance for the subtree of the given figure.
	 * 
	 * @param i_rootFigure the root of the tree to describe
	 * @throws NullPointerException if the given writer is <code>null</code>
	 */
	public FigureTreeDescriber(IFigure i_rootFigure) {

		if (i_rootFigure == null)
			throw new NullPointerException("i_figure must not be null");

		m_rootFigure = i_rootFigure;
	}

	private void describeAsText(IFigure i_figure, int i_level,
			Printable o_printable) {

		indent(i_level, o_printable);
		o_printable.print(i_figure.getClass().getName());
		o_printable.print(NEW_LINE);

		List<?> children = i_figure.getChildren();
		for (Object child : children) {
			if (child instanceof IFigure) {
				IFigure figure = (IFigure) child;
				describeAsText(figure, i_level + 1, o_printable);
			}
		}
	}

	/**
	 * Describes the tree in text form to the given logger.
	 * 
	 * @param o_log the logger to print to
	 * @param i_logLevel the log level to use
	 * @throws NullPointerException if any of the given arguments is
	 *             <code>null</code>
	 */
	public void describeAsText(final Logger o_log, final Level i_logLevel) {

		if (o_log == null)
			throw new NullPointerException("o_log must not be null");

		if (i_logLevel == null)
			throw new NullPointerException("i_logLevel must not be null");

		Printable printable = new Printable() {

			public void print(String i_text) {
				o_log.log(i_logLevel, i_text);
			}
		};

		describeAsText(m_rootFigure, 0, printable);
	}

	/**
	 * Describes the tree in text form to the given print stream.
	 * 
	 * @param o_stream the stream to print to
	 * @throws NullPointerException if the given writer is <code>null</code>
	 */
	public void describeAsText(final PrintStream o_stream) {

		if (o_stream == null)
			throw new NullPointerException("o_stream must not be null");

		Printable printable = new Printable() {

			public void print(String i_text) {
				o_stream.print(i_text);
			}
		};

		describeAsText(m_rootFigure, 0, printable);
	}

	/**
	 * Describes the tree in text form to the given print writer.
	 * 
	 * @param o_writer the writer to print to
	 * @throws NullPointerException if the given writer is <code>null</code>
	 */
	public void describeAsText(final PrintWriter o_writer) {

		if (o_writer == null)
			throw new NullPointerException("o_writer must not be null");

		Printable printable = new Printable() {

			public void print(String i_text) {
				o_writer.print(i_text);
			}
		};

		describeAsText(m_rootFigure, 0, printable);
	}

	private void indent(int i_level, Printable o_printable) {

		for (int i = 0; i < i_level; i++)
			o_printable.print(INDENT);
	}
}
