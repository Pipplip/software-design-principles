package architecture.domain

data class OrderLine(
    val productName: String,
    val quantity: Int,
    val unitPriceInCents: Int
) {
    val totalInCents: Int
        get() = quantity * unitPriceInCents
}

data class Order(
    val id: Int,
    val lines: List<OrderLine>
) {
    init {
        require(lines.isNotEmpty()) { "Eine Bestellung muss mindestens ein Produkt enthalten." }
    }

    val totalInCents: Int
        get() = lines.sumOf(OrderLine::totalInCents)
}
