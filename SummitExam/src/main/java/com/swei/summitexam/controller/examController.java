package com.swei.summitexam.controller;

import com.swei.summitexam.model.DataMessage;
import com.swei.summitexam.model.PaperExam;
import com.swei.summitexam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Arrays;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-24
 * Time: 17:51
 */
@RequestMapping("/paper-exam")
@RestController
public class examController {

    @Autowired
    private ExamService examService;

    @RequestMapping("/add")
    public DataMessage add(PaperExam paperExam) {
        System.out.println(paperExam);
        System.out.println(Arrays.toString(paperExam.getSelectId()));
        return examService.add(paperExam);
    }

    @RequestMapping("/queryPaperList")
    public DataMessage queryPaperList() {
        return examService.queryPaperList();
    }

    @RequestMapping("/queryQuestionList")
    public DataMessage queryQuestionList() {
        return examService.queryQuestionList();
    }

    @RequestMapping("/queryPaperById")
    public DataMessage queryPaperById(String id, HttpSession session) {
        return examService.queryPaperById(id, session);
    }

    @RequestMapping("/submitPaper")
    public DataMessage submitPaper(@RequestParam("arr[]") String[] arr, HttpSession session) {
        return examService.submitPaper(arr, session);
    }
}
