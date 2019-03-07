package com.example.demo.mapper;

import com.example.demo.pojo.Teacher;
import org.springframework.stereotype.Repository;

/**
 * 类说明:
 *
 * @author 宋阳
 * @date 2019/3/5
 */
@Repository
public interface TeacherMapper {

    /**
     * 写入老师数据
     *
     * @param teacher Teacher
     * @return int
     */
    int insertTeacher(Teacher teacher);

}
