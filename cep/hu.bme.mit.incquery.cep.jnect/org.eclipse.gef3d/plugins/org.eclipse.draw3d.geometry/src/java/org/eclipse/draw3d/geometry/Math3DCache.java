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
package org.eclipse.draw3d.geometry;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;

/**
 * Caches objects that are often used as temporary variables during
 * calculcations.
 * 
 * @author Kristian Duske
 * @version $Revision$
 * @since 29.07.2009
 */
public class Math3DCache {

	private static final Logger log =
		Logger.getLogger(Math3DCache.class.getName());

	private static final Queue<BoundingBox> m_boundingBox =
		new LinkedList<BoundingBox>();

	private static int m_boundingBoxCounter = 0;

	/**
	 * Count instantiations and warn when they reach a threshold.
	 */
	protected static boolean m_count = true;

	/**
	 * If the number of instantiations for a specific class exceeds this number,
	 * warnings are generated.
	 */
	protected static int m_counterThreshold = 100;

	/**
	 * If cache size for a specific class exceeds this number, warnings are
	 * generated.
	 */
	protected static int m_instanceThreshold = 100;

	private static final Queue<Matrix2f> m_matrix2f =
		new LinkedList<Matrix2f>();

	private static int m_matrix2fCounter = 0;

	private static final Queue<Matrix3f> m_matrix3f =
		new LinkedList<Matrix3f>();

	private static int m_matrix3fCounter = 0;

	private static final Queue<Matrix4f> m_matrix4f =
		new LinkedList<Matrix4f>();

	private static int m_matrix4fCounter = 0;

	private static final Queue<ParaxialBoundingBox> m_paraxialBoundingBox =
		new LinkedList<ParaxialBoundingBox>();

	private static int m_paraxialBoundingBoxCounter = 0;

	private static final Queue<Position3D> m_position3D =
		new LinkedList<Position3D>();

	private static int m_position3DCounter = 0;

	/**
	 * Synchronize access to the cache queues.
	 */
	protected static boolean m_synchronized = false;

	private static final Queue<Vector2f> m_vector2f =
		new LinkedList<Vector2f>();

	private static int m_vector2fCounter = 0;

	private static final Queue<Vector3f> m_vector3f =
		new LinkedList<Vector3f>();

	private static int m_vector3fCounter = 0;

	private static final Queue<Vector4f> m_vector4f =
		new LinkedList<Vector4f>();

	private static int m_vector4fCounter = 0;

	private static BoundingBox createBoundingBox() {

		if (m_count) {
			m_boundingBoxCounter++;
			if (m_boundingBoxCounter > m_counterThreshold)
				log.warning("created more than " + m_counterThreshold
					+ " bounding boxes, are you properly returning them?");
		}

		return new BoundingBoxImpl();
	}

	private static Matrix2fImpl createMatrix2f() {

		if (m_count) {
			m_matrix2fCounter++;
			if (m_matrix2fCounter > m_counterThreshold)
				log.warning("created more than " + m_counterThreshold
					+ " 2f matrices, are you properly returning them?");
		}

		return new Matrix2fImpl();
	}

	private static Matrix3fImpl createMatrix3f() {

		if (m_count) {
			m_matrix3fCounter++;
			if (m_matrix3fCounter > m_counterThreshold)
				log.warning("created more than " + m_counterThreshold
					+ " 3f matrices, are you properly returning them?");
		}

		return new Matrix3fImpl();
	}

	private static Matrix4fImpl createMatrix4f() {

		if (m_count) {
			m_matrix4fCounter++;
			if (m_matrix4fCounter > m_counterThreshold)
				log.warning("created more than " + m_counterThreshold
					+ " 4f matrices, are you properly returning them?");
		}

		return new Matrix4fImpl();
	}

	private static ParaxialBoundingBoxImpl createParaxialBoundingBox() {

		if (m_count) {
			m_paraxialBoundingBoxCounter++;
			if (m_paraxialBoundingBoxCounter > m_counterThreshold)
				log.warning("created more than "
					+ m_counterThreshold
					+ " paraxial bounding boxes, are you properly returning them?");
		}

		return new ParaxialBoundingBoxImpl();
	}

