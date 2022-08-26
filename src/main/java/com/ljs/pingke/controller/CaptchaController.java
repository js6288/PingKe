package com.ljs.pingke.controller;

import com.google.code.kaptcha.Producer;
import com.ljs.pingke.common.constant.Constants;
import com.ljs.pingke.common.domain.AjaxResult;
import com.ljs.pingke.common.redis.RedisCache;
import com.ljs.pingke.common.utils.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController()
@RequestMapping("/api")
public class CaptchaController {

    @Resource(name = "captchaProducerMath")
    public Producer captchaProducerMath;

    @Autowired
    private RedisCache redisCache;

    /**
     * 生成验证码
     */
    @GetMapping("/captchaImage")
    public AjaxResult getCode() {
        //保存验证码信息
        String uuid = UUID.randomUUID().toString();
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;

        //生成验证码
        String capText = captchaProducerMath.createText();
        String capStr = capText.substring(0,capText.lastIndexOf("@"));
        String code = capText.substring(capText.lastIndexOf("@") + 1);
        BufferedImage image = captchaProducerMath.createImage(capStr);

        redisCache.setCacheObject(verifyKey,code,Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try
        {
            ImageIO.write(image, "jpg", os);
        }
        catch (IOException e)
        {
            return AjaxResult.error(e.getMessage());
        }

        AjaxResult ajax = AjaxResult.success();

        ajax.put("uuid", uuid);
        ajax.put("img", Base64.encode(os.toByteArray()));
        return ajax;

    }

}
