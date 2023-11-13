package com.example.kwebkopring.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class UserDTO(
    val userId: String,
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    val password: String,
    val userName: String,
    val role: String
) {
    constructor(userId: String?, userName: String?, role: String?) : this(userId = userId!!, password = "", userName = userName!!, role = role!!)
}