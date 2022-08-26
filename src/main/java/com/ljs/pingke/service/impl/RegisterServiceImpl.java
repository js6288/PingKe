package com.ljs.pingke.service.impl;

import com.ljs.pingke.common.constant.Constants;
import com.ljs.pingke.common.constant.UserConstants;
import com.ljs.pingke.common.domain.AjaxResult;
import com.ljs.pingke.common.exception.user.CaptchaException;
import com.ljs.pingke.common.exception.user.CaptchaExpireException;
import com.ljs.pingke.common.redis.RedisCache;
import com.ljs.pingke.common.utils.RsaUtil;
import com.ljs.pingke.common.utils.SecurityUtils;
import com.ljs.pingke.common.utils.StringUtils;
import com.ljs.pingke.pojo.RegisterBody;
import com.ljs.pingke.pojo.User;
import com.ljs.pingke.service.RegisterService;
import com.ljs.pingke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Value("${auth.privateKey}")
    private String privateKey;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private UserService userService;

    @Override
    public AjaxResult register(RegisterBody registerBody) {

        //校验验证码
        validateCaptcha(registerBody.getCode(), registerBody.getUuid());

        String msg = "";
        String username = registerBody.getUsername();

        //解密
        String originPassword = RsaUtil.decrypt(registerBody.getPassword(), privateKey);
        if (StringUtils.isEmpty(username))
        {
            msg = "用户名不能为空";
        }
        else if (StringUtils.isEmpty(originPassword))
        {
            msg = "用户密码不能为空";
        }
        else if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH)
        {
            msg = "账户长度必须在5到16个字符之间";
        }
        else if (originPassword.length() < UserConstants.PASSWORD_MIN_LENGTH
                || originPassword.length() > UserConstants.PASSWORD_MAX_LENGTH)
        {
            msg = "密码长度必须在8到16个字符之间";
        }
        else if (UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(username)))
        {
            msg = "保存用户'" + username + "'失败，注册账号已存在";
        }else {

            User user = new User();
            user.setUsername(username);
            user.setRealName(registerBody.getRealName());
            user.setStuNum(registerBody.getStuNum());
            user.setAvatar(UserConstants.DEFAULT_AVATAR);
            //加密
//            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setPassword(SecurityUtils.encryptPassword(originPassword));
            boolean regFlag = userService.save(user);
            if (!regFlag){
                msg = "系统繁忙，注册失败，请稍后重试！";
            }
        }
        return StringUtils.isEmpty(msg)?AjaxResult.success("注册成功"):AjaxResult.error(msg);

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
}
