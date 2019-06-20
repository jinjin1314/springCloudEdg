package com.jin.controller;

import com.jin.entity.User;
import com.jin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private  String port;

    @RequestMapping("getUser/{id}")
    public ModelAndView GetUser(@PathVariable int id, Model model) {

        User user = userService.Sel(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("user/userTest", "userModel", model);
    }

    @RequestMapping("/port")
    public String getPort(){
     return "负载均衡port"+port;
    }
}
