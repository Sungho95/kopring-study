package study.kopring.domain.user.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import study.kopring.domain.user.dto.UserResponseDto
import study.kopring.domain.user.repository.UserRepository

@Service
@Transactional(readOnly = true)
class UserReadServiceImpl(

    private val userRepository: UserRepository

) : UserReadService {
    override fun getUser(userId: Long): UserResponseDto {
        val findUser = userRepository.findByIdOrNull(userId) ?: throw RuntimeException("User not found")

        return UserResponseDto.from(findUser)
    }

    override fun getUserList(): List<UserResponseDto> {
        val findAll = userRepository.findAll()

        return findAll.map { UserResponseDto.from(it) }
    }


}