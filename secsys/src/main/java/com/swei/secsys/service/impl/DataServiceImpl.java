package com.swei.secsys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.secsys.mapper.DataMapper;
import com.swei.secsys.pojo.Data;
import com.swei.secsys.pojo.Res;
import com.swei.secsys.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-06-01
 * Time: 15:31
 */
@Service
public class DataServiceImpl extends ServiceImpl<DataMapper, Data> implements DataService {

    @Autowired
    private DataMapper dataMapper;

    @Override
    public Res addUser(Data data) {
        if (1 == dataMapper.insert(data)) {
            return Res.success("添加成功!");
        }
        return Res.error("添加失败!");
    }

    @Override
    public Res deleteUser() {
        if(1 == dataMapper.deleteById(1)) {
            return Res.success("删除成功!");
        }
        return Res.error("删除失败!");
    }
}
