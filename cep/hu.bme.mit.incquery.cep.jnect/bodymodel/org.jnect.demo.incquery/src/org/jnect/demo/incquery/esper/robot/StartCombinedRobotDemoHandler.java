package org.jnect.demo.incquery.esper.robot;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.jnect.core.KinectManager;
import org.jnect.demo.incquery.viatra.cep.ViatraCepAdapter;

import bodymodel.ymca.BEMatcher;
import bodymodel.ymca.BSMatcher;
import bodymodel.ymca.FEMatcher;
import bodymodel.ymca.FSMatcher;


/**
 * Handler class for the Jnect/IncQuery awt.Robot demo.
 * 
 * @author istvanrath
 * 
 */
public class StartCombinedRobotDemoHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (KinectManager.INSTANCE.isSkeletonTrackingStarted()) {

			try {
				Notifier km = KinectManager.INSTANCE.getSkeletonModel();
				IncQueryEngine e = IncQueryEngine.on(km);
				// adapters for the powerpoint robot demo
				ViatraCepAdapter vca = new ViatraCepAdapter();
				vca.registerMatcher(FSMatcher.on(e));
				vca.registerMatcher(FEMatcher.on(e));
				vca.registerMatcher(BSMatcher.on(e));
				vca.registerMatcher(BEMatcher.on(e));

			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Start skeleton simulator first!");
		}
		return null;
	}

}
