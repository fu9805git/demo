package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.demo.servlet.WxServlet;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class DemoApplication {

    @Bean
    public ServletRegistrationBean MyServlet1() {
        return new ServletRegistrationBean(new WxServlet(), "/wxdemo");
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

