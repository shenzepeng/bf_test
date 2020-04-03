package com.example.bftest.controller;

import com.example.bftest.common.mbpJsonResult;
import com.example.bftest.dto.StudentGradeDto;
import com.example.bftest.response.GetAllFinishResponse;
import com.example.bftest.response.GetQuestionListResponse;
import com.example.bftest.service.StudentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    /**
     * 参加考试
     * 获取试题
     */
    @ApiOperation("参加考试,获取试题")
    @GetMapping("get/userId")
    public mbpJsonResult<GetAllFinishResponse> getTest(Long userId){
        return mbpJsonResult.ok(studentService.getList(userId));
    }
}
