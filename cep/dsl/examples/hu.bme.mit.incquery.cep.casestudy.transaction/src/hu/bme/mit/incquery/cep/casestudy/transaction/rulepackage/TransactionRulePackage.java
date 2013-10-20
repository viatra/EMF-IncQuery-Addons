package hu.bme.mit.incquery.cep.casestudy.transaction.rulepackage;

import hu.bme.mit.incquery.cep.api.ICepRule;
import hu.bme.mit.incquery.cep.casestudy.transaction.rules.R1;

import java.util.List;

import com.google.common.collect.Lists;

public final class TransactionRulePackage {
	private static TransactionRulePackage instance;
	private List<ICepRule> rules = Lists.newArrayList();
	
	public static TransactionRulePackage getInstance() {
		if (instance == null) {
			instance = new TransactionRulePackage();
		}
		return instance;
	}

	private TransactionRulePackage() {
		// TODO generate this
		rules.add(new R1());
	}
	
	public List<ICepRule> getRules() {
		return rules;
	}
}
