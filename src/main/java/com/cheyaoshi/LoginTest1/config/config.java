package com.cheyaoshi.LoginTest1.config;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
public class config implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 添加映射路径
        registry.addMapping("/**")
                .allowedOrigins("*") ;// 允许哪些域的请求
//                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE") // 允许的方法
//                .allowedHeaders("*") // 允许的头部设置
//                .allowCredentials(true) // 是否发送cookie
//                .maxAge(168000); // 预检间隔时间
    }
}
