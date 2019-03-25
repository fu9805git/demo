package com.example.demo;

import com.example.demo.interceptors.MybatisInterceptor;
import com.example.demo.interceptors.SessionInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 类说明: 配置类
 *
 * @author 宋阳
 * @date 2019/3/1
 */
@SpringBootConfiguration
public class ApplicationConfig implements WebMvcConfigurer {
    private final SessionInterceptor sessionInterceptor;

    @Autowired
    public ApplicationConfig(SessionInterceptor sessionInterceptor) {

        this.sessionInterceptor = sessionInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**");
    }

    @Bean
    public Interceptor getInterceptor(){
        return new MybatisInterceptor();
    }

}
