package com.ljs.pingke.controller;

import com.ljs.pingke.common.domain.AjaxResult;
import com.ljs.pingke.pojo.Adshow;
import com.ljs.pingke.service.AdshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdshowController {

    @Autowired
    private AdshowService adshowService;

    @GetMapping("/get/adshow")
    public AjaxResult getAdshow(){
        List<Adshow> adshowList = adshowService.list();
        return AjaxResult.success().put("adshowList",adshowList);
    }
}
