package com.example.bftest.service.impl;

import com.example.bftest.constants.BfTestConstants;
import com.example.bftest.dao.AnswerDao;
import com.example.bftest.dao.ExamDao;
import com.example.bftest.dao.QuestionDao;
import com.example.bftest.pojo.BfAnswer;
import com.example.bftest.pojo.BfExam;
import com.example.bftest.pojo.BfQuestion;
import com.example.bftest.service.ExamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 15:17
 * @Description: 写点注释
 */
@Service
@Slf4j
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamDao examDao;
    @Autowired
    private AnswerDao answerDao;
    @Autowired
    private QuestionDao questionDao;

    @Override
    public Integer getExamByUserId(Long userId) {
        //1 先看该学生是否有没做完的题,或者未批改的题,存在没有做的的题返回异常
        List<BfAnswer> answerByUserId = answerDao.findAnswerByUserId(userId);
        Integer size = answerByUserId.stream()
                .filter(t -> !StringUtils.isEmpty(t.getUserAnswer()))
                .filter(t -> t.getGrades() != null)
                .collect(Collectors.toList())
                .size();
        if (size!=answerByUserId.size()){
            return 0;
        }
        //2.如果没有则课获取新的题
        //3.优先不获取之前做过的题
        List<BfQuestion> questionIds = getQuestionIds();
        //创建新的考试，然后将试题进入题库关联表
        BfExam bfExam=new BfExam();
        bfExam.setUserId(userId);
        bfExam.setCreateTime(new Date());
        bfExam.setUpdateTime(new Date());
        examDao.addExam(bfExam);
        //题目
        List<BfAnswer> bfAnswerList = questionIds
                .stream()
                .map(t -> new BfAnswer(t.getId(),userId, BfTestConstants.ANSWER_STATUS_INIT,new Date(),new Date(),bfExam.getId()))
                .collect(Collectors.toList());

        for (BfAnswer bfAnswer : bfAnswerList) {
            answerDao.addAnswer(bfAnswer);
        }
        return 1;
    }
    //获取10到新题
    private List<BfQuestion> getQuestionIds(){
        List<BfQuestion> all = questionDao.findAll();
        if (all.size()<10){
            throw new RuntimeException("当前题库不够10道题");
        }
        HashSet<Long> hashSet=new HashSet<>();
        while (true){
            if (hashSet.size()<10){
                Long id=(long)(Math.random()*all.size());
                hashSet.add(id);
            }else {
                break;
            }
        }
        List<BfQuestion> collect = all
                .stream()
                .filter(t -> hashSet.contains(t.getId()))
                .collect(Collectors.toList());
        return collect;
    }
}
