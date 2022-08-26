package com.ljs.pingke.controller;

import com.ljs.pingke.common.domain.AjaxResult;
import com.ljs.pingke.common.utils.SecurityUtils;
import com.ljs.pingke.pojo.LoginBody;
import com.ljs.pingke.pojo.User;
import com.ljs.pingke.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {


    @Autowired
    private LoginService loginService;

    /**
     * 登录接口
     */
    @PostMapping("/user/login")
    public AjaxResult login(@RequestBody LoginBody loginBody){
        return loginService.login(loginBody);
    }

//退出登录由LogoutSuccessHandlerImpl自定义退出处理类完成
//    /**
//     * 退出登录
//     *
//     */
//    @PostMapping("/user/logout")
//    public AjaxResult logout(){
//        return loginService.logout();
//    }

    @GetMapping("/user/getUserInfo")
    public AjaxResult getUserInfo(){
        User user = SecurityUtils.getLoginUser().getUser();
        //返回给前端的密码要置空
        user.setPassword("");
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user",user);
        return ajax;
    }
}
