package org.jnect.demo.incquery.viatra.cep;

import hu.bme.mit.incquery.cep.api.ViatraCepAdapter;
import hu.bme.mit.incquery.cep.api.evm.CepEventType;
import hu.bme.mit.incquery.cep.api.runtime.EventModelManager;
import hu.bme.mit.incquery.cep.api.strategy.Strategy;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.metamodels.internalsm.NoiseFiltering;

import java.util.List;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.incquery.databinding.runtime.api.IncQueryHeadlessRealm;
import org.eclipse.incquery.databinding.runtime.api.IncQueryObservables;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.jnect.demo.incquery.esper.utils.Logger;
import org.jnect.demo.incquery.viatra.cep.events.FE_found;
import org.jnect.demo.incquery.viatra.cep.events.FE_lost;
import org.jnect.demo.incquery.viatra.cep.events.FS_found;
import org.jnect.demo.incquery.viatra.cep.events.FS_lost;
import org.jnect.demo.incquery.viatra.cep.patterns.FS_FE_Pattern;

/**
 * 
 * @author idavid
 * 
 */
public class RobotCepAdapter extends ViatraCepAdapter {
	IEventSource source;
	List<IncQueryMatcher<? extends IPatternMatch>> matchers;

	public RobotCepAdapter(List<IncQueryMatcher<? extends IPatternMatch>> matchers) {
		new IncQueryHeadlessRealm();
		//List<EventPattern> eventPatterns = new ArrayList<EventPattern>();
		//eventPatterns.add(new FS_FE_Pattern());
		this.eventModelManager = new EventModelManager(Strategy.getDefault());
		this.eventModelManager.assignEventPattern(new FS_FE_Pattern(), NoiseFiltering.STRICT);
		this.matchers = matchers;

		// TODO this call should be made somewhere in the CEP after registering
		// the adapter
		registerAdapter();
	}

	@Override
	public void registerAdapter() {
		for (IncQueryMatcher<? extends IPatternMatch> matcher : matchers) {
			IObservableSet os = IncQueryObservables.observeMatchesAsSet(matcher);
			os.addSetChangeListener(new ISetChangeListener() {
				@Override
				public void handleSetChange(SetChangeEvent event) {
					for (Object _o : event.diff.getAdditions()) {
						IPatternMatch pm = (IPatternMatch) _o;
						sendEvent(pm.patternName(), CepEventType.APPEARED);
					}
					for (Object _o : event.diff.getRemovals()) {
						IPatternMatch pm = (IPatternMatch) _o;
						sendEvent(pm.patternName(), CepEventType.DISAPPEARED);
					}
				}
			});
		}
	}

	private void sendEvent(String iqPatternName, CepEventType t) {
		if (iqPatternName.equalsIgnoreCase("bodymodel.ymca.FE")) {
			switch (t) {
			case APPEARED:
				Logger.log("ROBOTCEPADAPTER: Event " + iqPatternName + " found.");
				eventQueue.push(new FE_found(source));
				return;
			case DISAPPEARED:
				Logger.log("ROBOTCEPADAPTER: Event " + iqPatternName + " lost.");
				eventQueue.push(new FE_lost(source));
				return;
			}
		} else if (iqPatternName.equalsIgnoreCase("bodymodel.ymca.FS")) {
			switch (t) {
			case APPEARED:
				Logger.log("ROBOTCEPADAPTER: Event " + iqPatternName + " found.");
				eventQueue.push(new FS_found(source));
				return;
			case DISAPPEARED:
				Logger.log("ROBOTCEPADAPTER: Event " + iqPatternName + " lost.");
				eventQueue.push(new FS_lost(source));
				return;
			}
		}
	}
}
