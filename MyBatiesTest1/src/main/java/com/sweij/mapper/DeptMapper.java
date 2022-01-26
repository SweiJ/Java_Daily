package com.sweij.mapper;

import com.sweij.pojo.Dept;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-01-26
 * Time: 15:17
 */
public interface DeptMapper {
    List<Dept> selectMore(int deptno, String loc);
}
