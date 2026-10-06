package architecture.application

import architecture.domain.Product

interface ProductRepository {
    fun findById(id: String): Product?
}
