package com.ljs.pingke.service;

import com.ljs.pingke.common.domain.AjaxResult;
import com.ljs.pingke.pojo.Item;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author ljs
* @description 针对表【item】的数据库操作Service
* @createDate 2022-03-29 13:37:11
*/
public interface ItemService extends IService<Item> {

    public AjaxResult commitItem(Item item);

    AjaxResult getItemBySelf();

    Item getItemById(Integer itemId);
}
