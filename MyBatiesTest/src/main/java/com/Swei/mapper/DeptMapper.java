package com.Swei.mapper;

import com.Swei.pojo.Dept;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-01-24
 * Time: 19:43
 */
public interface DeptMapper {
    List<Dept> selectAll();
    int insert(Dept dept);
}
