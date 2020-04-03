package com.example.bftest.dao;

import com.example.bftest.mapper.BfQuestionMapper;
import com.example.bftest.pojo.BfAnswer;
import com.example.bftest.pojo.BfQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/1 14:24
 * @Description: 沈泽鹏写点注释吧
 */
@Repository
public class QuestionDao {
    @Autowired
    private BfQuestionMapper bfQuestionMapper;

    public Integer addQuestion(BfQuestion bfQuestion){
        return bfQuestionMapper.insert(bfQuestion);
    }

    public Integer countTotal(){
        Example example=new Example(BfQuestion.class);
       return bfQuestionMapper.selectCountByExample(example);
    }

    public List<BfQuestion> findExamInIdList(List<Long> ids){
        Example example=new Example(BfQuestion.class);
        example.createCriteria()
                .andIn("id",ids);
        return bfQuestionMapper.selectByExample(example);
    }

    public List<BfQuestion> findByTeacherId(Long teacherId){
        Example example=new Example(BfQuestion.class);
        example.createCriteria()
                .andEqualTo("teacherId",teacherId);
        example.orderBy("id").desc();
        return bfQuestionMapper.selectByExample(example);
    }

    public Integer updateQuestion(BfQuestion bfQuestion){
        return bfQuestionMapper.updateByPrimaryKeySelective(bfQuestion);
    }

    public Integer deleteQuestion(Long id){
        return bfQuestionMapper.deleteByPrimaryKey(id);
    }

    public List<BfQuestion> findAll(){
        return bfQuestionMapper.selectAll();
    }

    public List<BfQuestion> searchBfQuestionByTeacher(Long teacherId,String question){
        Example example=new Example(BfQuestion.class);
        example.createCriteria()
                .andEqualTo("teacherId",teacherId)
                .andLike("question","%"+question+"%");
        return bfQuestionMapper.selectByExample(example);
    }
}
