package com.ljs.pingke.controller;

import com.ljs.pingke.common.domain.AjaxResult;
import com.ljs.pingke.common.redis.RedisCache;
import com.ljs.pingke.common.utils.SecurityUtils;
import com.ljs.pingke.common.utils.StringUtils;
import com.ljs.pingke.pojo.LoginUser;
import com.ljs.pingke.pojo.User;
import com.ljs.pingke.service.TokenService;
import com.ljs.pingke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private TokenService tokenService;

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PutMapping("/update/userinfo")
    public AjaxResult updateUserInfo(@RequestBody User user){
        return userService.updateUserInfo(user);
    }

    /**
     * 重置密码
     */
    @PutMapping("/update/password")
    public AjaxResult updatePassword(String oldPassword,String newPassword){
        LoginUser loginUser = SecurityUtils.getLoginUser();

        Integer userId = loginUser.getUser().getUserId();
        String password = loginUser.getPassword();

        if (!SecurityUtils.matchesPassword(oldPassword, password)){
            return AjaxResult.error("修改密码失败，旧密码错误");
        }
        if (SecurityUtils.matchesPassword(newPassword,password)){
            return AjaxResult.error("新密码不能与旧密码相同");
        }
        if (userService.resetUserPwd(userId,SecurityUtils.encryptPassword(newPassword)) > 0){
            //删除缓存
            redisCache.deleteObject("login:"+userId);
            return AjaxResult.success();
        }
        return AjaxResult.success("修改密码异常，请联系客服");

    }


    /**
     * 头像上传
     */
    @PostMapping("/avatar")
    public AjaxResult avatar(@RequestParam("avatar") String avatar){
        if (StringUtils.isNotEmpty(avatar)){
            LoginUser loginUser = SecurityUtils.getLoginUser();
            if (userService.updateUserAvatar(loginUser.getUser().getUserId(),avatar)){
                AjaxResult ajaxResult =AjaxResult.success();
                ajaxResult.put("imgUrl",avatar);
                //更新用户缓存
                loginUser.getUser().setAvatar(avatar);
                tokenService.setLoginUser(loginUser);
                return ajaxResult;
            }
        }
        return AjaxResult.error("更新头像失败，请稍后重试");
    }
}
