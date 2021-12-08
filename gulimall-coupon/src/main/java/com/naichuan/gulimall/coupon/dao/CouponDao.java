package com.naichuan.gulimall.coupon.dao;

import com.naichuan.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author naichuan
 * @email zhangnaichuan168@gmail.com
 * @date 2021-12-08 20:54:19
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
