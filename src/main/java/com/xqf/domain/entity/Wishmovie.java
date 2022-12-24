package com.xqf.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_wishmovie
 */
@TableName(value ="t_wishmovie")
@Data
public class Wishmovie implements Serializable {
    /**
     * 想看电影id
     */
    @TableId(type = IdType.AUTO)
    private Object wishmovieId;

    /**
     * 用户id
     */
    private Object userId;

    /**
     * 电影id
     */
    private Object movieId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}