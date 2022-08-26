package com.ljs.pingke.mapper;

import com.ljs.pingke.pojo.Item;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ljs
* @description 针对表【item】的数据库操作Mapper
* @createDate 2022-03-29 13:37:11
* @Entity com.ljs.pingke.pojo.Item
*/
@Mapper
public interface ItemMapper extends BaseMapper<Item> {

}




