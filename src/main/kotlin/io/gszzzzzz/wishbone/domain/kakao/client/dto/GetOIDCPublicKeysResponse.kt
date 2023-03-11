package io.gszzzzzz.wishbone.domain.kakao.client.dto

import io.gszzzzzz.wishbone.domain.kakao.model.OIDCPublicKey

data class GetOIDCPublicKeysResponse(
    val keys: List<OIDCPublicKey>,
)
