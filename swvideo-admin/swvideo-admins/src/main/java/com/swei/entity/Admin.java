package com.swei.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * (Admin)表实体类
 *
 * @author makejava
 * @since 2022-09-17 18:50:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("admin")
@SuppressWarnings("serial")
public class Admin {
    //用户id    @TableId
    private Integer id;
    //用户名
    private String username;
    //用户密码
    private String password;
    //用户头像地址
    private String avatar;
    //创建时间
    private Date createdAt;
    //更新时间
    private Date updatedAt;
    //删除时间
    private Date deletedAt;
}

