package io.gszzzzzz.wishbone.configuration

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfiguration {

    @Bean
    fun swagger() =
        OpenAPI().apply {
            info(
                Info()
                    .title("Wishbone API")
                    .description("Wishbone API")
                    .version("1.0.0")
            )

            servers(
                listOf(
                    Server()
                        .url("/")
                        .description("Default")
                )
            )
        }
}
