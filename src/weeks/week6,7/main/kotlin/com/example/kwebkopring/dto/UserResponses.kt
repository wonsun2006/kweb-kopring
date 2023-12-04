package com.example.kwebkopring.dto

import com.example.kwebkopring.entity.User
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime
import java.util.*

data class SignUpResponse(
    val userSn: Long? = null,
    val userId: String? = null,
    var userName: String? = null,
    var role: String? = null
) {
    companion object {
        fun from(user: User) = SignUpResponse(
            userSn = user.userSn!!,
            userId = user.userId,
            userName = user.userName,
            role = user.role
        )
    }
}

data class SignInResponse(
    val userName: String?,
    val role: String?,
    val token: String?
)

data class UserUpdateResponse(
    val result: Boolean,
    val userName: String?,
    val role: String?
) {
    companion object {
        fun of(result: Boolean, user: User) = UserUpdateResponse(
            result = result,
            userName = user.userName,
            role = user.role
        )
    }
}

data class UserInfoResponse(
    val userSn: Long?,
    val userId: String,
    val userName: String?,
    val role: String?,
) {
    companion object {
        fun from(user: User) = UserInfoResponse(
            userSn = user.userSn!!,
            userId = user.userId!!,
            userName = user.userName,
            role = user.role
        )
    }
}

data class UserDeleteResponse(
    val result: Boolean
)