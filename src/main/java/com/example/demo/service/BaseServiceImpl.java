package com.example.demo.service;

import com.example.demo.pojo.BasePojo;

import java.util.Date;

public class BaseServiceImpl {

    /**
     * 给共有字段赋值
     */
    protected void setBaseFieldValue(BasePojo basePojo) {
        basePojo.setCreatedBy(1);
        basePojo.setCreatedTime(new Date());
        setUpdatedFieldValue(basePojo);
    }

    protected void setUpdatedFieldValue(BasePojo basePojo) {
        basePojo.setUpdatedBy(1);
        basePojo.setUpdatedTime(new Date());
    }
}
