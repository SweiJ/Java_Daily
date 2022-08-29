package com.swei.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-29 18:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleListDto {
    //角色名称
    private String roleName;

    private String status;
}
