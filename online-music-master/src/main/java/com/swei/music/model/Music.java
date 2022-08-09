package com.swei.music.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-06
 * Time: 20:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    private Integer id;
    private String title;
    private String singer;
    private String time;
    private String url;
    private Integer userid;
}
