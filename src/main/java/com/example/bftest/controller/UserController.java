package com.example.bftest.controller;

import com.example.bftest.common.SzpJsonResult;
import com.example.bftest.request.LoginRequest;
import com.example.bftest.request.UpdateUserInfoRequest;
import com.example.bftest.response.IntegerResultResponse;
import com.example.bftest.response.LoginUserInfoResponse;
import com.example.bftest.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 12:56
 * @Description: 写点注释
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 登录
     */
    @ApiOperation("登录,username账号，password密码")
    @PostMapping("login")
    public SzpJsonResult<LoginUserInfoResponse> login(@RequestBody  LoginRequest request){
        return SzpJsonResult.ok(userService.login(request.getUsername(), request.getPassword()));
    }
    /**
     * 修改
     */
    @ApiOperation("修改,number是工号或者学校，id是userId，必串")
    @PutMapping("put/msg")
    public SzpJsonResult<IntegerResultResponse> updateInfo(@RequestBody  UpdateUserInfoRequest updateUserInfoRequest){
        return SzpJsonResult.ok(userService.updateUserInfo(updateUserInfoRequest));
    }

}
