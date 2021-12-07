package com.naichuan.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.naichuan.common.utils.PageUtils;
import com.naichuan.gulimall.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author naichuan
 * @email zhangnaichuan168@gmail.com
 * @date 2021-12-07 20:38:33
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

