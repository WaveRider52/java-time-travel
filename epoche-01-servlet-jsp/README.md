# Era 1: Servlet 2.3, JSP 1.2, Ant (about 2001 to 2005)

A `web.xml` without annotations, a WAR archive, a build with Ant. The source code is written in the style of the time and runs on a current Tomcat 9 (see [umgebung](umgebung/)). It is a **reconstruction**.

## Status

- Environment: ready and tested (Tomcat 9 in Docker, built with Ant and JDK 17 at Java 8 level).
- Units: will be added step by step.

## Planned units

1. Directory structure and build with Ant
2. `web.xml` and the WAR archive
3. Servlet life cycle, thread safety, HTTP
4. Request, response, forms, character encoding, `RequestDispatcher`
5. Sessions and a login demo (user name only, no password)
6. Filters and listeners
7. JSP 1.2 and its XML syntax

## Learning Questions

My learning questions, answers, and progress notes are available in German and English:

- [Deutsch – Lernfragen](lernfragen/README.md)
- [English – Learning Questions](lernfragen/en/README.md)

Unit 1 covers the web application directory structure described in Servlet Specification 2.3, sections SRV.9.5 and SRV.9.5.1. The theoretical questions are answered; the practical implementation is still pending.

## Sources and inspirations

- Java Servlet Specification 2.3 (JSR 53): the factual basis for statements about the API.
- Inspiration for the order of topics: "Web Development with JavaServer Pages", 2nd edition (Fields, Kolb, Bayern; Manning, 2001), and "Java Development with Ant" (Hatcher, Loughran; Manning, 2002). Only the order of topics is used, no texts, examples or exercises.

## Note on the runtime

Support for the Tomcat 9.0.x branch ends on 31 March 2027, according to the [Apache Tomcat announcement](https://tomcat.apache.org/tomcat-9.0.x-eos.html). The project plans a follow-up branch 9.1.x with releases until 31 December 2030. The environment is meant for local use and does not run publicly on the internet.
