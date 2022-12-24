package com.xqf.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_user
 */
@TableName(value ="t_user")
@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户手机号码
     */
    private String phone;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 用户出生年月日
     */
    private String birthday;

    /**
     * 用户签名
     */
    private String sign;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}