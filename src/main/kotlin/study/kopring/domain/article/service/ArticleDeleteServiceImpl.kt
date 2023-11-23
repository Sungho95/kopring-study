package study.kopring.domain.article.service

import org.springframework.stereotype.Service
import study.kopring.domain.article.repository.ArticleRepository
import study.kopring.domain.user.service.UserCommonService

@Service
class ArticleDeleteServiceImpl(
    private val articleRepository: ArticleRepository,
    private val articleCommonService: ArticleCommonService,
    private val userCommonService: UserCommonService
) : ArticleDeleteService {

    override fun deleteArticle(userId: Long, articleId: Long) {
        val findUser = userCommonService.findVerifyUser(userId)
        val findArticle = articleCommonService.verifyArticle(articleId)

        if (findUser.id == findArticle.user.id) {
            articleRepository.delete(findArticle)
        } else {
            throw RuntimeException("Article not found")
        }
    }
}