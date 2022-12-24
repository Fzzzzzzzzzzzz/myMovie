package com.xqf.service;

import com.xqf.common.utils.Result;
import com.xqf.domain.entity.Cinema;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86199
* @description 针对表【t_cinema】的数据库操作Service
* @createDate 2022-12-24 10:34:45
*/
public interface CinemaService extends IService<Cinema> {

    Result getCinemaList();

    Result getCurrentCinemaDetail(Integer cinemaId);
}
