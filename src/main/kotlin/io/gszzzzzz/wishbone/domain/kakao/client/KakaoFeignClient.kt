package io.gszzzzzz.wishbone.domain.kakao.client

import io.gszzzzzz.wishbone.domain.kakao.client.dto.GetAccessTokenResponse
import io.gszzzzzz.wishbone.domain.kakao.client.dto.GetOIDCPublicKeysResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "kakao", url = "https://kauth.kakao.com")
interface KakaoFeignClient {

    @PostMapping(
        value = ["/oauth/token"],
        consumes = ["application/x-www-form-urlencoded"],
    )
    fun getAccessToken(
        @RequestParam("grant_type") grantType: String,
        @RequestParam("client_id") clientId: String,
        @RequestParam("redirect_uri") redirectUri: String,
        @RequestParam("code") code: String,
    ): GetAccessTokenResponse

    @GetMapping("/.well-known/jwks.json")
    fun getOIDCPublicKeys(): GetOIDCPublicKeysResponse
}
