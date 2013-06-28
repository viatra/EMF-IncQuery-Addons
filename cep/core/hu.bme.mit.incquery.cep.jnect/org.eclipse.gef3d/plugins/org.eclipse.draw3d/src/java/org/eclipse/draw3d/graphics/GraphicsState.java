package org.eclipse.draw3d.graphics;

import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw3d.geometry.IMatrix3f;
import org.eclipse.draw3d.geometry.Math3D;
import org.eclipse.draw3d.geometry.Matrix3f;
import org.eclipse.draw3d.geometry.Matrix3fImpl;
import org.eclipse.draw3d.geometry.Vector2f;
import org.eclipse.draw3d.util.Draw3DCache;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.widgets.Display;

/**
 * A graphics state that forwards requests for unset values to its parent state.
 * 
 * @author Kristian Duske
 * @version $Revision: 383 $
 * @since 08.03.2008
 */
public class GraphicsState {

	/**
	 * Creates a new graphics state that has been initialized with default
	 * values.
	 * 
	 * @param i_width the width of the graphics object
	 * @param i_height the height of the graphics object
	 * @return the new graphics state
	 */
	public static GraphicsState createDefaultState() {

		Display display = Display.getDefault();

		Color foregroundColor = display.getSystemColor(SWT.COLOR_BLACK);
		Color backgroundColor = display.getSystemColor(SWT.COLOR_WHITE);

		GraphicsState state = new GraphicsState();

		state.setClip(new Rectangle(0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE));
		state.setAdvanced(true);

		state.setForegroundColor(foregroundColor);
		state.setBackgroundColor(backgroundColor);
		state.setAlpha(255);

		state.setLineWidth(1);
		state.setLineStyle(SWT.LINE_SOLID);
		state.setLineCap(SWT.CAP_FLAT);
		state.setLineJoin(SWT.JOIN_MITER);
		state.setLineMiterLimit(11);

		state.setFont(display.getSystemFont());

		state.setTransformation(Matrix3f.IDENTITY);
		state.setXORMode(false);

		state.setAntialias(SWT.ON);
		state.setInterpolation(SWT.NONE);
		state.setTextAntialias(SWT.ON);

		state.setFillRule(SWT.FILL_WINDING);

		return state;
	}

	private Boolean m_advanced;

	private Integer m_alpha;

	private Integer m_antialias;

	private Color m_backgroundColor;

	private Pattern m_backgroundPattern;

	private PrecisionRectangle m_clip;

	private Integer m_fillRule;

	private Font m_font;

	private Color m_foregroundColor;

	private Pattern m_foregroundPattern;

	private Integer m_interpolation;

	private Integer m_lineCap;

	private int[] m_lineDash;

	private int m_lineDashLength;

	private Integer m_lineJoin;

	private FontMetrics m_fontMetrics;

	private Float m_lineMiterLimit;

	private Integer m_lineStyle;

	private Float m_lineWidth;

	private final GraphicsState m_parentState;

	private Integer m_textAntialias;

	private Matrix3fImpl m_transformation;

	private Boolean m_xorMode;

	private Font m_metricsFont;

	/**
	 * Returns the font metrics for the current font.
	 * 
	 * @return the font metrics
	 */
	public FontMetrics getFontMetrics() {

		Font font = getFont();
		if (font == null)
			return null;

		if (font.equals(m_metricsFont) && m_fontMetrics != null)
			return m_fontMetrics;

		m_metricsFont = font;
		Device device = m_metricsFont.getDevice();

		Image image = null;
		GC gc = null;

		try {
			image = new Image(device, 1, 1);
			gc = new GC(image);

			gc.setFont(m_metricsFont);
			m_fontMetrics = gc.getFontMetrics();

			return m_fontMetrics;
		} finally {
			if (gc != null)
				gc.dispose();

			if (image != null)
				image.dispose();
		}
	}

	/**
	 * Creates a new graphics state with no parent
	 */
	private GraphicsState() {

		m_parentState = null;
	}

