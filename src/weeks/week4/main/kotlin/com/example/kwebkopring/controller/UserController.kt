package com.example.kwebkopring.controller

import com.example.kwebkopring.dto.UserDTO
import com.example.kwebkopring.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@Tag(name = "UserController", description = "UserController API")
@RestController
class UserController(val userService:UserService){
    @Operation(summary = "Hello User", description = "Hello User API")
    @GetMapping("/")
    fun hello(): String {
        return "Hello User"
    }

    @GetMapping("/users")
    fun getAllUser(): List<UserDTO> {
        return userService.getAllUser()
    }

    @PostMapping("/signUp")
    fun signUp(user: UserDTO): UserDTO {
        return userService.joinUser(user)
    }
}
