package com.example.bftest.mapper;

import com.example.bftest.pojo.BfUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BfUserMapper extends  CommonMapper<BfUser> {
}