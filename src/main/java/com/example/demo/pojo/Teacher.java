package com.example.demo.pojo;

/**
 * 类说明: 老师
 * T_TEACHER
 *
 * @author 宋阳
 * @date 2019/3/5
 */
public class Teacher extends BasePojo{
    private String name;
    private int age;
    private String degree;
    private String des;
    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", degree='" + degree + '\'' +
                ", des='" + des + '\'' +
                ", title='" + title + '\'' +
                "} " + super.toString();
    }
}
