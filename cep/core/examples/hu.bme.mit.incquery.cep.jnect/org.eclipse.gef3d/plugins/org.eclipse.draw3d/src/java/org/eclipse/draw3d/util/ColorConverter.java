/*******************************************************************************
 * Copyright (c) 2008 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kristian Duske - initial API and implementation
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/

package org.eclipse.draw3d.util;

import org.eclipse.swt.graphics.Color;

/**
 * Utility class that contains methods to convert colors.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 03.04.2008
 */
public class ColorConverter {

	/**
	 * Converts the given red, green, blue and alpha values to a byte array
	 * containing RGBA values. If the given result array is <code>null</code>, a
	 * new array will be created and returned.
	 * 
	 * @param i_red the red value
	 * @param i_green the green value
	 * @param i_blue the blue value
	 * @param i_alpha the alpha value
	 * @param io_colors the array to put the result in
	 * @return the array containing the RGBA values
	 * @throws NullPointerException if the given color is <code>null</code>
	 * @throws IllegalAccessError if the given array is not <code>null</code>,
	 *             but does not have 4 elements
	 */
	public static byte[] toByteArray(byte i_red, byte i_green, byte i_blue,
		int i_alpha, byte[] io_colors) {

		byte[] colors = io_colors;
		if (colors == null)
			colors = new byte[4];

		if (colors.length != 4)
			throw new IllegalArgumentException(
				"io_byteColors must have a length of 4");

		colors[0] = i_red;
		colors[1] = i_green;
		colors[2] = i_blue;
		colors[3] = (byte) (i_alpha & 0xFF);

		return colors;
	}

	/**
	 * Converts the given color and alpha value to a byte array containing RGBA
	 * values. If the given result array is <code>null</code>, a new array will
	 * be created and returned.
	 * 
	 * @param i_color the color to convert
	 * @param i_alpha the alpha value
	 * @param io_colors the array to put the result in
	 * @return the array containing the RGBA values
	 * @throws NullPointerException if the given color is <code>null</code>
	 * @throws IllegalAccessError if the given array is not <code>null</code>,
	 *             but does not have 4 elements
	 */
	public static byte[] toByteArray(Color i_color, int i_alpha,
		byte[] io_colors) {

		if (i_color == null)
			throw new NullPointerException("i_color must not be null");

		byte red = (byte) (i_color.getRed() & 0xFF);
		byte green = (byte) (i_color.getGreen() & 0xFF);
		byte blue = (byte) (i_color.getBlue() & 0xFF);

		return toByteArray(red, green, blue, i_alpha, io_colors);
	}

	/**
	 * Converts the given color and alpha value to a float array containing RGBA
	 * values. If the given result array is <code>null</code>, a new array will
	 * be created and returned.
	 * 
	 * @param i_color the color to convert
	 * @param i_alpha the alpha value
	 * @param io_colors the array to put the result in
	 * @return the array containing the RGBA values
	 * @throws NullPointerException if the given color is <code>null</code>
	 * @throws IllegalAccessError if the given array is not <code>null</code>,
	 *             but does not have 4 elements
	 */
	public static float[] toFloatArray(Color i_color, int i_alpha,
		float[] io_colors) {

		if (i_color == null)
			throw new NullPointerException("i_color must not be null");

		int red = i_color.getRed();
		int green = i_color.getGreen();
		int blue = i_color.getBlue();

		return toFloatArray(red, green, blue, i_alpha, io_colors);
	}

	/**
	 * Converts the given color and alpha value to a float array containing RGBA
	 * values. If the given result array is <code>null</code>, a new array will
	 * be created and returned.
	 * 
	 * @param i_color the color, in BBGGRR format
	 * @param i_alpha the alpha value
	 * @param io_colors the array to put the result in
	 * @return the array containing the RGBA values
	 * @throws IllegalAccessError if the given array is not <code>null</code>,
	 *             but does not have 4 elements
	 */
	public static float[] toFloatArray(int i_color, int i_alpha,
		float[] io_colors) {

		int red = i_color & 0xFF;
		int green = (i_color >> 8) & 0xFF;
		int blue = (i_color >> 16) & 0xFF;

		return toFloatArray(red, green, blue, i_alpha, io_colors);
	}

	/**
	 * Converts the given red, green, blue and alpha values to a float array
	 * containing RGBA values. If the given result array is <code>null</code>, a
	 * new array will be created and returned.
	 * 
	 * @param i_red the red value
	 * @param i_green the green value
	 * @param i_blue the blue value
	 * @param i_alpha the alpha value
	 * @param io_colors the array to put the result in
	 * @return the array containing the RGBA values
	 * @throws NullPointerException if the given color is <code>null</code>
	 * @throws IllegalAccessError if the given array is not <code>null</code>,
	 *             but does not have 4 elements
	 */
	public static float[] toFloatArray(int i_red, int i_green, int i_blue,
		int i_alpha, float[] io_colors) {

		float[] colors = io_colors;
		if (colors == null)
			colors = new float[4];

		if (colors.length != 4)
			throw new IllegalArgumentException(
				"io_byteColors must have a length of 4");

		colors[0] = (i_red & 0xFF) / 255f;
		colors[1] = (i_green & 0xFF) / 255f;
		colors[2] = (i_blue & 0xFF) / 255f;
		colors[3] = (i_alpha & 0xFF) / 255f;

		return colors;
	}

	/**
	 * Converts the given color and alpha value to an int array containing RGBA
	 * values. If the given result array is <code>null</code>, a new array will
	 * be created and returned.
	 * 
	 * @param i_color the color to convert
	 * @param i_alpha the alpha value
	 * @param io_colors the array to put the result in
	 * @return the array containing the RGBA values
	 * @throws NullPointerException if the given color is <code>null</code>
	 * @throws IllegalAccessError if the given array is not <code>null</code>,
	 *             but does not have 4 elements
	 */
	public static int[] toIntArray(Color i_color, int i_alpha, int[] io_colors) {

		if (i_color == null)
			throw new NullPointerException("i_color must not be null");

		int red = i_color.getRed();
		int green = i_color.getGreen();
		int blue = i_color.getBlue();

		return toIntArray(red, green, blue, i_alpha, io_colors);
	}

	/**
	 * Converts the given red, green, blue and alpha values to an int array
	 * containing RGBA values. If the given result array is <code>null</code>, a
	 * new array will be created and returned.
	 * 
	 * @param i_red the red value
	 * @param i_green the green value
	 * @param i_blue the blue value
	 * @param i_alpha the alpha value
	 * @param io_colors the array to put the result in
	 * @return the array containing the RGBA values
	 * @throws NullPointerException if the given color is <code>null</code>
	 * @throws IllegalAccessError if the given array is not <code>null</code>,
	 *             but does not have 4 elements
	 */
	public static int[] toIntArray(int i_red, int i_green, int i_blue,
		int i_alpha, int[] io_colors) {

		int[] colors = io_colors;
		if (colors == null)
			colors = new int[4];

		if (colors.length != 4)
			throw new IllegalArgumentException(
				"io_byteColors must have a length of 4");

		colors[0] = i_red & 0xFF;
		colors[1] = i_green & 0xFF;
		colors[2] = i_blue & 0xFF;
		colors[3] = i_alpha & 0xFF;

		return colors;
	}

	private ColorConverter() {

		// non-instantiable class
	}
}
