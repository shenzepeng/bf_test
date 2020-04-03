package com.example.bftest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: szp
 * @Date: 2020/4/1 18:46
 * @Description: 沈泽鹏写点注释吧
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
