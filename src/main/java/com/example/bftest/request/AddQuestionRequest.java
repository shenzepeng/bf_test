package com.example.bftest.request;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Auther: szp
 * @Date: 2020/4/1 15:58
 * @Description: 沈泽鹏写点注释吧
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
