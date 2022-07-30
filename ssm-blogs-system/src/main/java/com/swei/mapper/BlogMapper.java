package com.swei.mapper;

import com.swei.model.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-07-25
 * Time: 21:47
 */
@Mapper
public interface BlogMapper {

    List<Blog> getAllBlogs(@Param("userId") Integer userId);

}
