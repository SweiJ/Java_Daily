package com.swei.summitexam.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-24
 * Time: 17:54
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("paper_exam")
public class PaperExam implements Serializable {
    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer examId;
    private String examTitle;
    private Integer examScore;

    @TableField(exist = false)
    private List<PaperQuestion> list;

    @TableField(exist = false)
    private String[] selectId;
}
