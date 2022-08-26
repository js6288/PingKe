package com.ljs.pingke.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljs.pingke.common.constant.UserConstants;
import com.ljs.pingke.common.domain.AjaxResult;
import com.ljs.pingke.common.redis.RedisCache;
import com.ljs.pingke.common.utils.SecurityUtils;
import com.ljs.pingke.pojo.User;
import com.ljs.pingke.service.UserService;
import com.ljs.pingke.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author ljs
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-03-14 18:16:25
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    public RedisCache redisCache;

    /**
     *  校验用户名是否唯一
     * @param username 用户名
     * @return 结果
     */
    @Override
    public String checkUserNameUnique(String username) {
        long count = count(new QueryWrapper<User>().eq("username", username));
        if (count>0){
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Override
    public AjaxResult updateUserInfo(User user) {
        //先更新数据库
        if (this.baseMapper.updateById(user)>0){
            //再更新redis缓存
            redisCache.deleteObject("login:"+user.getUserId());

        }
        return AjaxResult.error("更新用户信息失败，请稍后重试");
    }

    @Override
    public int resetUserPwd(Integer userId, String encryptPassword) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id",userId);
        updateWrapper.set("password",encryptPassword);
        return this.baseMapper.update(null,updateWrapper);
    }

    @Override
    public boolean updateUserAvatar(Integer userId, String avatar) {
        return baseMapper.update(null,
                new UpdateWrapper<User>()
                .eq("user_id",userId)
                .set("avatar",avatar))>0;
    }


}




