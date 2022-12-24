package com.xqf.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_hall
 */
@TableName(value ="t_hall")
@Data
public class Hall implements Serializable {
    /**
     * 影厅id
     */
    @TableId(type = IdType.AUTO)
    private Object hallId;

    /**
     * 影院id
     */
    private Object cinemaId;

    /**
     * 影厅名称
     */
    private String name;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}