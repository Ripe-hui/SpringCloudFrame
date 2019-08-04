package com.th.authorizationservice.mapper;

import com.th.authorizationservice.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Mapper
@Repository
public interface RoleMapper {
    Set<Role> queryByUserId(String userId);
}
