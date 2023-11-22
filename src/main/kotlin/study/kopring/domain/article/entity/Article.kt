package study.kopring.domain.article.entity

import jakarta.persistence.*
import study.kopring.domain.common.BaseTimeEntity
import study.kopring.domain.user.entity.User
import study.kopring.domain.user.enums.Gender

@Entity
class Article(
    title: String,
    content: String,
) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column
    var title = title
        protected set

    @Column
    var content = content
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    var user: User = User("default", "default", Gender.SECRET)
        protected set

    fun assignUser(user: User) {
        this.user = user
    }

    fun update(title: String, content: String) {
        this.title = title
        this.content = content
    }
}