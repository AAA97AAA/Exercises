# JPA Intro

JPA = Java Persistence API

Here's a tutorial: https://www.tutorialspoint.com/jpa/index.htm

## Project during the lesson:
The steps taken to create this project were:

 * Create a new Maven project: (Archetype: com.airhacks - javaee7-essentials-archetype)
 * rename the existing package, remove the `JAXRSConfiguration.java` file
 * add the necessary JPA dependencies to the [pom.xml](pom.xml)
 * add a folder `META-INF` in [src/main/resources](src/main/resources) + a [persistence.xml](src/main/resources/META-INF/persistence.xml) in the `META-INF`, add DERBY configuration
 * create a [Person.java](src/main/java/ch/unige/pinfo/jpaIntro/Person.java) class
 * add the JPA annotations (`@Entity, @Table, @Id, @Column, ...`) + getters + setters + default constructor (and a nicer one)
 * add the full qualifying class name (incl. packages) within a `class`-tag to [persistence.xml](src/main/resources/META-INF/persistence.xml#L5)

 * create a [test](src/test/java) source folder by creating the `test/java` subfolders for the `src` subfolder
 * write a [JUnit-Test](src/test/java/ch/unige/pinfo/jpaIntro/PersonTest.java) that will persist to the DB using an `EntityManager`
 * query the database and iterate over the query results



## What I did after the lecture (for you to explore!):

 * Add an  [Address.java](src/main/java/ch/unige/pinfo/jpaIntro/Address.java) class + annotate with JPA
 * add it to [persistence.xml](src/main/resources/META-INF/persistence.xml#L6)
 * Create an [AddressType.java](src/main/java/ch/unige/pinfo/jpaIntro/AddressType.java) Enum
 * Write a second test within the testfile to show off the cascading effect + ManyToMany mappings
