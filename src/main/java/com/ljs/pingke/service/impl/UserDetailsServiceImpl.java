package com.ljs.pingke.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ljs.pingke.common.exception.ServiceException;
import com.ljs.pingke.common.utils.StringUtils;
import com.ljs.pingke.mapper.MenuMapper;
import com.ljs.pingke.mapper.UserMapper;
import com.ljs.pingke.pojo.LoginUser;
import com.ljs.pingke.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,username);
        User user = userMapper.selectOne(queryWrapper);
        if (StringUtils.isNull(user)){
            log.info("登录用户：{} 不存在.", username);
            throw new ServiceException("登录用户：" + username + " 不存在");
        }
        // 查询对应的权限信息
        List<String> list = menuMapper.selectPermsByUserId(user.getUserId());
//        List<String> list = new ArrayList<>(Arrays.asList("normal","service","test"));
        return new LoginUser(user,list);
    }
}
