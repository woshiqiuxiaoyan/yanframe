package com.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by t on 2017/8/16.
 */
@Controller
@RequestMapping("TestController")
public class TestController {

    @RequestMapping("/testFirst")
    public String testFirst(){
        System.out.println("aa");
        return "123123";
    }
}
