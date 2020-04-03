package com.example.bftest.controller;


import com.example.bftest.common.SzpJsonResult;
import com.example.bftest.response.FindAllUserResponse;
import com.example.bftest.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: szp
 * @Date: 2020/4/3 22:53
 * @Description: 沈泽鹏写点注释吧
 */
@RestController
@RequestMapping("manager")
public class ManagerController {
    @Autowired
    private UserService userService;
    @ApiOperation("拿到所有学生信息")
    @GetMapping("find/all")
    public SzpJsonResult<FindAllUserResponse> finAllUser(){
        return SzpJsonResult.ok(userService.findAll());
    }
}
