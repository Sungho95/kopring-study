package study.kopring.domain.user.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import study.kopring.domain.user.entity.User
import study.kopring.domain.user.repository.UserRepository

@Service
class UserCommonServiceImpl(
    private val userRepository: UserRepository
) : UserCommonService {

    override fun findVerifyUser(userId: Long): User {
        return userRepository.findByIdOrNull(userId) ?: throw RuntimeException("User not found")
    }
}