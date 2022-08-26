package com.ljs.pingke.service;

import com.ljs.pingke.common.domain.AjaxResult;
import com.ljs.pingke.pojo.RegisterBody;
import com.ljs.pingke.pojo.User;

public interface RegisterService {

    AjaxResult register(RegisterBody registerBody);
}
