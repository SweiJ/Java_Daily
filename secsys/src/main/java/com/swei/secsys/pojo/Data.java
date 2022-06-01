package com.swei.secsys.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-06-01
 * Time: 15:20
 */
@lombok.Data
@TableName("data")
public class Data {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String customerName;

    private String customerPhone;

    private double price;

    private LocalDate createTime;
}
