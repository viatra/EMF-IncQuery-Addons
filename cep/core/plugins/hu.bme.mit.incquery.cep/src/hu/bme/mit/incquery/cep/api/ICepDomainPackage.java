package hu.bme.mit.incquery.cep.api;

import hu.bme.mit.incquery.cep.metamodels.cep.EventPattern;

import java.util.List;

public class ICepDomainPackage {
    public List<CepRule> getRules;
    public List<AbstractEventInstance> getEventClasses;
    public List<EventPattern> getEventPatterns;
}
