package com.example.kwebkopring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@EnableWebMvc
@SpringBootApplication
class KwebKopringApplication

fun main(args: Array<String>) {
    runApplication<KwebKopringApplication>(*args)
}
