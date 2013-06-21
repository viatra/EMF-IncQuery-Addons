Complex event processing with IncQuery
======================================

This add-on aims at providing a CEP layer for the **[VIATRA-EVM](http://www.eclipse.org/viatra2/)**. The efficient evaluation of the event patterns is achieved by appropriately designed IncQuery patterns.

Implementation
--------------

The implementation is located in plugin **[hu.bme.mit.incquery.cep](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/hu.bme.mit.incquery.cep)** plugin. The appropriate unit tests are located in plugin **[hu.bme.mit.incquery.cep.tests](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/hu.bme.mit.incquery.cep.tests)**.

For example codes see the \**.examples.*\* plugins:
* **[hu.bme.mit.incquery.cep.examples.example1](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/hu.bme.mit.incquery.cep.examples.example1)** shows a simple use-case where atomic and complex event patterns are defined and recognized on the event stream among other events.
* **[hu.bme.mit.incquery.cep.examples.evm.integration](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/hu.bme.mit.incquery.cep.examples.evm.integration)** presents an example for integrating  VIATRA-CEP and VIATRA-EVM.

Demo
--------------
The plugin **[hu.bme.mit.incquery.cep.jnect](https://github.com/istvanrath/EMF-IncQuery-Addons/tree/master/cep/hu.bme.mit.incquery.cep.jnect)** contains a demo based on a previously elaborated one: http://incquery.net//incquery/demos/jnect. The difference is in the event processing layer: in this new demo, the VIATRA-CEP engine is employed instead of ESPER.

Roadmap/TODO
------------

Latest enhancement:
* handling both ordered and unordered cases with time windows

In progress:
* revisit duplicate handling
* complete the examples and unit tests
* elaborate the JNect demo

Future work:
* define the language for modeling event patterns over EMF models
 * reuse the concepts of event-driven model transformations and the pattern language of IncQuery
* implement the common event processing strategies: chronicle, recent, unrestricted
* make the EventQueue thread-safe in order to enable higher performance via threading
* enable definition of custom execution strategies
 * define semantics for that
 * implement the required API (the extension point mechanism could work here perfectly)

License
-------
[Eclipse Public License v1.0] (http://www.eclipse.org/legal/epl-v10.html)
