package io.gszzzzzz.wishbone.endpoint.wish.dto

import io.swagger.v3.oas.annotations.media.Schema

data class GetWishesResponse(

    @field:Schema(description = "전체 소원 개수", example = "100")
    val totalCount: Int,

    @field:Schema(description = "현재 페이지", example = "1")
    val currentPage: Int,

    @field:Schema(description = "마지막 페이지", example = "10")
    val lastPage: Int,

    @field:Schema(description = "소원 목록")
    val items: List<WishResponse>,
)
