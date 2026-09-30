package com.elasticsearch.demo.web.router

import com.elasticsearch.demo.entities.interfaces.WebRouter
import com.elasticsearch.demo.web.handler.RequestHandler
import jakarta.inject.Named
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse

@Named
class HttpRouter(
    private val requestHandler: RequestHandler
) : WebRouter {
    override fun router(): RouterFunction<ServerResponse> {
        return org.springframework.web.reactive.function.server.router {
            "/api".nest {
                "/suggestions".nest {
                    GET("", requestHandler::suggest)
                }
                "/stream".nest {
                    GET("", requestHandler::stream)
                }
            }
        }
    }
}