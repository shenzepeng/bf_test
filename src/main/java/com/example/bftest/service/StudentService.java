package com.example.bftest.service;

import com.example.bftest.dto.StudentGradeDto;
import com.example.bftest.pojo.BfAnswer;
import com.example.bftest.response.GetAllFinishResponse;
import com.example.bftest.response.GetThisExamResponse;

import java.util.List;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 22:59
 * @Description: 写点注释
 */
public interface StudentService {
    /**
     * 获取学生成绩
     * @param userId
     * @return
     */
    GetAllFinishResponse getList(Long userId);

    /**
     * 通过考试id找到答案
     * @param testId
     * @return
     */
    GetThisExamResponse findAnswerByTestId(Long testId);
}
