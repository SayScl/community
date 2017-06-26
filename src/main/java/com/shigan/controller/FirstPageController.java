package com.shigan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/6/26.
 */
@Controller
public class FirstPageController {

    @RequestMapping("")
    public String firstPage(){
        return "firstPage";
    }
}
