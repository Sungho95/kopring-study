package study.kopring.domain.article.dto

import study.kopring.domain.article.entity.Article
import java.time.LocalDateTime

data class ArticleResponseDto(
    val userId: Long,
    val userName: String,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime,
    val lastModifiedAt: LocalDateTime
) {
    companion object {
        fun from(article: Article): ArticleResponseDto {
            return ArticleResponseDto(
                userId = article.user.id!!,
                userName = article.user.name,
                title = article.title,
                content = article.content,
                createdAt = article.createdAt,
                lastModifiedAt = article.lastModifiedAt
            )
        }
    }
}