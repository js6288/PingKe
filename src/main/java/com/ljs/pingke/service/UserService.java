package com.ljs.pingke.service;

import com.ljs.pingke.common.domain.AjaxResult;
import com.ljs.pingke.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author ljs
* @description 针对表【user】的数据库操作Service
* @createDate 2022-03-14 18:16:25
*/
public interface UserService extends IService<User> {

    String checkUserNameUnique(String username);

    AjaxResult updateUserInfo(User user);

    int resetUserPwd(Integer userId, String encryptPassword);

    boolean updateUserAvatar(Integer userId,String avatar);
}
