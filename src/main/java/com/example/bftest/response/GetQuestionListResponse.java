package com.example.bftest.response;

import com.example.bftest.dto.StudentGradeDto;
import lombok.Data;

import java.util.List;

/**
 * @Auther: mbp
 * @Date: 2020/4/2 23:48
 * @Description: 写点注释
 */
@Data
public class GetQuestionListResponse {
    private List<StudentGradeDto> studentGradeDtoList;
}

