package com.example.bftest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 18:46
 * @Description: 写点注释
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NeedWatcherQuestion{
    /**
     * 试题id
     */
    private Long testId;
    //private Long userId;
    /**
     * 问题id
     */
    private Long questionId;
    /**
     * 问题
     */
    private String questionContext;
    /**
     * 答案
     */
    private String answerContext;
}
