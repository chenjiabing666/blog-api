package com.vivachek.core.domain.rs;

import lombok.Data;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 21:44
 */
public enum  ResponseCode {

    OK("200","请求成功"),
    ACCOUNT_PWD_NOT_TURE("10001","账号或者密码不正确"),
    ACCOUNT_EXIST("1002","账号已经注册过！");


    private String code;

    private String msg;

    ResponseCode(String code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}