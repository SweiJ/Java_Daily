package com.swei.ordermeal.model;

import lombok.Data;
import org.springframework.boot.SpringApplicationRunListener;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-18 20:05
 */
@Data
public class resource {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String url;

    private String name;

    private Integer status;
}
