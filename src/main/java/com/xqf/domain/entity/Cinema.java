package com.xqf.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_cinema
 */
@TableName(value ="t_cinema")
@Data
public class Cinema implements Serializable {
    /**
     * 影院id
     */
    @TableId(type = IdType.AUTO)
    private Object cinemaId;

    /**
     * 影院名称
     */
    private String cinemaName;

    /**
     * 影院电话
     */
    private String cinemaPhone;

    /**
     * 影院所在省份
     */
    private String province;

    /**
     * 影院所在市
     */
    private String city;

    /**
     * 影院所在区县
     */
    private String county;

    /**
     * 影院详细地址
     */
    private String specifiedAddress;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}