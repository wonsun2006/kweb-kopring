package com.example.kwebkopring

import com.example.kwebkopring.entity.User
import com.example.kwebkopring.repository.UserRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class AdminInitializer(
    private val userRepository: UserRepository,
    private val encoder: PasswordEncoder
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        userRepository.save(User(userId="admin", password=encoder.encode("admin"), role="ADMIN"))
    }
}