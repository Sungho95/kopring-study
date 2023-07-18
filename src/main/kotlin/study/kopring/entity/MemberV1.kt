package study.kopring.entity

import jakarta.persistence.*
import study.kopring.calculator.ageCalculator
import java.time.LocalDate
import kotlin.jvm.Transient

@Entity
class MemberV1(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val name: String,

    @Column
    val birthDate: LocalDate,

    @Transient
    var age: Int = ageCalculator(birthDate),

    @Column
    @Enumerated(EnumType.STRING)
    var gender: Gender
) {
    enum class Gender(
        val gender: String
    ) {
        NOT_CHECK("미선택"),
        MAN("남자"),
        WOMAN("여자")
    }
}
