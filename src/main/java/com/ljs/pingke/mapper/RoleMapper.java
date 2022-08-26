package com.ljs.pingke.mapper;

import com.ljs.pingke.pojo.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ljs
* @description 针对表【role(角色信息表)】的数据库操作Mapper
* @createDate 2022-03-15 21:21:08
* @Entity com.ljs.pingke.pojo.Role
*/
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}




