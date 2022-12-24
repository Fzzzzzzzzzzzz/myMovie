package com.xqf.service.impl;


import com.xqf.common.domain.dto.LoginUser;
import com.xqf.domain.entity.User;
import com.xqf.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername1(userName);
        if (ObjectUtils.isEmpty(user))
            throw new UsernameNotFoundException("用户名不正确！");
        //查询对应的权限信息


        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(user.getUserId());
        loginUser.setUser(user);
        return loginUser;
    }
}
