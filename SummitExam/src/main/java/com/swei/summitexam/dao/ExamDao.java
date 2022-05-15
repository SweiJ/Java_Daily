package com.swei.summitexam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swei.summitexam.model.PaperExam;
import com.swei.summitexam.model.PaperExamQuestionRel;
import com.swei.summitexam.model.PaperQuestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-24
 * Time: 18:03
 */
@Mapper
public interface ExamDao extends BaseMapper<PaperExam> {
    @Select("select * from paper_exam")
    List<PaperExam> queryPaperList();

    @Insert("insert into paper_exam (exam_title, exam_score) values (#{examTitle}, #{examScore})")
    @SelectKey(keyColumn = "exam_id", keyProperty = "examId", statement = "select last_insert_id()", before = false, resultType = int.class)
    int insertPaperExam(PaperExam paperexam);

    @Insert("insert into paper_exam_question_rel values (null, #{paperId}, #{quId})")
    void insertPaperQuestion(Integer paperId, String quId);

    @Select("select *from paper_exam where exam_id = #{id}")
    PaperExam selectExamById(String id);

    @Select("select q.* from paper_exam_question_rel er left join paper_question q on er.qu_id = q.qu_id where er.paper_id = #{id}")
    List<PaperQuestion> selectExamQuestionById(String id);
}
