package com.th.authorization.service;

import com.th.authorization.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    User getByUsername(String usercode);
}
