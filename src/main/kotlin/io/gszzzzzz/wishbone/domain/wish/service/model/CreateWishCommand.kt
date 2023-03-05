package io.gszzzzzz.wishbone.domain.wish.service.model

data class CreateWishCommand(
    val userId: Long,
    val title: String,
    val content: String,
)
