package com.user.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>Title:SimplePojo </p>
 * <p>Description:</p>
 * Created with IntelliJ IDEA.
 * User: qxy
 * Date: 2017/8/21
 * Time: 10:54
 */
@Data
@NoArgsConstructor
public class SimplePojo   {
    private String userName;
    private String password;
    private int age;

}
