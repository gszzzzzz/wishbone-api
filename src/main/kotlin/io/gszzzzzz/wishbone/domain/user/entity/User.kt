package io.gszzzzzz.wishbone.domain.user.entity

import jakarta.persistence.*

@Entity
@Table(name = "user")
class User(

    @Id
    @GeneratedValue
    val id: Long = 0,

    @Column(name = "kakao_id")
    val kakaoId: String,

    @Column(name = "nickname")
    val nickname: String,
)
