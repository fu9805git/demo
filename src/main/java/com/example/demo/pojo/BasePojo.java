package com.example.demo.pojo;

/**
 * 类说明:
 *
 * @author 宋阳
 * @date 2019/3/5
 */
public class BasePojo {
    private int id; //主键
    private int status; //状态

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BasePojo{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
