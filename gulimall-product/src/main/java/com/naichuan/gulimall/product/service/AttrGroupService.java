package com.naichuan.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.naichuan.common.utils.PageUtils;
import com.naichuan.gulimall.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author naichuan
 * @email zhangnaichuan168@gmail.com
 * @date 2021-12-07 20:38:33
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

