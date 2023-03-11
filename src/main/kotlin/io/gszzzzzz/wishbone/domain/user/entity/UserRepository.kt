package io.gszzzzzz.wishbone.domain.user.entity

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByKakaoId(kakaoId: Long): User?
}
