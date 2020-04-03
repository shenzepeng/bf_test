package com.example.bftest.controller;

import com.example.bftest.common.mbpJsonResult;
import com.example.bftest.request.UpdateAnswerRequest;
import com.example.bftest.response.IntegerResultResponse;
import com.example.bftest.service.AnswerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 12:58
 * @Description: 写点注释
 */
@RestController
@RequestMapping("answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    /**
     * 答题于批改
     */
    @ApiOperation("用于答题或者批改")
    @PostMapping("answer")
    public mbpJsonResult<IntegerResultResponse> answer(@RequestBody @Valid UpdateAnswerRequest request){
        return mbpJsonResult.ok(answerService.updateAnswer(request));
    }


}
