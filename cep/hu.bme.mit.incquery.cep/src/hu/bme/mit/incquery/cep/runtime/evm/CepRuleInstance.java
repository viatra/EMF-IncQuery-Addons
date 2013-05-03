package hu.bme.mit.incquery.cep.runtime.evm;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import org.apache.log4j.Logger;
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
	
	protected CepRuleInstance(RuleSpecification specification, Atom filter) {
		super(specification, filter);
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
		
		/**
		 * This method is called with the match corresponding to the
		 * activation that is affected by the event.
		 * 
		 * @param atom
		 */
		protected void processMatchEvent(CepAtom<Match> atom) {
			checkNotNull(atom, "Cannot process null match!");
			
			// TODO check filter (this might be expensive!!!)
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
		
		/**
		 * This method is called by processMatchEvent if the activation
		 * already exists for the given match.
		 * 
		 * @param activation
		 */
		protected abstract void activationExists(Activation activation);
		
		/**
		 * This method is called by processMatchEvent if the activation
		 * does not exists for the given match.
		 * 
		 * @param match
		 */
		protected abstract void activationMissing(CepAtom<Match> atom);
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
	
	@Override
	protected Logger getLogger() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
