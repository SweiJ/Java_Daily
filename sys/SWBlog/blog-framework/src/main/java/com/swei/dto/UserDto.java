package com.swei.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-30 15:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String userName;

    private String password;
}
