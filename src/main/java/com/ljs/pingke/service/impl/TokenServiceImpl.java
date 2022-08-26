package com.ljs.pingke.service.impl;

import com.ljs.pingke.common.redis.RedisCache;
import com.ljs.pingke.common.utils.StringUtils;
import com.ljs.pingke.pojo.LoginUser;
import com.ljs.pingke.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisCache redisCache;



    @Override
    public void setLoginUser(LoginUser loginUser) {
        if (StringUtils.isNotNull(loginUser)){
            String key = "login:"+loginUser.getUser().getUserId();
            //获取过期时间
            Integer expireTime = (int) redisCache.getExpireTime(key);
            redisCache.setCacheObject(key,loginUser,expireTime,TimeUnit.MILLISECONDS);
        }
    }

//    /**
//     * 刷新令牌有效期
//     * @param loginUser
//     */
//    private void refreshToken(LoginUser loginUser) {
//
//
//    }


}
