package com.example.bftest.request;

import lombok.Data;

/**
 * @Auther: szp
 * @Date: 2020/4/2 22:50
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class UpdateQuestionInfoRequest {
    private String question;
    private Long questionId;
}
