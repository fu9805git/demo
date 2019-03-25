package com.example.demo.pojo;

import java.math.BigDecimal;

/**
 * 类说明: 老师
 * T_TEACHER
 *
 * @author 宋阳
 * @date 2019/3/5
 */
public class Teacher extends BasePojo{
    private Integer userId;
    private String name;
    private String degree;
    private String introduce;
    private String title;
    private BigDecimal proportion;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getProportion() {
        return proportion;
    }

    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", degree='" + degree + '\'' +
                ", introduce='" + introduce + '\'' +
                ", title='" + title + '\'' +
                ", proportion=" + proportion +
                "} " + super.toString();
    }
}
