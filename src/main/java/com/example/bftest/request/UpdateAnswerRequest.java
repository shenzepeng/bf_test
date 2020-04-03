package com.example.bftest.request;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 18:19
 * @Description: 写点注释
 */
@Data
public class UpdateAnswerRequest {
    /**
     * answerid
     */
    @NotNull
    private Long id;

    /**
     * 用户答案
     */
    private String userAnswer;


    /**
     * 分数
     */
    private Integer grades;
}
