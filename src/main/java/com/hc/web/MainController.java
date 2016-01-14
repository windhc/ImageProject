package com.hc.web;

import com.hc.domain.User;
import com.hc.service.UserService;
import com.hc.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/7/26.
 */
@Controller
@RequestMapping("/admin")
public class MainController {

    private final static Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String main(){
        return "/view/admin/main.html";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public
    @ResponseBody
    Map info() {
        String username = CommonUtil.getCurrentUserName();
        User user = userService.findUserByUsername(username);
        Map map = new HashMap<>();
        map.put("username", username);
        map.put("role", user.getRole());
        return map;
    }

}
