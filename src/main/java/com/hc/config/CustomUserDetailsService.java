//package com.hc.config;
//
//import com.hc.domain.SecurityUser;
//import com.hc.domain.User;
//import com.hc.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
///**
// * Created by Administrator on 2015/8/24.
// */
//@Component
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired  //数据库服务类
//    private UserService userService;//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //User对应数据库中的用户表，是最终存储用户和密码的表，可自定义
//        User user = userService.findUserByUsername(username); //
//        if (user == null) {
//            throw new UsernameNotFoundException("UserName " + username + " not found");
//        }
//        // SecurityUser实现UserDetails
//        return new SecurityUser(user); //
//    }
//}

