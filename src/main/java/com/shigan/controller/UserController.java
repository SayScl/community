package com.shigan.controller;

import com.shigan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/6/26.
 */
@Controller
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService userService;


    @RequestMapping("goRegister")
    public String goRegister(){
        return "register";
    }

    @RequestMapping("register")
    @ResponseBody
    public String register(Model model){
        int rows = userService.register();
        if(rows>0){
            model.addAttribute("success","success");
        }else {
            model.addAttribute("success","fail");
        }
    return "pages/show";
    }

}
