package com.example.bftest.service;

import com.example.bftest.pojo.BfAnswer;
import com.example.bftest.pojo.BfUser;
import com.example.bftest.request.UpdateUserInfoRequest;
import com.example.bftest.response.FindAllUserResponse;
import com.example.bftest.response.IntegerResultResponse;
import com.example.bftest.response.LoginUserInfoResponse;

import java.util.List;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 15:14
 * @Description: 写点注释
 */
public interface UserService {
    LoginUserInfoResponse login(String username, String password);
    IntegerResultResponse updateUserInfo(UpdateUserInfoRequest bfUser);
    IntegerResultResponse addUser(BfUser bfUser);
    IntegerResultResponse addUserList(List<BfUser> bfUsers);
    FindAllUserResponse findAll();
}
