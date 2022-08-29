package com.swei.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-29 10:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryListDto {

    private String name;
    //状态0:正常,1禁用
    private String status;
}
