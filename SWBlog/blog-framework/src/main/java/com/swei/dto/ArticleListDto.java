package com.swei.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-29 9:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleListDto {

    //标题
    private String title;
    //文章摘要
    private String summary;
}
