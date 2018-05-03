package com.windhc.service;

import com.windhc.dao.UserMapper;
import com.windhc.domain.User;
import com.windhc.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @date 2015/10/6
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    
    public User createOrUpdate(User user) {
        if (user.getId() == null) {
            user.setRegisterTime(String.valueOf(System.currentTimeMillis()));
            user.setEnabled(true);
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        }
        return userMapper.save(user);
    }

    public User findUserById(long id) {
        return userMapper.findById(id).orElseThrow(ServiceException::new);
    }

    public User findUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public Page<User> findAll(PageRequest pageRequest) {
        return userMapper.findAll(pageRequest);
    }

    public User update(User user) {
        return userMapper.save(user);
    }

    public void deleteUser(long id) {
        userMapper.deleteById(id);
    }

    public Page<User> findByUsernameLike(String s, PageRequest pageRequest) {
        return userMapper.findByUsernameLike(s, pageRequest);
    }

    public User updateUserPwd(User user, String oldPwd, String newPwd) {
        if (!new BCryptPasswordEncoder().matches(oldPwd, user.getPassword())) {
            throw new ServiceException("密码修改失败，原密码错误");
        }
        user.setPassword(new BCryptPasswordEncoder().encode(newPwd));
        return userMapper.save(user);
    }
}
