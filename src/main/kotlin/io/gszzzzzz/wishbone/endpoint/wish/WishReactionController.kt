package io.gszzzzzz.wishbone.endpoint.wish

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "WishReactionController", description = "소원 액션 API")
@RestController
@RequestMapping("/api/v1/wish/reaction")
class WishReactionController {

    @Operation(
        summary = "내가 남긴 모든 소원 액션 조회",
        description = "내가 남긴 모든 소원 액션을 조회합니다. 한 페이지 당 10개의 소원 액션을 결과로 제공합니다.",
    )
    @GetMapping
    fun getMyWishReactions() {
        TODO()
    }
}
