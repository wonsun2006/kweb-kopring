package com.example.kwebkopring.filters

import jakarta.servlet.*
import org.springframework.stereotype.Component

@Component
class UserFilter : Filter {
    override fun init(filtercCongig: FilterConfig){
        // 필터 초기 설정
        println("Filter init")
    }
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        // 요청 전 작업
        println("Filter doFilter before request")
        chain?.doFilter(request, response) // 다음 필터로 전달
        // 응답 후 작업
        println("Filter doFilter after response")
    }
    override fun destroy() {
        // 필터 소멸 로직
        println("Filter destroy")
    }
}