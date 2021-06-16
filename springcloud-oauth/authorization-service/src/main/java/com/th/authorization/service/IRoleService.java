package com.th.authorization.service;

import com.th.authorization.model.Role;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface IRoleService {
    Set<Role> queryUserRolesByUserId(String userId);
}
