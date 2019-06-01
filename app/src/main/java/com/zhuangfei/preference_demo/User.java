package com.zhuangfei.preference_demo;

import java.io.Serializable;

/**
 * Created by Liu ZhuangFei on 2019/6/1.
 */
public class User {
    private String name;
    private int age = 0;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
