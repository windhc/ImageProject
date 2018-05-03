package com.windhc.dao;

import com.windhc.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chen.huang
 */
@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {

    User findByUsername(@Param("username") String username);
}
