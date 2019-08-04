package com.th.authorizationservice.mapper;

import com.th.authorizationservice.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    User getByUsername(String usercode);
}
