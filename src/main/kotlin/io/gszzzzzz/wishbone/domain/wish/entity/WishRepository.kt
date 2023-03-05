package io.gszzzzzz.wishbone.domain.wish.entity

import org.springframework.data.jpa.repository.JpaRepository

interface WishRepository : JpaRepository<Wish, Long>
