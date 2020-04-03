package com.example.bftest.dao;

import com.example.bftest.mapper.BfExamMapper;
import com.example.bftest.pojo.BfExam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 14:24
 * @Description: 写点注释
 */
@Repository
public class ExamDao {
    @Autowired
    private BfExamMapper examMapper;

    /**
     * 添加
     * @param bfExam
     * @return
     */
    public Integer addExam(BfExam bfExam){
        return examMapper.insert(bfExam);
    }

    /**
     * 通过userId查看
     * @param userId
     * @return
     */
    public List<BfExam> findExamByUserId(Long userId){
        Example example=new Example(BfExam.class);
        example.createCriteria()
                .andEqualTo("userId",userId);
        example.orderBy("id").desc();
        return examMapper.selectByExample(example);
    }

}
