package study.kopring.domain.article.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import study.kopring.domain.article.entity.Article
import study.kopring.domain.article.repository.ArticleRepository

@Service
class ArticleCommonServiceImpl(
    private val articleRepository: ArticleRepository
) : ArticleCommonService {
    override fun verifyArticle(articleId: Long): Article {
        return articleRepository.findByIdOrNull(articleId) ?: throw RuntimeException("Article not found")
    }
}