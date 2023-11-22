package study.kopring.domain.user.service

import study.kopring.domain.user.entity.User

interface UserCommonService {

    fun findVerifyUser(userId: Long): User
}