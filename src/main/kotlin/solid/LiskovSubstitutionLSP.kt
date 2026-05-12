package de.phbe.solid

// Eine Unterklasse muss überall dort verwendbar sein, wo die Oberklasse erwartet wird
// – ohne dass das Programm kaputtgeht oder sich logisch falsch verhält.

// Ausgangslage: Oberklasse
// Die Berechnung der Fläche findet in der Oberklasse statt.
// Die Berechnung ist gleich, aber die Bedeutung der Zustände (width, height) wird verändert.
open class Rechteck{
    open var width: Int = 0
    open var height: Int = 0

    fun area(): Int = width * height
}

// Unterklasse
class Quadrat: Rechteck(){
    override var width: Int = 0
        set(value) {
            field = value
            height = value // Quadrat hat gleiche Breite und Höhe
        }

    override var height: Int = 0
}

// -------------------------------------------------------------------------------
// Lösung:
interface Shape {
    fun area(): Int
}

class GoodRechteck(
    private val width: Int,
    private val height: Int
) : Shape {
    override fun area(): Int = width * height
}

class GoodQuadrat (
    private val side: Int
) : Shape {
    override fun area(): Int = side * side
}

// -------------------------------------------------------------------------------
// Verwendung
class LiskovSubstitutionLSP {
    fun showPrinciple(){
        // Schlecht:
        val rechteck: Rechteck = Quadrat() // LSP Verletzung - andere Erwartung
        rechteck.width = 5
        rechteck.height = 10
        println("Flaeche: ${rechteck.width} * ${rechteck.height} = ${rechteck.area()}") // Erwartung 5 * 10 = 50, aber Quadrat verändert Verhalten

        // Gut:
        val rect = GoodQuadrat(5)
        println("Gut Flaeche: ${rect.area()}") // Erwartung 25
    }
}