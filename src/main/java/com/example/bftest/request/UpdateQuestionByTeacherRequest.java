package com.example.bftest.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Auther: mbp
 * @Date: 2020/4/2 22:46
 * @Description: 老师想更新上传的过后的题目
 *
 */
@Data
public class UpdateQuestionByTeacherRequest {
    @NotNull
    private Long questionId;
    @NotBlank
    private String question;
}
