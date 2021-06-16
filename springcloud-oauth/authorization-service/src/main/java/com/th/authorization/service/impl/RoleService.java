package com.th.authorization.service.impl;

import com.th.authorization.mapper.RoleMapper;
import com.th.authorization.model.Role;
import com.th.authorization.service.IRoleService;
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
