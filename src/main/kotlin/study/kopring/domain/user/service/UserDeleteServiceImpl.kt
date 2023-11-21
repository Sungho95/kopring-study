package study.kopring.domain.user.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import study.kopring.domain.user.repository.UserRepository

@Service
@Transactional
class UserDeleteServiceImpl(
    private val userRepository: UserRepository
) : UserDeleteService {

    override fun deleteUser(userId: Long) {
        val findUser = userRepository.findByIdOrNull(userId) ?: throw RuntimeException("User not found")
        userRepository.delete(findUser)
    }
}