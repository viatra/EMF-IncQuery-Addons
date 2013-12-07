package hu.bme.mit.incquery.cep.performance.rules;

import com.google.common.collect.Lists;
import hu.bme.mit.incquery.cep.api.ICepRule;
import hu.bme.mit.incquery.cep.api.evm.CepActivationStates;
import hu.bme.mit.incquery.cep.api.evm.IObservableComplexEventPattern;
import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;
import java.util.List;
import org.eclipse.incquery.runtime.evm.api.Job;

@SuppressWarnings("all")
public class R1 implements ICepRule {
  private List<EventPattern> eventPatterns = Lists.newArrayList();
  
  private Job<IObservableComplexEventPattern> job = new hu.bme.mit.incquery.cep.performance.jobs.R1_Job(CepActivationStates.ACTIVE);
  
  public R1() {
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent1_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent2_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent3_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent4_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent5_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent6_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent7_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent8_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent9_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent10_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent11_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent12_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent13_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent14_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent15_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent16_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent17_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent18_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent19_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent20_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent21_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent22_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent23_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent24_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent25_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent26_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent27_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent28_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent29_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent30_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent31_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent32_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent33_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent34_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent35_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent36_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent37_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent38_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent39_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent40_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent41_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent42_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent43_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent44_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent45_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent46_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent47_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent48_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent49_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent50_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent51_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent52_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent53_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent54_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent55_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent56_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent57_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent58_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent59_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent60_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent61_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent62_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent63_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent64_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent65_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent66_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent67_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent68_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent69_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent70_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent71_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent72_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent73_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent74_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent75_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent76_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent77_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent78_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent79_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent80_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent81_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent82_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent83_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent84_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent85_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent86_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent87_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent88_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent89_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent90_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent91_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent92_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent93_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent94_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent95_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent96_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent97_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent98_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent99_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent100_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent101_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent102_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent103_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent104_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent105_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent106_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent107_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent108_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent109_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent110_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent111_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent112_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent113_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent114_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent115_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent116_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent117_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent118_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent119_Pattern());
    eventPatterns.add(new hu.bme.mit.incquery.cep.performance.patterns.complex.CompoundTransactionEvent120_Pattern());
    
  }
  
  @Override
  public List<EventPattern> getEventPatterns() {
    return this.eventPatterns;
  }
  
  @Override
  public Job<IObservableComplexEventPattern> getJob() {
    return this.job;
  }
}
