package com.example.kwebkopring.mapper

import com.example.kwebkopring.dto.UserDTO
import com.example.kwebkopring.entity.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper {
    fun getAllUsers(): List<UserDTO>
    fun joinUser(user: User): UserDTO
}