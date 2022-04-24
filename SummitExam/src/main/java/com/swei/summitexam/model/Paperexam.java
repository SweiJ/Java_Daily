package com.swei.summitexam.model;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-24
 * Time: 17:54
 */
@Data
public class Paperexam {
    private Integer id;
    private String examType;
    private String examContent;
    private String examAnswer;
    private Boolean examScore;
}
