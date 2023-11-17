package study.kopring.interfaces.user

import org.slf4j.Logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.kopring.domain.common.BaseController
import study.kopring.domain.user.dto.UserPostDto
import study.kopring.domain.user.enums.Gender
import study.kopring.domain.user.service.UserCreateService
import study.kopring.utils.logger.logger

@RestController
@RequestMapping("/api/user")
class UserCreateController (
    private val userService: UserCreateService
) : BaseController() {

    @PostMapping
    fun createUser(
        @RequestBody userPostDto: UserPostDto
    ) : ResponseEntity<*> {
        val response = userService.createUser(userPostDto)

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(response)
    }
}