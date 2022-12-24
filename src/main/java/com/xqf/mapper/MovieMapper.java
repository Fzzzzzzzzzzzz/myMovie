package com.xqf.mapper;

import com.xqf.domain.Vo.MovieRelease;
import com.xqf.domain.entity.Movie;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 86199
* @description 针对表【t_movie】的数据库操作Mapper
* @createDate 2022-12-24 10:34:45
* @Entity com.xqf.domain.entity.Movie
*/
public interface MovieMapper extends BaseMapper<Movie> {

    List<MovieRelease> getMovieList();
}




