package com.example.bftest.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Auther: szp
 * @Date: 2020/4/2 10:57
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String  password;
}
