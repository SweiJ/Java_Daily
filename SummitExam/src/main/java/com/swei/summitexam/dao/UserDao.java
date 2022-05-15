package com.swei.summitexam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swei.summitexam.model.PaperQuestion;
import com.swei.summitexam.model.PaperUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-24
 * Time: 14:15
 */
public interface UserDao extends BaseMapper<PaperUser> {

    @Select("select * from paper_question")
    List<PaperQuestion> queryQuestionList();
}
