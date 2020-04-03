package com.example.bftest.controller;

import com.example.bftest.common.mbpJsonResult;
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
 * @Auther: mbp
 * @Date: 2020/4/1 18:37
 * @Description: 写点注释
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
    public mbpJsonResult<FindNeedWatcherQuestionResponse> getAllQuestion(@RequestBody @Valid FindNeedWatcherQuestionRequest request){
        return mbpJsonResult.ok(teacherService.findNeedWatcher(request));
    }

    /**
     * 模糊搜索
     * @param request
     * @return
     */
    @ApiOperation("模糊搜索题目")
    @PostMapping("search")
    public mbpJsonResult<SearchQuestionResponse> findAllTest(@RequestBody @Valid SearchQuestionRequest request){
        return mbpJsonResult.ok(teacherService.searchQuestionQuestion(request));
    }
    /**
     * 修改题目
     */
    @ApiOperation("老师修改上传之后的题目")
    @PostMapping("update/question")
    public mbpJsonResult<IntegerResultResponse> updateQuestion(@RequestBody @Valid UpdateQuestionInfoRequest request){
        return mbpJsonResult.ok(teacherService.updateQuestionInfoByTeacher(request));
    }
}
