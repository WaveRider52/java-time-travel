# Stufe 1: Bauen mit Ant (heutiges JDK, Ausgabe auf Java-8-Niveau)
FROM eclipse-temurin:17-jdk AS build
RUN apt-get update \
    && apt-get install -y --no-install-recommends ant \
    && rm -rf /var/lib/apt/lists/*
WORKDIR /app
COPY build.xml .
COPY src src
COPY web web
COPY lib lib
RUN ant war

# Stufe 2: Laufzeit auf Tomcat 9 (javax-Namensraum)
# Falls dieser Tag nicht existiert: tomcat:9 verwenden.
FROM tomcat:9.0-jdk17-temurin
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=build /app/build/hallo.war /usr/local/tomcat/webapps/hallo.war
EXPOSE 8080
