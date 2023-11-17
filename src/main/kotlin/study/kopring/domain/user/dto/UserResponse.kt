package study.kopring.domain.user.dto

import study.kopring.domain.user.entity.User

data class UserResponseDto(
    val id: Long,
    val email: String,
    val name: String,
    val gender: String
) {
    companion object {
        fun from(user: User): UserResponseDto {
            return UserResponseDto(
                id = user.id!!,
                email = user.email,
                name = user.name,
                gender = user.gender.value
            )
        }
    }
}