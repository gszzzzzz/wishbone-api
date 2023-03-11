package io.gszzzzzz.wishbone.configuration

import io.gszzzzzz.wishbone.domain.auth.resolver.RequestUserArgumentResolver
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfiguration(
    // For some reason, injecting this resolver without `@Lazy` causes a circular dependency error.
    // As a workaround, we use `@Lazy` here to avoid the error.
    @Lazy private val requestUserArgumentResolver: RequestUserArgumentResolver,
) : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry
            .addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("*")
            .maxAge(3600)
    }

    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
        resolvers.add(requestUserArgumentResolver)
    }
}
