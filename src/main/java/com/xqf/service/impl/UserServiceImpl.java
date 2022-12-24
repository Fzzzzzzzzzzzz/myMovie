package com.xqf.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xqf.common.domain.dto.LoginUser;
import com.xqf.common.domain.dto.UserRegistration;
import com.xqf.common.utils.Result;
import com.xqf.common.utils.TokenService;
import com.xqf.domain.entity.User;
import com.xqf.service.UserService;
import com.xqf.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
* @author 86199
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-12-23 22:54:14
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Resource
    public StringRedisTemplate stringRedisTemplate;


    @Override
    public String login(String username, String password) throws Exception{

        //这里的code和uuid用于验证码的实现

        Authentication authentication = null;
//        try {
        // 用户验证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
        authentication = authenticationManager.authenticate(authenticationToken);
        //如果认证不通过就抛一个提示(Authentication为空或者不抛出来了一个异常）
        if(Objects.isNull(authentication)){
            throw new RuntimeException("Authentication认证失败1");
        }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //此时回调回来，证明用户认证通过了，从Authentication获取到一个LoginUser对象的信息
        LoginUser loginUser = (LoginUser)authentication.getPrincipal();
///        使用生成一个jwt，
        String Jwt = tokenService.createToken(loginUser);
//        将jwt存进redis(按照若依的格式)
        //先写死这方法的后面两个值（不知道什么鬼东西）30秒
//        redisCache.setCacheObject("login_tokens:"+loginUser.getToken(),loginUser,30, TimeUnit.SECONDS);
        String loginUserString = JSON.toJSONString(loginUser);
        stringRedisTemplate.opsForValue().set("login_tokens:"+loginUser.getToken(),loginUserString,30, TimeUnit.MINUTES);

        return Jwt;
    }


    @Override
    public Result getUserInfo(Long userId) {
        User user = userMapper.selectById(userId);
        if(!ObjectUtils.isEmpty(user)){
            User user1 = new  User();
            user1.setUserId(user.getUserId());
            user1.setUserName(user.getUserName());
            user1.setAvatar(user.getAvatar());
//            user1.setNickName(user.getNickName());
            return Result.success(200,"获取个人信息成功！",user1);
        }
        return Result.fail(400,"获取个人信息失败！",null);
    }

    //用户注册
    @Override
    public Result registration(UserRegistration userRegistration) {
        User user = new User();
        user.setUserName(userRegistration.getUserName());
//        user.setNickName(userRegistration.getNickName());
        user.setPassword("{noop}"+userRegistration.getPassword());
        user.setAvatar("http://rmvft83aq.hn-bkt.clouddn.com/99d276f8-d98b-41fa-ab40-acc2420b2b3e");
        userMapper.insert(user);
        return Result.success(200,"用户注册成功",null);
    }

}






