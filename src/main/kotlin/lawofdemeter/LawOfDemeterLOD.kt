package de.phbe.lawofdemeter

// Ausgangslage: Ein Aufrufer kennt die komplette Objektstruktur
// Warnsignal: a.getB().getC().getD().doSomething()
class BadAddress(val city: String)
class BadCustomer(val address: BadAddress)
class BadOrder(val customer: BadCustomer)
// val oder = Order(Customer(Address("Stuttgart"))

// -------------------------------------------------------------------------------
// Lösung:
class GoodAddress(val city: String){
    fun getCity(): String = return city
}
class GoodCustomer(val address: GoodAddress){
    fun getCity(): String = address.getCity()
}
class GoodOrder(val customer: GoodCustomer){
    fun getCustomerCity(): String = customer.getCity()
}

// -------------------------------------------------------------------------------
// Verwendung
class LawOfDemeterLOD {
    fun showPrinciple(){
        // Schlecht
        val order = BadOrder(BadCustomer(BadAddress("Stuttgart")))
        println(order.customer.address.city) // Verletzung der Law of Demeter, zu tiefer Zugriff

        // Gut:
        val order2 = GoodOrder(GoodCustomer(GoodAddress("Stuttgart")))
        println(order2.getCustomerCity()) // Einfache Methode, die die Stadt zurückgibt, ohne die interne Struktur preiszugeben
    }
}