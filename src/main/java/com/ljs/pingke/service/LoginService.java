package com.ljs.pingke.service;

import com.ljs.pingke.common.domain.AjaxResult;
import com.ljs.pingke.pojo.LoginBody;
import com.ljs.pingke.pojo.User;

public interface LoginService {
    AjaxResult login(LoginBody loginBody);

}
