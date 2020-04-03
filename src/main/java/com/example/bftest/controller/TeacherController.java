package com.example.bftest.controller;

import com.example.bftest.common.SzpJsonResult;
import com.example.bftest.request.FindNeedWatcherQuestionRequest;
import com.example.bftest.request.SearchQuestionRequest;
import com.example.bftest.request.UpdateQuestionByTeacherRequest;
import com.example.bftest.request.UpdateQuestionInfoRequest;
import com.example.bftest.response.FindNeedWatcherQuestionResponse;
import com.example.bftest.response.IntegerResultResponse;
import com.example.bftest.response.NeedWatcherQuestion;
import com.example.bftest.response.SearchQuestionResponse;
import com.example.bftest.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/1 18:37
 * @Description: 沈泽鹏写点注释吧
 */
@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /**
     * 所有需要修改的题目
     */
    @ApiOperation("所有需要批改的题目")
    @PostMapping("all/question")
    public SzpJsonResult<FindNeedWatcherQuestionResponse> getAllQuestion(@RequestBody @Valid FindNeedWatcherQuestionRequest request){
        return SzpJsonResult.ok(teacherService.findNeedWatcher(request));
    }

    /**
     * 模糊搜索
     * @param request
     * @return
     */
    @ApiOperation("模糊搜索题目")
    @PostMapping("search")
    public SzpJsonResult<SearchQuestionResponse> findAllTest(@RequestBody @Valid SearchQuestionRequest request){
        return SzpJsonResult.ok(teacherService.searchQuestionQuestion(request));
    }
    /**
     * 修改题目
     */
    @ApiOperation("老师修改上传之后的题目")
    @PostMapping("update/question")
    public SzpJsonResult<IntegerResultResponse> updateQuestion(@RequestBody @Valid UpdateQuestionInfoRequest request){
        return SzpJsonResult.ok(teacherService.updateQuestionInfoByTeacher(request));
    }
}
