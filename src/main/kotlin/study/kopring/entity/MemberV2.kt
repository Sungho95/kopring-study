package study.kopring.entity

import jakarta.persistence.*
import study.kopring.calculator.ageCalculator
import java.time.LocalDate
import kotlin.jvm.Transient

@Entity
class MemberV2(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    var name: String,

    @Column
    val birthDate: LocalDate,

    @Transient
    val age: Int? = ageCalculator(birthDate),

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

    fun updateMemberV2(name: String, gender: Gender) {
        this.name = name
        this.gender = gender
    }
}

fun update(name: String, gender: MemberV2.Gender): MemberV2 {
    val memberV2 = MemberV2(
        1,
        "Park",
        LocalDate.of(1995, 8, 8),
        null,
        MemberV2.Gender.MAN
    )

    memberV2.let {
        it.name = name
        it.gender = gender
    }

    return memberV2
}