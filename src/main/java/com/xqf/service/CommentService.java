package com.xqf.service;

import com.xqf.common.utils.Result;
import com.xqf.domain.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86199
* @description 针对表【t_comment】的数据库操作Service
* @createDate 2022-12-24 10:34:45
*/
public interface CommentService extends IService<Comment> {

    Result getUserComment(Integer movieId, Long userId);
}
