package com.example.bftest.response;

import com.example.bftest.pojo.BfQuestion;
import lombok.Data;

import java.util.List;

/**
 * @Auther: mbp
 * @Date: 2020/4/2 22:35
 * @Description: 写点注释
 */
@Data
public class SearchQuestionResponse {
    private List<BfQuestion> bfQuestionList;
    private Long total;
}
