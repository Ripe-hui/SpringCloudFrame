package com.th.authorizationservice.service;

import com.th.authorizationservice.model.Role;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface IRoleService {

    Set<Role> queryUserRolesByUserId(String userId);
}
