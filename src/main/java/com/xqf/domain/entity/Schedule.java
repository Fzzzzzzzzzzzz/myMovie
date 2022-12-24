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
 * @TableName t_schedule
 */
@TableName(value ="t_schedule")
@Data
public class Schedule implements Serializable {
    /**
     * 排片id
     */
    @TableId(type = IdType.AUTO)
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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}