package com.hc.web;

import com.hc.domain.User;
import com.hc.service.UserService;
import com.hc.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by HC on 2016/1/14.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public Page<User> getAllPicture(@RequestParam() Map pageParams) {
        PageRequest pageRequest = CommonUtil.buildPageRequest(pageParams);
        String filterValue = (String) pageParams.get("filter[username]");
        if (filterValue != null) {
            return userService.findByUsernameLike("%" + filterValue + "%", pageRequest);
        }
        return userService.findAll(pageRequest);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Map delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return CommonUtil.response(true, "用户删除成功");
    }
}
