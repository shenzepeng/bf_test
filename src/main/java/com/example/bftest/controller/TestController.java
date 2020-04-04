package com.example.bftest.controller;

import com.example.bftest.common.SzpJsonResult;
import com.example.bftest.response.GetNewExamResponse;
import com.example.bftest.service.ExamService;
import com.example.bftest.service.StudentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 12:57
 * @Description: 写点注释
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ExamService examService;
    /**
     * 参加考试
     * 获取试题
     * @return
     */
    @ApiOperation("拿到所有做过的题")
    @GetMapping("get/userId")
    public SzpJsonResult getTest(Long userId){
        return SzpJsonResult.ok(studentService.getList(userId));
    }
    @ApiOperation("获取新的题目")
    @GetMapping("find/exam/info")
    public SzpJsonResult<GetNewExamResponse> findExamInfo(Long userId){
        return SzpJsonResult.ok(examService.getExamByUserId(userId));
    }
}
