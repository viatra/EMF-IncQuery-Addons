package hu.bme.mit.incquery.resolver;

import static com.google.common.base.Preconditions.checkArgument;
import hu.bme.mit.incquery.resolver.LifoConflictResolver.LifoConflictSet;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.incquery.runtime.evm.api.ConflictResolver;
import org.eclipse.incquery.runtime.evm.api.ConflictSet;
import org.eclipse.incquery.runtime.evm.specific.resolver.ReconfigurableConflictResolver;

import com.google.common.collect.Sets;

public class LifoConflictResolver extends ReconfigurableConflictResolver<LifoConflictSet> {
	
	@Override
	protected LifoConflictSet createReconfigurableConflictSet() {
		return new LifoConflictSet(this);
	}

	public static final class LifoConflictSet implements ConflictSet {

		private LifoConflictResolver resolver;
		private Deque<Activation<?>> activations = new ArrayDeque<Activation<?>>();

		public LifoConflictSet(LifoConflictResolver resolver) {
			this.resolver = resolver;
		}

		@Override
		public ConflictResolver<? extends ConflictSet> getConflictResolver() {
			return resolver;
		}

		@Override
		public Activation<?> getNextActivation() {
			return activations.peek();
		}

		@Override
		public Set<Activation<?>> getNextActivations() {
			if (activations.isEmpty()) {
				return Collections.emptySet();
			}
			HashSet<Activation<?>> activationSet = new HashSet<Activation<?>>();
			activationSet.add(getNextActivation());
			return activationSet;
		}

		@Override
		public Set<Activation<?>> getConflictingActivations() {
			return Collections.unmodifiableSet(Sets.newLinkedHashSet(activations));
		}

		@Override
		public boolean addActivation(Activation<?> activation) {
			checkArgument(activation != null, "Activation cannot be null!");
			if(activations.peek().equals(activation)) {
			    return false; // no change required
			} else {
			    // activation may already be in the queue, but never more than once (see JavaDoc of method)
			    activations.remove(activation);
			    activations.push(activation);
			    return true; // if the first activation changes, we consider it a change in the set
			}
		}

		@Override
		public boolean removeActivation(Activation<?> activation) {
			checkArgument(activation != null, "Activation cannot be null!");
			return activations.remove(activation);
		}
	}
}