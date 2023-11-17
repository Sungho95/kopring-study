package study.kopring

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.kopring.domain.article.entity.Article
import study.kopring.domain.user.entity.User
import study.kopring.domain.user.enums.Gender

class UserTest : StringSpec ({

    lateinit var user: User
    lateinit var article: Article

    beforeTest {
        user = User(
            email = "tjdgh1785@naver.com",
            name = "박성호",
            gender = Gender.MAN
        )

        article = Article(
            title = "제목",
            content = "컨텐츠",
            user = user
        )
    }

    "userCreateArticleTest" {
        val expected = 1
        user.createArticle(article)
        val result = user.articles.size

        result shouldBe expected
    }
})