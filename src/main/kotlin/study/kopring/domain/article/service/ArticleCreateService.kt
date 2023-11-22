package study.kopring.domain.article.service

import study.kopring.domain.article.dto.ArticlePostDto
import study.kopring.domain.article.dto.ArticleResponseDto

interface ArticleCreateService {

    fun createArticle(articlePostDto: ArticlePostDto): ArticleResponseDto
}