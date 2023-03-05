package io.gszzzzzz.wishbone.endpoint.wish.dto

import io.swagger.v3.oas.annotations.media.Schema

data class WishResponse(

    @field:Schema(description = "소원 ID", example = "1")
    val id: Long,

    @field:Schema(description = "소원 생성자 ID", example = "1")
    val ownerUserId: Long,

    @field:Schema(description = "소원 제목", example = "로또 1등 당첨")
    val title: String,

    @field:Schema(description = "소원 내용", example = "로또 1등 당첨")
    val content: String,

    @field:Schema(description = "소원 등록 Timestamp (기준단위: 초)", example = "1678020789")
    val createdAt: Long,
)
