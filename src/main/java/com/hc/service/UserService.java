package com.hc.service;

import com.hc.domain.User;

/**
 * Created by Administrator on 2015/8/24.
 */
public interface UserService {

//
//    public List<User> findAll() {
//        return (List<User>) userRepository.findAll();
//    }
//
//    public User create(User user) {
//        return userRepository.save(user);
//    }
//
    public User findUserById(int id);

    public User findUserByUsername(String username);

//
//    public User login(String username, String password) {
//        return userRepository.findByUsernameAndPassword(username, password);
//    }
//
//    public User update(User user) {
//        return userRepository.save(user);
//    }
//
//    public void deleteUser(int id) {
//        userRepository.delete(id);
//    }
//
//    public User findUserByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }

}
