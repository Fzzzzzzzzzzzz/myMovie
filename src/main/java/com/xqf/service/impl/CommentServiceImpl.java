package com.xqf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xqf.common.utils.Result;
import com.xqf.domain.entity.Comment;
import com.xqf.service.CommentService;
import com.xqf.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 86199
* @description 针对表【t_comment】的数据库操作Service实现
* @createDate 2022-12-24 10:34:45
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

    @Resource
    private CommentMapper commentMapper;

    @Override
    public Result getUserComment(Integer movieId, Long userId) {
        List<Comment> commentsList = commentMapper.selectList(new LambdaQueryWrapper<Comment>().eq(Comment::getMovieId, movieId)
                .eq(Comment::getUserId, userId));
        if (commentsList.size()==0)
            return Result.fail(201,"该用户还没有评论！",commentsList);

        return Result.success(200,"获取用户评论成功",commentsList);
    }
}




