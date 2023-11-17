package study.kopring.domain.user.repository

import org.springframework.data.jpa.repository.JpaRepository
import study.kopring.domain.user.entity.User

interface UserRepository : JpaRepository<User, Long> {

    fun findByEmail(email: String): User
}