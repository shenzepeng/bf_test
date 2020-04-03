package com.example.bftest.request;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 15:58
 * @Description: 写点注释
 */
@Data
public class AddQuestionRequest {



    /**
     * 问题
     */
    private String question;

    /**
     * 老师id
     */
    private Long teacherId;


    private String questionCode;
}
