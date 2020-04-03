package com.example.bftest.service.impl;

import com.example.bftest.constants.BfTestConstants;
import com.example.bftest.dao.AnswerDao;
import com.example.bftest.pojo.BfAnswer;
import com.example.bftest.request.UpdateAnswerRequest;
import com.example.bftest.response.IntegerResultResponse;
import com.example.bftest.service.AnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 15:16
 * @Description: 写点注释
 */
@Service
@Slf4j
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerDao answerDao;

    @Override
    public IntegerResultResponse addAnswer(BfAnswer bfAnswer) {
        IntegerResultResponse resultResponse=new IntegerResultResponse();
        resultResponse.setResult(answerDao.addAnswer(bfAnswer));
        return resultResponse;
    }

    @Override
    public IntegerResultResponse updateAnswer(UpdateAnswerRequest request) {
        IntegerResultResponse response=new IntegerResultResponse();
        BfAnswer bfAnswer=new BfAnswer();
        bfAnswer.setCreateTime(new Date());
        bfAnswer.setUpdateTime(new Date());
        BeanUtils.copyProperties(request,bfAnswer);
        if (StringUtils.isEmpty(request.getGrades())){
           bfAnswer.setHasCheck(BfTestConstants.ANSWER_STATUS_INIT);
        }else {
            bfAnswer.setHasCheck(BfTestConstants.ANSWER_STATUS_CHANGED);
        }
        Integer integer = answerDao.updateAnswer(bfAnswer);
        response.setResult(integer);
        return response;
    }

    @Override
    public IntegerResultResponse addAnswerList(List<BfAnswer> bfAnswerList) {
        for (BfAnswer bfAnswer : bfAnswerList) {

            bfAnswer.setCreateTime(new Date());
            bfAnswer.setUpdateTime(new Date());
            answerDao.addAnswer(bfAnswer);
        }
        IntegerResultResponse resultResponse=new IntegerResultResponse();
        resultResponse.setResult(1);
        return resultResponse;
    }
}
