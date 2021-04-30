package attempt1

import org.nield.kotlinstatistics.standardDeviation
import java.time.LocalDate
import java.time.temporal.ChronoUnit

data class Patient(val firstName: String,
                   val lastName: String,
                   val gender: Gender,
                   val birthday: LocalDate,
                   val whiteBloodCellCount: Int) {

    val age get() =
        ChronoUnit.YEARS.between(birthday, LocalDate.now())
}

val patients = listOf(
        Patient(
                "John",
                "Simone",
                Gender.MALE,
                LocalDate.of(1989, 1, 7),
                4500
        ),
        Patient(
                "Sarah",
                "Marley",
                Gender.FEMALE,
                LocalDate.of(1970, 2, 5),
                6700
        ),
        Patient(
                "Jessica",
                "Arnold",
                Gender.FEMALE,
                LocalDate.of(1980, 3, 9),
                3400
        ),
        Patient(
                "Sam",
                "Beasley",
                Gender.MALE,
                LocalDate.of(1981, 4, 17),
                8800
        ),
        Patient(
                "Dan",
                "Forney",
                Gender.MALE,
                LocalDate.of(1985, 9, 13),
                5400
        ),
        Patient(
                "Lauren",
                "Michaels",
                Gender.FEMALE,
                LocalDate.of(1975, 8, 21),
                5000
        ),
        Patient(
                "Michael",
                "Erlich",
                Gender.MALE,
                LocalDate.of(1985, 12, 17),
                4100
        ),
        Patient(
                "Jason",
                "Miles",
                Gender.MALE,
                LocalDate.of(1991, 11, 1),
                3900
        ),
        Patient(
                "Rebekah",
                "Earley",
                Gender.FEMALE,
                LocalDate.of(1985, 2, 18),
                4600
        ),
        Patient(
                "James",
                "Larson",
                Gender.MALE,
                LocalDate.of(1974, 4, 10),
                5100
        ),
        Patient(
                "Dan",
                "Ulrech",
                Gender.MALE,
                LocalDate.of(1991, 7, 11),
                6000
        ),
        Patient(
                "Heather",
                "Eisner",
                Gender.FEMALE,
                LocalDate.of(1994, 3, 6),
                6000
        ),
        Patient(
                "Jasper",
                "Martin",
                Gender.MALE,
                LocalDate.of(1971, 7, 1),
                6000
        )
)

enum class Gender {
    MALE,
    FEMALE
}

fun main() {
    println("Test the playground")

    val averageWbcc =
            patients.map { it.whiteBloodCellCount }.average()

    val standardDevWbcc = patients.map { it.whiteBloodCellCount }
            .standardDeviation()

    println("Average WBCC: $averageWbcc, Std Dev WBCC: $standardDevWbcc")
}