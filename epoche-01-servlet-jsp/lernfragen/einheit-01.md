# Einheit 1 – Verzeichnisstruktur und Build mit Ant

[Deutsch](einheit-01.md) | [English](en/unit-01.md)

## Mein Lernziel

Ich möchte verstehen, wie eine Java-Webanwendung aufgebaut ist und wie ich ihre Java-Klassen mit Apache Ant kompilieren kann.

## Teil 1 – Verzeichnisstruktur und Kompilierung

**Bisher gelesene Quellen:**
- Java Servlet Specification 2.3, SRV.9.5 und SRV.9.5.1, Seiten 60–61 (meine PDF-Ausgabe)
- *Java Development with Ant*, Kapitel 12.1

### Verständnisfragen

**1. Welche Bedeutung hat das Verzeichnis `WEB-INF`, und weshalb ist es besonders?**

In `WEB-INF` liegen die internen Teile meiner Webanwendung. Dieses Verzeichnis befindet sich direkt unter dem Wurzelverzeichnis. Der Servlet-Container darf Dateien unter `WEB-INF` nicht direkt als Antwort auf HTTP-Anfragen an Clients ausliefern.

Meine Servlets können aber innerhalb der Anwendung auf solche Dateien zugreifen, zum Beispiel mit `getResource()` oder `getResourceAsStream()` über den `ServletContext`. Auch eine interne Weiterleitung mit einem `RequestDispatcher` kann Ressourcen unter `WEB-INF` verwenden.

Dort liegt die Konfigurationsdatei `web.xml`. Ausserdem gibt es die Unterverzeichnisse `classes` für kompilierte Java-Klassen und `lib` für JAR-Dateien.

*Quelle für den Verzeichnisschutz, den Zugriff über `ServletContext` und die Grundstruktur: SRV.9.5. Die Erklärung zu `RequestDispatcher` ist eine zusätzliche technische Ergänzung.*

**2. Was gehört in `WEB-INF/classes` und was in `WEB-INF/lib`? Worin unterscheiden sich die beiden Verzeichnisse?**

In `WEB-INF/classes` liegen die kompilierten Klassen meiner Anwendung, also beispielsweise Servlets oder Hilfsklassen. Dort können auch andere Ressourcen liegen, die zu diesen Klassen gehören, etwa `.properties`-Dateien.

In `WEB-INF/lib` liegen dagegen JAR-Dateien mit Bibliotheken. Beide Verzeichnisse gehören zum Klassenpfad meiner Webanwendung. So kann der Servlet-Container meine Klassen und die benötigten Bibliotheken laden.

*Quelle für `WEB-INF/classes`, `WEB-INF/lib` und das Laden der Klassen durch den Anwendungsklassenlader: SRV.9.5. Der Hinweis auf zusätzliche Ressourcen wie `.properties`-Dateien ist eine ergänzende technische Erklärung.*

**3. Warum muss die Paketstruktur einer Java-Klasse in der Verzeichnisstruktur wiederzufinden sein?**

Wenn ich eine Java-Klasse in einem Paket ablege, muss ich die Paketstruktur auch im Pfad der kompilierten Klasse wiederfinden. So kann der Container die Klasse unter ihrem vollständigen Namen finden.

Bei `package ch.beispiel.web;` erwarte ich deshalb die kompilierte Datei hier:

`WEB-INF/classes/ch/beispiel/web/HalloServlet.class`

Jeder Punkt im Paketnamen entspricht dabei einer weiteren Verzeichnisebene unter `WEB-INF/classes`.

*Quelle für die Paketverzeichnisstruktur: SRV.9.5.1 (Beispiel).*

**4. Welche Dateien einer Webanwendung können ausserhalb von `WEB-INF` liegen?**

Ausserhalb von `WEB-INF` liegen die Dateien, die grundsätzlich direkt über den Browser erreichbar sein können. Dazu gehören beispielsweise HTML-Seiten, JSP-Dateien, CSS-Dateien, JavaScript-Dateien und Bilder. Sie können direkt im Wurzelverzeichnis oder in weiteren Unterverzeichnissen liegen.

Bei einer JSP-Datei wird normalerweise nicht ihr Quelltext an den Browser geschickt. Der Servlet-Container verarbeitet die JSP und liefert das erzeugte Ergebnis zurück.

Ich unterscheide deshalb zwischen Ressourcen ausserhalb von `WEB-INF`, die grundsätzlich direkt angefragt werden können, und den geschützten internen Ressourcen unter `WEB-INF`. Auch ausserhalb von `WEB-INF` können zusätzliche Sicherheitsregeln den Zugriff einschränken.

*Quelle für das Wurzelverzeichnis und den Schutz von `WEB-INF`: SRV.9.5. Die Verarbeitung von JSP-Dateien und mögliche Zugriffsbeschränkungen sind zusätzliche technische Erläuterungen.*

**5. Was zeigt mir das Beispiel in SRV.9.5.1 über den Aufbau einer Webanwendung?**

Das Beispiel hilft mir, die Verzeichnisse einer Webanwendung einzuordnen. Zuerst gibt es ein Wurzelverzeichnis. Darin können HTML- oder JSP-Seiten liegen und weitere Ordner, beispielsweise für Bilder.

Daneben gibt es `WEB-INF` für die internen Teile. Dort liegt `web.xml`. Im Unterverzeichnis `lib` befinden sich JAR-Dateien, und unter `classes` liegen die kompilierten Servlet- und Hilfsklassen in ihrer Paketstruktur.

Ich sehe daran, wie öffentliche Ressourcen und interne Bestandteile in einer gemeinsamen Webanwendung getrennt organisiert sind.

*Quelle zum Verzeichnisbeispiel: SRV.9.5.1.*

**Vereinfachte Verzeichnisstruktur, angelehnt an SRV.9.5.1:**

```text
MeineWebanwendung/
├── index.html
├── beispiel.jsp
├── images/
│   └── logo.gif
└── WEB-INF/
    ├── web.xml
    ├── classes/
    │   └── ... kompilierte Java-Klassen und Ressourcen
    └── lib/
        └── ... JAR-Dateien
```

### Meine praktische Umsetzung

**Was habe ich erstellt?**

*Noch offen.*

**Wie habe ich die Java-Klassen mit Ant kompiliert?**

*Noch offen.*

**Was hat mich überrascht?**

*Noch offen.*

**Welche Fragen sind geblieben?**

*Noch offen.*

## Teil 2 – WAR erstellen und in Tomcat bereitstellen

*Für einen späteren Arbeitsschritt vorgesehen. Hier dokumentiere ich die tatsächliche Umsetzung, sobald ich damit begonnen habe.*

## Mein Lernstand

- [x] Ant-Buch, Kapitel 12.1 gelesen und fünf Stichpunkte festgehalten
- [x] SRV.9.5 und SRV.9.5.1 gelesen
- [x] Verständnisfragen beantwortet
- [ ] Projektverzeichnis für Einheit 1 erstellt
- [ ] Eigenes Servlet und `web.xml` erstellt
- [ ] Ant-Targets `clean` und `compile` umgesetzt
- [ ] Kompilierung und Verzeichnisstruktur geprüft
