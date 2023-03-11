package io.gszzzzzz.wishbone.domain.kakao.model

import kotlinx.serialization.Serializable

@Serializable
data class JWTHeader(
    val alg: String,
    val typ: String,
    val kid: String,
)
