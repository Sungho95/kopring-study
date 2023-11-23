package study.kopring.domain.article.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import study.kopring.domain.article.dto.ArticleResponseDto
import study.kopring.domain.article.repository.ArticleRepository

@Service
class ArticleReadServiceImpl(
    private val articleRepository: ArticleRepository
) : ArticleReadService {
    override fun getArticle(articleId: Long): ArticleResponseDto {
        val findArticle = articleRepository.findByIdOrNull(articleId)
            ?: throw RuntimeException("Article not found")

        return ArticleResponseDto.from(findArticle)
    }

    override fun getArticleList(): List<ArticleResponseDto> {
        val findArticleList = articleRepository.findAll()

        return findArticleList.map {
            ArticleResponseDto.from(it)
        }
    }
}