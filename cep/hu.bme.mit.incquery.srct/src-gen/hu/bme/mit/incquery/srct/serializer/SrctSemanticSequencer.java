package hu.bme.mit.incquery.srct.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import hu.bme.mit.incquery.srct.services.SrctGrammarAccess;
import hu.bme.mit.incquery.srct.srct.Adapter;
import hu.bme.mit.incquery.srct.srct.PackageDeclaration;
import hu.bme.mit.incquery.srct.srct.Source;
import hu.bme.mit.incquery.srct.srct.SourceModel;
import hu.bme.mit.incquery.srct.srct.SrctPackage;
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
public class SrctSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private SrctGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == SrctPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case SrctPackage.ADAPTER:
				if(context == grammarAccess.getAdapterRule()) {
					sequence_Adapter(context, (Adapter) semanticObject); 
					return; 
				}
				else break;
			case SrctPackage.PACKAGE_DECLARATION:
				if(context == grammarAccess.getPackageDeclarationRule()) {
					sequence_PackageDeclaration(context, (PackageDeclaration) semanticObject); 
					return; 
				}
				else break;
			case SrctPackage.SOURCE:
				if(context == grammarAccess.getSourceRule()) {
					sequence_Source(context, (Source) semanticObject); 
					return; 
				}
				else break;
			case SrctPackage.SOURCE_MODEL:
				if(context == grammarAccess.getSourceModelRule()) {
					sequence_SourceModel(context, (SourceModel) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Adapter(EObject context, Adapter semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SrctPackage.Literals.ADAPTER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SrctPackage.Literals.ADAPTER__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAdapterAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=QualifiedName sourceModel=SourceModel)
	 */
	protected void sequence_PackageDeclaration(EObject context, PackageDeclaration semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SrctPackage.Literals.PACKAGE_DECLARATION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SrctPackage.Literals.PACKAGE_DECLARATION__NAME));
			if(transientValues.isValueTransient(semanticObject, SrctPackage.Literals.PACKAGE_DECLARATION__SOURCE_MODEL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SrctPackage.Literals.PACKAGE_DECLARATION__SOURCE_MODEL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getPackageDeclarationAccess().getSourceModelSourceModelParserRuleCall_2_0(), semanticObject.getSourceModel());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (sources+=Source*)
	 */
	protected void sequence_SourceModel(EObject context, SourceModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID adapter+=Adapter+)
	 */
	protected void sequence_Source(EObject context, Source semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
