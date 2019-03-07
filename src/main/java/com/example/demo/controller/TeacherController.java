package com.example.demo.controller;

import com.example.demo.pojo.Teacher;
import com.example.demo.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 类说明: 老师Controller
 *
 * @author 宋阳
 * @date 2019/3/5
 */
@Controller
@RequestMapping("teacher")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TeacherController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(TeacherController.class);
    private final TeacherService teacherService;
    private Teacher teacher;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @ModelAttribute
    public void setParams(Teacher teacher) {
        this.teacher = teacher;
    }

    @RequestMapping("goPage")
    public ModelAndView goPage(ModelAndView mav) {
        mav.setViewName("course/course_detail");
        return mav;
    }

    @Override
    protected int insertEntity() {
        logger.info("收到保存老师信息的请求," + teacher);
        int rows = teacherService.insertTeacher(teacher);
        System.out.println(teacher.getId());
        return rows;
    }
}
