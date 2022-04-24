package com.swei.summitexam.service;

import com.swei.summitexam.model.Paperexam;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-24
 * Time: 18:05
 */
public interface ExamService {
    Map<String, Object> addexam(Paperexam paperexam);
}
