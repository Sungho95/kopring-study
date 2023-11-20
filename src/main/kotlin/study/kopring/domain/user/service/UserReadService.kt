package study.kopring.domain.user.service

import study.kopring.domain.user.dto.UserResponseDto

interface UserReadService {

    fun getUser(userId: Long): UserResponseDto

    fun getUserList(): List<UserResponseDto>
}