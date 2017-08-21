package com.user.po;

import java.io.Serializable;

/**
 * <p>Title:SimplePojo </p>
 * <p>Description:</p>
 * Created with IntelliJ IDEA.
 * User: qxy
 * Date: 2017/8/21
 * Time: 10:54
 */
public class SimplePojo implements Serializable {


    private String userName;
    private String password;
    private int age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
