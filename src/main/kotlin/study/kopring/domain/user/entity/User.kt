package study.kopring.domain.user.entity

import jakarta.persistence.*
import study.kopring.domain.article.entity.Article
import study.kopring.domain.common.BaseTimeEntity
import study.kopring.domain.user.enums.Gender

@Entity
class User(
    email: String,
    name: String,
    gender: Gender
) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(nullable = false, unique = true, updatable = false)
    var email = email
        protected set

    @Column(nullable = false)
    var name = name
        protected set

    @Column
    @Enumerated(EnumType.STRING)
    var gender = gender
        protected set

    @OneToMany
    protected val mutableArticles: MutableList<Article> = mutableListOf()
    val articles: List<Article> get() = mutableArticles.toList()

    fun createArticle(article: Article) {
        mutableArticles.add(article)
    }

    fun update(name: String, gender: Gender) {
        this.name = name
        this.gender = gender
    }
}
