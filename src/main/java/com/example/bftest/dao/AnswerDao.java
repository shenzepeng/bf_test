package com.example.bftest.dao;

import com.example.bftest.constants.BfTestConstants;
import com.example.bftest.mapper.BfAnswerMapper;
import com.example.bftest.pojo.BfAnswer;
import com.example.bftest.pojo.BfQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 14:24
 * @Description: 写点注释
 */
@Repository
public class AnswerDao {
    @Autowired
    private BfAnswerMapper bfAnswerMapper;

    /**
     * 添加
     * @param bfAnswer
     * @return
     */
    public Integer addAnswer(BfAnswer bfAnswer){
        return bfAnswerMapper.insert(bfAnswer);
    }

    /**
     * 更新
     * @param bfAnswer
     * @return
     */
    public Integer updateAnswer(BfAnswer bfAnswer){
        return bfAnswerMapper.updateByPrimaryKeySelective(bfAnswer);
    }

    /**
     * 通过userId去查
     */
    public List<BfAnswer> findAnswerByUserId(Long userId){
        Example example=new Example(BfAnswer.class);
        example.createCriteria()
                .andEqualTo("userId",userId);
        return bfAnswerMapper.selectByExample(example);
    }

    /**
     * 通过问题id找到所有需要批改的问题
     * @param ids
     * @return
     */
    public List<BfAnswer> findAnswerByQuestionId(List<Long> ids){
        if (CollectionUtils.isEmpty(ids)){
            return new ArrayList<>();
        }
        Example example=new Example(BfAnswer.class);
        example.createCriteria()
                .andNotEqualTo("hasCheck", BfTestConstants.ANSWER_STATUS_CHANGED)
                .andIn("questionId",ids)
                .andIsNotNull("userAnswer");
        example.orderBy("id").desc();
        return bfAnswerMapper.selectByExample(example);
    }

    /**
     * 所有做过的试题，
     * @param testIds
     * @return
     */
    public List<BfAnswer> findAnswerByTestId(List<Long> testIds){
        if (CollectionUtils.isEmpty(testIds)){
            return new ArrayList<>();
        }
        Example example=new Example(BfAnswer.class);
        example.createCriteria()
                .andIn("testId",testIds);
        example.orderBy("id").desc();
        return bfAnswerMapper.selectByExample(example);

    }

    /**
     * 通过考试id找到所有的题目
     * @param testId
     * @return
     */
    public List<BfAnswer> findAnswerByTestId(Long testId){
        if (null!=testId){
            return new ArrayList<>();
        }
        Example example=new Example(BfAnswer.class);
        example.createCriteria()
                .andEqualTo("testId",testId);
        return bfAnswerMapper.selectByExample(example);
    }

    /**
     * 通过试题id找到
     */
    public List<BfAnswer> findBfAnswerByQuestionId(Long id){
        if (null!=id){
            return new ArrayList<>();
        }
        Example example=new Example(BfAnswer.class);
        example.createCriteria()
                .andEqualTo("questionId",id);
        return bfAnswerMapper.selectByExample(example);
    }


}
