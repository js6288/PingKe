package com.ljs.pingke.mapper;

import com.ljs.pingke.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ljs
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-03-14 18:16:25
* @Entity com.ljs.pingke.pojo.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




