package study.kopring.domain.article.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import study.kopring.domain.article.dto.ArticlePostDto
import study.kopring.domain.article.dto.ArticleResponseDto
import study.kopring.domain.article.repository.ArticleRepository
import study.kopring.domain.user.service.UserCommonService

@Service
@Transactional
class ArticleCreateServiceImpl(
    private val articleRepository: ArticleRepository,
    private val userCommonService: UserCommonService
) : ArticleCreateService {
    override fun createArticle(articlePostDto: ArticlePostDto): ArticleResponseDto {
        val findUser = userCommonService.findVerifyUser(articlePostDto.userId)
        val article = articlePostDto.toEntity()
        findUser.addArticle(article)
        val savedArticle = articleRepository.save(article)

        return ArticleResponseDto.from(savedArticle)
    }
}