package com.xqf.controller;


import com.xqf.common.utils.GetLoginUser;
import com.xqf.common.utils.Result;
import com.xqf.service.impl.MovieServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Resource
    private MovieServiceImpl movieService;

    @GetMapping("getMovieList")
    public Result getMovieList(){
        return movieService.getMovieList();
    }

    @GetMapping("getMovieById/{movieId}")
    public Result getMovieById(@PathVariable("movieId") Integer movieId){
        return movieService.getMovieById(movieId);
    }

    @PostMapping("isWishMovie/{movieId}")
    public Result isWishMovie(@PathVariable("movieId") Integer movieId,
                              HttpServletRequest request){
        //先获取个人的userId
        Long userId = GetLoginUser.getLoginUserNameInSession(request).getUserId();
        return movieService.isWishMovie(movieId,userId);
    }

    @PostMapping("wishMovie/{movieId}")
    public Result wishMovie(@PathVariable("movieId") Integer movieId,
                              HttpServletRequest request){
        //先获取个人的userId
        Long userId = GetLoginUser.getLoginUserNameInSession(request).getUserId();
        return movieService.wishMovie(movieId,userId);
    }

    @PostMapping("cancelWishMovie/{movieId}")
    public Result cancelWishMovie(@PathVariable("movieId") Integer movieId,
                            HttpServletRequest request){
        //先获取个人的userId
        Long userId = GetLoginUser.getLoginUserNameInSession(request).getUserId();
        return movieService.cancelWishMovie(movieId,userId);
    }
}
