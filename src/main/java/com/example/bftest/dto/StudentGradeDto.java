package com.example.bftest.dto;

import lombok.Data;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 23:00
 * @Description: 写点注释
 */
@Data
public class StudentGradeDto {
    /**
     * 学生id
     */
    private Long id;
    private Integer grades;
    /**
     * 这个字段会出现在
     * 当前如果有题没批改完的情况下
     */
    private String context;
    /**
     * testid
     */
    private Long testId;
}
