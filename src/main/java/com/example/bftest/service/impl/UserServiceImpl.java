package com.example.bftest.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.example.bftest.dao.UserDao;
import com.example.bftest.mapper.BfUserMapper;
import com.example.bftest.pojo.BfUser;
import com.example.bftest.request.UpdateUserInfoRequest;
import com.example.bftest.response.FindAllUserResponse;
import com.example.bftest.response.IntegerResultResponse;
import com.example.bftest.response.LoginUserInfoResponse;
import com.example.bftest.service.UserService;
import com.example.bftest.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 15:16
 * @Description: 写点注释
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

@Autowired
private BfUserMapper bfUserMapper;
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
        if (CollectionUtils.isEmpty(bfUsers)){
            throw new RuntimeException("上传名单有问题，文件为空，或者文件中没有内容");
        }
        for (BfUser bfUser : bfUsers) {
           bfUser.setUpdateTime(new Date());
           bfUser.setCreateTime(new Date());
        }
        IntegerResultResponse resultResponse=new IntegerResultResponse();
        resultResponse.setResult(bfUserMapper.insertList(bfUsers));
        return resultResponse;
    }

    @Override
    public FindAllUserResponse findAll() {
        FindAllUserResponse response=new FindAllUserResponse();
        List<BfUser> all = userDao.findAll();
        response.setBfUserList(all);
        return response;
    }


}
