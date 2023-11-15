package study.kopring.domain.article.entity

import jakarta.persistence.*
import study.kopring.domain.user.entity.User

@Entity
class Article(
    title: String,
    content: String,
    user: User
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column
    var title = title
        protected set

    @Column
    var content = content
        protected set

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    var user: User = user
        protected set
}