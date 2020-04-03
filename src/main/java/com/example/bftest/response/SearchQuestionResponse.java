package com.example.bftest.response;

import com.example.bftest.pojo.BfQuestion;
import lombok.Data;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/2 22:35
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class SearchQuestionResponse {
    private List<BfQuestion> bfQuestionList;
    private Long total;
}
