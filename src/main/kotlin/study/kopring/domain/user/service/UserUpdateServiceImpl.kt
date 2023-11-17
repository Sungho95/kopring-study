package study.kopring.domain.user.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import study.kopring.domain.user.dto.UserPatchDto
import study.kopring.domain.user.dto.UserResponseDto
import study.kopring.domain.user.enums.Gender
import study.kopring.domain.user.repository.UserRepository
import java.lang.RuntimeException

@Service
class UserUpdateServiceImpl(

    private val userRepository: UserRepository

) : UserUpdateService {
    override fun updateUser(
        userId: Long,
        userPatchDto: UserPatchDto
    ): UserResponseDto {
        val findUser = userRepository.findByIdOrNull(userId) ?: throw RuntimeException("member not found")

        val newName = userPatchDto.name
        val newGender = Gender.valueOf(userPatchDto.gender)
        findUser.update(newName, newGender)

        return UserResponseDto.from(userRepository.save(findUser))
    }
}