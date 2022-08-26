package com.ljs.pingke;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljs.pingke.common.constant.UserConstants;
import com.ljs.pingke.common.redis.RedisCache;
import com.ljs.pingke.common.utils.RsaUtil;
import com.ljs.pingke.mapper.MenuMapper;
import com.ljs.pingke.mapper.UserMapper;
import com.ljs.pingke.pojo.Item;
import com.ljs.pingke.pojo.LoginUser;
import com.ljs.pingke.pojo.User;
import com.ljs.pingke.service.ItemService;
import com.ljs.pingke.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class PingKeApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void TestBCryptPasswordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String encode = bCryptPasswordEncoder.encode("123456");
        boolean matches = bCryptPasswordEncoder.matches("123456", "$2a$10$nqSdpIDPyrR03cagKylTHeXCBkdtpPj6mOtzwEWk9bEvEuXEdjlAq");
        System.out.println(matches);
    }

    @Test
    public void UserDetailsService(){
        LoginUser user1 = (LoginUser)userDetailsService.loadUserByUsername("user1");
        String username = user1.getUsername();
        String password = user1.getPassword();
        System.out.println(username);
        System.out.println(password);
    }

    @Test
    public void select(){
        String username = "user1";
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,username);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }


    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void testMenuMapper(){
        List<String> list = menuMapper.selectPermsByUserId(1);

        System.out.println(list);
    }

    @Value("${auth.privateKey}")
    private String privateKey;

    @Test
    public void testDecrypt(){
        String encode = "wu0jrKHqXbfDC7H/cuuhUH8LQv3hYHQvHSpY2FUrK19cjIdBCMDI2ybYOKH9UjlC9/jLaTtfsyGerNFQ+OaO6T3zVP2o06w1Yb9aIEaLQhLMUOqsLXvVrMDKrIJYooWSYxKKp0xbcE3QHoDWXBGzUefvbrpVs36jEEGpeWcICZezJfNPcE3a83DEKMQQN/fa2FpEvq6ZzRBxZ1KFliHoqcqqAjSfmdOErSIK9hMKE1k0YxRYYs83aaMWdM+ucue3IVhpFxIGcb1Z0Dn61s+0JR4KHs49EYA8+WHMswo/jEv8xa8NgiDO0BdwLip82nB2hWXIAxrnXvYqnwP13m5PiA==";
        String password = RsaUtil.decrypt(encode,privateKey);
        System.out.println(password);
    }

    @Test
    public void testCount(){
        long count = userService.count(new QueryWrapper<User>().eq("username", "user2"));
        if (count > 0){
            System.out.println(UserConstants.NOT_UNIQUE);
        }else{
            System.out.println(UserConstants.UNIQUE);
        }
    }

    @Test
    public void ItemServiceTest(){
        Integer itemId = -1;
        Item item = itemService.getItemById(itemId);
        System.out.println(item);
    }

    @Test
    public void getExpireTime(){
        Long expire = redisTemplate.opsForValue().getOperations().getExpire("login:9");
        System.out.println("expire:"+expire);
    }
}
