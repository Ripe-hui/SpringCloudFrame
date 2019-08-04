package com.th.authorizationservice.service.impl;

import com.th.authorizationservice.mapper.RoleMapper;
import com.th.authorizationservice.model.Role;
import com.th.authorizationservice.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
        public Set<Role> queryUserRolesByUserId(String userId) {
        return roleMapper.queryByUserId(userId);
    }

}
