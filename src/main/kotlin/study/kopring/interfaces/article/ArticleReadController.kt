package study.kopring.interfaces.article

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.kopring.domain.article.service.ArticleReadService

@RestController
@RequestMapping("/api/articles")
class ArticleReadController(
    private val articleReadService: ArticleReadService
) {

    @GetMapping("/{articleId}")
    fun getArticle(
        @PathVariable articleId: Long
    ): ResponseEntity<*> {
        val response = articleReadService.getArticle(articleId)

        return ResponseEntity.status(HttpStatus.OK)
            .body(response)
    }

    @GetMapping("/{articleId}")
    fun getArticleList(): ResponseEntity<*> {
        val response = articleReadService.getArticleList()

        return ResponseEntity.status(HttpStatus.OK)
            .body(response)
    }
}