Complex event processing with IncQuery
======================================

This add-on aims at providing a CEP layer for the **[VIATRA-EVM](http://www.eclipse.org/viatra2/)**. The efficient evaluation of the event patterns is achieved by appropriately designed **[IncQuery](http://eclipse.org/incquery/)** patterns.

Implementation
--------------

The main implementation is located in plugin **[hu.bme.mit.incquery.cep](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/core/hu.bme.mit.incquery.cep)** plugin. The appropriate unit tests are located in plugin **[hu.bme.mit.incquery.cep.tests](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/core/hu.bme.mit.incquery.cep.tests)**.
There are also two DSLs for defining event patterns and event source types: **[hu.bme.mit.incquery.edl](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/dsl/hu.bme.mit.incquery.edl)** and **[hu.bme.mit.incquery.srct](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/dsl/hu.bme.mit.incquery.srct)** respectively.

For example codes see the **\*.examples.*** plugins:
* **[hu.bme.mit.incquery.cep.examples.example1](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/core/hu.bme.mit.incquery.cep.examples.example1)** shows a simple use-case where atomic and complex event patterns are defined and recognized on the event stream among other events.
* **[hu.bme.mit.incquery.cep.examples.evm.integration](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/core/hu.bme.mit.incquery.cep.examples.evm.integration)** presents an example for integrating  VIATRA-CEP and VIATRA-EVM.

Demo
--------------
The plugin **[hu.bme.mit.incquery.cep.jnect](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/core/hu.bme.mit.incquery.cep.jnect)** contains a demo based on a previously elaborated one: http://incquery.net/incquery/demos/jnect. The difference is in the event processing layer: in this new demo, the VIATRA-CEP engine is employed instead of ESPER.

Roadmap/TODO
------------

**Latest enhancements:**
* 06.30. noise filtering
* 06.29. DSL improvements: follows operator (+timewindows), syntax coloring
* 06.29. fixed token handling issue causing wrongly fired tokens
* 06.27. initial commit for the DSLs
* 06.26. duplicate handling fixed on state machine level
* 06.22. handling both ordered and unordered cases with time windows

**In progress:**
* replace Strategy with the generated EventProcessingContext
* make noise filtering more efficient
* elaborate the JNect demo (robot)
* enable discretization
* complete the examples and unit tests
* define the language for modeling event patterns over EMF models
 * reuse the concepts of event-driven model transformations and the pattern language of IncQuery

**Future work:**
* [r/d] enable defining more compound events, i.e. using measurments (as of CEDL)
 * e.g. instead of having an IQPattern_Found and an IQPattern_Lost event, define one event containing the Found/Lost parameter
 * this would require more advanced guard handling on the transitions
 * make it possible to define own measurement types (percentage, scalar and literal won't be satisfactory in the practice)
 * also: find a proper name for this feature
* [r/d] extend the DFA formalism to a PDA by utilizing the built-in memory of EventTokens
* [d] refactor the examples plugin in a more lucid way
 * package/class naming, comments, etc
 * make sure every use case is properly presented
* [d] implement the common event processing strategies: chronicle, recent, unrestricted
* [d] make the EventQueue thread-safe in order to enable higher performance via threading
* [r/d] enable definition of custom execution strategies
 * define semantics for that
 * implement the required API (the extension point mechanism could work here perfectly)
* [r] examine the opportunities in enabling DTW-based pattern recognition

License
-------
[Eclipse Public License v1.0] (http://www.eclipse.org/legal/epl-v10.html)
