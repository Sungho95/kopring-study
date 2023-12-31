package study.kopring.domain.article.repository

import org.springframework.data.jpa.repository.JpaRepository
import study.kopring.domain.article.entity.Article

interface ArticleRepository : JpaRepository<Article, Long> {
}