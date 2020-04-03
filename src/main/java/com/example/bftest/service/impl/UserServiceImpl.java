package com.example.bftest.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.example.bftest.dao.UserDao;
import com.example.bftest.pojo.BfUser;
import com.example.bftest.request.UpdateUserInfoRequest;
import com.example.bftest.response.IntegerResultResponse;
import com.example.bftest.response.LoginUserInfoResponse;
import com.example.bftest.service.UserService;
import com.example.bftest.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/1 15:16
 * @Description: 沈泽鹏写点注释吧
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public LoginUserInfoResponse login(String username, String password) {
        LoginUserInfoResponse response=new LoginUserInfoResponse();
        List<BfUser> login = userDao.login(username, password);
        log.info("loginlist-{}", JsonUtils.objectToJson(login));
        if (!CollectionUtils.isEmpty(login)) {
            BfUser bfUser = login.get(0);
            BeanUtils.copyProperties(bfUser,response);
            return response;
        }
        return response;
    }

    @Override
    public IntegerResultResponse updateUserInfo(UpdateUserInfoRequest bfUser) {
        IntegerResultResponse resultResponse=new IntegerResultResponse();
        BfUser bf=new BfUser();
        BeanUtils.copyProperties(bfUser,bf);
        bf.setUpdateTime(new Date());
        resultResponse.setResult(userDao.updateUserInfo(bf));
        return resultResponse;
    }

    @Override
    public IntegerResultResponse addUser(BfUser bfUser) {
        IntegerResultResponse resultResponse=new IntegerResultResponse();
        resultResponse.setResult(userDao.addUser(bfUser));
        return resultResponse;
    }

    @Override
    public IntegerResultResponse addUserList(List<BfUser> bfUsers) {
        for (BfUser bfUser : bfUsers) {
            bfUser.setUpdateTime(new Date());
            bfUser.setCreateTime(new Date());
            userDao.addUser(bfUser);
        }
        IntegerResultResponse resultResponse=new IntegerResultResponse();
        resultResponse.setResult(1);
        return resultResponse;
    }


}
