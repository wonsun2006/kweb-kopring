package com.example.kwebkopring.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

data class SignInRequest(
    val userId: String,
    val password: String
)

data class SignUpRequest(
    val userId: String,
    val password: String,
    val userName: String,
    val role: String
)

data class UserUpdateRequest(
    val password: String,
    val newPassword: String,
    val userName: String,
    val role: String
)