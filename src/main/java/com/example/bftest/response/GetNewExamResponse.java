package com.example.bftest.response;

import com.example.bftest.pojo.BfAnswer;
import lombok.Data;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/4 21:48
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class GetNewExamResponse {
    private List<BfAnswer> bfAnswerList;
}
