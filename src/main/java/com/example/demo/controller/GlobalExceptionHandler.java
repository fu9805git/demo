package com.example.demo.controller;

import com.example.demo.pojo.FrontMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类说明:
 *
 * @author 宋阳
 * @date 2019/3/7
 */
@CrossOrigin
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public FrontMessage processException(Exception ex, HttpServletRequest request, HttpServletResponse response){
        String message = StringUtils.hasLength(ex.getMessage())?ex.getMessage():"操作异常";
        logger.error("捕获全局异常", ex);
        return new FrontMessage(false, message);
    }
}
