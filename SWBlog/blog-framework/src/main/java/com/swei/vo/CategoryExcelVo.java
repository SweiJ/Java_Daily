package com.swei.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-30 17:59
 */
@Data
public class CategoryExcelVo implements Serializable {

    private static final long serialVersionUID = 1L;

    //分类名
    @ExcelProperty("分类名称")
    private String name;

    //父分类id，如果没有父分类为-1
    private Long pid;
    //描述
    @ExcelProperty("分类描述")
    private String description;
    //状态0:正常,1禁用
    @ExcelProperty("分类状态")
    private String status;

    @ExcelProperty("创建人")
    private Long createBy;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("更新人")
    private Long updateBy;

    @ExcelProperty("更新时间")
    private Date updateTime;

    //删除标志（0代表未删除，1代表已删除）
    @ExcelProperty("删除标记")
    private Integer delFlag;
}
