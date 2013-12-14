Complex event processing with IncQuery
======================================

This add-on aims at providing a CEP layer for the **[VIATRA-EVM](http://www.eclipse.org/viatra2/)**. The efficient evaluation of the event patterns is achieved by appropriately designed **[IncQuery](http://eclipse.org/incquery/)** patterns.

Implementation
--------------

The implementation consists of two main parts: the [core](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/core) (inlcuding the engine and an API for it) and the [DSL](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/dsl).
The core plugin: **[hu.bme.mit.incquery.cep](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/core/plugins/hu.bme.mit.incquery.cep)**. The appropriate unit tests are located in plugin **[hu.bme.mit.incquery.cep.tests](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/core/tests/hu.bme.mit.incquery.cep.tests)**.
The DSL plugin: **[hu.bme.mit.incquery.cep.dsl](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/dsl/plugins/hu.bme.mit.incquery.cep.dsl)**.

![ScreenShot](https://dl.dropboxusercontent.com/u/44011277/cep/architecture2.jpg)

For example codes see the **\*.examples.*** plugins:
* **[hu.bme.mit.incquery.cep.examples.example1](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/core/examples/hu.bme.mit.incquery.cep.examples.example1)** shows a simple use-case where atomic and complex event patterns are defined and recognized on the event stream among other events.
* **[hu.bme.mit.incquery.cep.examples.evm.integration](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/core/examples/hu.bme.mit.incquery.cep.examples.evm.integration)** presents an example for integrating  VIATRA-CEP and VIATRA-EVM.
* **[hu.bme.mit.incquery.cep.dls.examples](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/dsl/examples/hu.bme.mit.incquery.cep.dsl.examples)** contains examples for event pattern description DSL.

Demo
--------------
The plugin **[hu.bme.mit.incquery.cep.jnect](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/core/examples/hu.bme.mit.incquery.cep.jnect)** contains a demo based on a previously elaborated one: http://incquery.net/incquery/demos/jnect. The difference is in the event processing layer: in this new demo, the VIATRA-CEP engine is employed instead of ESPER.

Setting up the environment
--------------
* **Host** Eclipse - requires Xtext, EMF, etc
 * EMF-IncQuery projects
 * VIATRA2-EMF
* **Runtime1** Eclipse:
 * CEP-Core
 * CEP-DSL
 * CEP-DSL UI
* **Runtime2** Eclipse:
 * Case study IncQuery project with queries [hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/casestudy/transaction/hu.bme.mit.incquery.cep.casestudy.transaction.incquery.patterns)
 * Case study Ecore metamodell [hu.bme.mit.incquery.cep.casestudy.transaction.metamodel](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/casestudy/transaction/hu.bme.mit.incquery.cep.casestudy.transaction.metamodel)
 * Case study implementation [hu.bme.mit.incquery.cep.casestudy.transaction](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/casestudy/transaction/hu.bme.mit.incquery.cep.casestudy.transaction)


License
-------
[Eclipse Public License v1.0] (http://www.eclipse.org/legal/epl-v10.html)
