package com.example.kwebkopring.config

import com.example.kwebkopring.interceptors.UserInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class InterceptorConfig : WebMvcConfigurer {
    override fun addInterceptors(interceptorRegistry: InterceptorRegistry) {
        interceptorRegistry.addInterceptor(UserInterceptor())
            .addPathPatterns("/**").order(1)
    }
}