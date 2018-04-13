# bakery-DI
Bakery project for dependency injection example

I developed locally using Eclipse JEE and deployed on locally installed Wildfly server.
You should find plenty of information on how to setup the environment online.
Alternatively you can compile using Maven and deploy manually to Wildfly (or a Wildfly docker).

If you choose to use Eclipse, you should start Wildfly and then `Run as` -> `Run on Server` -> and then select your configured server.


## DI info

The project is quite simple and models a little bakery.
After deployment, you should be able to navigate to   [http://localhost:8080/bakery/](http://localhost:8080/bakery/)
and see the welcome message:

`The server is up and the App works. Yay!`

If you navigate to
[http://localhost:8080/bakery/bake](http://localhost:8080/bakery/bake)
you will be served a dish in a certain quality.

The quality of the dish is dependent on the `Oven` that was injected,
the dish depends on the `Baker` that was selected.
(`FrenchBaker` bakes `Macaron`, `GermanBaker` creates `BlackForrestCake`).

Default is that you will receive _bad Macarons_ by the _French baker_.
This can be changed in the `beans.xml` file, by specifying that alternatives should be used.
(See the example in the comment there.)

## Interceptors

The project contains two different ways of intercepting a method call.
The interception code itself is placed in `LoggingInterceptor.java` (package `ch.unige.pinfo.bakery.intercept`).

Using this class, it is possible to specify an interceptor using the `@Interceptors(LoggingInterceptor.class)` annotation, as in `BadOven.java`.

An alternative approach is to use a custom annotation. This approach uses the annotation `@Logged` as declared in `Logged.java`.
It is necessary to add `@Logged` to the `LoggingInterceptor` class and also to activate it in `beans.xml`.
Subsequently it is possible to use the interceptor with the annotation, as shown in `GoodOven.java`.

---
If you choose to change the configuration or the code, please note that you will have to make sure the old version is undeployed (removed) and the new version is deployed afterwards.


---
#### Problems:

Problems can occur if the project is NOT imported into Eclipse via `Import` -> `Existing Maven Projects`. Please make sure to declare it is a Maven Project.
