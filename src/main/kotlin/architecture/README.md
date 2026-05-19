# Vorgehensweise um Projekt zu definieren

## 1. Domäne verstehen
Was soll das System im echten Leben abbilden?   
Beispiel: Ein Online-Shop, der Produkte verkauft und Bestellungen verwaltet.  

Fachsprache sammeln:   
- Produkt: Ein Artikel, der im Shop verkauft wird.  
- Bestellung: Eine Sammlung von Produkten, die ein Kunde kauft.  
- Kunde: Eine Person, die Produkte kauft.  
- Preis: Der Geldbetrag, den ein Produkt kostet.  
- Rabatt: Ein Prozentsatz, der den Preis eines Produkts reduziert.  
- Lagerbestand: Die Anzahl der verfügbaren Produkte.

Prozesse/Abläufe verstehen:   
- Ein Kunde wählt Produkte aus und legt sie in den Warenkorb.  
- Der Kunde gibt seine Adresse und Zahlungsinformationen ein.  
- Das System berechnet den Gesamtpreis, einschließlich Rabatten.  
- Das System speichert die Bestellung und aktualisiert den Lagerbestand.

## 2. Domain Model erstellen
Domain-Objekte identifizieren:   
- Product (Entity): ID, Name, Preis, Lagerbestand  
- Order (Entity): ID, Liste von Produkten, Gesamtpreis, Kunde  
- Customer (Entity): ID, Name, Adresse  
- Money (Value Object): Betrag, Währung
- Address (Value Object): Straße, Stadt, Postleitzahl

## 3. Business Logic definieren
Regeln definieren:   
- Ein Produkt kann nur bestellt werden, wenn es auf Lager ist.  
- Der Gesamtpreis einer Bestellung wird berechnet, indem die Preise der Produkte addiert und Rabatte angewendet werden.  
- Eine Bestellung kann nur abgeschlossen werden, wenn der Kunde gültige Zahlungsinformationen bereitstellt.

Domänenmodell definieren (Source Code)   
- Product.kt: Definiert die Product-Entity mit ihren Eigenschaften und Methoden.  
- Order.kt: Definiert die Order-Entity mit ihren Eigenschaften und Methoden.  
- Customer.kt: Definiert die Customer-Entity mit ihren Eigenschaften und Methoden.  
- Money.kt: Definiert das Money-Value Object mit Betrag und Währung.  
- PricingService.kt: Definiert die Business Logic zur Berechnung von Preisen und Rabatten.

## 4. Application Layer definieren (Use Cases)
Was darf der Nutzer?
- CreateOrderUseCase: Ermöglicht es einem Kunden, eine Bestellung zu erstellen.  
- CheckoutOrderUseCase: Ermöglicht es einem Kunden, eine Bestellung abzuschließen.
- CreateOrderUseCase.kt: Implementiert die Logik zum Erstellen einer Bestellung.  
- CheckoutOrderUseCase.kt: Implementiert die Logik zum Abschließen einer Bestellung.

## 5. Ports definieren
Schnittstellen (Interfaces innerhalb der Domain!) für die Kommunikation mit externen Systemen:
- OrderRepository: Schnittstelle für den Zugriff auf Bestellungen (z.B. speichern, abrufen).  
- PaymentClient: Schnittstelle für die Kommunikation mit einem Zahlungsdienstleister.

## 6. Adapters implementieren
Konkrete Implementierungen der Ports:
- JpaOrderRepository: Implementiert die OrderRepository-Schnittstelle mit JPA für die Datenbank.  
- PaymentClientImpl: Implementiert die PaymentClient-Schnittstelle, um mit einem externen Zahlungsdienstleister zu kommunizieren.

## 7. Präsentationsebene definieren
API-Endpunkte und DTOs:
- OrderController: Definiert die REST-API-Endpunkte für Bestellungen.  
- OrderDto: Definiert die Datenstruktur für die Übertragung von Bestelldaten zwischen Client und Server.  
- OrderDtoMapper: Definiert die Logik zum Umwandeln von Order-Entities in OrderDto und umgekehrt.

```
                Außen (Technik)
┌────────────────────────────────────────────┐
│ Presentation Layer                         │
│ - REST Controller                          │
│ - UI (Web / Mobile)                        │
└────────────────────────────────────────────┘
                     ↓
┌────────────────────────────────────────────┐
│ Application Layer                          │
│ - Use Cases                                │
│ - Orchestrierung                           │
│ - nutzt Domain                             │
│ - definiert Ports (Interfaces)             │
└────────────────────────────────────────────┘
                     ↓
┌────────────────────────────────────────────┐ Ganz Innen (Kern)
│ Domain Layer 🧠                            │
│ - Entities                                 │
│ - Value Objects                            │
│ - Domain Services                          │
│ - Business Logic                           │
└────────────────────────────────────────────┘
                     ↑
        ┌────────────────────────────┐ Ports (Interfaces)
        │ Ports (Interfaces)         │
        │ - Repository               │
        │ - PaymentGateway           │
        │ - EmailService             │
        └────────────────────────────┘
                     ↑
┌────────────────────────────────────────────┐
│ Infrastructure Layer                       │ Adaptern (konkrete Implementierungen)
│ - DB (JPA, Mongo)                          │
│ - External APIs (Stripe etc.)              │
│ - Messaging (Kafka)                        │
└────────────────────────────────────────────┘
```


# Projektstruktur für eine Shop-Anwendung mit DDD, Clean Architecture und Hexagonal Architecture

```
src/
└── main/
├── kotlin/
│    └── com.example.shop/
│        ├── domain/                 🧠 DDD (Kern)
│        │    ├── model/
│        │    │    ├── Order.kt
│        │    │    ├── Product.kt
│        │    │    └── Money.kt
│        │    │
│        │    ├── service/
│        │    │    └── PricingService.kt
│        │    │
│        │    └── port/        (PORTS - interfaces)
│        │         └── OrderRepository.kt
│        │
│        ├── application/            ⚙️ Use Cases (Clean Architecture)
│        │    ├── usecase/
│        │    │    ├── CreateOrderUseCase.kt
│        │    │    └── CheckoutOrderUseCase.kt
│        │    │
│        │    └── dto/
│        │
│        ├── infrastructure/         🔌 Technische Umsetzung - ADAPTERS (konkrete Implementierungen + Framework Code)
│        │    ├── persistence/
│        │    │    └── JpaOrderRepository.kt
│        │    │
│        │    ├── payment/
│        │    │    └── PaymentClient.kt
│        │    │
│        │    └── config/
│        │
│        └── presentation/          🌐 API Layer
│             ├── controller/
│             │    └── OrderController.kt
│             │
│             └── mapper/
│                  └── OrderDtoMapper.kt
│
└── resources/
├── application.yml
```