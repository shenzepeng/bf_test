package com.example.bftest.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Auther: mbp
 * @Date: 2020/4/2 10:57
 * @Description: 写点注释
 */
@Data
public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String  password;
}
