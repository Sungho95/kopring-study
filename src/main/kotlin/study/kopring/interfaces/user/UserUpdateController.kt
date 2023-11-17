package study.kopring.interfaces.user

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.kopring.domain.user.dto.UserPatchDto
import study.kopring.domain.user.service.UserUpdateService

@RestController
@RequestMapping("/api/users")
class UserUpdateController(
    private val userUpdateService: UserUpdateService
) {

    @PatchMapping("/{userId}")
    fun updateUser(
        @PathVariable userId: Long,
        @RequestBody userPatchDto: UserPatchDto
    ): ResponseEntity<*> {
        val response = userUpdateService.updateUser(userId, userPatchDto)

        return ResponseEntity.status(HttpStatus.OK)
            .body(response)
    }
}