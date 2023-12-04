package com.example.kwebkopring.controller

import com.example.kwebkopring.dto.SignInRequest
import com.example.kwebkopring.dto.SignInResponse
import com.example.kwebkopring.dto.SignUpRequest
import com.example.kwebkopring.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*


@Tag(name = "UserController", description = "UserController API")
@RestController
class UserController(val userService:UserService){
    @Operation(summary = "Hello User", description = "Hello User API")
    @GetMapping("/")
    fun hello(): String {
        return "Hello User"
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/users")
    fun getAllUser(): List<SignInResponse> {
        return userService.getAllUser()
    }

    @PostMapping("/signUp")
    fun signUp(request: SignUpRequest) = userService.registerUser(request)

    @Operation(summary = "로그인")
    @PostMapping("/signIn")
    fun signIn(request: SignInRequest) = userService.signIn(request)
}
