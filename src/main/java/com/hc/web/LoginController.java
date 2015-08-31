package com.hc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2015/8/8.
 */
@RestController
 @RequestMapping("/login2")
 public class LoginController {

    @RequestMapping("")
    public void login(){

        System.out.println("login");
    }
}
