package study.kopring.interfaces.user

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.kopring.domain.user.service.UserDeleteService

@RestController
@RequestMapping("/api/users")
class UserDeleteController(
    private val userDeleteService: UserDeleteService
) {
    @DeleteMapping("/{userId}")
    fun deleteUser(
        @PathVariable userId: Long
    ) : ResponseEntity<*> {
        userDeleteService.deleteUser(userId)

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body("Success")
    }
}