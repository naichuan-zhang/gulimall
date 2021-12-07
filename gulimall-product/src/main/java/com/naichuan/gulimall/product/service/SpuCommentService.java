package com.naichuan.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.naichuan.common.utils.PageUtils;
import com.naichuan.gulimall.product.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author naichuan
 * @email zhangnaichuan168@gmail.com
 * @date 2021-12-07 20:38:33
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

