package com.hc.service;

import com.hc.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Created by Administrator on 2015/8/24.
 */
public interface UserService {

    User create(User user);

    User findUserById(long id);

    User findUserByUsername(String username);

    Page<User> findAll(PageRequest pageRequest);

    User update(User user);

    void deleteUser(long id);

    Page<User> findByUsernameLike(String s, PageRequest pageRequest);
}
