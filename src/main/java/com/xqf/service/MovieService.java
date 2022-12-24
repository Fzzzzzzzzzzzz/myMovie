package com.xqf.service;

import com.xqf.common.utils.Result;
import com.xqf.domain.entity.Movie;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86199
* @description 针对表【t_movie】的数据库操作Service
* @createDate 2022-12-24 10:34:45
*/
public interface MovieService extends IService<Movie> {

    Result getMovieList();

    Result getMovieById(Integer id);

    Result isWishMovie(Integer movieId, Long userId);

    Result wishMovie(Integer movieId, Long userId);

    Result cancelWishMovie(Integer movieId, Long userId);
}
