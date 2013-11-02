package hu.bme.mit.incquery.cep.casestudy.transaction.jobs;

import hu.bme.mit.incquery.cep.api.IActionHandler;
import hu.bme.mit.incquery.cep.api.evm.IObservableComplexEventPattern;
import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.incquery.runtime.evm.api.Context;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.event.ActivationState;

@SuppressWarnings("all")
public class R1Job extends Job<IObservableComplexEventPattern> {
  public R1Job(final ActivationState activationState) {
    super(activationState);
  }
  
  @Override
  public void execute(final Activation<? extends IObservableComplexEventPattern> activation, final Context context) {
    IActionHandler actionHandler = new hu.bme.mit.incquery.cep.casestudy.transaction.handlers.SimpleActionHandler();
    actionHandler.handle(activation);
  }
  
  @Override
  public void handleError(final Activation<? extends IObservableComplexEventPattern> activation, final Exception exception, final Context context) {
    //not gonna happen
  }
}
