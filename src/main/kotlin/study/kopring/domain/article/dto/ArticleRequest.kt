package study.kopring.domain.article.dto

data class ArticlePostDto(
    val title: String,
    val content: String
)

data class ArticlePatchDto(
    val title: String,
    val content: String
)