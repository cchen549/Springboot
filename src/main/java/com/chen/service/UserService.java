package com.chen.service;

import com.chen.dao.UserMapper;
import com.chen.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getFromId(Integer id) {
        return userMapper.selectById(id);
    }

    public User getFromUsername(String name){
        return userMapper.selectByUsername(name);
    }

    public List<User> getAll(){
        return userMapper.getAllUser();
    }

    public void insertUser(User user){
        userMapper.insertUser(user);
    }

    public void updatePwd(User user){
        userMapper.updatePassword(user);
    }

    public void deleteUser(Integer id){
        userMapper.deleteById(id);
    }

    public boolean login(String username, String password) {
        User userGet = userMapper.selectByUsername(username);
        if (userGet != null){
            if (password.equals(userGet.getPassword())){
                return true;
            }
        }
        return false;
    }







}
