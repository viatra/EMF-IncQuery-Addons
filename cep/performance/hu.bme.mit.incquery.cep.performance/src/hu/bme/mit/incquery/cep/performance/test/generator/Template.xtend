package hu.bme.mit.incquery.cep.performance.test.generator

import com.google.common.collect.Lists
import java.io.FileWriter
import java.util.List
import com.google.common.base.Joiner
import hu.bme.mit.incquery.cep.metamodels.cep.ComplexOperator

class Template {
	protected FileWriter writer

	def generate(String filename, List<List<String>> perm, ComplexOperator operator) {
		this.writer = new FileWriter(filename)
		writer.append(head)
		generateComplexEvents(perm, operator)
		writer.append(tail(perm.size))
		this.writer.close
	}

	def public static head() '''
		package hu.bme.mit.incquery.cep.performance
		
		uses hu.bme.mit.incquery.cep.api.evm.*
		
		AtomicEvent componentA(){}
		AtomicEvent componentB(){}
		AtomicEvent componentC(){}
		AtomicEvent componentD(){}
		AtomicEvent componentE(){}
		AtomicEvent componentF(){}
		AtomicEvent componentG(){}
		AtomicEvent componentH(){}
		AtomicEvent componentI(){}
		AtomicEvent componentJ(){}
		AtomicEvent componentK(){}
		AtomicEvent componentL(){}
		AtomicEvent componentM(){}
		AtomicEvent componentN(){}
		
	'''

	def public generateComplexEvents(List<List<String>> perm, ComplexOperator operator) {
		var i = 1

		for (p : perm) {
			writer.append(generateComplexEvent(i, generateDefinition(p, operator)))
			i = i + 1
		}
	}

	def private generateDefinition(List<String> atomicEventList, ComplexOperator operator) {
		if (operator.equals(ComplexOperator::ORDERED)) {
			return Joiner::on(" -> ").join(atomicEventList)
		}else if (operator.equals(ComplexOperator::UNORDERED)) {
			return Joiner::on(" OR ").join(atomicEventList)
		}
	}

	def public generateComplexEvent(int index, String definition) '''
		ComplexEvent compoundTransactionEvent«index»(){
			definition : «definition»
		}
		
	'''

	def public tail(int lastComplexEventIndex) '''
		Rule r1 {
			events:
				«FOR ce : getCEList(lastComplexEventIndex) SEPARATOR ", "»
					«ce»
				«ENDFOR»
			actionHandler: hu.bme.mit.incquery.cep.performance.actionhandlers.SimpleActionHandler2
		}
	'''

	def private getCEList(int lastComplexEventIndex) {
		var List<String> list = Lists::newArrayList()
		var i = 1

		while (i <= lastComplexEventIndex) {
			list.add("compoundTransactionEvent" + i)
			i = i + 1
		}

		list
	}
}
