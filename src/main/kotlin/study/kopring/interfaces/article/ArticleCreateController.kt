package study.kopring.interfaces.article

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.kopring.domain.article.dto.ArticlePostDto
import study.kopring.domain.article.service.ArticleCreateService

@RestController
@RequestMapping("/api/articles")
class ArticleCreateController(
    private val articleCreateService: ArticleCreateService
) {

    @PostMapping
    fun createArticle(
        @RequestBody articlePostDto: ArticlePostDto
    ): ResponseEntity<*> {
        val response = articleCreateService.createArticle(articlePostDto)

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(response)
    }
}