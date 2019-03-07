package com.example.demo.controller;

import com.example.demo.pojo.FrontMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 类说明:基础Controller
 *
 * @author 宋阳
 * @date 2019/3/5
 */
@ControllerAdvice
public class BaseController {

    @Autowired
    protected HttpServletRequest request;

    @RequestMapping("insert")
    @ResponseBody
    public FrontMessage insert() {
        try {
            int rows = insertEntity();
            return rows == 1 ? new FrontMessage(true, "保存成功") : new FrontMessage(true, "保存失败");
        } catch (Exception e) {
            e.printStackTrace();
            String exceptionMessage = "保存异常";
            if (StringUtils.hasLength(e.getMessage())) {
                exceptionMessage = exceptionMessage + "," + e.getMessage();
            }
            return new FrontMessage(false, exceptionMessage);
        }
    }

    protected int insertEntity() {
        return 1;
    }
}
