package com.hc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 * @date 2015/8/8
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping(value = "")
    public String login(){
        return "/view/admin/login.html";
    }
}
