package io.gszzzzzz.wishbone.domain.wish.service

import io.gszzzzzz.wishbone.domain.wish.entity.Wish
import io.gszzzzzz.wishbone.domain.wish.service.model.AddReactionCommand
import io.gszzzzzz.wishbone.domain.wish.service.model.CreateWishCommand
import org.springframework.stereotype.Service

@Service
class WishService {

    fun getWishByUserId(userId: Long): Wish {
        TODO()
    }

    fun createWish(command: CreateWishCommand): Wish {
        TODO()
    }

    fun addReaction(command: AddReactionCommand): Wish {
        TODO()
    }
}
