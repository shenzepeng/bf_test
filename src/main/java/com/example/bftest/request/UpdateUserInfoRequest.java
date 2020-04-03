package com.example.bftest.request;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Auther: szp
 * @Date: 2020/4/1 18:09
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class UpdateUserInfoRequest {
    @NotNull
    private Long id;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像
     */
    private String imgHead;


    /**
     * 工号
     */
    private String number;
}
