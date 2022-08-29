package com.swei.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-29 11:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagVo {

    private Long id;
    //标签名
    private String name;
}
