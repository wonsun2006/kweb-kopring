package com.example.kwebkopring

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@EnableWebMvc
@SpringBootApplication
// MyBatis Mapper Scan
@MapperScan("com.example.kwebkopring.mapper")
class KwebKopringApplication

fun main(args: Array<String>) {
    runApplication<KwebKopringApplication>(*args)
}
