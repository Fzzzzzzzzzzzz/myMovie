package com.xqf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xqf.common.utils.Result;
import com.xqf.domain.entity.Cinema;
import com.xqf.service.CinemaService;
import com.xqf.mapper.CinemaMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 86199
* @description 针对表【t_cinema】的数据库操作Service实现
* @createDate 2022-12-24 10:34:45
*/
@Service
public class CinemaServiceImpl extends ServiceImpl<CinemaMapper, Cinema>
    implements CinemaService{

    @Resource
    private CinemaMapper cinemaMapper;

    @Override
    public Result getCinemaList() {
        List<Cinema> cinemaList = cinemaMapper.selectList(new LambdaQueryWrapper<>());
        if(cinemaList.size()==0)
            return Result.fail(400,"未获取到电影院信息！",null);
        return Result.success(200,"获取到电影院信息成功！",cinemaList);
    }

    @Override
    public Result getCurrentCinemaDetail(Integer cinemaId) {
        Cinema cinema = cinemaMapper.selectById(cinemaId);
        if(ObjectUtils.isEmpty(cinema))
            return Result.fail(400,"不存在该影院",null);
        return Result.success(200,"获取当前影院详细信息成功！",cinema);
    }
}




