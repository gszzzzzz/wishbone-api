package io.gszzzzzz.wishbone.domain.kakao.service

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import io.gszzzzzz.wishbone.domain.kakao.client.KakaoFeignClient
import io.gszzzzzz.wishbone.domain.kakao.model.JWTHeader
import io.gszzzzzz.wishbone.domain.kakao.model.JWTPayload
import io.gszzzzzz.wishbone.domain.kakao.model.KakaoUserIdentity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.math.BigInteger
import java.security.KeyFactory
import java.security.interfaces.RSAPublicKey
import java.security.spec.RSAPublicKeySpec
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

@Service
class KakaoTokenService(
    private val kakaoFeignClient: KakaoFeignClient,
    @Value("\${kakao.client-id}") private val kakaoClientId: String,
) {

    private val jsonSerializer = Json { ignoreUnknownKeys = true }
    private val jwtIssuer = "https://kauth.kakao.com"

    fun getUserIdentity(token: String): KakaoUserIdentity {
        val decodedToken = decodeToken(token)
        val userId = decodedToken.subject.toLongOrNull()
            ?: throw IllegalArgumentException("JWT 토큰 검증 오류: `sub` 값이 올바르지 않습니다. (given: ${decodedToken.subject})")

        return KakaoUserIdentity(
            id = userId,
        )
    }

    private fun decodeToken(token: String): DecodedJWT {
        val (encodedHeader, encodedPayload, _) = token.split(".")

        val decodedPayload = encodedPayload.decodeBase64To<JWTPayload>()
        val decodedHeader = encodedHeader.decodeBase64To<JWTHeader>()

        if (decodedPayload.iss != jwtIssuer) {
            throw RuntimeException("JWT 토큰 검증 오류: `iss` 값이 올바르지 않습니다. (given: ${decodedPayload.iss})")
        }

        if (decodedPayload.aud != kakaoClientId) {
            throw RuntimeException("JWT 토큰 검증 오류: `aud` 값이 올바르지 않습니다. (given: ${decodedPayload.aud})")
        }

        val currentTimestamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)
        if (decodedPayload.exp >= currentTimestamp) {
            throw RuntimeException("JWT 토큰 검증 오류: `exp` 값이 올바르지 않습니다. (given: ${decodedPayload.exp})")
        }

        val publicKeys = kakaoFeignClient.getOIDCPublicKeys().keys
        val targetPublicKey = try {
            publicKeys.first { it.kid == decodedHeader.kid }
        } catch (e: NoSuchElementException) {
            throw RuntimeException("JWT 서명 검증 오류: `kid` 값이 올바르지 않습니다. (given: ${decodedHeader.kid}")
        }

        val publicKey = try {
            val modulus = BigInteger(1, Base64.getUrlDecoder().decode(targetPublicKey.n))
            val exponent = BigInteger(1, Base64.getUrlDecoder().decode(targetPublicKey.e))
            val keyFactory = KeyFactory.getInstance("RSA")
            val publicKeySpec = RSAPublicKeySpec(modulus, exponent)
            keyFactory.generatePublic(publicKeySpec) as RSAPublicKey
        } catch (e: Exception) {
            throw RuntimeException("JWT 서명 검증 오류: 공개키 생성 중 오류가 발생했습니다.", e)
        }

        val algorithm = Algorithm.RSA256(publicKey)
        val verifier = JWT.require(algorithm).withIssuer(jwtIssuer).build()

        return try {
            verifier.verify(token)
        } catch (e: Exception) {
            throw RuntimeException("JWT 서명 검증 오류: 서명 검증에 실패했습니다.", e)
        }
    }

    private inline fun <reified T> String.decodeBase64To(): T {
        val decodedJson = Base64.getDecoder().decode(this).toString(Charsets.UTF_8)
        return jsonSerializer.decodeFromString(decodedJson)
    }
}
