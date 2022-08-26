package com.ljs.pingke.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljs.pingke.pojo.Menu;
import com.ljs.pingke.service.MenuService;
import com.ljs.pingke.mapper.MenuMapper;
import org.springframework.stereotype.Service;

/**
* @author ljs
* @description 针对表【menu(菜单权限表)】的数据库操作Service实现
* @createDate 2022-03-15 19:45:36
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

}




