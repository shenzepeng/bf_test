package com.example.bftest.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_answer")
public class BfAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 问题id
     */
    @Column(name = "question_id")
    private Long questionId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户答案
     */
    @Column(name = "user_answer")
    private String userAnswer;

    /**
     * 批改结果
     */
    @Column(name = "has_check")
    private String hasCheck;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 考试id
     */
    @Column(name = "test_id")
    private Long testId;

    /**
     * 分数
     */
    private Integer grades;

    public BfAnswer(Long questionId, Long userId, String hasCheck, Date createTime, Date updateTime, Long testId) {
        this.questionId = questionId;
        this.userId = userId;
        this.hasCheck = hasCheck;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.testId = testId;
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取问题id
     *
     * @return question_id - 问题id
     */
    public Long getQuestionId() {
        return questionId;
    }

    /**
     * 设置问题id
     *
     * @param questionId 问题id
     */
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户答案
     *
     * @return user_answer - 用户答案
     */
    public String getUserAnswer() {
        return userAnswer;
    }

    /**
     * 设置用户答案
     *
     * @param userAnswer 用户答案
     */
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer == null ? null : userAnswer.trim();
    }

    /**
     * 获取批改结果
     *
     * @return has_check - 批改结果
     */
    public String getHasCheck() {
        return hasCheck;
    }

    /**
     * 设置批改结果
     *
     * @param hasCheck 批改结果
     */
    public void setHasCheck(String hasCheck) {
        this.hasCheck = hasCheck == null ? null : hasCheck.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取考试id
     *
     * @return test_id - 考试id
     */
    public Long getTestId() {
        return testId;
    }

    /**
     * 设置考试id
     *
     * @param testId 考试id
     */
    public void setTestId(Long testId) {
        this.testId = testId;
    }

    /**
     * 获取分数
     *
     * @return grades - 分数
     */
    public Integer getGrades() {
        return grades;
    }

    /**
     * 设置分数
     *
     * @param grades 分数
     */
    public void setGrades(Integer grades) {
        this.grades = grades;
    }
}