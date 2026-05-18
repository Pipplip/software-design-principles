# Software Design Principles

Ziel von Software Design Principles ist es, die Wartbarkeit, Erweiterbarkeit und Verständlichkeit von Software zu verbessern. Es gibt verschiedene Prinzipien, die Entwickler befolgen können, um qualitativ hochwertigen Code zu schreiben. Hier sind einige der wichtigsten Prinzipien:

## Grundlegende Design-Prinzipien

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

#### Low Coupling & High Cohesion (SOLID-Prinzipien unterstützen häufig Low Coupling und High Cohesion)
> **Low Coupling**:   
> Module oder Klassen sollten möglichst wenig voneinander abhängig sein, um die Flexibilität und Wartbarkeit zu erhöhen.

> **High Cohesion**:   
> Module oder Klassen sollten eine klar definierte Aufgabe haben und alle Funktionen sollten eng miteinander verbunden sein, um die Verständlichkeit und Wartbarkeit zu verbessern.

#### Law of Demeter
> **Law of Demeter (LoD)**:   
> Ein Objekt sollte nur mit seinen direkten Freunden kommunizieren und nicht mit den Freunden seiner Freunde. Das bedeutet, dass ein Objekt nur Methoden von Objekten aufrufen sollte, die es direkt kennt, um die Kopplung zu reduzieren und die Wartbarkeit zu verbessern.

___

## Core Concepts

#### Domain = Problemwelt
Domain beschreibt den Anwendungsbereich aus der realen Welt z.B. Online-Shop, Banking, etc. 
 
#### Business Logic = Regeln der Domain
Bringt die Regeln der Domain in ausführbaren Code.   
Business Logic liegt typischerweise im Kern (Domain Layer) einer sauberen Architektur.       
Sie enthält:   
- Geschäftsregeln und -logik
- Kernfunktionen
- Berechnungen und Abläufe    
- Validierungen und Regeln, die die Domäne definieren
- Keine Abhängigkeit nach außen (z.B. Datenbanken, APIs, UI, etc.)

Beispiel Onlineshop:
- Business Logic: Berechnung von Rabatten, Bestellabwicklung, etc.
- Es gibt keine Abhängigkeiten zu Datenbanken, APIs oder UI. (z.B. saveToDatabase() oder sendHttpRequest() sollten nicht in der Business Logic auftauchen)
```kotlin
class Order(private val items: List<Double>) {
    fun totalPrice(): Double { val sum = items.sum() ...}
    fun checkout() { require(items.isNotEmpty()) ...}
}
```

___
## Architekturprinzipien & Patterns

Architekturansätze beschreiben die übergeordnete Struktur einer Anwendung.

#### Clean Architecture - definiert WIE strukturiert wird
Clean Architecture organisiert Anwendungen in klar getrennte Schichten.  
Die Abhängigkeiten zeigen immer nach innen.

#### Hexagonal Architecture (Ports and Adapters) - definiert WIE verbunden wird
Hexagonal Architecture trennt die Business Logic von externen Systemen.  
- Ports = Schnittstellen, die die Anwendungslogik definiert.  
- Adapters = Implementierungen der Ports, die mit externen Systemen kommunizieren.

Datenbanken, APIs, UI, etc. können leichter ausgetauscht werden, ohne die Anwendungslogik zu beeinflussen.

#### Domain-Driven Design (DDD) - definiert WAS gebaut wird (ohne Technik)
DDD ist ein Ansatz zur Modellierung komplexer Fachdomänen.   
Domäne soll die reale Welt abbilden.    

> Entity = Identität (ID) zählt (z.B. Kunde hat eine eindeutige ID)   
> Value Object = Inhalt zählt (z.B. Money(10, "EUR") kann ich zweimal haben, aber sie sind inhaltlich gleich)


Beispiel: Online-Shop   
- Entities: Objekte mit Identität (z.B. Kunde, Bestellung)
- Value Objects: Werte ohne Identität (z.B. Adresse, Geldbetrag)
- Aggregates: Gruppen von Entities und Value Objects, die als Einheit behandelt werden (z.B. Bestellung mit ihren Positionen)
- Repositories: Schnittstellen zum Zugriff von Aggregates (z.B. BestellungRepository)
- Services: Geschäftslogik, die nicht zu einer Entity oder einem Value Object gehört (z.B. ZahlungsService)
- Ubiquitous Language: Gemeinsame Sprache zwischen Entwicklern und Fachexperten z.B. Kunde statt User, Bestellung statt Order, etc.
___

## Funktionale Prinzipien

#### Immutability
Unveränderliche Datenstrukturen und Objekte können die Wartbarkeit und Fehlersicherheit von Software verbessern, da sie keine Seiteneffekte haben und leichter zu verstehen sind. Immutability bedeutet, dass einmal erstellte Datenstrukturen oder Objekte nicht mehr verändert werden können. Stattdessen werden neue Instanzen erstellt, wenn Änderungen erforderlich sind. Dies kann dazu beitragen, Fehler zu vermeiden, die durch unerwartete Änderungen an Daten verursacht werden, und erleichtert die Fehlersuche und das Testen von Software.

#### Pure Functions
Reine Funktionen sind Funktionen, die keine Seiteneffekte haben und immer das gleiche Ergebnis zurückgeben, wenn sie mit den gleichen Eingaben aufgerufen werden. Reine Funktionen können die Wartbarkeit und Fehlersicherheit von Software verbessern, da sie leichter zu verstehen und zu testen sind. Reine Funktionen haben keine Abhängigkeiten von externen Zuständen oder Variablen und können daher unabhängig von anderen Teilen des Codes verwendet werden. Dies erleichtert die Wiederverwendbarkeit und die Fehlersuche, da Fehler in reinen Funktionen leichter zu isolieren und zu beheben sind. Reine Funktionen können auch die Parallelisierung von Code erleichtern, da sie keine Seiteneffekte haben und daher sicher in mehreren Threads oder Prozessen ausgeführt werden können.


