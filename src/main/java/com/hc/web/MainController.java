package com.hc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2015/7/26.
 */
@Controller
@RequestMapping("/admin")
public class MainController {

    private final static Logger log = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String main(){
        return "/view/admin/main.html";
    }
}
