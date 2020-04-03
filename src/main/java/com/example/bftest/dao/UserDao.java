package com.example.bftest.dao;

import com.example.bftest.mapper.BfUserMapper;
import com.example.bftest.pojo.BfUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 14:24
 * @Description: 写点注释
 */
@Repository
public class UserDao {
    @Autowired
    private BfUserMapper userMapper;

    public Integer addUserMapper(BfUser bfUser){
        return userMapper.insert(bfUser);
    }

    public List<BfUser> login(String username,String password){
        Example example=new Example(BfUser.class);
        example.createCriteria()
                .andEqualTo("username",username)
                .andEqualTo("password",password);
        return userMapper.selectByExample(example);
    }

    public Integer updateUserInfo(BfUser bfUser){
        return userMapper.updateByPrimaryKeySelective(bfUser);
    }

    public Integer addUser(BfUser bfUser){
        return userMapper.insert(bfUser);
    }

    public List<BfUser> findAll(){
        return userMapper.selectAll();
    }
}
