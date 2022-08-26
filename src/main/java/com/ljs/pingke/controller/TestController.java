package com.ljs.pingke.controller;

import com.ljs.pingke.common.domain.AjaxResult;
import com.ljs.pingke.pojo.Item;
import com.ljs.pingke.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/test")
    @PreAuthorize("hasAuthority('customer:service')")
    public Map<String,String> test(){
        Map<String,String> map = new HashMap<>();
        map.put("message","ok");
        return map;
    }

    @GetMapping("item")
    public AjaxResult getItem(Integer id){
        Item byId = itemService.getById(id);
        return AjaxResult.success(byId);
    }
}
