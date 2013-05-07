package hu.bme.mit.incquery.cep.runtime.evm;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.MatchUpdateAdapter;
import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.incquery.runtime.evm.api.ActivationLifeCycleEvent;
import org.eclipse.incquery.runtime.evm.api.ActivationState;
import org.eclipse.incquery.runtime.evm.api.RuleInstance;
import org.eclipse.incquery.runtime.evm.api.RuleSpecification;
import org.eclipse.incquery.runtime.evm.api.event.Atom;
import org.eclipse.incquery.runtime.evm.notification.AttributeMonitor;
import org.eclipse.incquery.runtime.evm.notification.IAttributeMonitorListener;
import org.eclipse.incquery.runtime.evm.specific.DefaultAttributeMonitor;
import org.eclipse.incquery.runtime.evm.specific.event.PatternMatchAtom;

public class CepRuleInstance<Match extends EventPatternMatch> extends RuleInstance {
	
	private IMatchUpdateListener<Match> matchUpdateListener;
	
	protected CepRuleInstance(RuleSpecification specification, Atom filter) {
		super(specification, filter);
	}
	
	protected void prepareInstance() {
		prepareMatchUpdateListener();
		prepareAttributeMonitorAndListener();
	}
	
	@Override
	protected Logger getLogger() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public IMatchUpdateListener<Match> getMatchUpdateListener() {
		return matchUpdateListener;
	}
	
	public void setMatchUpdateListener(IMatchUpdateListener<Match> matchUpdateListener) {
		this.matchUpdateListener = matchUpdateListener;
	}
	
	protected void prepareMatchUpdateListener() {
		IMatchProcessor<Match> matchAppearProcessor = checkNotNull(prepareMatchAppearProcessor(),
				"Prepared match appearance processor is null!");
		IMatchProcessor<Match> matchDisppearProcessor = checkNotNull(prepareMatchDisppearProcessor(),
				"Prepared match disappearance processor is null!");
		this.setMatchUpdateListener(new MatchUpdateAdapter<Match>(matchAppearProcessor, matchDisppearProcessor));
	}
	
	protected IMatchProcessor<Match> prepareMatchAppearProcessor() {
		return new DefaultMatchAppearProcessor();
	}
	
	protected IMatchProcessor<Match> prepareMatchDisppearProcessor() {
		return new DefaultMatchDisappearProcessor();
	}
	
	@Override
	protected AttributeMonitor prepareAttributeMonitor() {
		return new DefaultAttributeMonitor<Match>();
	}
	
	@Override
	protected IAttributeMonitorListener prepareAttributeMonitorListener() {
		return new DefaultAttributeMonitorListener();
	}
	
	private abstract class DefaultMatchEventProcessor {
		protected void processMatchEvent(CepAtom<Match> atom) {
			checkNotNull(atom, "Cannot process null match!");
			
			if (!getFilter().isCompatibleWith(atom)) {
				return;
			}
			
			Map<ActivationState, Activation> column = getActivations().column(atom);
			if (column.size() > 0) {
				checkArgument(column.size() == 1, String.format("%s activations in the same rule for the same match",
						column.size() == 0 ? "No" : "Multiple"));
				Activation act = column.values().iterator().next();
				activationExists(act);
			} else {
				activationMissing(atom);
			}
		}
		
		protected abstract void activationExists(Activation activation);
		
		protected abstract void activationMissing(CepAtom<Match> atom);
	}
	
	private final class DefaultMatchAppearProcessor extends DefaultMatchEventProcessor
			implements
				IMatchProcessor<Match> {
		
		@Override
		protected void activationExists(Activation activation) {
			activationStateTransition(activation, ActivationLifeCycleEvent.MATCH_APPEARS);
		}
		
		@Override
		protected void activationMissing(CepAtom<Match> atom) {
			Activation activation = createActivation(atom);
			if (getSpecification().getLifeCycle().containsTo(ActivationState.UPDATED)) {
				getAttributeMonitor().registerFor(atom);
			}
			activationStateTransition(activation, ActivationLifeCycleEvent.MATCH_APPEARS);
		}
		
		@Override
		public void process(Match match) {
			CepAtom<Match> atom = new CepAtom<Match>(match);
			processMatchEvent(atom);
		}
		
	}
	
	private final class DefaultMatchDisappearProcessor extends DefaultMatchEventProcessor
			implements
				IMatchProcessor<Match> {
		
		@Override
		protected void activationExists(Activation activation) {
			activationStateTransition(activation, ActivationLifeCycleEvent.MATCH_DISAPPEARS);
		}
		
		@Override
		protected void activationMissing(CepAtom<Match> atom) {
			getLogger().error(
					String.format("Atom %s disappeared without existing activation in rule instance %s!", atom, this));
		}
		
		@Override
		public void process(Match match) {
			CepAtom<Match> atom = new CepAtom<Match>(match);
			processMatchEvent(atom);
		}
		
	}
	
	private final class DefaultAttributeMonitorListener extends DefaultMatchEventProcessor
			implements
				IAttributeMonitorListener {
		@SuppressWarnings("unchecked")
		@Override
		public void notifyUpdate(final Atom atom) {
			if (atom instanceof PatternMatchAtom<?>) {
				processMatchEvent((CepAtom<Match>) atom);
			}
		}
		
		@Override
		protected void activationExists(Activation activation) {
			activationStateTransition(activation, ActivationLifeCycleEvent.MATCH_UPDATES);
		}
		
		@Override
		protected void activationMissing(CepAtom<Match> atom) {
			getLogger().error(
					String.format("Atom %s updated without existing activation in rule instance %s!", atom, this));
		}
	}
}
