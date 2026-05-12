package de.phbe.solid

// High-Level-Module sollen nicht von Low-Level-Modulen abhängen. Beide sollen von Abstraktionen abhängen.
// Ausgangslage: Die High-Level-Klasse hängt direkt von einer konkreten Implementierung ab
class MySqlDatabase {
    fun save(data: String){
        println("Speichere '$data' in MySQL")
    }
}

// Direkte Abhängigkeit, MySQL ist fest an den Service gekoppelt, ein Wechsel zu Postgres ist nicht einfach
class UserDIPService {
    private val database = MySqlDatabase() // direkte Abhängigkeit

    fun createUser(name: String) {
        database.save(name)
    }
}

// -------------------------------------------------------------------------------
// Lösung:
interface Database {
    fun save(data: String)
}
class GoodMySqlDatabase : Database {
    override fun save(data: String) {
        println("Speichere '$data' in MySQL")
    }
}
class PostgresDatabase : Database {
    override fun save(data: String) {
        println("Speichere '$data' in PostgreSQL")
    }
}
class GoodUserDIPService(private val database: Database) {
    fun createUser(name: String) {
        database.save(name)
    }
}

// -------------------------------------------------------------------------------
// Verwendung
class DependencyInversionDIP {
    fun showPrinciple(){
        // Schlecht
        val userDIPService = UserDIPService()
        userDIPService.createUser("Alice")

        // Gut
        val postgresDatabase = PostgresDatabase()
        val goodMySqlDatabase = GoodUserDIPService(postgresDatabase)
        goodMySqlDatabase.createUser("Alice")
    }
}