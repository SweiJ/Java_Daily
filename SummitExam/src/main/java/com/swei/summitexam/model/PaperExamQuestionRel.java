package com.swei.summitexam.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-15
 * Time: 9:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("paper_exam_question_rel")
public class PaperExamQuestionRel implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer pqId;
    private Integer paperId;
    private Integer quId;
}
