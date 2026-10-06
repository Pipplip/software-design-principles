package architecture.application

import architecture.domain.Order
import architecture.domain.OrderLine

data class RequestedProduct(
    val productId: String,
    val quantity: Int
)

class CreateOrderUseCase(
    private val products: ProductRepository,
    private val orders: OrderRepository
) {
    private var nextOrderId = 1

    fun execute(request: List<RequestedProduct>): Order {
        require(request.isNotEmpty()) { "Die Bestellung darf nicht leer sein." }

        val productsToReserve = request.map { requestedProduct ->
            val product = products.findById(requestedProduct.productId)
                ?: error("Produkt '${requestedProduct.productId}' wurde nicht gefunden.")

            product.ensureCanReserve(requestedProduct.quantity)
            product to requestedProduct.quantity
        }

        val order = Order(
            nextOrderId++,
            productsToReserve.map { (product, quantity) ->
                OrderLine(product.name, quantity, product.priceInCents)
            }
        )
        productsToReserve.forEach { (product, quantity) -> product.reserve(quantity) }
        return order.also(orders::save)
    }
}
