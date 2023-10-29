package com.example.kwebkopring.service

import com.example.kwebkopring.entity.UserVO
import com.example.kwebkopring.repository.UserRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UserService {
    @Autowired
    private lateinit var userRepository: UserRepository

    fun joinUser(vo: UserVO) {
        userRepository.save<UserVO>(vo)
    }
}

