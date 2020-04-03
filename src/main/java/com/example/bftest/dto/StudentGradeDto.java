package com.example.bftest.dto;

import lombok.Data;

/**
 * @Auther: szp
 * @Date: 2020/4/1 23:00
 * @Description: 沈泽鹏写点注释吧
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
