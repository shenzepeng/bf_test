package com.example.bftest.controller;

import com.example.bftest.common.mbpJsonResult;
import com.example.bftest.dto.StudentGradeDto;
import com.example.bftest.pojo.BfAnswer;
import com.example.bftest.response.GetAllFinishResponse;
import com.example.bftest.response.GetThisExamResponse;
import com.example.bftest.service.StudentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 22:56
 * @Description: 写点注释
 */
@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 获取所有做过题的列表
     * @param userId
     * @return
     */
    @ApiOperation("获取所有做过题的列表")
    @GetMapping("all/test")
    public mbpJsonResult<GetAllFinishResponse> getAllTest(Long userId){
        return mbpJsonResult.ok(studentService.getList(userId));
    }

    /**
     * 获取本次考试的所有题目
     * @param testId
     * @return
     */
    @ApiOperation("获取本次考试的所有题目")
    @GetMapping("test/info")
    public mbpJsonResult<GetThisExamResponse> getInfoByTestId(Long testId){
        return mbpJsonResult.ok(studentService.findAnswerByTestId(testId));
    }
}
