package com.example.kwebkopring.config

import com.example.kwebkopring.filters.UserFilter
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class FilterConfig : WebMvcConfigurer {

    @Bean
    fun firstFilterRegistarationBean(): FilterRegistrationBean<UserFilter> {
        val registrationBean = FilterRegistrationBean(UserFilter())
        registrationBean.order = 0
        registrationBean.urlPatterns = mutableListOf("/*")
        return registrationBean
    }

//    @Bean
//    fun secondFilterRegistrationBean(): FilterRegistrationBean<ThirdFilter>{
//        val registrationBean = FilterRegistrationBean(ThirdFilter())
//        registrationBean.order = 2
//        registrationBean.urlPatterns = mutableListOf("/*")
//        return registrationBean
//    }
}