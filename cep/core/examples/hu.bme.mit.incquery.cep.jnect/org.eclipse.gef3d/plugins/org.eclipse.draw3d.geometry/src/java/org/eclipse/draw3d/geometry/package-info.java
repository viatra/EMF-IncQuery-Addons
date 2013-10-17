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

/**
 * 3D geometry classes.
 * These classes are used with GEF3D, their functionality is very similar
 * to Java3D's vecmath package or LWJGL's vector package<sup>1)</sup>.
 * 
 * This package/plugin does not depend from any other non-JDK package, in
 * particular it does not depend from any Eclipse (SWT, GEF, Draw2D) plugins.
 * This it can be used standalone as well. 
 * 
 * <h3>Contained Classes</h3>
 * This package contains 3D geometry classes such as
 * <ul>
 * 	<li>Vector3fImpl</li>
 *  <li>Vector4f</li>
 *  <li>Matrix3f</li>
 *  <li>Matrix4f</li>
 * </ul>
 * <p>
 * Each item is represented by 
 * <ul>
 * 	<li>an immutable interface <code>I...</code>, e.g. <code>IVector3f</code></li>
 *  <li>an mutable interface with the name of the item, e.g. <code>Vector3fImpl</code></li>
 *  <li>an implementation <code>...Impl</code>, e.g. <code>Vector3fImpl</code></li>
 * </ul>
 * </p>
 * All these classes implement the {@link java.io.Serializable} and 
 * {@link Cloneable} interfaces. There is no Vector2f, class
 * {@link org.eclipse.draw2d.geometry.Ray} should be used instead.
 * <p>
 * We do not distinguish between tuple, vector, dimension, or point.
 * </p>
 * <p>
 * These classes define only constructors, getters and setters, cast operations,
 * and some basic methods; most mathematical operations are defined in Math3D.
 * </p>
 * <p>
 * <small>Explanation: This design was chosen to avoid too much operations: 
 * In other frameworks several variants of 
 * basically the same operation is defined, with confusing semantics. E.g. in
 * Java3D's vecmath, Tuple3f.absolute() makes all values of a vector absolute, 
 * Tuple3f.absolute(Tuple3f) sets the values of the given tuple. In Draw<b>2D</b>,
 * Point.negate() negates the values of the object itself, while Point.getNegated()
 * returns a new instance with negated values. In Draw3D we simply provide a single
 * operation, that is Math3D.abs(IVector3f, Vector3f) 
 * (or Math3D.negate(IVector3f, Vector3f) respectively), see below for further details.
 * </small>
 * </p>
 * 
 * Especially for use within Draw3D, the following classes are defined:
 * <ul>
 * 	<li>SyncedVector3f -- a vector3f based on a {@link org.eclpise.draw2d.geometry.Vector2f}</li>
 *  <li>BoundingBox (with immutable and mutable interfaces)</li>
 *  <li>SyncedBounds3D -- a bounding box based on {@link org.eclpise.draw2d.geometry.Rectangle}</li>
 * </ul>
 * The synchronized classes only stores the delta of a 3D vector and a 2D vector,
 * that is the floating values of the x and y attributes and the z value. 
 * <p>
 * >The synchronized classes do not store a reference
 * to the 2D object with which they are synchronized. This is not possible in 
 * many situations, since the clients may not only modify the values of the
 * 2D object (which would cause no problem), but the reference (of the
 * attribute) is also changed (see {@link org.eclipse.draw3d.Figure3D#getPreferredSize3D()}
 * and its implementation, especially  {@link org.eclipse.draw2d.Figure#getPreferredSize(int, int)}
 * Thus, the synced classes cannot implement the mutable interface! Since 
 * the draw3d.geometry package is not intended to have dependencies from
 * any other Eclipse plugins, these synchronization classes are implemented
 * in plugin draw3D.
 * </p>
 * 
 * 
 * <p>
 * All these upper mutable classes (and interfaces) implement the interface
 * </p>
 * <ul>
 * 	<li>Transformable, 3D version of {@link org.eclipse.draw2d.geometry.Translatable}</li>
 * </ul>
 * 
 * <h3>Operations</h3>
 * Most 3D operations are defined in the following class: 
 * <ul>
 * 	<li>Math3D -- Basic operations (such as add, mult), 
 * 		and 3D versions of operations defined in {@link java.lang.Math}</li>
 * </ul>
 * The vector and matrix operations are provided as static methods. 
 * For performance reasons, these
 * method signatures all follow this pattern:
 * <br/><code>static MT operation(IT inParameter1, IT inParameter2, MT outParameter)</code><br/>
 * <code>MT</code> is to be replaced by the immutable interface,
 * <code>IT</code> by the mutable interface respectively.
 * Simply spoken <code>inParameter1</code> and <code>inParameter2</code> are 
 * handled confirming the operation, e.g. added or multiplied, and the result
 * is stored in <code>outParameter</code>. The result is also returned by
 * the method. If the <code>outParameter</code> is null, a new instance of type
 * <code>T</code> is created. There is a trap which is handled by the operations:
 * The <code>outParameter</code> can also be passed as an <code>inParameter</code>.
 * In this case it may be possible that a value of the in/out-Parameter is
 * overwritten by a result value -- the methods take care that the operation is
 * correctly calculated by using temporary variables.
 * 
 * 
 * <p>All methods and classes of this package are tested using JUnit tests.</p>
 * 
 * <h3>Usage</h3>
 * <p>Since all classes are defined by immutable and mutable interfaces, 
 * classes using these 3D geometry classes should use the immutable interface
 * where ever possible. {@link org.eclipse.draw2d} doesn't distinguish between
 * immutable and mutable, thus always the mutable version is returned and we
 * find comments such as "callers of this method must not modify the
 * returned Rectangle." (from {@link org.eclipse.draw2d.Figure#getBounds()}. 
 * This problem is solved in Draw3D by using two kind of interfaces.
 * </p>
 * 
 * <p>Most render frameworks such as LWJGL provide their own implementations
 * of 3D geometry classes. Within the Draw3D adapters 
 * (e.g. org.eclipse.draw3d.lwjgl) special adapter classes are implemented for
 * easily casting a draw3d 3D geometry object into an render framework 
 * specific ones.
 * </p>
 * 
 * <h3>Performance Isues</h3>
 * A discussion about performance issues can be found at 
 * {@link http://lwjgl.org/forum/index.php/topic,2456.0.html}. Here is a test
 * which was implemented during this discussion:
 * 
 * <h4>The Test</h4>
 * Tested were two classes (or interfaces) implementing a Vector3f version. 
 * The first class (or interface) provides a read-only access while the second
 * read-write access. Additional, a static method "add" is introduced as
 * implemented in the current Vector3f class. Three different design 
 * alternatives were implemented:
 * 
 * <dl>
 * 	<dt>Concrete:</dt>
 * 	<dd>The first one (called "Concrete") implements a concrete readable class
 * with final getters and protected fields. The writable class extends this 
 * class providing setters.</dd>
 * <dt>Abstract:</dt>
 * 	<dd>The second version (called "Abstract") implements an abstract readable
 * class with abstract getters and no fields. The writable class extends this 
 * class, defining the fields (public) and implementing final getters and 
 * setters.</dd>
 * <dt>Interface:</dt>
 * 	<dd>The third version (called "Interface") defines a read-only interfaces
 *  with getters, the writable class implements this interface and defines all
 *  fields (public) and final getters and setters.</dd>
 * </dl>
 * 
 * <p>The static add method has a similar signature in all three versions: 
 * left and right vector are passed as read-only instances, the result is a
 * writable instance. If the passed result is null, a temporary variable is
 * constructed and returned, otherwise the result is filled.</p>
 * 
 * <p>The benchmark was executed 4 times, two times with a server VM and two
 * times with a client VM. For each VM, 1000000 calls of the add method and a
 * setter were repeated 100 and 1000 times. The result are shown below and
 * illustrated in the image.
 * 
 * <h4>The Result</h4>
 * <p>On OS X 10.4, the last version using interfaces is the slowest one in all
 * tests. Using an abstract class is more or less as fast as using a concrete
 * readable class. Interestingly it is even sometimes a little bit slower!
 * Also surprising is the fact that in some tests (with the server VM) creating
 * new temporary instances (i.e. passing null as result parameter) is faster 
 * than using an in-out parameter. The server VM is in all tests much faster 
 * than the client VM. in some cases about 5 times. Even the slowest server 
 * tests is nearly as fast as the fastest client test! 
 * <image src="../../../../../performance/benchmark_osx_jdk15.png" />
 * </p>
 * <p>On other machines with different JDKs and OS, different results were
 * determined!</p>
 * 
 * <h4>Conclusion</h4>
 * Using abstract readable base classes is the winner on OS X, but not on all
 * machines. It is just as fast as using concrete classes. On the other hand, 
 * interfaces are very useful if adapters are to be implemented and may
 * reduce the need for copying data.
 * <p>
 * We have decided to use interfaces here, in most mathematical functions the
 * in-parameters are casted to well-known types with direct field access (which
 * is a simple cast in most cases, but it is also possible to convert completely
 * different implementations.</p>
 * 
 * <h3>Performance Issues Regarding Matrix Implementations</h3>
 * <p>
 * The entries of a matrix of vector can be implemented using
 * <ol>
 * <li>a field for every entry, e.g. float</li>
 * <li>an array, e.g. float[]</li>
 * <li>a buffer, e.g. FloatBuffer</li>
 * </ol>
 * Here are the results of 1.000.000 method calls for
 * different implementations of {@link Matrix3f} (in ms):
 * <table>
 * <tr><th>Method</th>			<th>Field</th><th>Array</th><th>Buffer</th></tr>
 * <tr><th>Constructor</th>			<td>42</td><td>52</td><td>172</td></tr>
 * <tr><th>Copy-Constructor</th>	<td>46</td><td>75</td><td>156</td></tr>
 * <tr><th>set</th>					<td>12</td><td>29</td><td> 64</td></tr>
 * <tr><th>set(different impl)</th>	<td>70</td><td>22</td><td> 74</td></tr>
 * <tr><th>setIdentity</th>			<td>11</td><td>43</td><td> 55</td></tr>
 * <tr><th>setZero</th>				<td>10</td><td>47</td><td> 55</td></tr>
 * <tr><th>equals (same type)</th>	<td>41</td><td>45</td><td>118</td></tr>
 * <tr><th>determinante</th>		<td>34</td><td>35</td><td>229</td></tr>
 * </table>
 * As you can see, the field backed implementation is the fastest in all cases,
 * except when casting another type into that specific type (which is caused
 * by the implementation and may be optimized).
 * </p>
 *  
 * <p>The array and buffer based implementations and the test are included in
 * the test package.</p> 
 * 
 * <h4>Conclusion and Implementation Notes</h4>
 * <p>We have implemented all mathematical constructs, e.g. matrices, 
 * using fields, that is using attributes <code>float a12, ...</code>. Since we
 * only provide a single implementation, in most cases no conversions are 
 * required.</p>
 * 
 * <p>No setter or getter are provided for setting or getting a single entry of 
 * matrices. As other performance tests have shown, this is only faster then 
 * converting the whole class into a well known class (with direct field access)
 * if very few entries are accessed, which isn't the case in most matrix 
 * operations.</p>
 * 
 * <p>The fields of a matrix are all called <code>a<i>RC</i></code>,
 * in which <i>R</i> is the row and <i>C</i> is the column, beginning with 1.
 * For example, the fields a matrix <code>a11, a12, a13, a21, ..</code>. 
 * For accessing a single entry in an array, constant index values are defined 
 * in the immutable interfaces, e.g. {@link IMatrix3f#r1c1}. This naming was 
 * chosen since most mathematical articles (at least in wikipedia) use this 
 * names, too.
 * </p>
 * 
 * <h3>Note on hash codes</h3>
 * <p>All implementations should the same strategy for computing the hash code:
 * The entries of the structure are converted into an array, and then
 * Arrays#hashCode(float[]) is used for calculating the code. This is not the
 * fastest way of calculating the hash, but it ensures that different implementations
 * return the same hash code.</p>
 *  
 * <h3>Future Work</h3>
 * <p>There are some calculations currently handled by other classes of the Draw3D
 * project. These include
 * </p>
 * <ul>
 * 	<li>{@link org.eclipse.draw3d.CoordinateConverter}</li>
 * 	</ul>
 * This class should be moved to this package.
 * <p>
 * Besides, special methods, interfaces or classes valuable within Draw3D/GEF3D
 * should be implemented.
 * </p>
 * 
 * 
 *  
 * <p><small><sup>1)</sup>Even if the interfaces are very similar to the LWJGL
 * interfaces, the code was not copied, but a new version was implemented from
 * scratch by Jens von Pilgrim</small></p> 
 *  
 * @author 	Jens von Pilgrim
 * @version	$Revision$
 * @since 	Sep 29, 2008
 */
package org.eclipse.draw3d.geometry;