	/**
	 * Creates a new chained graphics state with the given parent.
	 * 
	 * @param i_parentState the parent of this state
	 */
	public GraphicsState(GraphicsState i_parentState) {

		if (i_parentState == null)
			throw new NullPointerException("i_parentState must not be null");

		m_parentState = i_parentState;
	}

	/**
	 * Intersects the current clipping rectangle with the given rectangle.
	 * 
	 * @param i_clip the rectangle to intersect with
	 */
	public void clipRect(Rectangle i_clip) {

		if (i_clip == null)
			return;

		PrecisionRectangle currentClip = getClip();
		if (currentClip != null && !currentClip.equals(i_clip)) {
			if (m_clip == null)
				m_clip = new PrecisionRectangle(currentClip);

			// clipping in SWTGraphics is working slightly differently as
			// Rectangle clipping, so we emulate the SWTClipping here:
			double l = Math.max(m_clip.preciseX(), i_clip.preciseX());
			double r =
				Math.min(m_clip.preciseX() + m_clip.preciseWidth(),
					i_clip.preciseX() + i_clip.preciseWidth());

			double t = Math.max(m_clip.preciseY(), i_clip.preciseY());
			double b =
				Math.min(m_clip.preciseY() + m_clip.preciseHeight(),
					i_clip.preciseY() + i_clip.preciseHeight());

			if (r < l || b < t) {
				// width and height of -1 to avoid ceiling function from
				// re-adding a pixel.
				r = l - 1;
				b = t - 1;
			}

			m_clip.setX(l);
			m_clip.setY(t);
			m_clip.setWidth(r - l);
			m_clip.setHeight(b - t);

			// m_clip.intersect(i_clip);
		} else
			m_clip = new PrecisionRectangle(i_clip);
	}

	/**
	 * Indicates whether the graphics system is in advanced graphics mode.
	 * 
	 * @return <code>true</code> if the graphics subsystem is in advanced
	 *         graphics mode and <code>false</code> otherwise
	 */
	public boolean getAdvanced() {

		if (m_advanced != null)
			return m_advanced;

		return m_parentState.getAdvanced();
	}

	/**
	 * Returns the alpha value of this graphics state.
	 * 
	 * @return the alpha value of this graphics state
	 */
	public int getAlpha() {

		if (m_alpha != null)
			return m_alpha;

		return m_parentState.getAlpha();
	}

	/**
	 * Returns the antialias value for this graphics state.
	 * 
	 * @return the antialias value for this graphics state.
	 */
	public int getAntialias() {

		if (m_antialias != null)
			return m_antialias;

		return m_parentState.getAntialias();
	}

	/**
	 * Returns the background color of this graphics state.
	 * 
	 * @return the background color
	 */
	public Color getBackgroundColor() {

		if (m_backgroundColor != null)
			return m_backgroundColor;

		return m_parentState.getBackgroundColor();
	}

	/**
	 * Returns the background pattern of this graphics state.
	 * 
	 * @return the background pattern
	 */
	public Pattern getBackgroundPattern() {

		if (m_backgroundPattern != null)
			return m_backgroundPattern;

		if (m_parentState != null)
			return m_parentState.getBackgroundPattern();

		return null;
	}

	/**
	 * Returns the clip rectangle of this state.
	 * 
	 * @return the clip rectangle
	 */
	public PrecisionRectangle getClip() {

		if (m_clip != null)
			return m_clip;

		if (m_parentState != null)
			return m_parentState.getClip();

		return null;
	}

	/**
	 * Returns the fill rule of this graphics state.
	 * 
	 * @return the fill rule of this graphics state
	 */
	public int getFillRule() {

		if (m_fillRule != null)
			return m_fillRule;

		return m_parentState.getFillRule();
	}

	/**
	 * Returns the font of this graphics state.
	 * 
	 * @return the font
	 */
	public Font getFont() {

		if (m_font != null)
			return m_font;

		return m_parentState.getFont();
	}

	/**
	 * Returns the foreground color of this graphics state.
	 * 
	 * @return the foreground color
	 */
	public Color getForegroundColor() {

		if (m_foregroundColor != null)
			return m_foregroundColor;

		return m_parentState.getForegroundColor();
	}

