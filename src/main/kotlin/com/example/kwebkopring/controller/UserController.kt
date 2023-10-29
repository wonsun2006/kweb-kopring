package com.example.kwebkopring.controller

import com.example.kwebkopring.entity.UserVO
import com.example.kwebkopring.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@Tag(name = "UserController", description = "UserController API")
@RestController
class UserController {
    @Autowired
    private lateinit var userService: UserService

    @Operation(summary = "Hello User", description = "Hello User API")
    @GetMapping("/")
    fun getUser(): String {
        return "Hello User"
    }

    @PostMapping("/signUp")
    fun signUp(vo: UserVO): String {
        userService.joinUser(vo)
        return "index"
    }
}
