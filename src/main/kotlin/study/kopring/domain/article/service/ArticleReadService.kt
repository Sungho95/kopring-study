package study.kopring.domain.article.service

import study.kopring.domain.article.dto.ArticleResponseDto

interface ArticleReadService {

    fun getArticle(articleId: Long): ArticleResponseDto

    fun getArticleList(): List<ArticleResponseDto>
}