package io.gszzzzzz.wishbone.domain.wish.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "wish_reaction")
class WishReaction(

    @Id
    @GeneratedValue
    val id: Long = 0,

    @Column(name = "wish_id")
    val wishId: Long,

    @Column(name = "user_id")
    val userId: Long,

    @Column(name = "created_at")
    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now(),
)
