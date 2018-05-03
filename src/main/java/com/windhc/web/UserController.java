package com.windhc.web;

import com.github.pagehelper.PageInfo;
import com.windhc.domain.User;
import com.windhc.service.UserService;
import com.windhc.utils.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author HC
 * @date 2016/1/14
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/userPage")
    public PageInfo<User> getAllPicture(PageRequest pageRequest) {
        return userService.findAll(pageRequest);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody User user) {
        userService.createOrUpdate(user);
    }

    @PutMapping(value = "/update")
    public void update(@RequestBody User user) {
        userService.createOrUpdate(user);
    }

    @GetMapping(value = "/{id}")
    public User findOne(@PathVariable("id") long id) {
        return userService.findOne(id);
    }
}
