package com.example.bftest.service;

import com.example.bftest.response.GetNewExamResponse;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 15:14
 * @Description: 写点注释
 */
public interface ExamService {
    GetNewExamResponse getExamByUserId(Long userId);
}
