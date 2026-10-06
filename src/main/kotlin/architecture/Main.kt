package architecture

import architecture.application.CreateOrderUseCase
import architecture.domain.Product
import architecture.infrastructure.InMemoryOrderRepository
import architecture.infrastructure.InMemoryProductRepository
import architecture.presentation.FakeOrderController
import architecture.presentation.FakeProductController

class Main {
    fun run() {
        // Repositories: Fülle die Produktliste mit Beispieldaten und erstelle ein leeres Order-Repository
        val products = InMemoryProductRepository(
            listOf(
                Product("book-1", "Domain-Driven Design kompakt", 2999, stock = 3),
                Product("book-2", "Clean Architecture", 2499, stock = 1)
            )
        )
        val orders = InMemoryOrderRepository()
        // Use Case: Erstelle eine Instanz des CreateOrderUseCase mit den Repositories
        val createOrder = CreateOrderUseCase(products, orders)

        // Controllers: Erstelle Instanzen der Fake-Controller mit den entsprechenden Use Cases
        val productController = FakeProductController(products)
        val orderController = FakeOrderController(createOrder)

        println("--- Produktanzeige (FakeProductController) ---")
        productController.showProduct("book-1")

        println("--- Bestellung (FakeOrderController) ---")
        orderController.createOrder("book-1", quantity = 2)

        println("--- Bestand nach der Bestellung ---")
        productController.showProduct("book-1")
    }
}

fun main() {
    Main().run()
}
