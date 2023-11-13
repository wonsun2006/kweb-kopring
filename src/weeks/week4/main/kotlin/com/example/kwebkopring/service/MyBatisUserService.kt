package com.example.kwebkopring.service

import com.example.kwebkopring.dto.UserDTO
import com.example.kwebkopring.entity.User
import com.example.kwebkopring.mapper.UserMapper

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false, timeout = 5)
@Service
class MyBatisUserService(val userMapper: UserMapper) {
    fun toEntity(dto: UserDTO): User {
        return User(userId = dto.userId, password = dto.password, userName = dto.userName, role = dto.role)
    }
    fun toDto(entity: User?): UserDTO {
        return UserDTO(userId = entity?.userId, userName = entity?.userName, role = entity?.role)
    }

    fun getAllUser(): List<UserDTO> {
        return userMapper.getAllUsers()
    }

    fun joinUser(dto: UserDTO): UserDTO {
        val user = toEntity(dto)
        return userMapper.joinUser(user)
    }
}

