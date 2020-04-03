package com.example.bftest.pojo;

import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;
@NoArgsConstructor
@Table(name = "t_question")
public class BfQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 问题
     */
    private String question;

    public BfQuestion(String question, Long teacherId, String questionCode) {
        this.question = question;
        this.teacherId = teacherId;
        this.questionCode = questionCode;
    }

    /**
     * 老师id
     */
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "question_code")
    private String questionCode;

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
     * 获取问题
     *
     * @return question - 问题
     */
    public String getQuestion() {
        return question;
    }

    /**
     * 设置问题
     *
     * @param question 问题
     */
    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    /**
     * 获取老师id
     *
     * @return teacher_id - 老师id
     */
    public Long getTeacherId() {
        return teacherId;
    }

    /**
     * 设置老师id
     *
     * @param teacherId 老师id
     */
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
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
     * @return question_code
     */
    public String getQuestionCode() {
        return questionCode;
    }

    /**
     * @param questionCode
     */
    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode == null ? null : questionCode.trim();
    }
}