	/**
	 * Returns the foreground parttern for this graphics state.
	 * 
	 * @return the foreground pattern
	 */
	public Pattern getForegroundPattern() {

		if (m_foregroundPattern != null)
			return m_foregroundPattern;

		if (m_parentState != null)
			return m_parentState.getForegroundPattern();

		return null;
	}

	/**
	 * Returns the interpolation setting for this graphics state.
	 * 
	 * @return the interpolation setting
	 */
	public int getInterpolation() {

		if (m_interpolation != null)
			return m_interpolation;

		return m_parentState.getInterpolation();
	}

	/**
	 * Returns the line cap setting for this graphics state
	 * 
	 * @return the line cap setting
	 */
	public int getLineCap() {

		if (m_lineCap != null)
			return m_lineCap;

		return m_parentState.getLineCap();
	}

	/**
	 * Returns the custom line dash pattern.
	 * 
	 * @return the custom line dash pattern
	 */
	public int[] getLineDash() {

		if (m_lineDash != null)
			return m_lineDash;

		if (m_parentState != null)
			return m_parentState.getLineDash();

		return null;
	}

	/**
	 * Returns the total length of the line dash pattern. The total length of a
	 * line dash pattern is the sum of all the elements of the pattern array.
	 * 
	 * @return the total length of the line dash pattern
	 */
	public int getLineDashLength() {

		if (m_lineDash != null)
			return m_lineDashLength;

		return m_parentState.getLineDashLength();
	}

	/**
	 * Returns the line join style for this graphics state.
	 * 
	 * @return the line join style for this graphics state
	 */
	public int getLineJoin() {

		if (m_lineJoin != null)
			return m_lineJoin;

		return m_parentState.getLineJoin();
	}

	/**
	 * Returns the line miter limit of this graphics state.
	 * 
	 * @return the line miter limit of this graphics state
	 */
	public float getLineMiterLimit() {

		if (m_lineMiterLimit != null)
			return m_lineMiterLimit;

		return m_parentState.getLineMiterLimit();
	}

	/**
	 * Returns the line style of this graphics state.
	 * 
	 * @return the line style
	 */
	public int getLineStyle() {

		if (m_lineStyle != null)
			return m_lineStyle;

		return m_parentState.getLineStyle();
	}

	/**
	 * Returns the line width of this graphics state.
	 * 
	 * @return the line width
	 */
	public float getLineWidth() {

		if (m_lineWidth != null)
			return m_lineWidth;

		return m_parentState.getLineWidth();
	}

	/**
	 * Returns the parent graphics state.
	 * 
	 * @return the parent graphics state
	 */
	public GraphicsState getParent() {

		return m_parentState;
	}

	/**
	 * Returns the text antialias value of this graphics state.
	 * 
	 * @return the text antialias value
	 */
	public int getTextAntialias() {

		if (m_textAntialias != null)
			return m_textAntialias;

		return m_parentState.getTextAntialias();
	}

	/**
	 * Returns the transformation matrix of this graphics state.
	 * 
	 * @return the transformation matrix
	 */
	public Matrix3f getTransformation() {

		if (m_transformation != null)
			return m_transformation;

		return m_parentState.getTransformation();
	}

	/**
	 * Indicates whether XOR mode drawing is enabled.
	 * 
	 * @return <code>true</code> if XOR drawing mode is enabled or
	 *         <code>false</code> otherwise
	 */
	public boolean getXORMode() {

		if (m_xorMode != null)
			return m_xorMode;

		return m_parentState.getXORMode();
	}

