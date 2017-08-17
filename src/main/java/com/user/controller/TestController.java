package com.user.controller;

import com.user.po.TDemo;
import com.user.service.TestService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("TestController")
@Controller
public class TestController {

    @Autowired
    public TestService testService;

    /**
     * @Authod
     * @param model
     * @param req
     * @Method 测试model
     * @return
     */
    @RequestMapping(value = "/testFirst")
    public String testFirst(Model model, HttpServletRequest req) {
        model.addAttribute("aa","123123");
        return "test";
    }


    /**
     * 测试 dao
     * @param td
     * @param model
     * @return
     */
    @RequestMapping(value = "/testDao")
    public ModelAndView testDao(TDemo td, Model model) {
        System.out.println(td);
        List<TDemo> list = testService.queryList();
        ModelAndView mav = new ModelAndView("test");
        mav.addObject("tmp", "123");
        return mav;
    }


    /**
     * 测试数据绑定
     * @param td
     * @param resp
     */
    @RequestMapping(value = "/testBound", method = RequestMethod.POST)
    public void testBound(@RequestParam(value = "aa", required = true, defaultValue = "默认值") String td,String bb, HttpServletResponse resp) {
        try {

            System.out.println(td+" "+bb);
            resp.getWriter().print(td+"   "+bb);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试自定义 时间类型转换器
     * @param t
     * @param resp
     */
    @RequestMapping(value = "/testDemo", method = RequestMethod.POST)
    public void testDemo(TDemo t, HttpServletResponse resp) {
        try {

            DateTime dateTime = t.getCreateTime();
            System.out.println(dateTime.toString("yyyy-MM-dd"));
            resp.getWriter().print(t);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 测试  spring vildation
     * @param t
     * @param resp
     */
    @RequestMapping(value = "/testVildator", method = {RequestMethod.POST,RequestMethod.GET})
    public void testVildator(TDemo t, HttpServletResponse resp) {
        try {


            resp.getWriter().print(t);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }





}
