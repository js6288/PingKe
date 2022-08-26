package com.ljs.pingke.handler;

import com.alibaba.fastjson.JSON;
import com.ljs.pingke.common.domain.AjaxResult;
import com.ljs.pingke.common.redis.RedisCache;
import com.ljs.pingke.common.utils.JwtUtil;
import com.ljs.pingke.common.utils.StringUtils;
import com.ljs.pingke.common.utils.WebUtils;
import com.ljs.pingke.pojo.LoginUser;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义退出处理类 返回成功
 */
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Autowired
    private RedisCache redisCache;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //获取token
        LoginUser loginUser = getLoginUser(request);
        if (StringUtils.isNotNull(loginUser)){
            //删除用户缓存记录
            String redisKey = "login:"+loginUser.getUser().getUserId();
            redisCache.deleteObject(redisKey);
        }
        WebUtils.renderString(response, JSON.toJSONString(AjaxResult.success("退出登录成功")));

    }

    private LoginUser getLoginUser(HttpServletRequest request){
        String token = getToken(request);
        if (StringUtils.isNotEmpty(token)){
            try{
                Claims claims = JwtUtil.parseJWT(token);
                String userId = claims.getSubject();
                String redisKey = "login:"+userId;
                return redisCache.getCacheObject(redisKey);
            }catch (Exception e){

            }
        }
        return null;
    }

    private String getToken(HttpServletRequest request){
        return request.getHeader("token");
    }

}
