Complex event processing with IncQuery
======================================

This add-on aims at providing a CEP layer for the VIATRA-EVM. The efficient evaluation of the event patterns is achieved by appropriately designed IncQuery patterns.

Implementation
--------------

The implementation has a dedicated plugin: hu.bme.mit.incquery.cep.
For example codes see the test plugins: hu.bme.mit.incquery.cep.tests, hu.bme.mit.incquery.cep.tests.evm.integration, hu.bme.mit.incquery.cep.tests.evm.integration2. The former one will contain the JUnit tests in the future; there will be an examples plugin for the EVM integration and the demonstrations.

Demo
--------------
The plugin hu.bme.mit.incquery.cep.jnect contains a demo based on a previously elaborated one: [http://incquery.net//incquery/demos/jnect]. The difference is in the event processing layer: in this demo, the new VIATRA-CEP layer is employed instead of ESPER.

Roadmap/TODO
------------
In progress:
* handle both ordered and unordered cases with time windows
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