package com.elasticsearch.demo.web.handler

import jakarta.inject.Named
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@Named
class RequestHandler {
    fun suggest(req: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().bodyValue("suggestions api")
    }

    fun stream(req: ServerRequest): Mono<ServerResponse> {
        val dataStream =
            Flux.interval(Duration.ofMillis(500))
                .map { "Event $it" }
        return ServerResponse.ok()
            .contentType(MediaType.TEXT_EVENT_STREAM).body(dataStream, String::class.java)
    }
}