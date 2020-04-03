package com.example.bftest.response;

import lombok.Data;

import java.util.List;

/**
 * @Auther: mbp
 * @Date: 2020/4/2 22:19
 * @Description: 写点注释
 */
@Data
public class FindNeedWatcherQuestionResponse {
    private Long total;
    private List<NeedWatcherQuestion> needWatcherQuestionList;
}
