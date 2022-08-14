package com.swei.music.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-10
 * Time: 20:45
 * @author SweiPC
 */
@Data
@TableName("resource")
public class Resource implements Serializable {

    private static final long serialVersionUID = 2L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String path;
    private String name;
    /**
     * 类型。0为菜单，1为接口
     */
    private Integer type;

    @TableField(exist = false)
    private List<Role> roles;
}
