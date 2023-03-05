package io.gszzzzzz.wishbone.domain.wish.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "wish")
class Wish(

    @Id
    @GeneratedValue
    val id: Long = 0,

    @Column(name = "owner_user_id")
    val ownerUserId: Long,

    @Column(name = "title")
    val title: String,

    @Column(name = "content")
    val content: String,

    @Column(name = "created_at")
    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    @UpdateTimestamp
    val updatedAt: LocalDateTime = LocalDateTime.now(),
)
