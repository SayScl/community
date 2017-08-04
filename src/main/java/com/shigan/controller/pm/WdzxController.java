package com.shigan.controller.pm;

import com.shigan.pojo.pm.Wdzx;
import com.shigan.service.pm.WdzxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Controller
@RequestMapping("pm")
public class WdzxController {
    @Autowired
    private WdzxService wdzxService;
    //跳转到我的装修日志页
    @RequestMapping("towdzx")
    public String towdzx(HttpServletRequest request, Model model){
        String id = request.getParameter("id");
        List<Wdzx> getwdzx = wdzxService.getwdzx(Integer.parseInt(id));
        model.addAttribute("wdzx",getwdzx);
        return "/pm/wdzx";
    }
}
