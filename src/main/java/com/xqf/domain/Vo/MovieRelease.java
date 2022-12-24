package com.xqf.domain.Vo;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class MovieRelease {

    private Object scheduleId;

    /**
     * 电影id
     */
    private Object movieId;

    /**
     * 影院id
     */
    private Object cinemaId;

    /**
     * 影厅名字
     */
    private String hallName;

    /**
     * 放映日期
     */
    private String showDate;

    /**
     * 放映时间
     */
    private String showTime;

    /**
     * 电影售价
     */
    private BigDecimal price;

    /**
     * 座位信息
     */
    private String seatInfo;

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
}
