package hu.bme.mit.incquery.cep.casestudy.transaction.rules;

import com.google.common.collect.Lists;
import hu.bme.mit.incquery.cep.api.ICepRule;
import hu.bme.mit.incquery.cep.api.evm.CepActivationStates;
import hu.bme.mit.incquery.cep.api.evm.ObservedComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import java.util.List;
import org.eclipse.incquery.runtime.evm.api.Job;

@SuppressWarnings("all")
public class R1 implements ICepRule {
  private List<EventPattern> eventPatterns = Lists.newArrayList();
  
  private Job<ObservedComplexEventPattern> job = new hu.bme.mit.incquery.cep.casestudy.transaction.jobs.R1Job(CepActivationStates.ACTIVE);
  
  public R1() {
    eventPatterns.add(new hu.bme.mit.incquery.cep.casestudy.transaction.patterns.complex.CompoundTransactionEvent1Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.casestudy.transaction.patterns.complex.CompoundTransactionEvent2Pattern());
    
  }
  
  public List<EventPattern> getEventPatterns() {
    return this.eventPatterns;
  }
  
  public Job<ObservedComplexEventPattern> getJob() {
    return this.job;
  }
}
