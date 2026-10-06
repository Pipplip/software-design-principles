package architecture.domain

data class Product(
    val id: String,
    val name: String,
    val priceInCents: Int,
    var stock: Int
) {
    fun ensureCanReserve(quantity: Int) {
        require(quantity > 0) { "Die Menge muss größer als 0 sein." }
        require(stock >= quantity) { "Nicht genügend Bestand für '$name'." }
    }

    fun reserve(quantity: Int) {
        ensureCanReserve(quantity)
        stock -= quantity
    }
}
