package com.example.bftest.request;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @Auther: szp
 * @Date: 2020/4/1 15:39
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class UpdateQuestionRequest {

    private Long id;

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
