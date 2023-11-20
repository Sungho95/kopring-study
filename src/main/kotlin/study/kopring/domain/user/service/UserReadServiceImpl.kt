package study.kopring.domain.user.service

import org.springframework.stereotype.Service
import study.kopring.domain.user.dto.UserResponseDto
import study.kopring.domain.user.repository.UserRepository

@Service
class UserReadServiceImpl(

    private val userRepository: UserRepository

) : UserReadService {
    override fun getUser(userId: Long): UserResponseDto {
        val findUser = userRepository.findById(userId).orElseThrow()

        return UserResponseDto.from(findUser)
    }

    override fun getUserList(): List<UserResponseDto> {
        val findAll = userRepository.findAll()

        return findAll.map { UserResponseDto.from(it) }
    }


}