package com.swei.summitexam.service;

import com.swei.summitexam.model.DataMessage;
import com.swei.summitexam.model.PaperExam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-24
 * Time: 18:05
 */
public interface ExamService {

    DataMessage queryPaperList();

    DataMessage queryQuestionList();

    DataMessage add(PaperExam paperExam);

    DataMessage queryPaperById(String id, HttpSession session);

    DataMessage submitPaper(String[] arr, HttpSession session);
}
