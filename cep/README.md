VIATRA2-CEP: incremental graph pattern matching meets complex event processing
==============================================================================

This sub-project delivers a general CEP engine for the Eclipse platform and also presents a novel architecture for streaming transformations by combining CEP with incremental graph transformations.

 #**[EMF-IncQuery](http://eclipse.org/incquery/)**, #**[VIATRA2-EMF](http://www.eclipse.org/viatra2/)**, #EVM

Implementation
--------------

The implementation consists of two main parts: the [core](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/core) (inlcuding the engine and an API) and the [DSL](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/dsl).
The core plugin: **[hu.bme.mit.incquery.cep](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/core/plugins/hu.bme.mit.incquery.cep)**. The appropriate unit tests are located in plugin **[hu.bme.mit.incquery.cep.tests](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/core/tests/hu.bme.mit.incquery.cep.tests)**.
The DSL plugin: **[hu.bme.mit.incquery.cep.dsl](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/dsl/plugins/hu.bme.mit.incquery.cep.dsl)**.


For example codes see the **\*.examples.*** plugins:
* **[hu.bme.mit.incquery.cep.examples.example1](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/core/examples/hu.bme.mit.incquery.cep.examples.example1)** shows a simple use-case where atomic and complex event patterns are defined and recognized on the event stream among other events.
* **[hu.bme.mit.incquery.cep.examples.evm.integration](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/core/examples/hu.bme.mit.incquery.cep.examples.evm.integration)** presents an example for integrating  VIATRA-CEP and VIATRA-EVM.
* **[hu.bme.mit.incquery.cep.dls.examples](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/dsl/examples/hu.bme.mit.incquery.cep.dsl.examples)** contains examples for event pattern description DSL.

Demo
--------------
The plugin **[hu.bme.mit.incquery.cep.jnect](https://github.com/david-istvan/viatra-cep-examples/tree/master/hu.bme.mit.incquery.cep.jnect)** contains a demo based on a previously elaborated one: http://incquery.net/incquery/demos/jnect. The difference is in the event processing layer: in this new demo, the VIATRA-CEP engine is employed instead of ESPER.

Setting up the environment
--------------
* **Host** Eclipse - requires Xtext, EMF, etc
 * EMF-IncQuery plugins
 * VIATRA2-EMF
 * CEP-Core
 * CEP-DSL
 * CEP-DSL UI

For the transaction case study:
* **Runtime** Eclipse:
 * IncQuery project with queries [hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/casestudy/transaction/hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns)
 * Ecore metamodell [hu.bme.mit.incquery.cep.casestudy.transaction.metamodel](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/casestudy/transaction/hu.bme.mit.incquery.cep.casestudy.transaction.metamodel)
 * Case study implementation [hu.bme.mit.incquery.cep.casestudy.transaction](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/casestudy/transaction/hu.bme.mit.incquery.cep.casestudy.transaction)

For the [Jnect demo](https://github.com/david-istvan/viatra-cep-examples/tree/master/hu.bme.mit.incquery.cep.jnect):
 * GEF3D projects: [org.eclipse.gef3d](https://github.com/david-istvan/viatra-cep-examples/tree/master/hu.bme.mit.incquery.cep.jnect/org.eclipse.gef3d)
 * Jnect body model: [org.jnect.bodymodel](https://github.com/david-istvan/viatra-cep-examples/tree/master/hu.bme.mit.incquery.cep.jnect/bodymodel/jnect-modified/org.jnect.bodymodel)
 * Core Jnect framework: [org.jnect.core](https://github.com/david-istvan/viatra-cep-examples/tree/master/hu.bme.mit.incquery.cep.jnect/bodymodel/jnect-modified/org.jnect.core)
 * IncQuery body patterns: [bodymodel.incquery](https://github.com/david-istvan/viatra-cep-examples/tree/master/hu.bme.mit.incquery.cep.jnect/bodymodel/bodymodel.incquery)
 * Application: [org.jnect.demo.incquery.app](https://github.com/david-istvan/viatra-cep-examples/tree/master/hu.bme.mit.incquery.cep.jnect/bodymodel/org.jnect.demo.incquery.app)
 * IncQuery demo: [org.jnect.demo.incquery](https://github.com/david-istvan/viatra-cep-examples/tree/master/hu.bme.mit.incquery.cep.jnect/bodymodel/org.jnect.demo.incquery)
 * GEF demo: [org.jnect.demo.gef](https://github.com/david-istvan/viatra-cep-examples/tree/master/hu.bme.mit.incquery.cep.jnect/bodymodel/jnect-modified/org.jnect.demo.gef)
 * Federated model: [hu.bme.mit.viatra.cep.jnect.bodies](https://github.com/david-istvan/viatra-cep-examples/tree/master/hu.bme.mit.incquery.cep.jnect/bodymodel/hu.bme.mit.viatra.cep.jnect.bodies)
 * Patterns for the federated model: [hu.bme.mit.viatra.cep.jnect.patterns](https://github.com/david-istvan/viatra-cep-examples/tree/master/hu.bme.mit.incquery.cep.jnect/bodymodel/hu.bme.mit.viatra.cep.jnect.patterns)
 * Simulator for the federated model: [hu.bme.mit.viatra.cep.jnect.simulator](https://github.com/david-istvan/viatra-cep-examples/tree/master/hu.bme.mit.incquery.cep.jnect/bodymodel/hu.bme.mit.viatra.cep.jnect.simulator)

License
-------
[Eclipse Public License v1.0] (http://www.eclipse.org/legal/epl-v10.html)
