package com.example.kwebkopring.entity

import jakarta.persistence.*

@Entity
class UserVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var userSn: Long? = null
    var userId: String? = null
    var password: String? = null
    var userName: String? = null
    var role: String? = null
}

