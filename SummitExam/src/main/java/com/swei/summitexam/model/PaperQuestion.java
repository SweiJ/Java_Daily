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
 * Date: 2022-05-14
 * Time: 17:26
 */
@Data
@TableName("paper_question")
@EqualsAndHashCode(callSuper = false)
public class PaperQuestion implements Serializable {
    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer quId;
    private String quContent;
    private String quAoption;
    private String quBoption;
    private String quCoption;
    private String quDoption;
    private String quType;
    private Integer quScore;
    private String quAnswer;
}
