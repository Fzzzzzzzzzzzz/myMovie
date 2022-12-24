package com.xqf.controller;

import com.xqf.common.utils.GetLoginUser;
import com.xqf.common.utils.Result;
import com.xqf.service.impl.CommentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/comment")
public class CommenController {

    @Resource
    private CommentServiceImpl commentService;

    //获取当前用户对某个电影评论
    @GetMapping("getUserComment/{movieId}")
    public Result getUserComment(@PathVariable("movieId") Integer movieId,
                                 HttpServletRequest request){
        //先获取个人的userId
        Long userId = GetLoginUser.getLoginUserNameInSession(request).getUserId();
        return commentService.getUserComment(movieId,userId);
    }
}
