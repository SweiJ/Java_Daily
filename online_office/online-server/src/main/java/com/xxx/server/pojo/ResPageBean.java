package com.xxx.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 分页公共返回对象
 * User: SweiPC
 * Date: 2022-05-16
 * Time: 10:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResPageBean {
    /**
     * 总条数
     */
    private Long total;
    /**
     * 数据
     */
    private List<?> data;
}
