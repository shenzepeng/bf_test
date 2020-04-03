package com.example.bftest.request;

import lombok.Data;

/**
 * @Auther: mbp
 * @Date: 2020/4/2 22:20
 * @Description: 写点注释
 */
@Data
public class FindNeedWatcherQuestionRequest {
    private Long teacherId;
    private Integer pageSize=10;
    private Integer pageNumber=1;
}
