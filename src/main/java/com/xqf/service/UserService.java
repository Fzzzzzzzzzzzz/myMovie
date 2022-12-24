package com.xqf.service;

import com.xqf.common.domain.dto.UserRegistration;
import com.xqf.common.utils.Result;
import com.xqf.domain.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86199
* @description 针对表【t_user】的数据库操作Service
* @createDate 2022-12-23 22:54:14
*/
public interface UserService extends IService<User> {


    String login(String username, String password) throws Exception;

    Result getUserInfo(Long userId);

    Result registration(UserRegistration userRegistration);
}
