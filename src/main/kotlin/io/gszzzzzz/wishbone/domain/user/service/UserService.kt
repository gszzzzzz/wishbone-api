package io.gszzzzzz.wishbone.domain.user.service

import io.gszzzzzz.wishbone.domain.user.entity.User
import io.gszzzzzz.wishbone.domain.user.entity.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    fun findByKakaoId(kakaoId: Long): User? {
        return userRepository.findByKakaoId(kakaoId)
    }
}
