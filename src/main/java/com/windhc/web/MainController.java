package com.windhc.web;

import com.windhc.domain.User;
import com.windhc.service.UserService;
import com.windhc.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @date 2015/7/26
 */
@Controller
@RequestMapping("/admin")
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/info")
    @ResponseBody
    public Map info() {
        String username = CommonUtil.getCurrentUserName();
        User user = userService.findUserByUsername(username);
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("role", user.getRole());
        return map;
    }
}
