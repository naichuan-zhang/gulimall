package com.naichuan.gulimall.member.dao;

import com.naichuan.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author naichuan
 * @email zhangnaichuan168@gmail.com
 * @date 2021-12-08 21:01:39
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
