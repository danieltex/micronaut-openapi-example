package com.example

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses

@Controller("/hello")
class HelloWorldController {

    @Post("/greet")
    @Operation(
        summary = "Greet the user",
        description = "Endpoint to greet the user based on the provided name"
    )
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "Successful greeting"),
        ApiResponse(responseCode = "400", description = "Invalid request format")
    )
    fun greet(@Body request: HelloWorldRequest): HelloWorldResponse {
        val greetingMessage = "Hello, ${request.name}!"
        return HelloWorldResponse(greetingMessage)
    }
}

data class HelloWorldRequest(
    @field:Schema(description = "Name to include in the greeting", example = "John")
    val name: String
)

data class HelloWorldResponse(
    @field:Schema(description = "Greeting message")
    val greeting: String
)
