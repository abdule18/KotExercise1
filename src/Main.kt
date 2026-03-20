// Exercise 2: Data class
data class Laptop(val brand: String, val ramGB: Int)

// Exercise 3: Sealed class
sealed class EnrollmentStatus {
    data class Success(val courseCode: String) : EnrollmentStatus()
    data class Error(val message: String) : EnrollmentStatus()
    object Loading : EnrollmentStatus()
}

// Exercise 2: Extension function
fun Int.toLehmanGigabytes(): String {
    return "$this GB (Lehman Standard)"
}

// Exercise 3: Function using when expression
fun printStatus(status: EnrollmentStatus) {
    when (status) {
        is EnrollmentStatus.Success -> println("Enrollment successful for course: ${status.courseCode}")
        is EnrollmentStatus.Error -> println("Enrollment failed: ${status.message}")
        EnrollmentStatus.Loading -> println("Enrollment is loading...")
    }
}

fun main() {
    // Exercise 1: Nullable Student Profile
    val studentName: String = "Abdule"
    val middleName: String? = null

    println("Welcome, $studentName ${middleName ?: "No Middle Name"}!")

    // Exercise 2: Create two laptop instances
    val laptop1 = Laptop("Dell", 16)
    val laptop2 = Laptop("Apple", 8)

    println("${laptop1.brand} has ${laptop1.ramGB.toLehmanGigabytes()}")
    println("${laptop2.brand} has ${laptop2.ramGB.toLehmanGigabytes()}")

    // Exercise 3: Test sealed classes
    val successStatus = EnrollmentStatus.Success("CIS 228")
    val errorStatus = EnrollmentStatus.Error("Course is full")

    printStatus(successStatus)
    printStatus(errorStatus)
    printStatus(EnrollmentStatus.Loading)
}