	private static Position3D createPosition3D() {

		if (m_count) {
			m_position3DCounter++;
			if (m_position3DCounter > m_counterThreshold)
				log.warning("created more than " + m_counterThreshold
					+ " 3D positions, are you properly returning them?");
		}

		return Position3DUtil.createAbsolutePosition();
	}

	private static Vector2fImpl createVector2f() {

		if (m_count) {
			m_vector2fCounter++;
			if (m_vector2fCounter > m_counterThreshold)
				log.warning("created more than " + m_counterThreshold
					+ " 2f vectors, are you properly returning them?");
		}

		return new Vector2fImpl();
	}

	private static Vector3fImpl createVector3f() {

		if (m_count) {
			m_vector3fCounter++;
			if (m_vector3fCounter > m_counterThreshold)
				log.warning("created more than " + m_counterThreshold
					+ " 3f vectors, are you properly returning them?");
		}

		return new Vector3fImpl();
	}

	private static Vector4fImpl createVector4f() {

		if (m_count) {
			m_vector4fCounter++;
			if (m_vector4fCounter > m_counterThreshold)
				log.warning("created more than " + m_counterThreshold
					+ " 4f vectors, are you properly returning them?");
		}

		return new Vector4fImpl();
	}

	/**
	 * Returns a cached {@link BoundingBox}.
	 * 
	 * @return a cached bounding box
	 */
	public static BoundingBox getBoundingBox() {

		if (m_synchronized) {
			synchronized (m_boundingBox) {
				if (m_boundingBox.isEmpty())
					return createBoundingBox();
				else
					return m_boundingBox.remove();
			}
		} else {
			if (m_boundingBox.isEmpty())
				return createBoundingBox();
			else
				return m_boundingBox.remove();
		}
	}

	/**
	 * Returns a cached {@link Matrix2f}.
	 * 
	 * @return a cached matrix
	 */
	public static Matrix2f getMatrix2f() {

		if (m_synchronized) {
			synchronized (m_matrix2f) {
				if (m_matrix2f.isEmpty())
					return createMatrix2f();
				else
					return m_matrix2f.remove();
			}
		} else {
			if (m_matrix2f.isEmpty())
				return createMatrix2f();
			else
				return m_matrix2f.remove();
		}
	}

	/**
	 * Returns a cached {@link Matrix3f}.
	 * 
	 * @return a cached matrix
	 */
	public static Matrix3f getMatrix3f() {

		if (m_synchronized) {
			synchronized (m_matrix3f) {
				if (m_matrix3f.isEmpty())
					return createMatrix3f();
				else
					return m_matrix3f.remove();
			}
		} else {
			if (m_matrix3f.isEmpty())
				return createMatrix3f();
			else
				return m_matrix3f.remove();
		}
	}

	/**
	 * Returns a cached {@link Matrix4f}.
	 * 
	 * @return a cached matrix
	 */
	public static Matrix4f getMatrix4f() {

		if (m_synchronized) {
			synchronized (m_matrix4f) {
				if (m_matrix4f.isEmpty())
					return createMatrix4f();
				else
					return m_matrix4f.remove();
			}
		} else {
			if (m_matrix4f.isEmpty())
				return createMatrix4f();
			else
				return m_matrix4f.remove();
		}
	}

	/**
	 * Returns a cached {@link ParaxialBoundingBox}.
	 * 
	 * @return a cached paraxial bounding box
	 */
	public static ParaxialBoundingBox getParaxialBoundingBox() {

		if (m_synchronized) {
			synchronized (m_paraxialBoundingBox) {
				if (m_paraxialBoundingBox.isEmpty())
					return createParaxialBoundingBox();
				else
					return m_paraxialBoundingBox.remove();
			}
		} else {
			if (m_paraxialBoundingBox.isEmpty())
				return createParaxialBoundingBox();
			else
				return m_paraxialBoundingBox.remove();
		}
	}

