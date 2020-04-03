package com.example.bftest.request;

import lombok.Data;

/**
 * @Auther: mbp
 * @Date: 2020/4/2 22:50
 * @Description: 写点注释
 */
@Data
public class UpdateQuestionInfoRequest {
    private String question;
    private Long questionId;
}
