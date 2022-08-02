package com.swei.blogs.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-07-25
 * Time: 21:46
 */
@Data
public class Blog {
    private Integer blogId;
    private String title;
    private String content;
    private Integer userId;
    // 注意, 此处不能使用 java.sql.Date(这个类只有年月日, 没有时分秒)
// 而应该使用 java.sql.TimeStamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp postTime;
}
