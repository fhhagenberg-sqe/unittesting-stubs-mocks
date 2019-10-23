# Unit Testing for Isolated Objects

This exercise shows the use of testing patterns such as Test Stub, Self Shunt and Mock. These patterns are used to isolate the tested objects by replacing dependencies from the tested object to other objects. Once the dependencies have been cut, the tested object can be controlled completely from the test case.

## ObservableStubTest _(3 points)_

As example for a class under test we use [`java.util.Observable`](http://docs.oracle.com/javase/8/docs/api/java/util/Observable.html), (although deprecated since Java 9). The class is part of the Java implementation of the [Observer](https://en.wikipedia.org/wiki/Observer_pattern) design pattern and collaborates with other classes that implement the interface `java.util.Observer`.

Use JUnit to write a test `testNotifyObservers()` that should be put in the test class `at.fhhagenberg.sqe.stubsmocks.ObservableStubTest`. The test should assert that the Observer receives an `update(…)` including a notification message when `notifyObservers()` of the Observable is called. Make sure that the notification (1) is received exactly once and (2) passes the correct parameters. 

Please note:
- According to the default maven project structure, test classes have to be in the folder `src/test/java` (instead of `src/main/java`).
- The test pattern 'Dummy' should be used. Develop a class `DummyObserver` that implements the interface `Observer` and registers with the `Observable`.
- Notifications are only sent when the `Observable` has been changed. The `Observable` can be marked as changed via `setChanged()`. However, this method is protected. Therefore `java.util.Observable` has to be sub-classed for the purpose of testing to call `setChanged()`.

## ObservableShuntTest _(2 points)_

Create the same test as in the previous example `ObservableStubTest`, but now use the Self Shunt test pattern. Name the new test class `ObservableShuntTest`. Again, make sure that the notification (1) is received exactly once and (2) passes the correct parameters. 

Please note:
- When using the Self Shunt test pattern, the test class itself acts as dummy. Therefore the test class implements the interface `Observer` and by setting the reference this the test class is registered as Observer with the Observable. 
- This example is based on the previous example. Follow the instructions from the previous if applicable.

## ObservableMockTest _(3 points)_

Create the same test as in the previous example `ObservableStubTest`, but now use the mock framework [Mockito](https://site.mockito.org/) to implement the test case. Name the new test class `ObservableMockTest`. Again, make sure that the notification (1) is received exactly once and (2) passes the correct parameters.

Please note:
- To use the Mockito library, it must be added as dependency in `pom.xml`. We already did that for you, so you can start using Mockito directly without any modifications!
- The Mock test pattern uses stubs generated by the mock framework. It is not necessary to implement the stubs manually in form of dummies or shunts anymore.
- See `SimpleMockTest.java` for a very simple example of how to use Mockito:
    - Annotate your test class with `@ExtendWith(MockitoExtension.class)` to be able to use the `@Mock` annotation.
    - Use the annotation `@Mock` to automatically create a mock.
- Create the mock object for the interface Observer by using the library. Detailed instructions can be found in the documentation available online at https://javadoc.io/static/org.mockito/mockito-core/3.1.0/org/mockito/Mockito.html.
- Follow the instructions from the previous example if applicable.

# Design for Testability

This exercise emphasizes the topic of testability. 

## Effective Unit Testing with Design for Testability _(2 points)_

When writing a unit test is technically hard or impossible, this is often an indicator that the design of the code you want to test is not testable and, thus, should be refactored. Read the chapter on testable design from Lasse Koskela: Effective Unit Testing (Manning Publications, 2013). The chapter explains typical testability issues that block unit testing and provides guidelines for testable design.

Read the entire chapter. Select one of the guidelines for testable design (7.3), which you think is the most useful for you. “Promise to yourself” that you will always develop according to this guideline in future!

### Question: Which guideline have you selected? Why?

[insert your answer here]