package com.ljs.pingke.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljs.pingke.common.constant.ItemConstants;
import com.ljs.pingke.common.domain.AjaxResult;
import com.ljs.pingke.common.utils.SecurityUtils;
import com.ljs.pingke.pojo.Item;
import com.ljs.pingke.service.ItemService;
import com.ljs.pingke.mapper.ItemMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author ljs
* @description 针对表【item】的数据库操作Service实现
* @createDate 2022-03-29 13:37:11
*/
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item>
    implements ItemService{

    @Override
    public AjaxResult commitItem(Item item) {
        Integer userId = SecurityUtils.getLoginUser().getUser().getUserId();
        item.setUserId(userId);
        item.setItemStatus(ItemConstants.TO_BE_SOLVED);
        item.setCreateTime(new Date());
        int insert = baseMapper.insert(item);
        if (insert == 1){
            return AjaxResult.success("项目提交成功,请等待客服回复和后台审核");
        }else {
            return AjaxResult.error("提交失败");
        }
    }

    @Override
    public AjaxResult getItemBySelf() {
        Integer userId = SecurityUtils.getLoginUser().getUser().getUserId();
        List<Item> itemList = baseMapper.selectList(new QueryWrapper<Item>().eq("user_id", userId));
        return AjaxResult.success().put("itemList",itemList);
    }

    @Override
    public Item getItemById(Integer itemId) {
        return this.baseMapper.selectById(itemId);
    }
}




