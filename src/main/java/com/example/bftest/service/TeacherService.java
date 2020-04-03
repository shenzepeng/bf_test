package com.example.bftest.service;

import com.example.bftest.request.FindNeedWatcherQuestionRequest;
import com.example.bftest.request.SearchQuestionRequest;
import com.example.bftest.request.UpdateQuestionInfoRequest;
import com.example.bftest.response.FindNeedWatcherQuestionResponse;
import com.example.bftest.response.IntegerResultResponse;
import com.example.bftest.response.NeedWatcherQuestion;
import com.example.bftest.response.SearchQuestionResponse;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/1 18:41
 * @Description: 沈泽鹏写点注释吧
 */

public interface TeacherService {
    /**
     * 需要批改的题目
     * @param request
     * @return
     */
    FindNeedWatcherQuestionResponse findNeedWatcher(FindNeedWatcherQuestionRequest request);
    /**
     * 搜索题目
     */
    SearchQuestionResponse searchQuestionQuestion(SearchQuestionRequest request);

    /**
     * 更新题目，如果当前题目已经被选择或者被做答，怎不能修改
     */
    IntegerResultResponse updateQuestionInfoByTeacher(UpdateQuestionInfoRequest request);
}
