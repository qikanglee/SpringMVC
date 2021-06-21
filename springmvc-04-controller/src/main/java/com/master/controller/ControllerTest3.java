package com.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/t3")
public class ControllerTest3 {
    @RequestMapping("/t1")
    public String test(Model model){
        model.addAttribute("msg","Hello RequestMapping !");
        return "test";
    }
}
