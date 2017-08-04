package com.shigan.controller.pm;

import com.shigan.pojo.User;
import com.shigan.pojo.pm.Wybx;
import com.shigan.service.pm.WybxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/25.
 */
@Controller
@RequestMapping("pm")
public class PmContrlooer {
    @Autowired
    private WybxService wybxService;
    //跳转到物管首页
    @RequestMapping("topm")
    public String topm(){
        return "/pm/pm";
    }

    //跳转到物业报修
    @RequestMapping("towybx")
    public String towybx(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        List<Wybx> wybxes = wybxService.getwybxbycommunityid(user.getCommunityid());
        model.addAttribute("wybx",wybxes);
        return "/pm/wybx";
    }

    //跳转到增加报修页面
    @RequestMapping("toaddbx")
    public String toaddbx(){
        return "/pm/addbx";
    }

    //新增保修
    @RequestMapping("addbx")
    @ResponseBody
    public String addbx(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user =(User)session.getAttribute("user");
        Wybx wybx=new Wybx();
        String content = request.getParameter("content");
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createtime = sdf.format(date);
        String path = request.getParameter("img");
        wybx.setContent(content);
        wybx.setCreatetime(createtime);
        wybx.setStatu(0);
        wybx.setUserid(user.getId());
        wybx.setCommunityid(user.getCommunityid());
        wybx.setPath(path);
        int i = wybxService.addbx(wybx);
        if(i>0){
            return "success";
        }else{
            return "faild";
        }
    }
    //确认报修
    @PostMapping("confirmbx")
    @ResponseBody
    public String confirmbx(HttpServletRequest request){
        String id = request.getParameter("id");
        Wybx bx=new Wybx();
        bx.setId(Integer.parseInt(id));
        bx.setStatu(3);
        int i = wybxService.confirmbx(bx);
        if(i>0){
            return "success";
        }else{
            return "faild";
        }
    }


    //跳转到快捷充值
    @RequestMapping("tokjcz")
    public String tokjcz(){
        return "/pm/kjcz";
    }

}
