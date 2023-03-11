package io.gszzzzzz.wishbone.configuration

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(basePackages = ["io.gszzzzzz.wishbone.domain"])
class FeignConfiguration
