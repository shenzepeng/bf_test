package com.example.bftest.common;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 12:56
 * @Description: 写点注释
 */
public class mbpJsonResult<T> {
    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    private String ok; // 不使用


    public static mbpJsonResult build(Integer status, String msg, Object data) {
        return new mbpJsonResult(status, msg, data);
    }

    public static mbpJsonResult ok(Object data) {
        return new mbpJsonResult(data);
    }

    public static mbpJsonResult ok() {
        return new mbpJsonResult(null);
    }

    public static mbpJsonResult errorMsg(String msg) {
        return new mbpJsonResult(500, msg, null);
    }

    public static mbpJsonResult errorMap(Object data) {
        return new mbpJsonResult(501, "error", data);
    }

    public static mbpJsonResult errorTokenMsg(String msg) {
        return new mbpJsonResult(502, msg, null);
    }

    public static mbpJsonResult errorException(String msg) {
        return new mbpJsonResult(555, msg, null);
    }

    public mbpJsonResult() {

    }

    public mbpJsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public mbpJsonResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }
}
