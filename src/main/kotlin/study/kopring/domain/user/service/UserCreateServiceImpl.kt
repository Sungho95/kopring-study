package study.kopring.domain.user.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import study.kopring.domain.user.dto.UserPostDto
import study.kopring.domain.user.dto.UserResponseDto
import study.kopring.domain.user.repository.UserRepository

@Service
@Transactional
class UserCreateServiceImpl(
    private val userRepository: UserRepository

) : UserCreateService {

    override fun createUser(userPostDto: UserPostDto): UserResponseDto {
        val user = userPostDto.toEntity()
        val savedUser = userRepository.save(user)

        return UserResponseDto.from(savedUser)
    }
}