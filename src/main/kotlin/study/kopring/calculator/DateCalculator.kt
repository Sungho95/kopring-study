package study.kopring.calculator

import java.time.LocalDate
import java.time.Period


fun ageCalculator(birthDate: LocalDate): Int {
    return Period.between(birthDate, LocalDate.now()).years
}