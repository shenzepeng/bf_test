package com.example.bftest.service.impl;

import com.example.bftest.dao.AnswerDao;
import com.example.bftest.dao.ExamDao;
import com.example.bftest.dao.QuestionDao;
import com.example.bftest.pojo.BfAnswer;
import com.example.bftest.pojo.BfQuestion;
import com.example.bftest.request.FindNeedWatcherQuestionRequest;
import com.example.bftest.request.SearchQuestionRequest;
import com.example.bftest.request.UpdateQuestionInfoRequest;
import com.example.bftest.response.FindNeedWatcherQuestionResponse;
import com.example.bftest.response.IntegerResultResponse;
import com.example.bftest.response.NeedWatcherQuestion;
import com.example.bftest.response.SearchQuestionResponse;
import com.example.bftest.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther: szp
 * @Date: 2020/4/1 18:50
 * @Description: 老师业务逻辑
 */
@Service
public class TeacherServceImpl implements TeacherService {
    @Autowired
    private ExamDao examDao;
    @Autowired
    private AnswerDao answerDao;
    @Autowired
    private QuestionDao questionDao;
    @Override
    public FindNeedWatcherQuestionResponse findNeedWatcher(FindNeedWatcherQuestionRequest request) {
        FindNeedWatcherQuestionResponse response=new FindNeedWatcherQuestionResponse();
        //拿到这个老师所有的题目
        List<BfQuestion> byTeacherId = questionDao.findByTeacherId(request.getTeacherId());
        List<Long> ids = byTeacherId.stream()
                .map(BfQuestion::getId)
                .collect(Collectors.toList());
        Map<Long, String> question = byTeacherId.stream().collect(Collectors.toMap(BfQuestion::getId, BfQuestion::getQuestion,(k1,k2)->k2));
        //那看那些题目在当前考生中
        //分页
        PageHelper.startPage(request.getPageNumber(),request.getPageSize());
        List<BfAnswer> answerByQuestionId = answerDao.findAnswerByQuestionId(ids);
        PageInfo<BfAnswer> pageInfo = new PageInfo<>(answerByQuestionId);
        List<NeedWatcherQuestion> collect = pageInfo.getList()
                .stream()
                .map(t -> new NeedWatcherQuestion(t.getTestId(), t.getQuestionId(),question.get(t.getQuestionId()), t.getUserAnswer()))
                .collect(Collectors.toList());
        response.setNeedWatcherQuestionList(collect);
        response.setTotal(pageInfo.getTotal());
        return response;
    }

    @Override
    public SearchQuestionResponse searchQuestionQuestion(SearchQuestionRequest request) {
        SearchQuestionResponse response=new SearchQuestionResponse();
        PageHelper.startPage(request.getPageNumber(),request.getPageSize());
        List<BfQuestion> bfQuestions = questionDao.searchBfQuestionByTeacher(request.getTeacherId(), request.getQuestion());
        PageInfo<BfQuestion> pageInfo = new PageInfo<>(bfQuestions);
        response.setBfQuestionList(pageInfo.getList());
        response.setTotal(pageInfo.getTotal());
        return response;
    }

    /**
     * 更新已近上传的题目
     * @param request
     * @return
     */
    @Override
    public IntegerResultResponse updateQuestionInfoByTeacher(UpdateQuestionInfoRequest request) {
        IntegerResultResponse resultResponse=new IntegerResultResponse();
        Long questionId = request.getQuestionId();
        List<BfAnswer> bfAnswerByQuestionId = answerDao.findBfAnswerByQuestionId(questionId);
        if (!CollectionUtils.isEmpty(bfAnswerByQuestionId)){
            throw new RuntimeException("当前题目正在被做答，无法修改");
        }
        BfQuestion bfQuestion=new BfQuestion();
        bfQuestion.setId(request.getQuestionId());
        bfQuestion.setQuestion(request.getQuestion());
        bfQuestion.setUpdateTime(new Date());
        resultResponse.setResult(questionDao.updateQuestion(bfQuestion));
        return   resultResponse;
    }
}
