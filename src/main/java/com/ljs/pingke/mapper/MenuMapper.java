package com.ljs.pingke.mapper;

import com.ljs.pingke.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author ljs
* @description 针对表【menu(菜单权限表)】的数据库操作Mapper
* @createDate 2022-03-15 19:45:36
* @Entity com.ljs.pingke.pojo.Menu
*/
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectPermsByUserId(Integer userId);
}




