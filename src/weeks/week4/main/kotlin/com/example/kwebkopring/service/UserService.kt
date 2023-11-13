package com.example.kwebkopring.service

import com.example.kwebkopring.dto.UserDTO
import com.example.kwebkopring.entity.User
import com.example.kwebkopring.repository.UserRepository

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class UserService(val userRepository: UserRepository) {
    fun toEntity(dto: UserDTO): User {
        return User(userId = dto.userId, password = dto.password, userName = dto.userName, role = dto.role)
    }
    fun toDto(entity: User?): UserDTO {
        return UserDTO(userId = entity?.userId, userName = entity?.userName, role = entity?.role)
    }

    fun getAllUser(): List<UserDTO> {
        val result = userRepository.findAll()
        return result.map { toDto(it) }
    }

    fun joinUser(dto: UserDTO) : UserDTO{
        val user = toEntity(dto)
        val result = userRepository.save<User>(user)
        return toDto(result)
    }
}

