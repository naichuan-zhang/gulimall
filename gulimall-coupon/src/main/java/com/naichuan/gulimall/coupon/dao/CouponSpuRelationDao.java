package com.naichuan.gulimall.coupon.dao;

import com.naichuan.gulimall.coupon.entity.CouponSpuRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券与产品关联
 * 
 * @author naichuan
 * @email zhangnaichuan168@gmail.com
 * @date 2021-12-08 20:54:20
 */
@Mapper
public interface CouponSpuRelationDao extends BaseMapper<CouponSpuRelationEntity> {
	
}
