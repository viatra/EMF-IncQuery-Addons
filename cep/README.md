Complex event processing with IncQuery
======================================

This add-on aims at providing a CEP layer for the **[VIATRA-EVM](http://www.eclipse.org/viatra2/)**. The efficient evaluation of the event patterns is achieved by appropriately designed IncQuery patterns.

Implementation
--------------

The implementation is located in plugin **[hu.bme.mit.incquery.cep](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/hu.bme.mit.incquery.cep)** plugin. The appropriate unit tests are located in plugin **[hu.bme.mit.incquery.cep.tests](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/hu.bme.mit.incquery.cep.tests)**.

For example codes see the **\*.examples.*** plugins:
* **[hu.bme.mit.incquery.cep.examples.example1](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/hu.bme.mit.incquery.cep.examples.example1)** shows a simple use-case where atomic and complex event patterns are defined and recognized on the event stream among other events.
* **[hu.bme.mit.incquery.cep.examples.evm.integration](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/hu.bme.mit.incquery.cep.examples.evm.integration)** presents an example for integrating  VIATRA-CEP and VIATRA-EVM.

Demo
--------------
The plugin **[hu.bme.mit.incquery.cep.jnect](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/hu.bme.mit.incquery.cep.jnect)** contains a demo based on a previously elaborated one: http://incquery.net//incquery/demos/jnect. The difference is in the event processing layer: in this new demo, the VIATRA-CEP engine is employed instead of ESPER.

Roadmap/TODO
------------

Latest enhancements:
* duplicate handling fixed on state machine level
* handling both ordered and unordered cases with time windows

In progress:
* complete the examples and unit tests
* elaborate the JNect demo

Future work:
* make it possible to enable/disable "noise filtering" (per event pattern)
 * e.g. for an "AB" pattern defined and an "AxxxxBxxx" stream observed, the noise-filtered alternative will trigger a recognized event, while the non-filtered will not
 * as a typical use-case for noise-filtering, consider the Jnect Robot Demo 
* enable defining more compound events, i.e. using measurments (as of CEDL)
 * e.g. instead of having an IQPattern_Found and an IQPattern_Lost event, define one event containing the Found/Lost parameter
 * this would require more advanced guard handling on the transitions
 * make it possible to define own measurement types (percentage, scalar and literal won't be satisfactory in the practice)
 * also: find a proper name for this feature
* extend the DFA formalism to a PDA by utilizing the built-in memory of EventTokens
* refactor the examples plugin in a more lucid way
 * package/class naming, comments, etc
 * make sure every use case is properly presented
* define the language for modeling event patterns over EMF models
 * reuse the concepts of event-driven model transformations and the pattern language of IncQuery
* implement the common event processing strategies: chronicle, recent, unrestricted
* make the EventQueue thread-safe in order to enable higher performance via threading
* enable definition of custom execution strategies
 * define semantics for that
 * implement the required API (the extension point mechanism could work here perfectly)

Known issues:
* slightly stochastic behavior when multiple tokens are placed on a state before the final one and an appropriate event arrives to pass some tokens forward to the final state
 * in case of N tokens, the first N-2 are fired properly, the last two, however, are fired together but only one triggers a finished state machine


License
-------
[Eclipse Public License v1.0] (http://www.eclipse.org/legal/epl-v10.html)
