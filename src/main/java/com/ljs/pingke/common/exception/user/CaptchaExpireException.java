package com.ljs.pingke.common.exception.user;

public class CaptchaExpireException extends RuntimeException{
    public CaptchaExpireException(){
        super("验证码过期了,请重新获取");
    }
}
