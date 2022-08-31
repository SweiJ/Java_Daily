package com.swei.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-28 15:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserInfoVo {
    private List<String> permissions;

    private List<String> roles;

    private UserInfoVo user;
}
