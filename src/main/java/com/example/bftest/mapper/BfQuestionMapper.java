package com.example.bftest.mapper;

import com.example.bftest.pojo.BfQuestion;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BfQuestionMapper extends  CommonMapper<BfQuestion> {
}