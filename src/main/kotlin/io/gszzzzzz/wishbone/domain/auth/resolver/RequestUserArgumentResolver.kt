package io.gszzzzzz.wishbone.domain.auth.resolver

import io.gszzzzzz.wishbone.domain.auth.annotation.RequestUser
import io.gszzzzzz.wishbone.domain.kakao.service.KakaoTokenService
import io.gszzzzzz.wishbone.domain.user.entity.User
import io.gszzzzzz.wishbone.domain.user.service.UserService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer
import org.springframework.web.util.WebUtils

@Component
class RequestUserArgumentResolver(
    private val kakaoTokenService: KakaoTokenService,
    private val userService: UserService,
) : HandlerMethodArgumentResolver {

    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.getParameterAnnotation(RequestUser::class.java) != null
                && parameter.parameterType == User::class.java
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?,
    ): User {
        val accessTokenCookie = WebUtils.getCookie(webRequest.nativeRequest as HttpServletRequest, "access_token")
            ?: throw IllegalArgumentException("`access_token` 쿠키가 존재하지 않습니다.")

        val kakaoUserIdentity = kakaoTokenService.getUserIdentity(accessTokenCookie.value)
        return userService.findByKakaoId(kakaoUserIdentity.id)
            ?: throw IllegalArgumentException("주어진 정보에 해당하는 사용자를 찾을 수 없습니다. (Kakao ID: ${kakaoUserIdentity.id})")
    }
}
