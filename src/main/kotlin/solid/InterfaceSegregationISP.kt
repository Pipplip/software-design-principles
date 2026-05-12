package de.phbe.solid

// „Klienten sollen nicht gezwungen werden, von Interfaces abzuhängen, die sie nicht benutzen.“
// Mit anderen Worten: Lieber mehrere kleine, spezialisierte Interfaces statt eines großen „Alleskönner“-Interfaces.
// Ausganglage:
interface BadWorker{
    fun work()
    fun eat()
    fun sleep()
}

// Problem: Ein „Roboter“ kann zwar arbeiten, aber nicht essen oder schlafen.
// Die Klasse ist gezwungen, Methoden zu implementieren, die sie nicht braucht.
class Robot : BadWorker {
    override fun work() {
        println("Robot is working")
    }
    override fun eat() {
        // unnötig
        throw UnsupportedOperationException("Roboter können nicht essen")
    }
    override fun sleep() {
        // unnötig
        throw UnsupportedOperationException("Roboter können nicht schlafen")
    }
}

// -------------------------------------------------------------------------------
// Lösung:
interface Workable {
    fun work()
}

interface Eatable {
    fun eat()
}

interface Sleepable {
    fun sleep()
}

class Mensch : Workable, Eatable, Sleepable {
    override fun work() {
        println("Mensch arbeitet")
    }
    override fun eat() {
        println("Mensch isst")
    }
    override fun sleep() {
        println("Mensch schläft")
    }
}

// -------------------------------------------------------------------------------
// Verwendung
class InterfaceSegregationISP {
    fun showPrinciple(){
        // Schlecht
        val robot = Robot()
        robot.work()

        // Gut
        val mensch = Mensch()
        mensch.eat()
        mensch.sleep()
        mensch.work()
    }
}