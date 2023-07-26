package study.kopring.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
class MemberV4(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    var email: String = "",

    @Column
    var name: String = "name",

    @Column
    var birthDate: LocalDate = LocalDate.now(),

    @Column
    @Enumerated(EnumType.STRING)
    var gender: Gender = Gender.NOT_CHECK
) {

    enum class Gender(
        val gender: String
    ) {
        NOT_CHECK("미선택"),
        MAN("남자"),
        WOMAN("여자")
    }
}
