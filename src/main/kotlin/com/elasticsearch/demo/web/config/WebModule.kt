package com.elasticsearch.demo.web.config

import com.elasticsearch.demo.entities.interfaces.WebRouter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration(proxyBeanMethods = false)
@EnableWebFlux
class WebModule {
    @Bean
    fun routers(
        webRouter: WebRouter
    ): RouterFunction<ServerResponse> {
        return webRouter.router()
    }
}