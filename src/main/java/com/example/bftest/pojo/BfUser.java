package com.example.bftest.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;
@NoArgsConstructor
@Data
@Table(name = "t_user")
public class BfUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像
     */
    @Column(name = "img_head")
    private String imgHead;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 类型 0 管理员  1学生  2老师
     */
    private Short type;

    /**
     * 工号
     */
    private String number;

    @Column(name = "chinese_name")
    private String chineseName;

    public BfUser(String username, String password, String number, String chineseName) {
        this.username = username;
        this.password = password;
        this.number = number;
        this.chineseName = chineseName;
    }

    public BfUser(String username, String password, Short type, String number, String chineseName) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.number = number;
        this.chineseName = chineseName;
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
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取头像
     *
     * @return img_head - 头像
     */
    public String getImgHead() {
        return imgHead;
    }

    /**
     * 设置头像
     *
     * @param imgHead 头像
     */
    public void setImgHead(String imgHead) {
        this.imgHead = imgHead == null ? null : imgHead.trim();
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
     * 获取类型 0 管理员  1学生  2老师
     *
     * @return type - 类型 0 管理员  1学生  2老师
     */
    public Short getType() {
        return type;
    }

    /**
     * 设置类型 0 管理员  1学生  2老师
     *
     * @param type 类型 0 管理员  1学生  2老师
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * 获取工号
     *
     * @return number - 工号
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置工号
     *
     * @param number 工号
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * @return chinese_name
     */
    public String getChineseName() {
        return chineseName;
    }

    /**
     * @param chineseName
     */
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName == null ? null : chineseName.trim();
    }
}