package hu.bme.mit.incquery.cep.casestudy.transaction.jobs;

import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.casestudy.transaction.MyActionHandler;
import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.incquery.runtime.evm.api.Context;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.event.ActivationState;

@SuppressWarnings("all")
public class R1Job extends Job<ObservedComplexEventPattern> {
  public R1Job(final ActivationState activationState) {
    super(activationState);
    
  }
  
  public void execute(final Activation<? extends ObservedComplexEventPattern> activation, final Context context) {
    final String testMsg = "test";
    MyActionHandler _myActionHandler = new MyActionHandler();
    _myActionHandler.handleAction(testMsg);
  }
  
  public void handleError(final Activation<? extends ObservedComplexEventPattern> activation, final Exception exception, final Context context) {
    //not gonna happen
    
  }
}
