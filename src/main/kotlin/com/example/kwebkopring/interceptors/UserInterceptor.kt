package com.example.kwebkopring.interceptors

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView

@Component
class UserInterceptor : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        // 컨트롤러 실행 전 수 작업
        println("Interceptor preHandle")
        return true
    }
    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any, modelAndView: ModelAndView?) {
        // 컨트롤러 실행 후에 수행할 작업
        println("Interceptor postHandle")
    }
    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, ex: Exception?) {
        // 뷰 렌더링 후에 수행할 작업
        println("Interceptor afterCompletion")
    }
}