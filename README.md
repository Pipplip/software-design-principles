# Software Design Principles

Ziel von Software Design Principles ist es, die Wartbarkeit, Erweiterbarkeit und Verständlichkeit von Software zu verbessern. Es gibt verschiedene Prinzipien, die Entwickler befolgen können, um qualitativ hochwertigen Code zu schreiben. Hier sind einige der wichtigsten Prinzipien:

## Grundlegende Prinzipien

#### SOLID Prinzipien

SOLID Prinzipien sind eine Gruppe von fünf Designprinzipien:    
> 1. **Single Responsibility Principle (SRP)**:    
> Eine Klasse sollte nur eine einzige Verantwortung haben und diese vollständig kapseln.
 
> 2. **Open/Closed Principle (OCP)**:    
> Software-Entitäten sollten offen für Erweiterungen, aber geschlossen für Modifikationen sein. Also neue Features hinzufügen ohne alten Code kaputtzumachen

> 3. **Liskov Substitution Principle (LSP)**:    
> Objekte einer Basisklasse sollten durch Objekte ihrer Unterklasse ersetzt werden können, ohne dass das Verhalten des Programms beeinträchtigt wird.

> 4. **Interface Segregation Principle (ISP)**:   
> Clients sollten nicht gezwungen sein, Schnittstellen zu implementieren, die sie nicht verwenden. Also lieber viele kleine Interfaces als wenige große.

> 5. **Dependency Inversion Principle (DIP)**:     
> Abhängigkeiten sollten von Abstraktionen abhängen, nicht von konkreten Implementierungen. Lose Kopplung zwischen Modulen.

#### DRY Prinzip
> **Don't Repeat Yourself (DRY)**:   
> Vermeide die Wiederholung von Code. Stattdessen sollten gemeinsame Funktionalitäten in Funktionen,Klassen oder Module ausgelagert werden, um Redundanz zu reduzieren und die Wartbarkeit zu verbessern.


#### KISS Prinzip
> **Keep It Simple, Stupid (KISS)**:   
> Halte den Code so einfach wie möglich. Vermeide unnötige Komplexität und schreibe klaren, verständlichen Code, der leicht zu warten und zu erweitern ist.

#### YAGNI Prinzip
> **You Aren't Gonna Need It (YAGNI)**:   
> Implementiere keine Funktionalitäten, die derzeit nicht benötigt werden. Konzentriere dich auf die aktuellen Anforderungen und vermeide die Versuchung, zukünftige Features vorzeitig zu implementieren, um die Komplexität zu reduzieren und die Entwicklung zu beschleunigen.

#### Separation of Concerns (SoC)
> Trenne verschiedene Aspekte eines Programms in separate Module oder Klassen, um die Wartbarkeit und Verständlichkeit zu verbessern. Zum Beispiel könnte die Datenbanklogik von der Geschäftslogik getrennt werden, um die Verantwortlichkeiten klar zu definieren und die Wiederverwendbarkeit zu erhöhen.

#### Low Coupling & High Cohesion
> **Low Coupling**:   
> Module oder Klassen sollten möglichst wenig voneinander abhängig sein, um die Flexibilität und Wartbarkeit zu erhöhen.

> **High Cohesion**:   
> Module oder Klassen sollten eine klar definierte Aufgabe haben und alle Funktionen sollten eng miteinander verbunden sein, um die Verständlichkeit und Wartbarkeit zu verbessern.

#### Law of Demeter
> **Law of Demeter (LoD)**:   
> Ein Objekt sollte nur mit seinen direkten Freunden kommunizieren und nicht mit den Freunden seiner Freunde. Das bedeutet, dass ein Objekt nur Methoden von Objekten aufrufen sollte, die es direkt kennt, um die Kopplung zu reduzieren und die Wartbarkeit zu verbessern.

___

## Architekturprinzipien

#### Clean Architecture
Clean Architecture ist ein Architekturansatz, der darauf abzielt, die Abhängigkeiten zwischen den verschiedenen Schichten einer Software zu minimieren. Es betont die Trennung von Verantwortlichkeiten und die Verwendung von Schnittstellen, um die Flexibilität und Wartbarkeit zu erhöhen. In Clean Architecture gibt es vier Hauptschichten: die Entities, die Use Cases, die Interface Adapters und die Frameworks & Drivers. Jede Schicht hat eine klare Verantwortung und kommuniziert nur mit den angrenzenden Schichten, um die Abhängigkeiten zu minimieren. 

#### Hexagonal Architecture
Hexagonal Architecture, auch bekannt als Ports and Adapters, ist ein Architekturansatz, der darauf abzielt, die Abhängigkeiten zwischen der Anwendungslogik und den externen Systemen zu minimieren. Es betont die Trennung von Verantwortlichkeiten und die Verwendung von Schnittstellen, um die Flexibilität und Wartbarkeit zu erhöhen. In Hexagonal Architecture gibt es drei Hauptkomponenten: die Anwendungslogik, die Ports und die Adapters. Die Anwendungslogik enthält die Geschäftslogik, die Ports definieren die Schnittstellen für die Kommunikation mit externen Systemen, und die Adapters implementieren diese Schnittstellen, um die Kommunikation mit den externen Systemen zu ermöglichen.

#### Domain-Driven Design (DDD)
Domain-Driven Design (DDD) ist ein Ansatz zur Softwareentwicklung, der sich auf die Modellierung der Domäne und die Zusammenarbeit zwischen Entwicklern und Fachexperten konzentriert. DDD betont die Bedeutung von Ubiquitous Language, um eine gemeinsame Sprache zwischen Entwicklern und Fachexperten zu schaffen, und die Verwendung von Bounded Contexts, um die Komplexität der Domäne zu bewältigen. In DDD gibt es verschiedene Bausteine wie Entities, Value Objects, Aggregates, Repositories und Services, die dazu beitragen, die Geschäftslogik zu modellieren und die Wartbarkeit zu verbessern.

___

## Funktionale Prinzipien

#### Immutability
Unveränderliche Datenstrukturen und Objekte können die Wartbarkeit und Fehlersicherheit von Software verbessern, da sie keine Seiteneffekte haben und leichter zu verstehen sind. Immutability bedeutet, dass einmal erstellte Datenstrukturen oder Objekte nicht mehr verändert werden können. Stattdessen werden neue Instanzen erstellt, wenn Änderungen erforderlich sind. Dies kann dazu beitragen, Fehler zu vermeiden, die durch unerwartete Änderungen an Daten verursacht werden, und erleichtert die Fehlersuche und das Testen von Software.

#### Pure Functions
Reine Funktionen sind Funktionen, die keine Seiteneffekte haben und immer das gleiche Ergebnis zurückgeben, wenn sie mit den gleichen Eingaben aufgerufen werden. Reine Funktionen können die Wartbarkeit und Fehlersicherheit von Software verbessern, da sie leichter zu verstehen und zu testen sind. Reine Funktionen haben keine Abhängigkeiten von externen Zuständen oder Variablen und können daher unabhängig von anderen Teilen des Codes verwendet werden. Dies erleichtert die Wiederverwendbarkeit und die Fehlersuche, da Fehler in reinen Funktionen leichter zu isolieren und zu beheben sind. Reine Funktionen können auch die Parallelisierung von Code erleichtern, da sie keine Seiteneffekte haben und daher sicher in mehreren Threads oder Prozessen ausgeführt werden können.


