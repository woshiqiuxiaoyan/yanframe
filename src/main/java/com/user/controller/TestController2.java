package com.user.controller;

import com.user.po.TDemo;
import com.user.service.TestService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by t on 2017/8/16.
 */
@RequestMapping("TestController2")
@Controller
public class TestController2 {

    @Autowired
    public TestService testService;



    /**
     * 测试  spring vildation 分给校验002
     *
     * @param t
     * @param resp
     */
    @RequestMapping(value = "/testVildatorGroup002", method = {RequestMethod.POST, RequestMethod.GET})
    public void testVildatorGroup001(@Validated TDemo t, BindingResult bindingResult, HttpServletResponse resp) {
        try {

            if (bindingResult.hasErrors()) {

                int lenght = bindingResult.getAllErrors().size();

                for (int i = 0 ; i < lenght; i++) {

                    String aa = bindingResult.getAllErrors().get(i).getDefaultMessage();

                    aa = new String(aa.getBytes("ISO-8859-1"),"utf-8");

                    System.out.println(aa);

                }

            }

            resp.getWriter().print(t);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    


}
