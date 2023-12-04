package com.example.kwebkopring.service

import com.example.kwebkopring.dto.*
import com.example.kwebkopring.entity.User
import com.example.kwebkopring.repository.UserRepository
import com.example.kwebkopring.security.TokenProvider
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.security.crypto.password.PasswordEncoder

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class UserService(val userRepository: UserRepository,
                  val tokenProvider: TokenProvider,
                  val encoder: PasswordEncoder,
) {
    fun getAllUser(): List<SignInResponse> {
        val result = userRepository.findAll()
        return result.map {
            val token:String? = if(it?.userId != null || it?.role != null) {
                tokenProvider.createToken("${it.userId}:${it.role}")
            }else{
                null
            }
            SignInResponse(userName = it?.userName, role = it?.role, token = token)
        }
    }

    @Transactional
    fun registerUser(request: SignUpRequest) = SignUpResponse.from(
        userRepository.save(User.from(request, encoder))
    )

    @Transactional
    fun signIn(request: SignInRequest): SignInResponse {
        val user = userRepository.findByUserId(request.userId)
            ?.takeIf { encoder.matches(request.password, it.password) }	// 암호화된 비밀번호와 비교하도록 수정
            ?: throw IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.")
        val token = tokenProvider.createToken("${user.userId}:${user.role}")
        return SignInResponse(user.userName, user.role, token)
    }

    @Transactional
    fun updateUser(id: String, request: UserUpdateRequest): UserUpdateResponse {
        val user = userRepository.findByUserId(id)?.takeIf { encoder.matches(request.password, it.password) }	// 암호화된 비밀번호와 비교하도록 수정
            ?: throw IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.")
        user.update(request, encoder)	// 새 비밀번호를 암호화하도록 수정
        return UserUpdateResponse.of(true, user)
    }
}

