package architecture.infrastructure

import architecture.application.OrderRepository
import architecture.application.ProductRepository
import architecture.domain.Order
import architecture.domain.Product

class InMemoryProductRepository(
    private val products: List<Product>
) : ProductRepository {
    override fun findById(id: String): Product? =
        products.find { it.id == id }
}

class InMemoryOrderRepository : OrderRepository {
    val savedOrders = mutableListOf<Order>()

    override fun save(order: Order) {
        savedOrders += order
    }
}
