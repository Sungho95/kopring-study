package study.kopring.domain.common

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseTimeEntity {

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.MIN
        protected set

//    @CreatedBy
//    @Column(nullable = false, updatable = false)
//    lateinit var createdBy: String

    @LastModifiedDate
    @Column(nullable = false)
    var lastModifiedAt: LocalDateTime = LocalDateTime.MIN
        protected set

//    @LastModifiedBy
//    @Column(nullable = false)
//    lateinit var modifiedBy: Stringe
}