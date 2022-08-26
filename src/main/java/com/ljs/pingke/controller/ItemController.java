package com.ljs.pingke.controller;

import com.ljs.pingke.common.constant.HttpStatus;
import com.ljs.pingke.common.domain.AjaxResult;
import com.ljs.pingke.common.utils.SecurityUtils;
import com.ljs.pingke.common.utils.StringUtils;
import com.ljs.pingke.pojo.Item;
import com.ljs.pingke.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 提交项目
     * @param item
     * @return
     */
    @PostMapping("/item/commit")
    public AjaxResult itemCommit(@RequestBody Item item){
        return itemService.commitItem(item);
    }

    /**
     * 获取当前用户的项目
     * @return
     */
    @GetMapping("/get/my/item")
    public AjaxResult getMyItems(){
        return itemService.getItemBySelf();
    }

    /**
     * 根据itemId获取项目详情
     */
    @GetMapping("/get/item/by/{itemId}")
    public AjaxResult getItemDetail(@PathVariable Integer itemId){
        Item item = itemService.getItemById(itemId);
        Integer loginUserId = SecurityUtils.getLoginUser().getUser().getUserId();
        //判断获取的项目是否为当前用户的项目
        if (StringUtils.isNotNull(item) && item.getUserId().equals(loginUserId)){
            return AjaxResult.success().put("item",item);
        }
        return AjaxResult.error(HttpStatus.UNAUTHORIZED,"项目不存在或者该项目不是你的项目");
    }

}
