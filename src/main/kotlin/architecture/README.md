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
│        │    └── repository/        (PORTS - interfaces)
│        │         └── OrderRepository.kt
│        │
│        ├── application/            ⚙️ Use Cases (Clean Architecture)
│        │    ├── usecase/
│        │    │    ├── CreateOrderUseCase.kt
│        │    │    └── CheckoutOrderUseCase.kt
│        │    │
│        │    └── dto/
│        │
│        ├── infrastructure/         🔌 Technische Umsetzung - ADAPTERS (konkrete Implementierungen)
│        │    ├── persistence/
│        │    │    └── JpaOrderRepository.kt
│        │    │
│        │    ├── api/
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