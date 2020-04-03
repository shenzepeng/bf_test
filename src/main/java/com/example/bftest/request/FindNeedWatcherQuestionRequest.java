package com.example.bftest.request;

import lombok.Data;

/**
 * @Auther: szp
 * @Date: 2020/4/2 22:20
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class FindNeedWatcherQuestionRequest {
    private Long teacherId;
    private Integer pageSize=10;
    private Integer pageNumber=1;
}
