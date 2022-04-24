package com.swei.summitexam.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-24
 * Time: 10:14
 */
@Data
public class Paperuser {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String userName;
    private String pwd;
}
