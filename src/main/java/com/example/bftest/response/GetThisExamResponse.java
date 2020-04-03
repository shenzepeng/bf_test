package com.example.bftest.response;

import com.example.bftest.pojo.BfAnswer;
import lombok.Data;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/2 23:43
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class GetThisExamResponse {
    private List<BfAnswer> bfAnswerList;
}
