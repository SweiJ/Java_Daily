package com.swei.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-30 14:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleVo {
    //角色ID
    private Long id;
    //角色名称
    private String roleName;
    //角色状态（0正常 1停用）
    private String status;
}
