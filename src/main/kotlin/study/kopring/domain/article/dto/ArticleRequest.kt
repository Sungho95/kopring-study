package study.kopring.domain.article.dto

import study.kopring.domain.article.entity.Article

data class ArticlePostDto(
    val userId: Long,
    val title: String,
    val content: String
) {
    fun toEntity(): Article {
        return Article(
            title = title,
            content = content
        )
    }
}

data class ArticlePatchDto(
    val articleId: Long,
    val title: String,
    val content: String
)