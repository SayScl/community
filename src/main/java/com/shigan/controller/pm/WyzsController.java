package com.shigan.controller.pm;

import com.shigan.pojo.User;
import com.shigan.pojo.pm.Wyzs;
import com.shigan.pojo.pm.Xqgg;
import com.shigan.service.pm.WyzsService;
import com.shigan.service.pm.XqggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */
@Controller
@RequestMapping("pm")
public class WyzsController {

    @Autowired
    private WyzsService wyzsService;
    //跳转到物业展示页
    @RequestMapping("towyzs")
    public String towybx(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        List<Wyzs> getggbycommunityid = wyzsService.getzsbycommunityid(user.getCommunityid());
        model.addAttribute("wyzs",getggbycommunityid);
        return "/pm/wyzs";
    }

    //跳转到展示详情页
    @RequestMapping("tozsinfo")
    public String togginfo(@PathParam("id") Integer id, Model model){
        Wyzs getgginfobyid = wyzsService.getzsinfobyid(id);
        model.addAttribute("wyzs",getgginfobyid);
        return "/pm/zsinfo";
    }
}
