package com.ljs.pingke.config;

import com.ljs.pingke.filter.JwtAuthenticationTokenFilter;
import com.ljs.pingke.handler.LogoutSuccessHandlerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * spring security 配置类
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    /**
     * 认证失败处理类
     */
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    /**
     * 退出处理类
     */
    @Autowired
    private LogoutSuccessHandlerImpl logoutSuccessHandler;

    /**
     * 强散列哈希加密实现
     */
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * anyRequest          |   匹配所有请求路径
     * access              |   SpringEl表达式结果为true时可以访问
     * anonymous           |   匿名可以访问
     * denyAll             |   用户不能访问
     * fullyAuthenticated  |   用户完全认证可以访问（非remember-me下自动登录）
     * hasAnyAuthority     |   如果有参数，参数表示权限，则其中任何一个权限可以访问
     * hasAnyRole          |   如果有参数，参数表示角色，则其中任何一个角色可以访问
     * hasAuthority        |   如果有参数，参数表示权限，则其权限可以访问
     * hasIpAddress        |   如果有参数，参数表示IP地址，如果用户IP和参数匹配，则可以访问
     * hasRole             |   如果有参数，参数表示角色，则其角色可以访问
     * permitAll           |   用户可以任意访问
     * rememberMe          |   允许通过remember-me登录的用户访问
     * authenticated       |   用户登录后可访问
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //关闭csrf
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 对于登录接口 允许匿名访问
                .antMatchers("/api/user/login").anonymous()
                //注册接口
                .antMatchers("/api/user/register").anonymous()
                //验证码接口
                .antMatchers("/api/captchaImage").anonymous()
                //轮播图
                .antMatchers("/api/get/rollad").anonymous()
                //项目展示
                .antMatchers("/api/get/adshow").anonymous()
//                .antMatchers("/api/user/logout").anonymous()
//                .antMatchers("/testCors").hasAuthority("system:dept:list222")
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated();
        //把token认证过滤器放在过滤器链中
        http.logout().logoutUrl("/api/user/logout").logoutSuccessHandler(logoutSuccessHandler);
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        //异常过滤器
        http.exceptionHandling()
                //配置认证失败过滤器
                .authenticationEntryPoint(authenticationEntryPoint);
        //配置跨域
        http.cors();
    }

//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//
//     }
}
