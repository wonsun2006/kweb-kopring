package com.example.kwebkopring.repository

import com.example.kwebkopring.entity.UserVO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserVO?, Long?> {}
