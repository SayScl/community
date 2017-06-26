package com.shigan.controller;

import com.shigan.pojo.User;
import com.shigan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/6/26.
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @RequestMapping("goRegister")
    public String goRegister(){
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(Model model,@RequestParam String phoneNumber,@RequestParam String nickname,
                           @RequestParam String name,@RequestParam String city,@RequestParam String community,
                           @RequestParam String address,@RequestParam String password){

        User user=new User();
        user.setPhoneNumber(phoneNumber);
        user.setNickname(nickname);
        user.setName(name);
        user.setAddress(address);
        user.setCity(city);
        user.setCommunity(community);
        user.setPassword(password);
        int rows = userService.register(user);
        if(rows>0){
           return "success";
        }else {
            return "faild";
        }
    }

}
