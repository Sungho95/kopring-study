package study.kopring.domain.user.service

import study.kopring.domain.user.dto.UserPatchDto
import study.kopring.domain.user.dto.UserResponseDto

interface UserUpdateService {

    fun updateUser(userId: Long, userPatchDto: UserPatchDto): UserResponseDto

}