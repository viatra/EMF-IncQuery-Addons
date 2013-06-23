package org.jnect.demo.incquery.esper.robot;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.jnect.core.KinectManager;
import org.jnect.demo.incquery.viatra.cep.RobotCepAdapter;

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
				
				List<IncQueryMatcher<? extends IPatternMatch>> matchers = new ArrayList<IncQueryMatcher<? extends IPatternMatch>>();
				matchers.add(FSMatcher.on(e));
				matchers.add(FEMatcher.on(e));
				matchers.add(BSMatcher.on(e));
				matchers.add(BEMatcher.on(e));
				
				new RobotCepAdapter(matchers);

			} catch (IncQueryException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Start skeleton simulator first!");
		}
		return null;
	}

}
