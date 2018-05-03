package com.windhc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HC
 * @date 2016/1/24
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping(value = "")
    public String main(){
        return "/view/admin/main.html";
    }

    @GetMapping(value = "/login")
    public String login(){
        return "/view/admin/login.html";
    }
}
