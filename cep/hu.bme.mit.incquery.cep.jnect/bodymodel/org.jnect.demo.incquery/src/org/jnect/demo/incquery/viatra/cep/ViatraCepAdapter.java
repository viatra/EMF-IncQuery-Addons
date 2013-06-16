package org.jnect.demo.incquery.viatra.cep;

import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.runtime.EventQueue;
import hu.bme.mit.incquery.cep.runtime.evaluation.EventModelManager;
import hu.bme.mit.incquery.cep.runtime.evaluation.strategy.Strategy;
import hu.bme.mit.incquery.cep.specific.evm.CepEventType;

import java.util.ArrayList;
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
public class ViatraCepAdapter {
	EventModelManager manager;
	EventQueue queue = EventQueue.getInstance();
	IEventSource source;
	
	public ViatraCepAdapter() {
		new IncQueryHeadlessRealm();
		List<EventPattern> eventPatterns = new ArrayList<EventPattern>();
		eventPatterns.add(new FS_FE_Pattern());
		manager = new EventModelManager(Strategy.getDefault());
		manager.assignEventPatterns(eventPatterns);
	}
	
	public void registerMatcher(IncQueryMatcher<? extends IPatternMatch> matcher) {
		IObservableSet os = IncQueryObservables.observeMatchesAsSet(matcher);
		os.addSetChangeListener(new ISetChangeListener() {

			@Override
			public void handleSetChange(SetChangeEvent event) {
				for (Object _o : event.diff.getAdditions()) {
					IPatternMatch pm = (IPatternMatch) _o;
					Logger.log("VIATRACEPADAPTER: Event " + pm.patternName() + " found.");

					sentEvent(pm.patternName(), CepEventType.APPEARED);
				}
				for (Object _o : event.diff.getRemovals()) {
					IPatternMatch pm = (IPatternMatch) _o;
					Logger.log("VIATRACEPADAPTER: Event " + pm.patternName() + " lost.");
					sentEvent(pm.patternName(), CepEventType.DISAPPEARED);
				}
			}
		});
	}

	private void sentEvent(String iqPatternName, CepEventType t) {

		if (iqPatternName.equalsIgnoreCase("bodymodel.ymca.FE")) {
			switch (t) {
			case APPEARED:
				queue.push(new FE_found(source));
				return;
			case DISAPPEARED:
				queue.push(new FE_lost(source));
				return;
			}
		} else if (iqPatternName.equalsIgnoreCase("bodymodel.ymca.FS")) {
			switch (t) {
			case APPEARED:
				queue.push(new FS_found(source));
				return;
			case DISAPPEARED:
				queue.push(new FS_lost(source));
				return;
			}
		}
	}
}
