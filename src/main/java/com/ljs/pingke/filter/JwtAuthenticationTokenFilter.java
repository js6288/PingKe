package com.ljs.pingke.filter;

import com.alibaba.fastjson.JSON;
import com.ljs.pingke.common.domain.AjaxResult;
import com.ljs.pingke.common.redis.RedisCache;
import com.ljs.pingke.common.utils.JwtUtil;
import com.ljs.pingke.common.utils.WebUtils;
import com.ljs.pingke.pojo.LoginUser;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * token认证过滤器
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    private static void printJson(HttpServletResponse response){
        AjaxResult responseResult = AjaxResult.error(401, "用户未登录");
        String content = JSON.toJSONString(responseResult);
        WebUtils.renderString(response,content);
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //从请求头获取token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)){
            //放行
            filterChain.doFilter(request,response);
            return;
        }
        String userid;
        //解析token
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        } catch (Exception e) {
            printJson(response);
//            throw new ServiceException("token非法");
            return;
        }
        //从redis中获取用户信息
        String redisKey = "login:"+userid;
        LoginUser loginUser = redisCache.getCacheObject(redisKey);
        //redis中的用户信息不存在（过期了）
        if (Objects.isNull(loginUser)){
            printJson(response);
//            throw new ServiceException("用户未登录");
            return;
        }


        //TODO 获取权限信息封装到Authentication中
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());

        //存入SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        //放行
        filterChain.doFilter(request,response);
    }
}
