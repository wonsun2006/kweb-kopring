package com.example.kwebkopring.entity

import com.example.kwebkopring.dto.SignUpRequest
import com.example.kwebkopring.dto.UserUpdateRequest
import jakarta.persistence.*
import org.springframework.security.crypto.password.PasswordEncoder

@Entity(name="users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userSn: Long? = null,
    val userId: String? = null,
    var password: String? = null,
    var userName: String? = null,
    var role: String? = "USER"
){
    companion object {
        fun from(request: SignUpRequest, encoder: PasswordEncoder) = User(
            userId = request.userId,
            password = encoder.encode(request.password),
            userName = request.userName,
            role = request.role
        )
    }
    fun update(newUser: UserUpdateRequest, encoder: PasswordEncoder) {
        this.password = newUser.newPassword
            ?.takeIf { it.isNotBlank() }
            ?.let { encoder.encode(it) }	// 추가
            ?: this.password
        this.userName = newUser.userName
        this.role = newUser.role
    }
}

