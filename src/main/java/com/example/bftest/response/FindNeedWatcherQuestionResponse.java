package com.example.bftest.response;

import lombok.Data;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/2 22:19
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class FindNeedWatcherQuestionResponse {
    private Long total;
    private List<NeedWatcherQuestion> needWatcherQuestionList;
}
