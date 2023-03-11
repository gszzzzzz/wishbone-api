package io.gszzzzzz.wishbone.endpoint.user

import io.gszzzzzz.wishbone.domain.kakao.service.KakaoService
import io.gszzzzzz.wishbone.endpoint.user.dto.GetAccessTokenResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "UserController", description = "사용자 API")
@RestController
@RequestMapping("/api/v1/user")
class UserController(
    private val kakaoService: KakaoService,
) {

    @Operation(
        summary = "액세스 토큰 조회",
        description = "액세스 토큰을 조회합니다. 카카오 로그인 인가 코드가 필요합니다.",
    )
    @GetMapping("/access-token")
    fun getAccessToken(
        @Parameter(
            name = "X-Kakao-Auth-Code",
            description = "카카오 로그인 인가 코드",
            required = true,
        )
        @RequestHeader("X-Kakao-Auth-Code") authorizationCode: String,
        response: HttpServletResponse,
    ): GetAccessTokenResponse {
        val accessToken = kakaoService.getAccessToken(authorizationCode)
        val accessTokenCookie =
            Cookie("access_token", accessToken).apply {
                path = "/"
                maxAge = 60 * 60 * 6
                secure = true
                isHttpOnly = true
            }

        response.addCookie(accessTokenCookie)
        return GetAccessTokenResponse(
            accessToken = accessToken,
        )
    }
}
