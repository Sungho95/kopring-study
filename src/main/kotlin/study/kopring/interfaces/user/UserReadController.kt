package study.kopring.interfaces.user

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.kopring.domain.common.BaseController
import study.kopring.domain.user.service.UserReadService

@RestController
@RequestMapping("/api/users")
class UserReadController(

    private val userReadService: UserReadService

) : BaseController() {

    @GetMapping("/{userId}")
    fun getUser(
        @PathVariable userId: Long
    ) : ResponseEntity<*> {
        val response = userReadService.getUser(userId)

        return ResponseEntity.status(HttpStatus.OK)
            .body(response)
    }

    @GetMapping
    fun getUser() : ResponseEntity<*> {
        val response = userReadService.getUserList()

        return ResponseEntity.status(HttpStatus.OK)
            .body(response)
    }
}