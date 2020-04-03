package com.example.bftest.service.impl;

import com.example.bftest.dao.QuestionDao;
import com.example.bftest.mapper.BfQuestionMapper;
import com.example.bftest.pojo.BfQuestion;
import com.example.bftest.request.AddQuestionRequest;
import com.example.bftest.request.UpdateQuestionRequest;
import com.example.bftest.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 15:17
 * @Description: 写点注释
 */
@Slf4j
@Service
public class QuestionSerivceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private BfQuestionMapper mapper;

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
        if (CollectionUtils.isEmpty(list)){
            throw new RuntimeException("上传题目有问题，文件为空，或者文件中没有内容");
        }
        for (BfQuestion bfQuestion : list) {
            bfQuestion.setUpdateTime(new Date());
            bfQuestion.setCreateTime(new Date());
        }
        //mapper.insertList(list);
        return mapper.insertList(list);
    }
}
