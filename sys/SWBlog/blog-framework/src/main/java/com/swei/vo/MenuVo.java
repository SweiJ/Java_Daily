package com.swei.vo;

import com.swei.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-30 11:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class MenuVo {
    private Long id;
    private String label;
    private List<MenuVo> menus;
    private List<MenuVo> children;
}
