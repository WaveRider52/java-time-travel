# Environment for era 1: Servlet 2.3 on Tomcat 9 in Docker

A tiny servlet that only uses classes of the Servlet API 2.3, a `web.xml` with the 2.3 declaration and a build with Ant. The WAR runs on Tomcat 9.

The `Dockerfile` sets up the whole runtime environment. You do not need Java, Ant or Tomcat on your machine to build and run it, only Docker.

**Tested** on 1 November 2026 on a MacBook Air with an M2 chip (Apple silicon, macOS): the build finished without errors, Apache Tomcat 9.0.123 deployed the WAR without a warning, and the servlet answers with status 200.

**Not proven:** how Tomcat 4.1 itself behaves, and whether the DTD of the `web.xml` is read without internet access.

## Setup on a MacBook Air (Apple silicon)

1. **Install Docker Desktop for Mac** (the version for Apple chips) from docker.com and start the app. Wait until the status at the bottom left says "Engine running".
   The `docker` command alone is not enough. If Docker Desktop is not running, `docker run` reports that it cannot connect to the Docker API.
2. **Check that Docker works:**

       docker run --rm hello-world

   It should print "Hello from Docker!". On an M2 the image is pulled for the Apple chip (`arm64v8`). The base images of this `Dockerfile` (Eclipse Temurin and Tomcat) are pulled the same way, and the Tomcat log reports `aarch64`.
3. **Get the repository and the Servlet API jar** (see "Steps" below), then build and run with Docker.

Tested with Docker command line 29.0.1 and Docker Desktop, Eclipse Temurin 17 and Apache Tomcat 9.0.123 in the containers.

### Optional: editing the code in VS Code

Docker is enough to build and run. To get code completion and error markers while you edit, you additionally need a JDK on the Mac:

1. Install Homebrew (see brew.sh), then the JDK: `brew install --cask temurin@17`. Check with `java -version` in a new terminal. Tested with Temurin 17.0.21.
2. In VS Code, install the "Extension Pack for Java" (tested with version 0.31.2). Stay on the release version, not the pre-release.
3. Download the Servlet API jar into `lib/` (step 1 below). The file `.vscode/settings.json` in this repository tells VS Code where to find it. If the editor still marks `javax.servlet` as unresolved, run "Developer: Reload Window".

## Steps

1. Get the Servlet API 2.3 jar from Maven Central. It is not checked in:

       cd epoche-01-servlet-jsp/umgebung
       mkdir -p lib
       curl -L -o lib/servlet-api-2.3.jar https://repo1.maven.org/maven2/javax/servlet/servlet-api/2.3/servlet-api-2.3.jar
       file lib/servlet-api-2.3.jar

   `file` should report "Zip archive" or "Java archive".

2. Build and start:

       docker build -t zeitreise-test .
       docker run --rm -p 8080:8080 --name zeitreise-test zeitreise-test

3. In a second terminal:

       curl -i http://localhost:8080/hallo/hallo

   Expected: status 200 and the text "Hallo aus einem Servlet im 2.3-Stil".

Stop the container with Ctrl+C. Because of `--rm`, Docker removes it.

## What the Dockerfile does

- **Stage 1 (build):** starts from `eclipse-temurin:17-jdk`, installs Ant, copies `build.xml`, `src`, `web` and `lib`, and runs `ant war`. The code is compiled against the Servlet API 2.3 jar at Java 8 level.
- **Stage 2 (runtime):** starts from `tomcat:9.0-jdk17-temurin`, removes the default web applications and copies `hallo.war` into `webapps`.

## Layout

- `Dockerfile`: the two stages described above.
- `build.xml`: Ant build with `javac` and `war`.
- `src/`: the servlet.
- `web/WEB-INF/web.xml`: deployment descriptor with the 2.3 DOCTYPE.

## Notes

- The container reports Servlet API 4.0. The server is newer than the code, which is why this is a reconstruction.
- According to the project's announcement, support for Tomcat 9 ends on 31 March 2027. Use it locally only.
- On a successful build, Docker hides the output of Ant. With `docker build --progress=plain -t zeitreise-test .` it stays visible.
