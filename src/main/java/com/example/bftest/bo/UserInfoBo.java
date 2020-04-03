package com.example.bftest.bo;

import lombok.Data;

/**
 * @Auther: szp
 * @Date: 2020/4/1 13:46
 * @Description: 沈泽鹏写点注释吧
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
