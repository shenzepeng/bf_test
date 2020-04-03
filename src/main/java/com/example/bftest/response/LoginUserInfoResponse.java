package com.example.bftest.response;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @Auther: mbp
 * @Date: 2020/4/2 22:11
 * @Description: 写点注释
 */
@Data
public class LoginUserInfoResponse {
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像
     */
    private String imgHead;


    private Date createTime;


    private Date updateTime;

    /**
     * 类型 0 管理员  1学生  2老师
     */
    private Short type;

    /**
     * 工号
     */
    private String number;
}
