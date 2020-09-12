package com.pupu.thymeleafdemo.controller;

import com.pupu.thymeleafdemo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : lipu
 * @since : 2020-09-11 22:34
 */
@Controller
public class MainController {


    @RequestMapping(value = {"","index"})
    public String main(Model model, HttpSession session){
        User user = new User();
        user.setId(1L);
        user.setName("qiongqiong");
        user.setAge(15);
        User user1 = new User();
        user1.setId(2L);
        user1.setName("mumu");
        user1.setAge(2);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        model.addAttribute("users",users);
        List<String> strs = new ArrayList<>();
        strs.add("我是觉得");
        model.addAttribute("strs",strs);
        model.addAttribute("str","Hello");
        session.setAttribute("name","pupu");
        model.addAttribute("info", "Love you <b>中国</b>");

        return "/模板布局/index";
    }

    @RequestMapping(value = {"show"})
    @ResponseBody
    public String show(Integer id, String name){
        String str = "id:"+id+",name:"+name;
        System.out.println(str);

        return str;
    }

    @RequestMapping(value = {"index/index"})
    public String frame(Model model, HttpSession session){
        model.addAttribute("aa","aa");

        return "/模板布局/index";
    }

}


