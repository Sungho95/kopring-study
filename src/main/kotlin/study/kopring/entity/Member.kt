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
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val email: String,

    name: String,

    @Column
    val birthDate: LocalDate,

    gender: Gender

) {

    @Column
    var name = name
        protected set

    @Column
    @Enumerated(EnumType.STRING)
    var gender = Gender.NOT_CHECK
        protected set

    enum class Gender(
        val gender: String
    ) {
        NOT_CHECK("미선택"),
        MAN("남자"),
        WOMAN("여자")
    }
}
