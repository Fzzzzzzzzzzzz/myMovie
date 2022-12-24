package com.xqf.controller;

import com.xqf.common.utils.Result;
import com.xqf.service.impl.CinemaServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

    @Resource
    private CinemaServiceImpl cinemaService;

    //获取所有的影院信息
    @GetMapping("getCinemaList")
    public Result getCinemaList(){
        return cinemaService.getCinemaList();
    }

    //获取当前影院详细信息
    @GetMapping("getCurrentCinemaDetail/{cinemaId}")
    public Result getCurrentCinemaDetail(@PathVariable("cinemaId") Integer cinemaId){
        return cinemaService.getCurrentCinemaDetail(cinemaId);
    }

    //获取当前影院排片情况
    @GetMapping("getCurrentCinemaMovieSchedule/{cinemaId}")
    public Result getCurrentCinemaMovieSchedule(@PathVariable("cinemaId") Integer cinemaId){
        return cinemaService.getCurrentCinemaDetail(cinemaId);
    }
}
