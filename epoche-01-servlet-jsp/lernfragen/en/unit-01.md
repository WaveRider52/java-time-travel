# Unit 1 – Directory Structure and Building with Ant

[Deutsch](../einheit-01.md) | [English](unit-01.md)

## My Learning Goal

I want to understand how a Java web application is structured and how to compile its Java classes using Apache Ant.

## Part 1 – Directory Structure and Compilation

**Sources I have read so far:**
- Java Servlet Specification 2.3, SRV.9.5 and SRV.9.5.1, pages 60–61 (in my PDF edition)
- *Java Development with Ant*, Chapter 12.1

### Comprehension Questions

**1. What is the purpose of the `WEB-INF` directory, and why is it special?**

`WEB-INF` contains the internal parts of my web application. This directory sits directly below the application's root directory. The servlet container must not serve files located under `WEB-INF` directly to clients in response to HTTP requests.

My servlets can access these files from within the application, for example through `getResource()` or `getResourceAsStream()` on the `ServletContext`. An internal dispatch through a `RequestDispatcher` can also use resources under `WEB-INF`.

This directory contains the `web.xml` configuration file. It also has the `classes` subdirectory for compiled Java classes and `lib` for JAR files.

*Source for directory protection, access through `ServletContext`, and the basic structure: SRV.9.5. The explanation concerning `RequestDispatcher` is an additional technical note.*

**2. What belongs in `WEB-INF/classes` and `WEB-INF/lib`? How do these directories differ?**

`WEB-INF/classes` contains my application's compiled classes, such as servlets and helper classes. It can also contain other resources associated with these classes, such as `.properties` files.

`WEB-INF/lib`, by contrast, contains JAR files with libraries. Both directories contribute to my web application's classpath. This allows the servlet container to load my classes and the libraries they need.

*Source for `WEB-INF/classes`, `WEB-INF/lib`, and class loading by the web application's class loader: SRV.9.5. The note about additional resources such as `.properties` files is a supplementary technical explanation.*

**3. Why must the package structure of a Java class be reflected in the directory structure?**

When I place a Java class in a package, its compiled class file must also reflect that package structure in its path. This allows the container to find the class by its fully qualified name.

For `package ch.beispiel.web;`, I therefore expect the compiled file at:

`WEB-INF/classes/ch/beispiel/web/HalloServlet.class`

Each dot in the package name corresponds to another directory level under `WEB-INF/classes`.

*Source for the package directory structure: SRV.9.5.1 (example).*

**4. What files in a web application can be located outside `WEB-INF`?**

Outside `WEB-INF` are files that can, in principle, be accessed directly through a browser. Examples include HTML pages, JSP files, CSS files, JavaScript files, and images. These can be placed in the root directory or in additional subdirectories.

For a JSP file, the source code is not normally sent to the browser. The servlet container processes the JSP and returns the generated output.

I therefore distinguish between resources outside `WEB-INF`, which can in principle be requested directly, and protected internal resources under `WEB-INF`. Additional security rules can also restrict access to resources outside `WEB-INF`.

*Source for the root directory and protection of `WEB-INF`: SRV.9.5. JSP processing and possible access restrictions are additional technical explanations.*

**5. What does the example in SRV.9.5.1 show me about the structure of a web application?**

The example helps me understand where the various directories of a web application belong. There is a root directory, which can contain HTML or JSP pages, as well as other directories such as one for images.

There is also `WEB-INF` for internal components. It contains `web.xml`. The `lib` subdirectory holds JAR files, while `classes` contains compiled servlet and helper classes arranged according to their package structure.

This shows me how publicly accessible resources and internal components are organised separately within the same web application.

*Source for the directory example: SRV.9.5.1.*

**Simplified directory structure, based on SRV.9.5.1:**

The example uses the German directory name `MeineWebanwendung` ("MyWebApplication").

```text
MeineWebanwendung/
├── index.html
├── beispiel.jsp
├── images/
│   └── logo.gif
└── WEB-INF/
    ├── web.xml
    ├── classes/
    │   └── ... compiled Java classes and resources
    └── lib/
        └── ... JAR files
```

### My Practical Work

**What have I created?**

*Not started yet.*

**How did I compile the Java classes with Ant?**

*Not started yet.*

**What surprised me?**

*Not started yet.*

**What questions remain?**

*Not started yet.*

## Part 2 – Creating a WAR and Deploying to Tomcat

*Planned for a later step. I will document the actual implementation here once I have started it.*

## My Progress

- [x] Read Chapter 12.1 of the Ant book and recorded five notes
- [x] Read SRV.9.5 and SRV.9.5.1
- [x] Answered the comprehension questions
- [ ] Created the project directory structure for Unit 1
- [ ] Created my own servlet and `web.xml`
- [ ] Implemented the Ant targets `clean` and `compile`
- [ ] Checked compilation and the directory structure
