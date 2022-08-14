package com.swei.music.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-10
 * Time: 20:47
 */
@Data
@TableName("role")
public class Role implements Serializable {
    private static final long serialVersionUID = 3L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;
}
