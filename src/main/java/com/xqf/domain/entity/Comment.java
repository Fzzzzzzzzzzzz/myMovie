package com.xqf.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName t_comment
 */
@TableName(value ="t_comment")
@Data
public class Comment implements Serializable {
    /**
     * 评论id
     */
    @TableId(type = IdType.AUTO)
    private Object commentId;

    /**
     * 用户id
     */
    private Object userId;

    /**
     * 电影id
     */
    private Object movieId;

    /**
     * 用户评分
     */
    private Object userScore;

    /**
     * 用户评论内容
     */
    private String commentContent;

    /**
     * 评论日期
     */
    private Date commentDate;

    /**
     * 点赞数
     */
    private Object supportNum;

    /**
     * 评论是否通过审核
     */
    private Integer isPass;

    /**
     * 点赞用户数组
     */
    private String supportUser;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}