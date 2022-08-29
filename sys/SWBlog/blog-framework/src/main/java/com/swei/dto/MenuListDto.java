package com.swei.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-29 18:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuListDto {

    //菜单名称
    private String menuName;
    private String status;
}
