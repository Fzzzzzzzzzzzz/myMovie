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
 * @TableName t_order
 */
@TableName(value ="t_order")
@Data
public class Order implements Serializable {
    /**
     * 订单id
     */
    @TableId(type = IdType.AUTO)
    private Object orderId;

    /**
     * 用户id
     */
    private Object userId;

    /**
     * 影院id
     */
    private Object scheduleId;

    /**
     * 下单手机
     */
    private String orderPhone;

    /**
     * 用户下单时间
     */
    private String orderDate;

    /**
     * 购买电影票数
     */
    private Object ticketNum;

    /**
     * 电影票单价
     */
    private BigDecimal ticketTotalPrice;

    /**
     * 座位信息
     */
    private String orderSeatInfo;

    /**
     * 支付方式
     */
    private String payType;

    /**
     * 手机取票码
     */
    private String phoneCode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}