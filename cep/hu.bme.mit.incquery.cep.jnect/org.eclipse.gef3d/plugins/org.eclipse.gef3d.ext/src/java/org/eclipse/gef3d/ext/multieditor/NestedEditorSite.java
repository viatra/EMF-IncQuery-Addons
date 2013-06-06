package org.eclipse.gef3d.ext.multieditor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.ui.IEditorSite;

/**
 * Proxy, delegates all requests to nested site, except getId(). This proxy is
 * created in
 * {@link AbstractMultiEditor3D#addEditor(org.eclipse.ui.IEditorInput)} and set
 * as editor site for nested editors. The id translation is required in order to
 * let GMF providers and other ID aware classes support the nested editor, even
 * if they do not support the multi editor.
 * 
 * @author Jens von Pilgrim
 * @version $Revision$
 * @since May 24, 2010
 */
public class NestedEditorSite implements InvocationHandler {

	public static IEditorSite createNestedEditorSite(String nestedID,
		IEditorSite editorSite) {
		return (IEditorSite) java.lang.reflect.Proxy.newProxyInstance(
			editorSite.getClass().getClassLoader(), editorSite.getClass()
				.getInterfaces(), new NestedEditorSite(nestedID, editorSite));
	}

	String nestedID;

	Object multiEditorSite;

	/**
	 * @param i_nestedID
	 * @param i_nestedInstance
	 */
	public NestedEditorSite(String i_nestedID, Object i_multiEditorSite) {
		nestedID = i_nestedID;
		multiEditorSite = i_multiEditorSite;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
		throws Throwable {
		if ("getId".equals(method.getName())
			&& (args == null || args.length == 0)) {
			return nestedID;
		}
		Object result;

		try {
			result = method.invoke(multiEditorSite, args);
		} catch (InvocationTargetException e) {
			throw e.getTargetException();
		} catch (Exception e) {
			throw new RuntimeException("unexpected invocation exception: "
				+ e.getMessage());
		}
		return result;

	}
}