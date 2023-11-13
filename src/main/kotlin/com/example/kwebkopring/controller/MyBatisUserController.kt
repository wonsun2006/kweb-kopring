package com.example.kwebkopring.controller

import com.example.kwebkopring.dto.UserDTO
import com.example.kwebkopring.service.MyBatisUserService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mybatis")
class MyBatisUserController(val userService: MyBatisUserService){
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
