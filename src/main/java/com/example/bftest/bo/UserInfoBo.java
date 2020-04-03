package com.example.bftest.bo;

import lombok.Data;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 13:46
 * @Description: 写点注释
 */
@Data
public class UserInfoBo {
    /**
     * 工号
     */
    private String number;
    /**
     * 汉语名
     */
    private String chinese;
    /**
     * 手机号
     */
    private String phoneNumber;
}
