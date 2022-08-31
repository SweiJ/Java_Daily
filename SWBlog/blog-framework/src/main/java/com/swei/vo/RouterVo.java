package com.swei.vo;

import com.swei.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-28 19:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouterVo {

    private List<Menu> menus;
}
