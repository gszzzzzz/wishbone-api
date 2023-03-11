package io.gszzzzzz.wishbone.domain.kakao.model

import kotlinx.serialization.Serializable

@Serializable
data class OIDCPublicKey(
    val kid: String,
    val kty: String,
    val alg: String,
    val use: String,
    val n: String,
    val e: String,
)
