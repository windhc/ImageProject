package com.windhc.web;

import com.github.pagehelper.PageInfo;
import com.windhc.config.exception.ServiceException;
import com.windhc.domain.User;
import com.windhc.dto.LoginResponse;
import com.windhc.service.UserService;
import com.windhc.utils.CommonUtil;
import com.windhc.utils.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author HC
 * @date 2016/1/14
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public PageInfo<User> getAllPicture(PageRequest pageRequest) {
        return userService.findAll(pageRequest);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }

    @PostMapping(value = "")
    public void save(@RequestBody User user) {
        userService.createOrUpdate(user);
    }

    @PutMapping(value = "")
    public void update(@RequestBody User user) {
        userService.createOrUpdate(user);
    }

    @GetMapping(value = "/{id}")
    public User findOne(@PathVariable("id") long id) {
        return userService.findOne(id);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody User user) {
        return userService.login(user);
    }

    @PutMapping(value = "/password")
    public void updateCurrentUserPwd(@RequestBody Map<String, String> params) {
        if (params.size() != 3) {
            throw new ServiceException("密码修改失败,参数不全");
        }
        String oldPwd = params.get("oldPwd");
        String newPwd = params.get("newPwd");
        String newPwdAgain = params.get("newPwdAgain");
        if (!newPwd.equals(newPwdAgain)) {
            throw new ServiceException("密码修改失败,新密码不一致");
        }
        String username = CommonUtil.getCurrentUserName();
        User user = userService.findUserByUsername(username);
        userService.updateUserPwd(user, oldPwd, newPwd);
    }
}
