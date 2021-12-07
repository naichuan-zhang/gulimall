package com.naichuan.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.naichuan.common.utils.PageUtils;
import com.naichuan.gulimall.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author naichuan
 * @email zhangnaichuan168@gmail.com
 * @date 2021-12-07 20:38:33
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

