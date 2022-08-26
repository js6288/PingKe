package com.ljs.pingke.service;

import com.ljs.pingke.pojo.LoginUser;
import org.springframework.stereotype.Service;


public interface TokenService {

    void setLoginUser(LoginUser loginUser);
}
