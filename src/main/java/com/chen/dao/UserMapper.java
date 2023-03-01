package com.chen.dao;

import com.chen.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    void insertUser(User user);

    void updatePassword(User user);

    void deleteById(@Param("id") Integer id);

    User selectById(@Param("id") Integer id);

    User selectByUsername(@Param("username") String username);

    List<User> getAllUser();

}
