package study.kopring.entity

import jakarta.persistence.*
import study.kopring.calculator.ageCalculator
import java.time.LocalDate
import kotlin.jvm.Transient

@Entity
class MemberV3(
    name: String,
    birthDate: LocalDate,
    gender: Gender
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column
    var name: String = name
        protected set

    @Column
    var birthDate: LocalDate = birthDate
        protected set

    @Transient
    val age: Int? = ageCalculator(birthDate)

    @Column
    @Enumerated(EnumType.STRING)
    var gender: Gender = gender
        protected set

    enum class Gender(
        val gender: String
    ) {
        NOT_CHECK("미선택"),
        MAN("남자"),
        WOMAN("여자")
    }

    fun updateMemberV3(name: String, gender: Gender) {
        this.name = name
        this.gender = gender
    }
}

fun main() {
    val memberV3 = MemberV3("park", LocalDate.of(1995, 8, 8), MemberV3.Gender.MAN)

    memberV3.updateMemberV3("Kim", MemberV3.Gender.WOMAN)
}