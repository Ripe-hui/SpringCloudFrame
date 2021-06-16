package com.th.authorization.mapper;

import com.th.authorization.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User getByUserCode(String usercode);
}
