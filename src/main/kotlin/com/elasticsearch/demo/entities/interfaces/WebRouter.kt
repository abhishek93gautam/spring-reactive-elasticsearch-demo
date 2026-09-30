package com.elasticsearch.demo.entities.interfaces

import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse

interface WebRouter {
    fun router(): RouterFunction<ServerResponse>
}