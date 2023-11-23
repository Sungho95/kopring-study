package study.kopring.interfaces.article

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.kopring.domain.article.dto.ArticlePatchDto
import study.kopring.domain.article.service.ArticleUpdateService

@RestController
@RequestMapping("/api/articles")
class ArticleUpdateController(
    private val articleUpdateService: ArticleUpdateService
) {

    @PatchMapping("/{userId}/edit")
    fun updateArticle(
        @PathVariable userId: Long,
        @RequestBody articlePatchDto: ArticlePatchDto
    ): ResponseEntity<*> {
        val response = articleUpdateService.updateArticle(userId, articlePatchDto)

        return ResponseEntity.status(HttpStatus.OK)
            .body(response)
    }
}