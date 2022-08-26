package com.ljs.pingke.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljs.pingke.pojo.Admin;
import com.ljs.pingke.service.AdminService;
import com.ljs.pingke.mapper.AdminMapper;
import org.springframework.stereotype.Service;

/**
* @author ljs
* @description 针对表【admin】的数据库操作Service实现
* @createDate 2022-03-13 22:22:54
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

}




