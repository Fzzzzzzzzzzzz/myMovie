package com.xqf.controller;


import com.xqf.common.domain.dto.LoginBody;
import com.xqf.common.domain.dto.UserRegistration;
import com.xqf.common.utils.GetLoginUser;
import com.xqf.common.utils.Result;
import com.xqf.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserServiceImpl sysUserService;

    //用户登录
    @PostMapping("/login")
    public Result login(@RequestBody LoginBody loginBody){

        String token = null;
        try {
            token = sysUserService.login(loginBody.getUsername(),loginBody.getPassword());
        } catch (Exception exception) {
            return Result.fail(200,"用户名密码错误",null);
        }
        return Result.success(200,"获取token",token);
    }
    //获取个人信息
    @GetMapping("getUserInfo")
    public Result getUserInfo(HttpServletRequest request){
        //先获取个人的userId
        Long userId = GetLoginUser.getLoginUserNameInSession(request).getUserId();
        return sysUserService.getUserInfo(userId);
    }
    //用户注册
    @PostMapping("registration")
    public Result registration(@RequestBody UserRegistration userRegistration){
        return sysUserService.registration(userRegistration);
    }
}