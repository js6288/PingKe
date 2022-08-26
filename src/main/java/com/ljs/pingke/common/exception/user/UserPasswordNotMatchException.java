package com.ljs.pingke.common.exception.user;

public class UserPasswordNotMatchException extends RuntimeException {


    public UserPasswordNotMatchException() {
        super("登录失败，用户名或密码不正确");
    }
}
