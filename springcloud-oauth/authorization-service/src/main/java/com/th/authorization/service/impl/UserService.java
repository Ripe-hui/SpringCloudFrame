package com.th.authorization.service.impl;

import com.th.authorization.mapper.UserMapper;
import com.th.authorization.model.User;
import com.th.authorization.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByUsername(String usercode) {
        return userMapper.getByUserCode(usercode);
    }
}
