package com.xqf.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName t_movie
 */
@TableName(value ="t_movie")
@Data
public class Movie implements Serializable {
    /**
     * 电影id
     */
    @TableId(type = IdType.AUTO)
    private Object movieId;

    /**
     * 电影名称
     */
    private String name;

    /**
     * 电影海报
     */
    private String poster;

    /**
     * 导演
     */
    private String director;

    /**
     * 主演
     */
    private String actor;

    /**
     * 电影片长
     */
    private String movieLong;

    /**
     * 电影语言版本
     */
    private String language;

    /**
     * 电影简介
     */
    private String intro;

    /**
     * 电影类型
     */
    private String type;

    /**
     * 电影上映时间
     */
    private String publicDate;

    /**
     * 想看人数
     */
    private Object wishNum;

    /**
     * 电影综合评分
     */
    private BigDecimal score;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}