	/**
	 * Rotates the coordinates system by the given angle counterclockwise.
	 * 
	 * @param i_degrees the rotation angle in degrees
	 */
	public void rotate(float i_degrees) {

		if (m_transformation == null)
			m_transformation = new Matrix3fImpl();

		Matrix3f rot = Draw3DCache.getMatrix3f();
		try {
			// don't use Math3d.rotate() here because when rotating about
			// the z axis, we can use a shorthand:
			double radians = Math.toRadians(i_degrees);
			float sin = (float) Math.sin(radians);
			float cos = (float) Math.cos(radians);

			rot.setIdentity();
			rot.set(0, 0, cos);
			rot.set(1, 0, sin);
			rot.set(1, 1, cos);
			rot.set(0, 1, -sin);

			Math3D.mul(rot, m_transformation, m_transformation);
		} finally {
			Draw3DCache.returnMatrix3f(rot);
		}
	}

	/**
	 * Scales the current transformation and corrects the clipping rectangle by
	 * the given factors.
	 * 
	 * @param i_horizontal the horizontal scaling factor
	 * @param i_vertical the vertical scaling factor
	 */
	public void scale(float i_horizontal, float i_vertical) {

		if (m_transformation == null)
			m_transformation = new Matrix3fImpl();

		Vector2f scale = Draw3DCache.getVector2f();
		try {
			scale.set(i_horizontal, i_vertical);
			Math3D.scale(scale, m_transformation, m_transformation);
		} finally {
			Draw3DCache.returnVector2f(scale);
		}
	}

	/**
	 * Specifies whether the graphics system is in advanced graphics mode.
	 * 
	 * @param i_advanced <code>true</code> if the graphics system is in advanced
	 *            graphics mode and <code>false</code> otherwise
	 */
	public void setAdvanced(boolean i_advanced) {

		m_advanced = i_advanced;
	}

	/**
	 * Sets the alpha value of this graphics state.
	 * 
	 * @param i_alpha the alpha value
	 */
	public void setAlpha(int i_alpha) {

		m_alpha = i_alpha;
	}

	/**
	 * Sets the antialias value for this graphics state.
	 * 
	 * @param i_antialias the antialias value
	 */
	public void setAntialias(int i_antialias) {

		m_antialias = i_antialias;
	}

	/**
	 * Sets the background color of this graphics state.
	 * 
	 * @param i_backgroundColor the new background color
	 */
	public void setBackgroundColor(Color i_backgroundColor) {

		m_backgroundColor = i_backgroundColor;
	}

	/**
	 * Sets the background pattern of this graphics state.
	 * 
	 * @param i_backgroundPattern the background pattern
	 */
	public void setBackgroundPattern(Pattern i_backgroundPattern) {

		m_backgroundPattern = i_backgroundPattern;
	}

	/**
	 * Sets the clip rectangleof this state.
	 * 
	 * @param i_clip the clip rectangle
	 */
	public void setClip(Rectangle i_clip) {

		if (i_clip == null) {
			m_clip = null;
			return;
		}

		if (m_clip == null) {
			m_clip = new PrecisionRectangle(i_clip);
			return;
		}

		m_clip.setX(i_clip.preciseX());
		m_clip.setY(i_clip.preciseY());
		m_clip.setWidth(i_clip.preciseWidth());
		m_clip.setHeight(i_clip.preciseHeight());
	}

	/**
	 * Sets the fill rule of this graphics state.
	 * 
	 * @param i_fillRule the fill rule of this graphics state
	 */
	public void setFillRule(int i_fillRule) {

		m_fillRule = i_fillRule;
	}

	/**
	 * Sets the font of this graphics state.
	 * 
	 * @param i_font the font
	 */
	public void setFont(Font i_font) {

		m_font = i_font;

		m_fontMetrics = null;
		m_metricsFont = null;
	}

	/**
	 * Sets the foreground color of this graphics state.
	 * 
	 * @param i_foregroundColor the foreground color
	 */
	public void setForegroundColor(Color i_foregroundColor) {

		m_foregroundColor = i_foregroundColor;
	}

	/**
	 * Sets the foreground pattern of this graphics state.
	 * 
	 * @param i_foregroundPattern the foreground pattern
	 */
	public void setForegroundPattern(Pattern i_foregroundPattern) {

		m_foregroundPattern = i_foregroundPattern;
	}

