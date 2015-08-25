package com.hc.dao;

import com.hc.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2015/8/24.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "select u from User u where u.username=?1 and u.password=?2")
    User login(String username, String password);

    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

}
