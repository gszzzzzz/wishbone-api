package io.gszzzzzz.wishbone.domain.kakao.model

import kotlinx.serialization.Serializable

@Serializable
data class JWTPayload(
    val iss: String,
    val aud: String,
    val sub: String,
    val exp: Long,
    val iat: Long,
)
