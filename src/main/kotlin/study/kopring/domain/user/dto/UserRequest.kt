package study.kopring.domain.user.dto

import study.kopring.domain.user.entity.User
import study.kopring.domain.user.enums.Gender

data class UserPostDto(
    val email: String,
    val name: String,
    val gender: String
) {
    fun toEntity(): User {
        return User(
            email = email,
            name = name,
            gender = Gender.valueOf(gender)
        )
    }
}

data class UserPatchDto(
    val name: String,
    val gender: String
)