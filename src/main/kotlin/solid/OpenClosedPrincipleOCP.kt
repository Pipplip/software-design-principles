package de.phbe.solid

// Ausgangslage: Paymentservice. Wenn eine neue Zahlmethode dazu kommt, muss der Service angepasst werden.

class BadPaymentService {
    fun pay(type: String, amount: Double) {
        when (type) {
            "paypal" -> println("Bezahle $amount mit PayPal")
            "creditcard" -> println("Bezahle $amount mit Kreditkarte")
        }
    }
}

// -------------------------------------------------------------------------------
// Lösung:
// Erstelle eine Interface für eine Zahlungsmethode
interface PaymentMethod {
    fun pay(amount: Double)
}

class PayPalPayment : PaymentMethod {
    override fun pay(amount: Double) {
        println("Bezahle $amount mit PayPal")
    }
}

class CreditCardPayment : PaymentMethod {
    override fun pay(amount: Double) {
        println("Bezahle $amount mit Kreditkarte")
    }
}

class PaymentService(
    private val paymentMethod: PaymentMethod
) {
    fun process(amount: Double) {
        paymentMethod.pay(amount)
    }
}

// -------------------------------------------------------------------------------
// Verwendung
class OpenClosedPrincipleOCP{
    fun showPrinciple(){
        // Schlecht:
        val badPaymentService = BadPaymentService()
        badPaymentService.pay("paypal", 100.0)
        badPaymentService.pay("unknown", 250.0)

        // Gut
        val paypal = PaymentService(PayPalPayment())
        paypal.process(100.0)

        val creditCard = PaymentService(CreditCardPayment())
        creditCard.process(250.0)
    }
}