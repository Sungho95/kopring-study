package study.kopring.domain.user.service

import study.kopring.domain.user.dto.UserPostDto
import study.kopring.domain.user.dto.UserResponseDto

interface UserCreateService {

    fun createUser(userPostDto: UserPostDto): UserResponseDto

}