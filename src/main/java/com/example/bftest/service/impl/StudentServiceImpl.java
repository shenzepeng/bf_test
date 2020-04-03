package com.example.bftest.service.impl;

import com.example.bftest.constants.BfTestConstants;
import com.example.bftest.dao.AnswerDao;
import com.example.bftest.dao.ExamDao;
import com.example.bftest.dto.StudentGradeDto;
import com.example.bftest.pojo.BfAnswer;
import com.example.bftest.pojo.BfExam;
import com.example.bftest.response.GetAllFinishResponse;
import com.example.bftest.response.GetThisExamResponse;
import com.example.bftest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Auther: szp
 * @Date: 2020/4/1 23:03
 * @Description: 沈泽鹏写点注释吧
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private ExamDao examDao;
    @Autowired
    private AnswerDao answerDao;
    //获取学生所有的试题
    @Override
    public GetAllFinishResponse getList(Long userId) {
        GetAllFinishResponse response=new GetAllFinishResponse();
        List<BfExam> examByUserId = examDao.findExamByUserId(userId);
        //所有考试
        List<Long> collect = examByUserId
                .stream()
                .map(t -> t.getId())
                .collect(Collectors.toList());
        //当前做过的所有试题
        List<BfAnswer> answerByTestId = answerDao.findAnswerByTestId(collect);

        List<StudentGradeDto> studentList = answerByTestId.stream().map(new Function<BfAnswer, StudentGradeDto>() {
            @Override
            public StudentGradeDto apply(BfAnswer bfAnswer) {
                StudentGradeDto studentGradeDto = new StudentGradeDto();
                Long testId = bfAnswer.getTestId();
                Integer grade=0;
                Integer counts=0;
                //本次考试的题目
                List<BfAnswer> b = answerByTestId.stream().filter(t -> t.getTestId().equals(testId)).collect(Collectors.toList());
                for (BfAnswer answer : b) {
                    if (null!=answer.getGrades()) {
                        grade = grade + answer.getGrades();
                    }
                    if (answer.getHasCheck().equals(BfTestConstants.ANSWER_STATUS_CHANGED)){
                        counts=counts+1;
                    }
                }
                studentGradeDto.setGrades(grade);
                studentGradeDto.setContext(String.format(BfTestConstants.url,counts));
                studentGradeDto.setTestId(testId);
                return studentGradeDto;
            }
        }).collect(Collectors.toList());
        response.setStudentGradeDtoList(studentList);
        return response;
    }

    @Override
    public GetThisExamResponse findAnswerByTestId(Long testId) {
        GetThisExamResponse response=new GetThisExamResponse();
        List<BfAnswer> answerByTestId = answerDao.findAnswerByTestId(testId);
        response.setBfAnswerList(answerByTestId);
        return response;
    }
}
