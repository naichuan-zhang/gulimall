package com.naichuan.gulimall.order.dao;

import com.naichuan.gulimall.order.entity.PaymentInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 * 
 * @author naichuan
 * @email zhangnaichuan168@gmail.com
 * @date 2021-12-08 21:04:10
 */
@Mapper
public interface PaymentInfoDao extends BaseMapper<PaymentInfoEntity> {
	
}
