package de.phbe.solid

// Ausgangslage: BadUserManager hat zu viele unterschiedliche Aufgaben. User anlegen, speichern in DB und Email senden
// Wenn sich:
// - die Datenbank ändert
// - das E-Mail-System ändert
// - die Benutzerlogik ändert
// …muss dieselbe Klasse angepasst werden.
class BadUserManager {
    fun createUser(name: String, email: String) {
        println("Benutzer erstellt: $name")

        saveToDatabase(name, email)
        sendWelcomeEmail(email)
    }

    private fun saveToDatabase(name: String, email: String) {
        println("Speichere $name in Datenbank")
    }

    private fun sendWelcomeEmail(email: String) {
        println("Sende Willkommen-Mail an $email")
    }
}
// -------------------------------------------------------------------------------
// Lösung:
// Erstelle einen Service und Repository, die jeweils nur eine Verantwortung haben.
class UserService(
    private val userRepository: UserRepository,
    private val emailService: EmailService
) {

    fun createUser(name: String, email: String) {
        println("Benutzer erstellt: $name")

        userRepository.save(name, email)
        emailService.sendWelcomeEmail(email)
    }
}

// Repository hat nur eine Aufgabe, das Speichern des users
class UserRepository {
    fun save(name: String, email: String) {
        println("Speichere $name in Datenbank")
    }
}

// EmailService hat nur eine Aufgabe, das Senden von Emails
class EmailService {
    fun sendWelcomeEmail(email: String) {
        println("Sende Willkommen-Mail an $email")
    }
}

// -------------------------------------------------------------------------------
// Verwendung
class SingleResponsibilitySRP {
    fun showPrinciple(){
        // Schlecht:
        val badUserManager = BadUserManager()
        badUserManager.createUser("Max Mustermann","test@test.de")

        // Gut:
        val repository = UserRepository()
        val emailService = EmailService()

        val userService = UserService(repository, emailService)

        userService.createUser(
            "Max Mustermann",
            "test@test.de"
        )
    }
}