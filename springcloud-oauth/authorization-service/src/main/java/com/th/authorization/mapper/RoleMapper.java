package com.th.authorization.mapper;

import com.th.authorization.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Mapper
@Repository
public interface RoleMapper {
    Set<Role> queryByUserId(String userId);
}
