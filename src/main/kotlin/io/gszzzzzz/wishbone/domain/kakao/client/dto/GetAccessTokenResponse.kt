package io.gszzzzzz.wishbone.domain.kakao.client.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class GetAccessTokenResponse(
    @JsonProperty("id_token") val accessToken: String,

    // NOTE: Below fields are not used, as we are using OIDC for authentication.
    // @JsonProperty("access_token") val accessToken: String,
    // @JsonProperty("expires_in") val accessTokenExpiresIn: Long,
    // @JsonProperty("refresh_token") val refreshToken: String,
    // @JsonProperty("refresh_token_expires_in") val refreshTokenExpiresIn: Long,
)
