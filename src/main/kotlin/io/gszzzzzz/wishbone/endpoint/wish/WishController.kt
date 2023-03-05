package io.gszzzzzz.wishbone.endpoint.wish

import io.gszzzzzz.wishbone.endpoint.wish.dto.GetWishesResponse
import io.gszzzzzz.wishbone.endpoint.wish.dto.WishResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(name = "WishController", description = "소원 API")
@RestController
@RequestMapping("/api/v1/wish")
class WishController {

    @Operation(
        summary = "모든 소원 조회",
        description = "모든 소원을 조회합니다. 한 페이지 당 10개의 소원을 결과로 제공합니다.",
    )
    @GetMapping("/all")
    fun getWishes(): GetWishesResponse {
        TODO()
    }

    @Operation(
        summary = "내 소원 조회",
        description = "내 소원을 조회합니다.",
    )
    @GetMapping
    fun getMyWish(): WishResponse {
        TODO()
    }

    @Operation(
        summary = "내 소원 등록",
        description = "내 소원을 등록합니다.",
    )
    @PostMapping
    fun createMyWish() {
        TODO()
    }

    @Operation(
        summary = "소원에 액션 등록",
        description = "소원에 액션을 등록합니다.",
    )
    @PostMapping("/{wishId}/reaction")
    fun addReaction(
        @PathVariable wishId: Long,
    ) {
        TODO()
    }

    @Operation(
        summary = "소원에 액션 제거",
        description = "소원에 액션을 제거합니다.",
    )
    @DeleteMapping("/{wishId}/reaction")
    fun deleteReaction(
        @PathVariable wishId: Long,
    ) {
        TODO()
    }
}
