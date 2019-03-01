package com.example.demo;

import com.example.demo.interceptors.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 类说明:
 *
 * @author 宋阳
 * @date 2019/3/1
 */
@SpringBootConfiguration
public class ApplicationConfig extends WebMvcConfigurerAdapter {
    private final SessionInterceptor sessionInterceptor;

    @Autowired
    public ApplicationConfig(SessionInterceptor sessionInterceptor) {
        this.sessionInterceptor = sessionInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**");
    }
}
