package com.xqf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xqf.domain.entity.Order;
import com.xqf.service.OrderService;
import com.xqf.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author 86199
* @description 针对表【t_order】的数据库操作Service实现
* @createDate 2022-12-24 10:34:45
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}




