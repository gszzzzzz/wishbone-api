package io.gszzzzzz.wishbone.domain.kakao.service

import io.gszzzzzz.wishbone.domain.kakao.client.KakaoFeignClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*

@Service
class KakaoService(
    private val kakaoFeignClient: KakaoFeignClient,
    @Value("\${kakao.client-id}") private val kakaoClientId: String,
    @Value("\${kakao.redirect-uri}") private val kakaoRedirectUri: String,
) {

    fun getAccessToken(authorizationCode: String): String {
        val response = kakaoFeignClient.getAccessToken(
            grantType = "authorization_code",
            clientId = kakaoClientId,
            redirectUri = kakaoRedirectUri,
            code = authorizationCode,
        )
        return response.accessToken
    }
}
