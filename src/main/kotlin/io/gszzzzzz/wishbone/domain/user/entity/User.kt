package io.gszzzzzz.wishbone.domain.user.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "user")
class User(

    @Id
    @GeneratedValue
    val id: Long = 0,

    @Column(name = "kakao_id")
    val kakaoId: Long,

    @Column(name = "nickname")
    val nickname: String,

    @Column(name = "reg_ts")
    @CreationTimestamp
    val regTs: LocalDateTime = LocalDateTime.now(),
)
