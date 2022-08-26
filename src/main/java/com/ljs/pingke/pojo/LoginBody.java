package com.ljs.pingke.pojo;

import lombok.Data;

/**
 * 用户登录对象
 */
@Data
public class LoginBody {

    /**
     *用户名
     */
    String username;

    /**
     *用户密码
     */
    String password;

    /**
     * 验证码
     */
    String code;

    /**
     * 唯一标识
     */
    String uuid;
}
