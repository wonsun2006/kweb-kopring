package com.example.kwebkopring

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "HelloController", description = "HelloController API")
@RestController
class HelloController {

    @Operation(summary = "Hello World", description = "Hello World API")
    @GetMapping("/")
    fun getUser(): String {
        return "Hello World"
    }
}
