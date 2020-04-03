package com.example.bftest.response;

import com.example.bftest.dto.StudentGradeDto;
import lombok.Data;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/2 23:48
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class GetQuestionListResponse {
    private List<StudentGradeDto> studentGradeDtoList;
}

