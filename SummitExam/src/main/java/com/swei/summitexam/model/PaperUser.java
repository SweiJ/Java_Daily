package com.swei.summitexam.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-24
 * Time: 10:14
 */
@Data
@TableName("paper_user")
public class PaperUser {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String userName;
    private String pwd;
}
