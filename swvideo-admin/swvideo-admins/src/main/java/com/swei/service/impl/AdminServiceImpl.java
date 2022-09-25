package com.swei.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.entity.Admin;
import com.swei.mapper.AdminMapper;
import com.swei.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2022-09-17 18:50:20
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
