package com.th.authorizationservice.service;


import com.th.authorizationservice.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    @Cacheable(value = "#id")
    User getByUsername(String username);
}
