package org.jnect.demo.incquery.viatra.cep;

import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.IEventSource;
import hu.bme.mit.incquery.cep.runtime.EventQueue;
import hu.bme.mit.incquery.cep.runtime.evaluation.EventModelManager;
import hu.bme.mit.incquery.cep.runtime.evaluation.strategy.Strategy;

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
import org.jnect.demo.incquery.viatra.cep.events.FE;
import org.jnect.demo.incquery.viatra.cep.events.FS;
import org.jnect.demo.incquery.viatra.cep.patterns.FEPattern;
import org.jnect.demo.incquery.viatra.cep.patterns.FSPattern;
import org.jnect.demo.incquery.viatra.cep.patterns.FS_FE_Pattern;

public class ViatraCepAdapter {
	IncQueryMatcher<? extends IPatternMatch> matcher;
	EventModelManager manager;
	EventQueue queue = EventQueue.getInstance();
	IEventSource source;

	public ViatraCepAdapter(IncQueryMatcher<? extends IPatternMatch> matcher) {
		this.matcher = matcher;
		new IncQueryHeadlessRealm();
		
		List<EventPattern> eventPatterns = new ArrayList<EventPattern>();
		eventPatterns.add(new FEPattern());
		eventPatterns.add(new FSPattern());
		eventPatterns.add(new FS_FE_Pattern());
		manager = new EventModelManager(Strategy.getDefault());
		manager.assignEventPatterns(eventPatterns);
		
		IObservableSet os = IncQueryObservables.observeMatchesAsSet(matcher);
		os.addSetChangeListener(new ISetChangeListener() {

			@Override
			public void handleSetChange(SetChangeEvent event) {
				for (Object _o : event.diff.getAdditions()) {
					IPatternMatch pm = (IPatternMatch) _o;
					Logger.log("VIATRACEPADAPTER: Event " + pm.patternName()
							+ " found.");
			
					sentEvent(pm.patternName());
					// EsperManager.getInstance().sendEvent(
					// new PatternMatchEvent(pm, pm.patternName(),
					// PatternMatchEventType.NEW));
				}
				for (Object _o : event.diff.getRemovals()) {
					IPatternMatch pm = (IPatternMatch) _o;
					Logger.log("VIATRACEPADAPTER: Event " + pm.patternName()
							+ " lost.");
					// EsperManager.getInstance().sendEvent(
					// new PatternMatchEvent(pm, pm.patternName(),
					// PatternMatchEventType.LOST));
					sentEvent(pm.patternName());
				}

			}

		});
	}
	
	private void sentEvent(String iqPatternName){
		if(iqPatternName.equalsIgnoreCase("bodymodel.ymca.FE")){
			queue.push(new FE(source));
			return;
		}
		else if(iqPatternName.equalsIgnoreCase("bodymodel.ymca.FS")){
			queue.push(new FS(source));
			return;
		}
	}
}
