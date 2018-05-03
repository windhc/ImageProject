package com.windhc.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.windhc.dao.UserMapper;
import com.windhc.domain.User;
import com.windhc.exception.ServiceException;
import com.windhc.utils.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    public void createOrUpdate(User user) {
        if (user.getId() == null) {
            user.setCreatedAt(System.currentTimeMillis());
            user.setEnabled(true);
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        }
        userMapper.insertSelective(user);
    }

    public User findOne(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User findUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public PageInfo<User> findAll(PageRequest pageRequest) {
        return PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize())
                .doSelectPageInfo(() -> userMapper.selectAll());
    }

    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    public void deleteUser(long id) {
        userMapper.deleteByPrimaryKey(id);
    }

//    public Page<User> findByUsernameLike(String s, PageRequest pageRequest) {
//        return userMapper.findByUsernameLike(s, pageRequest);
//    }

    public void updateUserPwd(User user, String oldPwd, String newPwd) {
        if (!new BCryptPasswordEncoder().matches(oldPwd, user.getPassword())) {
            throw new ServiceException("密码修改失败，原密码错误");
        }
        user.setPassword(new BCryptPasswordEncoder().encode(newPwd));
        userMapper.updateByPrimaryKeySelective(user);
    }
}
