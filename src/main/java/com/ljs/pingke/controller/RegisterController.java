package com.ljs.pingke.controller;

import com.ljs.pingke.common.domain.AjaxResult;
import com.ljs.pingke.pojo.RegisterBody;
import com.ljs.pingke.pojo.User;
import com.ljs.pingke.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/user/register")
    public AjaxResult register(@RequestBody RegisterBody registerBody){
        return registerService.register(registerBody);
    }
}
