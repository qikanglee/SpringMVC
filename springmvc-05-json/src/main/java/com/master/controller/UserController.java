package com.master.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.master.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
@RestController //相当于@Controller和@RequestBody的结合！！！
public class UserController {

    //@ResponseBody // 添加这个注解，这个方法就不会走视图解析器跳转返回字符串的名字页面，而是直接返回真实值
    @RequestMapping("/j1")
    public String json1() throws JsonProcessingException {
        // jackson ,ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        // 创建一个对象
        User user = new User("李琪康",26,"男");
        // 将Java对象转为一个字符串
        String s = mapper.writeValueAsString(user);
        return s;
    }

    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        List<User> users = new ArrayList<User>();

        User user1 = new User("李琪康1",26,"男");
        User user2 = new User("李琪康2",26,"男");
        User user3 = new User("李琪康3",26,"男");
        User user4 = new User("李琪康4",26,"男");
        User user5 = new User("李琪康5",26,"男");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        String s = mapper.writeValueAsString(users);

        return s;
    }

    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        // 方式二：ObjectMapper 关闭时间戳
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);

        Date date = new Date();

        //// 方式一：通过java方式转换格式
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //format.format(date);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(format);
        // ObjectMapper 时间解析后默认是一个时间戳
        String s = mapper.writeValueAsString(date);

        return s;
    }
}