	/**
	 * Returns a cached absolute {@link Position3D}.
	 * 
	 * @return a cached absolute position 3d
	 */
	public static Position3D getPosition3D() {

		if (m_synchronized) {
			synchronized (m_position3D) {
				if (m_position3D.isEmpty())
					return createPosition3D();
				else
					return m_position3D.remove();
			}
		} else {
			if (m_position3D.isEmpty())
				return createPosition3D();
			else
				return m_position3D.remove();
		}
	}

	/**
	 * Returns a cached {@link Vector2f}.
	 * 
	 * @return a cached vector
	 */
	public static Vector2f getVector2f() {

		if (m_synchronized) {
			synchronized (m_vector2f) {
				if (m_vector2f.isEmpty())
					return createVector2f();
				else
					return m_vector2f.remove();
			}
		} else {
			if (m_vector2f.isEmpty())
				return createVector2f();
			else
				return m_vector2f.remove();
		}
	}

	/**
	 * Returns a cached {@link Vector3f}.
	 * 
	 * @return a cached vector
	 */
	public static Vector3f getVector3f() {

		if (m_synchronized) {
			synchronized (m_vector3f) {
				if (m_vector3f.isEmpty())
					return createVector3f();
				else
					return m_vector3f.remove();
			}
		} else {
			if (m_vector3f.isEmpty())
				return createVector3f();
			else
				return m_vector3f.remove();
		}
	}

	/**
	 * Returns a cached {@link Vector4f}.
	 * 
	 * @return a cached vector
	 */
	public static Vector4f getVector4f() {

		if (m_synchronized) {
			synchronized (m_vector4f) {
				if (m_vector4f.isEmpty())
					return createVector4f();
				else
					return m_vector4f.remove();
			}
		} else {
			if (m_vector4f.isEmpty())
				return createVector4f();
			else
				return m_vector4f.remove();
		}
	}

	/**
	 * Returns the given bounding boxes to the cache. If any of the given
	 * bounding boxes is <code>null</code>, it is ignored.
	 * 
	 * @param i_bs the bounding boxes to return
	 */
	public static void returnBoundingBox(BoundingBox... i_bs) {

		if (m_synchronized)
			synchronized (m_boundingBox) {
				for (BoundingBox b : i_bs)
					if (b != null)
						m_boundingBox.offer(b);
			}
		else
			for (BoundingBox b : i_bs)
				if (b != null)
					m_boundingBox.offer(b);

		if (m_count && m_boundingBox.size() > m_instanceThreshold)
			log.warning("cache contains more than " + m_instanceThreshold
				+ " bounding boxes");
	}

	/**
	 * Returns the given matrices to the cache. If any of the given matrices is
	 * <code>null</code>, it is ignored.
	 * 
	 * @param i_ms the matrices to return
	 */
	public static void returnMatrix2f(Matrix2f... i_ms) {

		if (m_synchronized)
			synchronized (m_matrix2f) {
				for (Matrix2f m : i_ms)
					if (m != null)
						m_matrix2f.offer(m);
			}
		else
			for (Matrix2f m : i_ms)
				if (m != null)
					m_matrix2f.offer(m);

		if (m_count && m_matrix2f.size() > m_instanceThreshold)
			log.warning("cache contains more than " + m_instanceThreshold
				+ " 2f matrices");

	}

	/**
	 * Returns the given matrices to the cache. If any of the given matrices is
	 * <code>null</code>, it is ignored.
	 * 
	 * @param i_ms the matrices to return
	 */
	public static void returnMatrix3f(Matrix3f... i_ms) {

		if (m_synchronized)
			synchronized (m_matrix3f) {
				for (Matrix3f m : i_ms)
					if (m != null)
						m_matrix3f.offer(m);
			}
		else
			for (Matrix3f m : i_ms)
				if (m != null)
					m_matrix3f.offer(m);

		if (m_count && m_matrix3f.size() > m_instanceThreshold)
			log.warning("cache contains more than " + m_instanceThreshold
				+ " 3f matrices");

	}

