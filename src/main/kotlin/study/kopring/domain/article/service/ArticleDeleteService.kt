package study.kopring.domain.article.service

interface ArticleDeleteService {

    fun deleteArticle(userId: Long, articleId: Long)
}