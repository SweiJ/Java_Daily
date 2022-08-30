package com.swei.vo;

import com.swei.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-30 15:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    private User user;

    // 当前用户拥有的角色
    private List<RoleVo> roles;
    // 当前用户拥有的所有角色id
    private List<String> roleIds;
    private String password;
}
