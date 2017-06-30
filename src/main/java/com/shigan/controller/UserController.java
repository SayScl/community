package com.shigan.controller;

import com.shigan.pojo.Ad;
import com.shigan.pojo.User;
import com.shigan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.Request;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    //跳转到注册页面
    @RequestMapping("goRegister")
    public String goRegister(){
        return "register";
    }


    //跳转到重置密码页面
    @RequestMapping("goModify")
    public String goModify(){
        return "modifyPWD";
    }

    //跳转到登录页面
    @RequestMapping("goLogin")
    public String goLogin(){
        return "login";
    }

    //注册
    @PostMapping("/register")
    @ResponseBody
    public String register(Model model,@RequestParam String phoneNumber,@RequestParam String nickname,
                           @RequestParam String name,@RequestParam String city,@RequestParam String community,
                           @RequestParam String address,@RequestParam String password){

        User user=new User();
        user.setPhoneNumber(phoneNumber);
        if(nickname==null || nickname==""){
            user.setNickname(phoneNumber);
        }else{
            user.setNickname(nickname);
        }
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


    //实现登录
    @PostMapping("login")
    @ResponseBody
    public String login(HttpServletRequest request){

        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        User user=new User();
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);
        User u1 = userService.getOne(user);
        if(u1!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user",u1);
            return "success";
        }else{
            return "faild";
        }
    }


    //实现密码修改
    @PostMapping("modify")
    @ResponseBody
    public String modify(HttpServletRequest request){
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        User user=new User();
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);
        int row = userService.modify(user);
        if(row>0){
            return "success";
        }else{
            return "faild";
        }
    }

    //查找广告
    @RequestMapping("getAd")
    @ResponseBody
    public String getAd(HttpServletRequest request){
        String adlocationid = request.getParameter("adlocationid");
        Ad ad = new Ad();
        if(adlocationid!=null){
            ad.setAdlocationid(Integer.parseInt(adlocationid));
        }
        List<Ad> ads = userService.getAdByAdId(ad);

        return "success";

    }

}
