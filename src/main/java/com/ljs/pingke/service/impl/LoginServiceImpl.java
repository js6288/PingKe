package com.ljs.pingke.service.impl;

import com.ljs.pingke.common.constant.Constants;
import com.ljs.pingke.common.domain.AjaxResult;
import com.ljs.pingke.common.exception.ServiceException;
import com.ljs.pingke.common.exception.user.CaptchaException;
import com.ljs.pingke.common.exception.user.CaptchaExpireException;
import com.ljs.pingke.common.exception.user.UserPasswordNotMatchException;
import com.ljs.pingke.common.redis.RedisCache;
import com.ljs.pingke.common.utils.JwtUtil;
import com.ljs.pingke.common.utils.RsaUtil;
import com.ljs.pingke.common.utils.StringUtils;
import com.ljs.pingke.pojo.LoginBody;
import com.ljs.pingke.pojo.LoginUser;
import com.ljs.pingke.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Value("${auth.privateKey}")
    private String privateKey;

    @Override
    public AjaxResult login(LoginBody loginBody){

        //校验验证码
        validateCaptcha(loginBody.getCode(),loginBody.getUuid());

        //获取前端RSA加密后的明文
        String originPassword = RsaUtil.decrypt(loginBody.getPassword(), privateKey);

        //AuthenticationManager authenticate进行用户认证
        Authentication authentication = null;
        try {
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginBody.getUsername(), originPassword));
        }catch (Exception e){
            //如果认证没通过，会抛出异常
            if(e instanceof BadCredentialsException){
                throw new UserPasswordNotMatchException();
            }else {
                throw new ServiceException(e.getMessage());
            }
        }

        //如果认证通过了
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userId = loginUser.getUser().getUserId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //将用户信息保存到redis，并设置3小时的过期时间
        redisCache.setCacheObject("login:"+userId,loginUser,3, TimeUnit.HOURS);

        return AjaxResult.success("登录成功").put(Constants.TOKEN,jwt);

    }

    /**
     * 校验验证码
     *
     * @param code 验证码
     * @param uuid 唯一标识
     * @return 结果
     */
    public void validateCaptcha(String code,String uuid){
        String verifyKey = Constants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        //验证码过期
        if (captcha == null){
            throw new CaptchaExpireException();
        }
        //验证码错误
        if (!code.equalsIgnoreCase(captcha)){
            throw new CaptchaException();
        }
    }



    public AjaxResult logout() {
        //获取SecurityContextHolder的用户id

        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser)authentication.getPrincipal();

        Integer userId = loginUser.getUser().getUserId();

        //删除redis中的值
        redisCache.deleteObject("login:"+userId);
        return AjaxResult.success("退出登录成功");

    }
}
