package architecture.presentation

import architecture.application.CreateOrderUseCase
import architecture.application.ProductRepository
import architecture.application.RequestedProduct

class FakeProductController(
    private val products: ProductRepository
) {
    fun showProduct(id: String) {
        val product = products.findById(id)
            ?: error("Produkt '$id' wurde nicht gefunden.")
        println("${product.name}: ${product.priceInCents / 100.0} EUR (${product.stock} auf Lager)")
    }
}

class FakeOrderController(
    private val createOrder: CreateOrderUseCase
) {
    fun createOrder(productId: String, quantity: Int) {
        val order = createOrder.execute(listOf(RequestedProduct(productId, quantity)))
        println("Bestellung #${order.id} erstellt: ${order.totalInCents / 100.0} EUR")
    }
}
