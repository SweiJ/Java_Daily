package com.swei.summitexam.service.Impl;

import com.swei.summitexam.dao.ExamDao;
import com.swei.summitexam.dao.UserDao;
import com.swei.summitexam.model.DataMessage;
import com.swei.summitexam.model.PaperExam;
import com.swei.summitexam.model.PaperExamQuestionRel;
import com.swei.summitexam.model.PaperQuestion;
import com.swei.summitexam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-24
 * Time: 18:05
 */
@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamDao examDao;

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public DataMessage add(PaperExam paperexam) {
        DataMessage message = new DataMessage();
        // 插入试卷
        examDao.insertPaperExam(paperexam);
        // 该试卷和试卷类型建立关系
        for (String s : paperexam.getSelectId()) {
            examDao.insertPaperQuestion(paperexam.getExamId(), s);
        }
        message.setSuccess(true);
        return message;
    }

    @Override
    public DataMessage queryPaperById(String id, HttpSession session) {
        DataMessage message = new DataMessage();
        Map<String, Object> map = new HashMap<>();
        // 试卷的标题和分数
        PaperExam paperExam = examDao.selectExamById(id);

        List<PaperQuestion> list = examDao.selectExamQuestionById(id);
        session.setAttribute("paper", list);
        List<PaperQuestion> signList = new ArrayList<>();
        List<PaperQuestion> moreList = new ArrayList<>();
        List<PaperQuestion> judgeList = new ArrayList<>();

        for (PaperQuestion paperQuestion : list) {
            if("单选题".equals(paperQuestion.getQuType())) {
                signList.add(paperQuestion);
            } else if("多选题".equals(paperQuestion.getQuType())) {
                moreList.add(paperQuestion);
            } else {
                judgeList.add(paperQuestion);
            }
        }
        map.put("name", paperExam.getExamTitle());
        map.put("score", paperExam.getExamScore());
        map.put("signList", signList);
        map.put("moreList", moreList);
        map.put("judgeList", judgeList);

        message.setSuccess(true);
        message.setData(map);
        return message;
    }

    @Override
    public DataMessage submitPaper(String[] arr, HttpSession session) {
        List<PaperQuestion> list = (List<PaperQuestion>) session.getAttribute("paper");
        ArrayList<Object> listAnswer = new ArrayList<>();
        ArrayList<Object> listNo = new ArrayList<>();
        for (String s : arr) {
            String[] ss = s.split("#");
            listNo.add(Integer.parseInt(ss[0]));
            listAnswer.add(ss[1]);
        }
        int score = 0;
        for (PaperQuestion paperQuestion : list) {
            for (int i = 0; i < listNo.size(); i++) {
                if(paperQuestion.getQuId() == listNo.get(i)) {
                    if(paperQuestion.getQuAnswer().equals(listAnswer.get(i))) {
                        score = score+paperQuestion.getQuScore();
                    }
                }
            }
        }
        DataMessage message = new DataMessage();
        message.setData(score);
        return message;
    }

    @Override
    public DataMessage queryPaperList() {
        DataMessage message = new DataMessage();
        List<PaperExam> userexam = examDao.queryPaperList();

        message.setSuccess(true);
        message.setData(userexam);
        return message;
    }

    @Override
    public DataMessage queryQuestionList() {
        DataMessage message = new DataMessage();
        List<PaperQuestion> paperquestion = userDao.queryQuestionList();

        message.setSuccess(true);
        message.setData(paperquestion);
        return message;
    }

}
