package com.example.bftest.service.impl;

import com.example.bftest.dao.QuestionDao;
import com.example.bftest.pojo.BfQuestion;
import com.example.bftest.request.AddQuestionRequest;
import com.example.bftest.request.UpdateQuestionRequest;
import com.example.bftest.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/1 15:17
 * @Description: 沈泽鹏写点注释吧
 */
@Slf4j
@Service
public class QuestionSerivceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;


    @Override
    public Integer addQuestion(AddQuestionRequest request) {
        BfQuestion bfQuestion=new BfQuestion();
        bfQuestion.setCreateTime(new Date());
        bfQuestion.setUpdateTime(new Date());
        BeanUtils.copyProperties(request,bfQuestion);
        return questionDao.addQuestion(bfQuestion);
    }

    @Override
    public Integer updateQuestion(UpdateQuestionRequest request) {
        BfQuestion bfQuestion=new BfQuestion();
        bfQuestion.setUpdateTime(new Date());
        BeanUtils.copyProperties(request,bfQuestion);
        return questionDao.updateQuestion(bfQuestion);
    }

    @Override
    public Integer deleteQuestion(Long id) {
        return questionDao.deleteQuestion(id);
    }

    @Override
    public Integer addQuestionByFileList(List<BfQuestion> list) {
        for (BfQuestion bfQuestion : list) {
            bfQuestion.setUpdateTime(new Date());
            bfQuestion.setCreateTime(new Date());
            questionDao.addQuestion(bfQuestion);
        }
        return 1;
    }
}
