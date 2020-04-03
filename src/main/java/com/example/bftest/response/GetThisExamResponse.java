package com.example.bftest.response;

import com.example.bftest.pojo.BfAnswer;
import lombok.Data;

import java.util.List;

/**
 * @Auther: mbp
 * @Date: 2020/4/2 23:43
 * @Description: 写点注释
 */
@Data
public class GetThisExamResponse {
    private List<BfAnswer> bfAnswerList;
}
