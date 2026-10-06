package architecture.application

import architecture.domain.Order

interface OrderRepository {
    fun save(order: Order)
}
