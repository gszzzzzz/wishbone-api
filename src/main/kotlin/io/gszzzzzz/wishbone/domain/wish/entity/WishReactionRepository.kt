package io.gszzzzzz.wishbone.domain.wish.entity

import org.springframework.data.jpa.repository.JpaRepository

interface WishReactionRepository : JpaRepository<WishReaction, Long>
