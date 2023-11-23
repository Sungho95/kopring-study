package study.kopring.interfaces.article

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.kopring.domain.article.service.ArticleDeleteService
import study.kopring.domain.common.BaseController

@RestController
@RequestMapping("/api/articles")
class ArticleDeleteController(
    private val articleDeleteService: ArticleDeleteService
) : BaseController() {

    @DeleteMapping("/{userId}/{articleId}")
    fun deleteArticle(
        @PathVariable userId: Long,
        @PathVariable articleId: Long
    ): ResponseEntity<*> {
        articleDeleteService.deleteArticle(userId, articleId)

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body("Success")
    }
}