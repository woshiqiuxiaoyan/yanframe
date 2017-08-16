package com.user.controller;

import com.user.po.TDemo;
import com.user.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by t on 2017/8/16.
 */
@RequestMapping("TestController")
@Controller
public class TestController {

    @Autowired
    public TestService testService;

    @RequestMapping(value = "/testFirst")
    public String testFirst() {
        System.out.println("-------------------------------------------");
        return "test";
    }


    @RequestMapping(value = "/testDao")
    public String testDao(TDemo td) {
        System.out.println(td);
        List<TDemo> list =  testService.queryList();

        return "test";
    }


    @RequestMapping(value = "/testBound",method = RequestMethod.GET )
    public void testBound(@RequestParam(value = "pp") String td, HttpServletResponse resp) {

        try {
            resp.getWriter().print("123");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}
