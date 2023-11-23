package study.kopring.domain.article.service

import org.springframework.stereotype.Service
import study.kopring.domain.article.dto.ArticlePatchDto
import study.kopring.domain.article.dto.ArticleResponseDto
import study.kopring.domain.article.repository.ArticleRepository
import study.kopring.domain.user.service.UserCommonService

@Service
class ArticleUpdateServiceImpl(
    private val articleRepository: ArticleRepository,
    private val articleCommonService: ArticleCommonService,
    private val userCommonService: UserCommonService
) : ArticleUpdateService {
    override fun updateArticle(userId: Long, articlePatchDto: ArticlePatchDto): ArticleResponseDto {
        val findUser = userCommonService.findVerifyUser(userId)
        val findArticle = articleCommonService.verifyArticle(articlePatchDto.articleId)

        if (findUser.id == findArticle.user.id) {
            findArticle.update(articlePatchDto.title, articlePatchDto.content)
            val updateArticle = articleRepository.save(findArticle)
            return ArticleResponseDto.from(updateArticle)
        } else {
            throw RuntimeException("Article not found")
        }
    }
}