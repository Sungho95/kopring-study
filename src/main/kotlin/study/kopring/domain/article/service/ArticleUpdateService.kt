package study.kopring.domain.article.service

import study.kopring.domain.article.dto.ArticlePatchDto
import study.kopring.domain.article.dto.ArticleResponseDto

interface ArticleUpdateService {

    fun updateArticle(userId: Long, articlePatchDto: ArticlePatchDto): ArticleResponseDto
}