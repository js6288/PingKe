package com.ljs.pingke.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljs.pingke.pojo.Role;
import com.ljs.pingke.service.RoleService;
import com.ljs.pingke.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author ljs
* @description 针对表【role(角色信息表)】的数据库操作Service实现
* @createDate 2022-03-15 21:21:08
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




