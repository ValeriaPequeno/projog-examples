Provides examples of how to extend the functionality of Prolog by writing new built-in predicates and arithmetic operations using Java.

`src/main/java/com/example/SingletonPredicateExample.java` demonstrates how to add a built-in predicate.

`src/main/java/com/example/CalculatableExample.java` demonstrates how to add a new arithmetic operation.

`src/test/java/com/example/PrologTest.java` demonstrates how the Projog test framework (included as a dependency in the `pom.xml` file) can be used to unit test the new functionality. `PrologTest` contains a method that:

1. Extracts tests that have been written using Prolog and are contained in comments of the Java source files.
2. Runs the extracted tests and compares the actual results against the expected results.