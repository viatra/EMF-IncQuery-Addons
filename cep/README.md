Complex event processing with IncQuery
======================================

This add-on aims at providing a CEP layer for the VIATRA-EVM. The efficient evaluation of the event patterns is achieved by appropriately designed IncQuery patterns.

Implementation
--------------

The implementation has a dedicated plugin: hu.bme.mit.incquery.cep.
For example codes see the test plugin: hu.bme.mit.incquery.cep.tests.

Roadmap/TODO
------------
* implement the common event processing strategies: chronicle, recent, unrestricted
* handle ordered case with time windows
* handle unordered case
 * either with hierarchical state machines,
 * or with generating every execution path of the state machine based on the operational semantics of the language (preferably)
* elaborate the JNect
* negotiate the interfaces used between the CEP layer and the EVM
* make the EventQueue thread-safe in order to enable higher performance via threading
* enable definition of custom execution strategies
 * define semantics for that
 * implement the required API (the extension point mechanism could work here perfectly)
* define the language for modeling event patterns over EMF models
 * reuse the concepts of event-driven model transformations and the pattern language of IncQuery


License
-------
[Eclipse Public License v1.0] (http://www.eclipse.org/legal/epl-v10.html)