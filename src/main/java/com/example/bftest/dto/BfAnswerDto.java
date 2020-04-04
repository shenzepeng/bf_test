package com.example.bftest.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @Auther: szp
 * @Date: 2020/4/4 22:49
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class BfAnswerDto {
    private Long id;

    /**
     * 问题id
     */

    private Long questionId;

    /**
     * 用户id
     */

    private Long userId;

    /**
     * 用户答案
     */

    private String userAnswer;

    /**
     * 批改结果
     */

    private String hasCheck;


    private Date createTime;


    private Date updateTime;

    /**
     * 考试id
     */

    private Long testId;

    /**
     * 分数
     */
    private Integer grades;
    /**
     * 问题
     */
    private String question;
}
