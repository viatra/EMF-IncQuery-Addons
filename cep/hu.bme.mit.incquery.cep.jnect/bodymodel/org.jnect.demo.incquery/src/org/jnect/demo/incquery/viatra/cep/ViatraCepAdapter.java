package org.jnect.demo.incquery.viatra.cep;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.incquery.databinding.runtime.api.IncQueryHeadlessRealm;
import org.eclipse.incquery.databinding.runtime.api.IncQueryObservables;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.jnect.demo.incquery.esper.utils.Logger;

public class ViatraCepAdapter {
	IncQueryMatcher<? extends IPatternMatch> matcher;

	public ViatraCepAdapter(IncQueryMatcher<? extends IPatternMatch> matcher) {
		this.matcher = matcher;
		IncQueryHeadlessRealm realm = new IncQueryHeadlessRealm();

		IObservableSet os = IncQueryObservables.observeMatchesAsSet(matcher);
		os.addSetChangeListener(new ISetChangeListener() {

			@Override
			public void handleSetChange(SetChangeEvent event) {
				for (Object _o : event.diff.getAdditions()) {
					IPatternMatch pm = (IPatternMatch) _o;
					Logger.log("VIATRACEPADAPTER: Event " + pm.patternName()
							+ " found.");
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
				}

			}

		});
	}
}
