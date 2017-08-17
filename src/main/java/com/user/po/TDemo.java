package com.user.po;

import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by t on 2017/8/16.
 */

public class TDemo implements Serializable {


    private int id;

    @NotNull(message = "{tdemo.userName.null}")
    private String userName;

    private int age;

    private DateTime createTime;

    private DateTime updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    public DateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(DateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "TDemo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
