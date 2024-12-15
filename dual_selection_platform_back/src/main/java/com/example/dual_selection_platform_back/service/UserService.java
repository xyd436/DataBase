package com.example.dual_selection_platform_back.service;

import com.example.dual_selection_platform_back.mapper.UserMapper;
import com.example.dual_selection_platform_back.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     *
     * @param
     * @return User
     */
    public User login(String username, String password) {
        return userMapper.findByUsernameAndPassword(username, password);
    }
}
