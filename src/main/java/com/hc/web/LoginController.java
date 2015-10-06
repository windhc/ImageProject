package com.hc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2015/8/8.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String login(){
        return "/admin/login.html";
    }
}
