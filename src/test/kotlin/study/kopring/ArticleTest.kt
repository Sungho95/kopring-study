package study.kopring

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldNotBe
import study.kopring.domain.article.dto.ArticlePatchDto
import study.kopring.domain.article.entity.Article
import study.kopring.domain.user.entity.User
import study.kopring.domain.user.enums.Gender

class ArticleTest : StringSpec({

    lateinit var article: Article
    lateinit var articlePatch: ArticlePatchDto

    beforeTest {
        article = Article(
            title = "제목",
            content = "본문",
            user = User(
                email = "tjdgh1785@naver.com",
                name = "박성호",
                gender = Gender.MAN
            )
        )

        articlePatch = ArticlePatchDto(
            title = "제목 수정",
            content = "본문 수정"
        )
    }

    "articleUpdateTitleTest" {
        val before = article.title
        article.update(articlePatch)
        val after = article.title

        before shouldNotBe after
    }

    "articleUpdateContentTest" {
        val before = article.content
        article.update(articlePatch)
        val after = article.content

        before shouldNotBe after
    }
})