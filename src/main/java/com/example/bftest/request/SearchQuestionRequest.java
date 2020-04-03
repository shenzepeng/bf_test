package com.example.bftest.request;

import io.swagger.models.auth.In;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Auther: mbp
 * @Date: 2020/4/2 22:33
 * @Description: 写点注释
 */
@Data
public class SearchQuestionRequest {
    @NotBlank
    private String question;
    @NotNull
    private Long teacherId;
    private Integer pageSize;
    private Integer pageNumber;
}
