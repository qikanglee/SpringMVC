package cn.masterqi.controller;

import cn.masterqi.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String test() {
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param ==>" + name);
        if ("qikang".equals(name)) {
            response.getWriter().println("true");
        } else {
            response.getWriter().println("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2() {
        List<User> userArrayList = new ArrayList<User>();

        // 添加数据
        userArrayList.add(new User("MasterQi", 26, "男"));
        userArrayList.add(new User("李琪康", 25, "女"));
        userArrayList.add(new User("琪少", 24, "男女"));

        return userArrayList;
    }

    @RequestMapping("/a3")
    public String a3(String name, String pwd) {
        String msg="";
        if (name != null) {
            // admin 这些数据应该在数据库中查
            if ("admin".equals(name)) {
                msg = "OK!";
            } else {
                msg = "wrong username!";
            }
        }
        if (pwd != null) {
            // admin 这些数据应该在数据库中查
            if ("123456".equals(pwd)) {
                msg = "OK!";
            } else {
                msg = "wrong password!";
            }
        }

        return msg;
    }
}





