	/**
	 * Sets the interpolation setting for this graphics state.
	 * 
	 * @param i_interpolation the interpolation setting
	 */
	public void setInterpolation(int i_interpolation) {

		m_interpolation = i_interpolation;
	}

	/**
	 * Sets the line cap value of this graphics state.
	 * 
	 * @param i_lineCap the line cap value
	 */
	public void setLineCap(int i_lineCap) {

		m_lineCap = i_lineCap;
	}

	/**
	 * Sets the custom line dash pattern.
	 * 
	 * @param i_lineDash the custom line dash pattern
	 */
	public void setLineDash(int[] i_lineDash) {

		m_lineDash = i_lineDash;
		m_lineDashLength = 0;

		if (m_lineDash != null)
			for (int i = 0; i < m_lineDash.length; i++)
				m_lineDashLength += m_lineDash[i];
	}

	/**
	 * Sets the line join value of this graphics state.
	 * 
	 * @param i_lineJoin the line join value
	 */
	public void setLineJoin(int i_lineJoin) {

		m_lineJoin = i_lineJoin;
	}

	/**
	 * Sets the line miter limit of this graphics state.
	 * 
	 * @param i_lineMiterLimit the new line miter limit
	 */
	public void setLineMiterLimit(float i_lineMiterLimit) {

		m_lineMiterLimit = i_lineMiterLimit;
	}

	/**
	 * Sets the line style of this graphics state.
	 * 
	 * @param i_lineStyle the line style
	 */
	public void setLineStyle(int i_lineStyle) {

		m_lineStyle = i_lineStyle;
	}

	/**
	 * Sets the line width of this graphics state.
	 * 
	 * @param i_lineWidth the line width
	 */
	public void setLineWidth(float i_lineWidth) {

		m_lineWidth = i_lineWidth;
	}

	/**
	 * Sets the text antialias value of this graphics state.
	 * 
	 * @param i_textAntialias the text antialias value
	 */
	public void setTextAntialias(int i_textAntialias) {

		m_textAntialias = i_textAntialias;
	}

	/**
	 * Sets the current transformation.
	 * 
	 * @param i_transformation the current transformation
	 */
	public void setTransformation(IMatrix3f i_transformation) {

		if (m_transformation == null)
			m_transformation = new Matrix3fImpl(i_transformation);
		else
			m_transformation.set(i_transformation);
	}

	/**
	 * Specifies whether XOR mode drawing is enabled.
	 * 
	 * @param i_xorMode <code>true</code> if XOR mode should be enabled or
	 *            <code>false</code> otherwise
	 */
	public void setXORMode(boolean i_xorMode) {

		m_xorMode = i_xorMode;
	}

	/**
	 * Shears the current transformation and corrects the clipping rectangle by
	 * the given amounts.
	 * 
	 * @param i_horz the horizontal shearing amount
	 * @param i_vert the vertical shearing amount
	 */
	public void shear(float i_horz, float i_vert) {

		if (m_transformation == null)
			m_transformation = new Matrix3fImpl();

		Matrix3f shear = Draw3DCache.getMatrix3f();
		try {
			shear.setIdentity();
			shear.set(1, 0, i_horz);
			shear.set(0, 1, i_vert);

			Math3D.mul(shear, m_transformation, m_transformation);
		} finally {
			Draw3DCache.returnMatrix3f(shear);
		}
	}

	/**
	 * Translates the current transformation and corrects the clipping rectangle
	 * by the given amounts.
	 * 
	 * @param i_dX the X translation
	 * @param i_dY the Y translation
	 */
	public void translate(float i_dX, float i_dY) {

		if (m_transformation == null)
			m_transformation = new Matrix3fImpl();

		Vector2f trans = Draw3DCache.getVector2f();
		try {
			trans.set(i_dX, i_dY);
			Math3D.translate(m_transformation, trans, m_transformation);

			if (m_clip == null)
				m_clip = new PrecisionRectangle(m_parentState.getClip());

			m_clip.translate(new PrecisionPoint(-i_dX, -i_dY));
		} finally {
			Draw3DCache.returnVector2f(trans);
		}
	}
}