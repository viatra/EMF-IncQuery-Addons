package hu.bme.mit.incquery.cep.performance.size;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.performance.events.ComponentA_Event;
import hu.bme.mit.incquery.cep.performance.events.ComponentB_Event;
import hu.bme.mit.incquery.cep.performance.events.ComponentC_Event;
import hu.bme.mit.incquery.cep.performance.patterns.atomic.ComponentA_Pattern;
import hu.bme.mit.incquery.cep.performance.patterns.atomic.ComponentB_Pattern;
import hu.bme.mit.incquery.cep.performance.patterns.atomic.ComponentC_Pattern;
import hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent1_Pattern;

public class ObjectSizeTester {
	
	
	
	public static void main(String[] args) {
//		System.out.println(Runtime.getRuntime().maxMemory());
//		
//		ObjectSizeTester t =new ObjectSizeTester();
//		System.out.println(t.getmem());
		int i = 10;
		MyEventSource source = new MyEventSource();
		ComponentA_Event componentA_Event = new ComponentA_Event(source);
		componentA_Event.getParameters().add(new ComponentB_Event(null));
		Object o2 = new ComponentB_Event(null);
		Object o3 = new ComponentC_Event(null);
		Object p = new ComponentA_Pattern();
		Object p2 = new ComponentB_Pattern();
		Object p3 = new ComponentC_Pattern();
		Object p4 = new CompoundTransactionEvent1_Pattern();
		while(true){}
//		System.out.println(t.getmem());
//		System.out.println(ObjectSizeFetcher.getObjectSize(new ComponentA_Event(null)));
	}
	
	
	public long getmem() {
		collectGarbage();
	    long totalMemory = Runtime.getRuntime().totalMemory();
	    collectGarbage();
	    long freeMemory = Runtime.getRuntime().freeMemory();
	    return (totalMemory - freeMemory);
	}
	
	@SuppressWarnings("static-access")
	private void collectGarbage() {
	    try {
	      System.gc();
	      Thread.currentThread().sleep(100);
	      System.runFinalization();
	      Thread.currentThread().sleep(100);
	    }
	    catch (InterruptedException ex){
	      ex.printStackTrace();
	    }
	  }
}
