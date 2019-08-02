package com.th.authorizationservice.service.impl;

import com.th.authorizationservice.mapper.UserMapper;
import com.th.authorizationservice.model.User;
import com.th.authorizationservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }
}