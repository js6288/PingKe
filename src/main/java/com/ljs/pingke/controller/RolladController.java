package com.ljs.pingke.controller;

import com.ljs.pingke.common.domain.AjaxResult;
import com.ljs.pingke.pojo.Rollad;
import com.ljs.pingke.service.RolladService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RolladController {

    @Autowired
    private RolladService rolladService;

    /**
     * 获取轮播图
     * @return
     */
    @GetMapping("/get/rollad")
    public AjaxResult getRollad(){
        List<Rollad> rolladList = rolladService.list();
        return AjaxResult.success().put("rolladList",rolladList);
    }

}
