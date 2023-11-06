package com.example.kwebkopring.service

import com.example.kwebkopring.dto.UserDTO
import com.example.kwebkopring.entity.User
import com.example.kwebkopring.repository.UserRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UserService(val userRepository: UserRepository) {
    fun toEntity(dto: UserDTO): User {
        return User(userId = dto.userId, password = dto.password, userName = dto.userName, role = dto.role)
    }
    fun toDto(entity: User): UserDTO {
        return UserDTO(userId = entity.userId, userName = entity.userName, role = entity.role)
    }

    fun joinUser(dto: UserDTO) : UserDTO{
        val user = toEntity(dto)
        val result = userRepository.save<User>(user)
        return toDto(result)
    }
}