	/**
	 * Returns the given matrices to the cache. If any of the given matrices is
	 * <code>null</code>, it is ignored.
	 * 
	 * @param i_ms the matrices to return
	 */
	public static void returnMatrix4f(Matrix4f... i_ms) {

		if (m_synchronized)
			synchronized (m_matrix4f) {
				for (Matrix4f m : i_ms)
					if (m != null)
						m_matrix4f.offer(m);
			}
		else
			for (Matrix4f m : i_ms)
				if (m != null)
					m_matrix4f.offer(m);

		if (m_count && m_matrix4f.size() > m_instanceThreshold)
			log.warning("cache contains more than " + m_instanceThreshold
				+ " 4f matrices");
	}

	/**
	 * Returns the given paraxial bounding boxes to the cache. If any of the
	 * given paraxial bounding boxes is <code>null</code>, it is ignored.
	 * 
	 * @param i_ps the paraxial bounding boxes to return
	 */
	public static void returnParaxialBoundingBox(ParaxialBoundingBox... i_ps) {

		if (m_synchronized)
			synchronized (m_paraxialBoundingBox) {
				for (ParaxialBoundingBox p : i_ps)
					if (p != null)
						m_paraxialBoundingBox.offer(p);
			}
		else
			for (ParaxialBoundingBox p : i_ps)
				if (p != null)
					m_paraxialBoundingBox.offer(p);

		if (m_count && m_paraxialBoundingBox.size() > m_instanceThreshold)
			log.warning("cache contains more than " + m_instanceThreshold
				+ " paraxial bounding boxes");
	}

	/**
	 * Returns the given positions to the cache. If any of the given positions
	 * is <code>null</code>, it is ignored.
	 * 
	 * @param i_ps the positions to return
	 */
	public static void returnPosition3D(Position3D... i_ps) {

		if (m_synchronized)
			synchronized (m_position3D) {
				for (Position3D p : i_ps)
					if (p != null)
						m_position3D.offer(p);
			}
		else
			for (Position3D p : i_ps)
				if (p != null)
					m_position3D.offer(p);

		if (m_count && m_position3D.size() > m_instanceThreshold)
			log.warning("cache contains more than " + m_instanceThreshold
				+ " 3D positions");
	}

	/**
	 * Returns the given vectors to the cache. If any of the given vectors is
	 * <code>null</code>, it is ignored.
	 * 
	 * @param i_vs the vectors to return
	 */
	public static void returnVector2f(Vector2f... i_vs) {

		if (m_synchronized)
			synchronized (m_vector2f) {
				for (Vector2f v : i_vs)
					if (v != null)
						m_vector2f.offer(v);
			}
		else
			for (Vector2f v : i_vs)
				if (v != null)
					m_vector2f.offer(v);

		if (m_count && m_vector2f.size() > m_instanceThreshold)
			log.warning("cache contains more than " + m_instanceThreshold
				+ " 2f vectors");
	}

	/**
	 * Returns the given vectors to the cache. If any of the given vectors is
	 * <code>null</code>, it is ignored.
	 * 
	 * @param i_vs the vectors to return
	 */
	public static void returnVector3f(Vector3f... i_vs) {

		if (m_synchronized)
			synchronized (m_vector3f) {
				for (Vector3f v : i_vs)
					if (v != null)
						m_vector3f.offer(v);
			}
		else
			for (Vector3f v : i_vs)
				if (v != null)
					m_vector3f.offer(v);

		if (m_count && m_vector3f.size() > m_instanceThreshold)
			log.warning("cache contains more than " + m_instanceThreshold
				+ " 3f vectors");
	}

	/**
	 * Returns the given vectors to the cache. If any of the given vectors is
	 * <code>null</code>, it is ignored.
	 * 
	 * @param i_vs the vectors to return
	 */
	public static void returnVector4f(Vector4f... i_vs) {

		if (m_synchronized)
			synchronized (m_vector4f) {
				for (Vector4f v : i_vs)
					if (v != null)
						m_vector4f.offer(v);
			}
		else
			for (Vector4f v : i_vs)
				if (v != null)
					m_vector4f.offer(v);

		if (m_count && m_vector4f.size() > m_instanceThreshold)
			log.warning("cache contains more than " + m_instanceThreshold
				+ " 4f vectors");
	}
}
