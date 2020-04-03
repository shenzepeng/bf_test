package com.example.bftest.service;

import com.example.bftest.pojo.BfAnswer;
import com.example.bftest.request.UpdateAnswerRequest;
import com.example.bftest.response.IntegerResultResponse;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/1 15:14
 * @Description: 沈泽鹏写点注释吧
 */
public interface AnswerService {
    IntegerResultResponse addAnswer(BfAnswer bfAnswer);
    IntegerResultResponse updateAnswer(UpdateAnswerRequest request);
    IntegerResultResponse addAnswerList(List<BfAnswer> bfAnswerList);
}
