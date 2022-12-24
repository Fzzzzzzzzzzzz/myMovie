package com.xqf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xqf.common.utils.Result;
import com.xqf.domain.Vo.MovieRelease;
import com.xqf.domain.entity.Movie;
import com.xqf.domain.entity.Wishmovie;
import com.xqf.mapper.WishmovieMapper;
import com.xqf.service.MovieService;
import com.xqf.mapper.MovieMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 86199
* @description 针对表【t_movie】的数据库操作Service实现
* @createDate 2022-12-24 10:34:45
*/
@Service
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie>
    implements MovieService{

    @Resource
    private MovieMapper movieMapper;

    @Resource
    private WishmovieMapper wishmovieMapper;

    @Override
    public Result getMovieList() {
        //获取所有的上映电影
        List<MovieRelease> movieList = movieMapper.getMovieList();

        if(movieList.size()==0)
            return Result.fail(201,"未获取到电影列表",null);
        return Result.success(200,"获取电影列表成功！",movieList);
    }

    @Override
    public Result getMovieById(Integer movieId) {
        Movie movie = movieMapper.selectById(movieId);
        if(ObjectUtils.isEmpty(movie))
            return Result.fail(400,"未查询到该电影",null);
        return Result.success(200,"查询电影成功！",movie);
    }

    @Override
    public Result isWishMovie(Integer movieId, Long userId) {
        Long selectCount = wishmovieMapper.selectCount(new LambdaQueryWrapper<Wishmovie>().eq(Wishmovie::getMovieId, movieId)
                .eq(Wishmovie::getUserId, userId));
        if (selectCount==1)
            return Result.success(200,"该电影为想看的电影",null);
        return Result.fail(201,"该电影不是用户想看的电影",null);
    }

    @Override
    public Result wishMovie(Integer movieId, Long userId) {
        Wishmovie wishmovie = new Wishmovie();
        wishmovie.setMovieId(movieId);
        wishmovie.setUserId(userId);
        int insert = wishmovieMapper.insert(wishmovie);
        if(insert>0)
            return Result.success(200,"已将电影设置为您想看的电影！",null);
        return Result.fail(201,"设置电影为想看的电影失败！",null);
    }

    @Override
    public Result cancelWishMovie(Integer movieId, Long userId) {
        int delete = wishmovieMapper.delete(new LambdaQueryWrapper<Wishmovie>().eq(Wishmovie::getMovieId, movieId)
                .eq(Wishmovie::getUserId, userId));
        if (delete==1)
            return Result.success(200,"取消电影为想看的电影成功！",null);
        return Result.fail(201,"取消电影为想看的电影失败！",null);
    }

}




