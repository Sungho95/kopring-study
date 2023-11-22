package study.kopring.domain.article.service

import study.kopring.domain.article.entity.Article

interface ArticleCommonService {
    fun verifyArticle(articleId: Long): Article
}