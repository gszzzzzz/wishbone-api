package io.gszzzzzz.wishbone.domain.wish.service.model

data class AddReactionCommand(
    val wishId: Long,
    val userId: Long,
)
