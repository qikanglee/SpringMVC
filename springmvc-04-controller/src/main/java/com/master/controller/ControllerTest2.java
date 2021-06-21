package com.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 表示这个类会被 Spring 接管
// 被这个注解的类中的所有的方法，如果返回值是 String，并且有具体的页面可以跳转，那么就会被视图解释器解析
public class ControllerTest2 {
    @RequestMapping("/t1")
    public String test1(Model model){
        model.addAttribute("msg","Hello Controller Test2");
        return "test";
    }
}
