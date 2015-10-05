package org.eclipse.incquery.uml.generator

import com.google.common.base.CaseFormat
import hu.bme.mit.ocl2iq.mapping.api.OCL2IQ
import hu.bme.mit.ocl2iq.mapping.api.OCLParseControl
import java.util.Set
import java.util.regex.Pattern
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine
import org.junit.Test

class Generator {

    @Test
    def void union() {
        val unionMatcher = UnionMatcher.on(engine)
        println('''
            «header»

            «FOR unionFeature : unionMatcher.allValuesOfunion.sortBy[qualifiedName]»
	            «unionFeature.surrogateAnnotation»
	            «unionFeature.patternSignature»
	            «FOR subsetFeature : unionMatcher.getAllValuesOfsubset(unionFeature).sortBy[qualifiedName] SEPARATOR " or "»
	                { «IF subsetFeature.derived || subsetFeature.volatile»find «subsetFeature.patternName»(«sourceParameterName», «targetParameterName»);«ELSE»«subsetFeature.containingClass.name».«subsetFeature.name.escape»(«sourceParameterName», «targetParameterName»);«ENDIF» }
	            «ENDFOR»
	            
	        «ENDFOR»
        ''')
    }
	
	@Test
	def void derivedNotBuggy() {
		val matcher = DerivedNotBuggyMatcher.on(engine)
		ocl(matcher.allValuesOffeature, [matcher.getAllValuesOfdocumentation(it)], true)
	}
	
	@Test
	def void derivedBuggy() {
		val matcher = DerivedBuggyMatcher.on(engine)
		ocl(matcher.allValuesOffeature, [matcher.getAllValuesOfdocumentation(it)], true)
	}

	@Test
	def void usedOperations() {
		val matcher = UsedOperationMatcher.on(engine)
		ocl(matcher.allValuesOfoperation, [matcher.getAllValuesOfdocumentation(null, it)], false)
	}

    @Test
    def void standaloneSetup() {
        val features = DerivedMatcher.on(engine).allValuesOffeature
        println('''
        	«FOR feature : features.sortBy[qualifiedName]»
        		«val containingClassName = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, feature.EContainingClass.name)»
        		«val featureName = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, feature.name)»
        					.put(UMLPackage.Literals.«containingClassName»__«featureName», «feature.patternName.toFirstUpper»QuerySpecification.instance())
        	«ENDFOR»
        '''
 	    )
    }
    
    static val engine = {
		val resourceSet = new ResourceSetImpl
		val resource = resourceSet.createResource(URI.createPlatformPluginURI("/org.eclipse.uml2.uml/model/UML.ecore", true))
		resource.load(#{})
		AdvancedIncQueryEngine.createUnmanagedEngine(resourceSet, false, true)
	}

	def String getQualifiedName(ETypedElement it)
		'''«containingClass.name».«name»'''

	dispatch def getContainingClass(EStructuralFeature it) {
		EContainingClass
	}
		
	dispatch def getContainingClass(EOperation it) {
		EContainingClass
	}

	def <F extends ETypedElement> void ocl(Set<F> elements, (F)=>Set<String> getDocumentation, boolean isFeature) {
		println('''
			«header»

			«FOR element : elements.sortBy[qualifiedName]»
				«val value = getDocumentation.apply(element).head.matchRegularExpression("result = (.*)<p>")»
				/*
				«value»
				*/
				«{
					val context = element.containingClass
					try {
						val ocl = new OCLParseControl().parse(context, value)
						'''
						«if (isFeature) element.surrogateAnnotation»
						«new OCL2IQ(context, ocl, element.patternName).gen»'''
					} catch (Exception e) {
						'''
						// Can't compile OCL to IncQuery because of «e»
						«IF isFeature»//«element.surrogateAnnotation»«ENDIF»
						//«element.patternSignature» {}'''
					}
				}»

			«ENDFOR»
		''')
	}
	
	def patternSignature(ETypedElement element)
		'''pattern «patternName(element)»(«sourceParameterName»: «element.containingClass.name», «targetParameterName»: «element.EType.name»)'''

	def String patternName(ETypedElement element)
		'''«element.containingClass.name.toFirstLower»«element.name.toFirstUpper»'''
	
	def surrogateAnnotation(ENamedElement feature)
		'''@Surrogate(feature = "«feature.name»")'''

	def matchRegularExpression(String content, String regEx) {
		val pattern = Pattern.compile(regEx, Pattern.DOTALL)
		val matcher = pattern.matcher(content)
		if (matcher.find) {
			matcher.group(1)
		} else {
			null
		}
	}

    static val header =
        '''
        package org.eclipse.incquery.uml.derivedfeatures
        
        import "http://www.eclipse.org/uml2/5.0.0/UML"
        '''
	static val sourceParameterName = "source"
	static val targetParameterName = "target"
    static val keywords = #{"extension", "package"}

    def escape(String name)
        '''«if (keywords.contains(name)) "^"»«name»'''

}