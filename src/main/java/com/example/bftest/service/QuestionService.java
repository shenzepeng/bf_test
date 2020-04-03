package com.example.bftest.service;

import com.example.bftest.pojo.BfQuestion;
import com.example.bftest.request.AddQuestionRequest;
import com.example.bftest.request.UpdateQuestionRequest;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/1 15:14
 * @Description: 沈泽鹏写点注释吧
 */
public interface QuestionService {
    Integer addQuestion(AddQuestionRequest request);
    Integer updateQuestion(UpdateQuestionRequest request);
    Integer deleteQuestion(Long id);
    Integer addQuestionByFileList(List<BfQuestion> list);
}
