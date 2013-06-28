package hu.bme.mit.incquery.vedl.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import hu.bme.mit.incquery.vedl.edl.AtomicEvent;
import hu.bme.mit.incquery.vedl.edl.CEParamlist;
import hu.bme.mit.incquery.vedl.edl.ClosedClosed;
import hu.bme.mit.incquery.vedl.edl.ClosedOpen;
import hu.bme.mit.incquery.vedl.edl.ComplexEvent;
import hu.bme.mit.incquery.vedl.edl.ContextAnnotation;
import hu.bme.mit.incquery.vedl.edl.EdlPackage;
import hu.bme.mit.incquery.vedl.edl.EventSourceUsage;
import hu.bme.mit.incquery.vedl.edl.IQPattern;
import hu.bme.mit.incquery.vedl.edl.IQPatternEvent;
import hu.bme.mit.incquery.vedl.edl.IQUsage;
import hu.bme.mit.incquery.vedl.edl.LiteralFilter;
import hu.bme.mit.incquery.vedl.edl.Model;
import hu.bme.mit.incquery.vedl.edl.NumericFilter;
import hu.bme.mit.incquery.vedl.edl.OpenClosed;
import hu.bme.mit.incquery.vedl.edl.OpenOpen;
import hu.bme.mit.incquery.vedl.edl.PackageDeclaration;
import hu.bme.mit.incquery.vedl.edl.ParamWithType;
import hu.bme.mit.incquery.vedl.edl.ParameterFilter;
import hu.bme.mit.incquery.vedl.edl.PriorityAnnotation;
import hu.bme.mit.incquery.vedl.edl.RangeFilter;
import hu.bme.mit.incquery.vedl.edl.SamplingAnnotation;
import hu.bme.mit.incquery.vedl.services.EdlGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class EdlSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private EdlGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == EdlPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case EdlPackage.ATOMIC_EVENT:
				if(context == grammarAccess.getAbstractAtomicEventRule() ||
				   context == grammarAccess.getAtomicEventRule() ||
				   context == grammarAccess.getEventRule()) {
					sequence_AtomicEvent(context, (AtomicEvent) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.CE_PARAMLIST:
				if(context == grammarAccess.getCEParamlistRule()) {
					sequence_CEParamlist(context, (CEParamlist) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.CLOSED_CLOSED:
				if(context == grammarAccess.getClosedClosedRule() ||
				   context == grammarAccess.getRangeRule()) {
					sequence_ClosedClosed(context, (ClosedClosed) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.CLOSED_OPEN:
				if(context == grammarAccess.getClosedOpenRule() ||
				   context == grammarAccess.getRangeRule()) {
					sequence_ClosedOpen(context, (ClosedOpen) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.COMPLEX_EVENT:
				if(context == grammarAccess.getComplexEventRule() ||
				   context == grammarAccess.getEventRule()) {
					sequence_ComplexEvent(context, (ComplexEvent) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.CONTEXT_ANNOTATION:
				if(context == grammarAccess.getAnnotationsRule() ||
				   context == grammarAccess.getContextAnnotationRule()) {
					sequence_ContextAnnotation(context, (ContextAnnotation) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.EVENT_SOURCE_USAGE:
				if(context == grammarAccess.getEventSourceUsageRule() ||
				   context == grammarAccess.getUsageRule()) {
					sequence_EventSourceUsage(context, (EventSourceUsage) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.IQ_PATTERN:
				if(context == grammarAccess.getIQPatternRule()) {
					sequence_IQPattern(context, (IQPattern) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.IQ_PATTERN_EVENT:
				if(context == grammarAccess.getAbstractAtomicEventRule() ||
				   context == grammarAccess.getEventRule() ||
				   context == grammarAccess.getIQPatternEventRule()) {
					sequence_IQPatternEvent(context, (IQPatternEvent) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.IQ_USAGE:
				if(context == grammarAccess.getIQUsageRule() ||
				   context == grammarAccess.getUsageRule()) {
					sequence_IQUsage(context, (IQUsage) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.LITERAL_FILTER:
				if(context == grammarAccess.getLiteralFilterRule() ||
				   context == grammarAccess.getParameterFilterRuleRule()) {
					sequence_LiteralFilter(context, (LiteralFilter) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.NUMERIC_FILTER:
				if(context == grammarAccess.getNumericFilterRule() ||
				   context == grammarAccess.getParameterFilterRuleRule()) {
					sequence_NumericFilter(context, (NumericFilter) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.OPEN_CLOSED:
				if(context == grammarAccess.getOpenClosedRule() ||
				   context == grammarAccess.getRangeRule()) {
					sequence_OpenClosed(context, (OpenClosed) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.OPEN_OPEN:
				if(context == grammarAccess.getOpenOpenRule() ||
				   context == grammarAccess.getRangeRule()) {
					sequence_OpenOpen(context, (OpenOpen) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.PACKAGE_DECLARATION:
				if(context == grammarAccess.getPackageDeclarationRule()) {
					sequence_PackageDeclaration(context, (PackageDeclaration) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.PARAM_WITH_TYPE:
				if(context == grammarAccess.getParamWithTypeRule()) {
					sequence_ParamWithType(context, (ParamWithType) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.PARAMETER_FILTER:
				if(context == grammarAccess.getParameterFilterRule()) {
					sequence_ParameterFilter(context, (ParameterFilter) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.PRIORITY_ANNOTATION:
				if(context == grammarAccess.getAnnotationsRule() ||
				   context == grammarAccess.getPriorityAnnotationRule()) {
					sequence_PriorityAnnotation(context, (PriorityAnnotation) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.RANGE_FILTER:
				if(context == grammarAccess.getParameterFilterRuleRule() ||
				   context == grammarAccess.getRangeFilterRule()) {
					sequence_RangeFilter(context, (RangeFilter) semanticObject); 
					return; 
				}
				else break;
			case EdlPackage.SAMPLING_ANNOTATION:
				if(context == grammarAccess.getAnnotationsRule() ||
				   context == grammarAccess.getSamplingAnnotationRule()) {
					sequence_SamplingAnnotation(context, (SamplingAnnotation) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (annotations+=Annotations* name=ID source=[Source|ID] id=STRING parameterFilters+=ParameterFilter+)
	 */
	protected void sequence_AtomicEvent(EObject context, AtomicEvent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (params+=ParamWithType*)
	 */
	protected void sequence_CEParamlist(EObject context, CEParamlist semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (lowerBound=DOUBLE upperBound=DOUBLE)
	 */
	protected void sequence_ClosedClosed(EObject context, ClosedClosed semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.RANGE__LOWER_BOUND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.RANGE__LOWER_BOUND));
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.RANGE__UPPER_BOUND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.RANGE__UPPER_BOUND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getClosedClosedAccess().getLowerBoundDOUBLEParserRuleCall_1_0(), semanticObject.getLowerBound());
		feeder.accept(grammarAccess.getClosedClosedAccess().getUpperBoundDOUBLEParserRuleCall_3_0(), semanticObject.getUpperBound());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (lowerBound=DOUBLE upperBound=DOUBLE)
	 */
	protected void sequence_ClosedOpen(EObject context, ClosedOpen semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.RANGE__LOWER_BOUND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.RANGE__LOWER_BOUND));
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.RANGE__UPPER_BOUND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.RANGE__UPPER_BOUND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getClosedOpenAccess().getLowerBoundDOUBLEParserRuleCall_1_0(), semanticObject.getLowerBound());
		feeder.accept(grammarAccess.getClosedOpenAccess().getUpperBoundDOUBLEParserRuleCall_3_0(), semanticObject.getUpperBound());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (annotations+=Annotations* name=ID paramlist=CEParamlist)
	 */
	protected void sequence_ComplexEvent(EObject context, ComplexEvent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     context=Context
	 */
	protected void sequence_ContextAnnotation(EObject context, ContextAnnotation semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.CONTEXT_ANNOTATION__CONTEXT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.CONTEXT_ANNOTATION__CONTEXT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getContextAnnotationAccess().getContextContextEnumRuleCall_2_0(), semanticObject.getContext());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     importedNamespace=QualifiedNameWithWildcard
	 */
	protected void sequence_EventSourceUsage(EObject context, EventSourceUsage semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.USAGE__IMPORTED_NAMESPACE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.USAGE__IMPORTED_NAMESPACE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEventSourceUsageAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0(), semanticObject.getImportedNamespace());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID iqpattern=IQPattern changeType=IQPatternChangeType)
	 */
	protected void sequence_IQPatternEvent(EObject context, IQPatternEvent semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.EVENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.EVENT__NAME));
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.IQ_PATTERN_EVENT__IQPATTERN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.IQ_PATTERN_EVENT__IQPATTERN));
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.IQ_PATTERN_EVENT__CHANGE_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.IQ_PATTERN_EVENT__CHANGE_TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIQPatternEventAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getIQPatternEventAccess().getIqpatternIQPatternParserRuleCall_6_0(), semanticObject.getIqpattern());
		feeder.accept(grammarAccess.getIQPatternEventAccess().getChangeTypeIQPatternChangeTypeEnumRuleCall_9_0(), semanticObject.getChangeType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_IQPattern(EObject context, IQPattern semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.IQ_PATTERN__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.IQ_PATTERN__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIQPatternAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     importedNamespace=QualifiedNameWithWildcard
	 */
	protected void sequence_IQUsage(EObject context, IQUsage semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.USAGE__IMPORTED_NAMESPACE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.USAGE__IMPORTED_NAMESPACE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIQUsageAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0(), semanticObject.getImportedNamespace());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (neg=NegationOpartor? operator=LiteralOperator value=STRING)
	 */
	protected void sequence_LiteralFilter(EObject context, LiteralFilter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (annotations+=Annotations* name=ID events+=Event*)
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operator=NumericOperator value=DOUBLE)
	 */
	protected void sequence_NumericFilter(EObject context, NumericFilter semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.NUMERIC_FILTER__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.NUMERIC_FILTER__OPERATOR));
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.NUMERIC_FILTER__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.NUMERIC_FILTER__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNumericFilterAccess().getOperatorNumericOperatorParserRuleCall_0_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getNumericFilterAccess().getValueDOUBLEParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (lowerBound=DOUBLE upperBound=DOUBLE)
	 */
	protected void sequence_OpenClosed(EObject context, OpenClosed semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.RANGE__LOWER_BOUND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.RANGE__LOWER_BOUND));
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.RANGE__UPPER_BOUND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.RANGE__UPPER_BOUND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOpenClosedAccess().getLowerBoundDOUBLEParserRuleCall_1_0(), semanticObject.getLowerBound());
		feeder.accept(grammarAccess.getOpenClosedAccess().getUpperBoundDOUBLEParserRuleCall_3_0(), semanticObject.getUpperBound());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (lowerBound=DOUBLE upperBound=DOUBLE)
	 */
	protected void sequence_OpenOpen(EObject context, OpenOpen semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.RANGE__LOWER_BOUND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.RANGE__LOWER_BOUND));
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.RANGE__UPPER_BOUND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.RANGE__UPPER_BOUND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOpenOpenAccess().getLowerBoundDOUBLEParserRuleCall_1_0(), semanticObject.getLowerBound());
		feeder.accept(grammarAccess.getOpenOpenAccess().getUpperBoundDOUBLEParserRuleCall_3_0(), semanticObject.getUpperBound());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=QualifiedName usages+=Usage* model=Model)
	 */
	protected void sequence_PackageDeclaration(EObject context, PackageDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID type=[AbstractAtomicEvent|ID])
	 */
	protected void sequence_ParamWithType(EObject context, ParamWithType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.PARAM_WITH_TYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.PARAM_WITH_TYPE__NAME));
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.PARAM_WITH_TYPE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.PARAM_WITH_TYPE__TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getParamWithTypeAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getParamWithTypeAccess().getTypeAbstractAtomicEventIDTerminalRuleCall_2_0_1(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (attributeName=ID paramFilterRule=ParameterFilterRule)
	 */
	protected void sequence_ParameterFilter(EObject context, ParameterFilter semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.PARAMETER_FILTER__ATTRIBUTE_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.PARAMETER_FILTER__ATTRIBUTE_NAME));
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.PARAMETER_FILTER__PARAM_FILTER_RULE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.PARAMETER_FILTER__PARAM_FILTER_RULE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getParameterFilterAccess().getAttributeNameIDTerminalRuleCall_0_0(), semanticObject.getAttributeName());
		feeder.accept(grammarAccess.getParameterFilterAccess().getParamFilterRuleParameterFilterRuleParserRuleCall_1_0(), semanticObject.getParamFilterRule());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     priority=INT
	 */
	protected void sequence_PriorityAnnotation(EObject context, PriorityAnnotation semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.PRIORITY_ANNOTATION__PRIORITY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.PRIORITY_ANNOTATION__PRIORITY));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPriorityAnnotationAccess().getPriorityINTTerminalRuleCall_2_0(), semanticObject.getPriority());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (neg=NegationOpartor? range=Range)
	 */
	protected void sequence_RangeFilter(EObject context, RangeFilter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     sampling=INT
	 */
	protected void sequence_SamplingAnnotation(EObject context, SamplingAnnotation semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EdlPackage.Literals.SAMPLING_ANNOTATION__SAMPLING) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EdlPackage.Literals.SAMPLING_ANNOTATION__SAMPLING));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSamplingAnnotationAccess().getSamplingINTTerminalRuleCall_2_0(), semanticObject.getSampling());
		feeder.finish();
	}
}
