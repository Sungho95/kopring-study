package study.kopring.domain.user.dto

import study.kopring.domain.user.entity.User
import java.time.LocalDateTime

data class UserResponseDto(
    val id: Long,
    val email: String,
    val name: String,
    val gender: String,
    val createdAt: LocalDateTime,
    val lastModifiedAt: LocalDateTime
) {
    companion object {
        fun from(user: User): UserResponseDto {
            return UserResponseDto(
                id = user.id!!,
                email = user.email,
                name = user.name,
                gender = user.gender.value,
                createdAt = user.createdAt,
                lastModifiedAt = user.lastModifiedAt
            )
        }
    }
}