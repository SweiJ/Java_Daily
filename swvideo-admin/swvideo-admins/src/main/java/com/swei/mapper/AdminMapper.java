package com.swei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swei.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Admin)表数据库访问层
 *
 * @author makejava
 * @since 2022-09-17 18:50:16
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}
