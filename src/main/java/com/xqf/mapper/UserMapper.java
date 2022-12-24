package com.xqf.mapper;

import com.xqf.domain.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 86199
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-12-23 22:54:14
* @Entity com.xqf.domain.entity.User
*/
public interface UserMapper extends BaseMapper<User> {

    User loadUserByUsername1(String userName);
}




