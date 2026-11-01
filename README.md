# java-time-travel (Java Zeitreise)

A learning path through Java eras since 2001. For each era there is a small, tested example written in the style of the time and openly labelled as a **reconstruction**. Each step comes with a blog post at [odabas.ch](https://odabas.ch) (German and English).

## Status

| Era | Topic | Status |
|---|---|---|
| 1 | Servlet 2.3, JSP 1.2, Ant (about 2001 to 2005) | in progress: environment ready, units to follow |

## Getting started

How to set up and run the era 1 environment on a MacBook Air with Apple silicon (Docker Desktop, optional JDK and VS Code) is described in [epoche-01-servlet-jsp/umgebung](epoche-01-servlet-jsp/umgebung/README.md).

## Structure

```
java-time-travel/
├── README.md
├── LICENSE
├── notizen/                    daily notes (raw material for posts, in German)
└── epoche-01-servlet-jsp/
    ├── README.md               goals, planned units, sources
    └── umgebung/               development and runtime environment (Ant, Docker, Tomcat 9)
```

The folder names are German: `epoche` means era, `umgebung` means environment, `notizen` means notes.

## Honest notes

- The source code is written in the style of each era, but it runs on current software. In era 1 that is Tomcat 9 with Servlet API 4.0, not the Tomcat 4.1 of the time. These are reconstructions, not originals.
- Sources and inspirations are listed in each era folder. No text or examples are copied from books or courses.

## License

MIT, see [LICENSE](LICENSE).
