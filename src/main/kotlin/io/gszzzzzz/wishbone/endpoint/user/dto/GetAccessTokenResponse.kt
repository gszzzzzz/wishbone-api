package io.gszzzzzz.wishbone.endpoint.user.dto

import io.swagger.v3.oas.annotations.media.Schema

data class GetAccessTokenResponse(

    @field:Schema(
        description = "서버 API 인가를 위한 액세스 토큰",
        example = "41bbf070491c4ead935977b4fe8c4431",
    )
    val accessToken: String,
)
