eiq2cypher
==========

The purpose of the eiq2cypher plug-in is to translate patterns from EMF-IncQuery's query language to Cypher.

Neo4j is a popular open-source graph database implemented in Java. Neo4j features two query languages: Gremlin (http://docs.neo4j.org/chunked/snapshot/gremlin-plugin.html) is focused on graph traversals, while Cypher (http://docs.neo4j.org/chunked/snapshot/cypher-query-lang.html) takes a declarative approach for describing patterns.

By default, Neo4j does not support the storage of Java objects. To overcome that limitation, we use the open-source Spring Data (http://www.springsource.org/spring-data) Neo4j library.

eiq2cypher implementation
-------------------------

The eiq2cypher plug-in is implemented using the Xtend2 (http://www.eclipse.org/xtend/) language. In the implementation we used only the following constructs of the Cypher language:
* `START`: The starting points of the query.
* `MATCH`: Define patterns (nodes, undirected and directed edges) in the graph. The intermediate nodes of a path are anonymous nodes denoted with ().
* `WHERE`: Boolean expression. Currently only arithmetic comparisons are supported. 
* `RETURN`: The return values are the parameters of the IncQuery pattern.

Example
-------

The example is based on the School introductory example (http://viatra.inf.mit.bme.hu/incquery/new/examples/school). The following pattern lists all schools and their subjects:

EMF-IncQuery pattern:

    import "http://school.ecore"

    pattern schools(Sch, Subject) = {
        School(Sch);
        School.teachers.courses.subject(Sch, Subject); 
    }

Generated Cypher code:
    
    START
        Sch=node:__types__(className="School")
    MATCH
        (Sch)-[teachers]->()-[courses]->()-[subject]->(Temp1)
    WHERE 1 = 1 
    RETURN
        Sch, Temp1.subject

Run the `hu.bme.mit.emf.incquery.generatecypher` project as an Eclipse application. In the launched Eclipse application import any EMF-IncQuery project. Right click on the `.eiq` file and choose EMF-IncQuery > Generate Cypher query. A `.cypher` file will appear for each pattern in the `src-gen` folder.

