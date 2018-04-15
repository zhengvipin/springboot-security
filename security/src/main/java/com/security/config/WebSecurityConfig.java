package com.security.config;

import com.security.service.SysUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @classDesc: spring security配置类
 * @author: Vipin Zheng
 * @createDate: 2018-04-15 16:45:07
 * @version: v1.0
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 注册CustomUserService的Bean
     *
     * @return SysUserService
     */
    @Bean
    UserDetailsService customUserService() {
        return new SysUserService();
    }

    /**
     * 装载BCrypt密码编码器
     *
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.
                // 设置 UserDetailsService
                        userDetailsService(customUserService()).
                // 使用 BCrypt 进行密码的 hash
                        passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                // 过滤静态资源
                .antMatchers(
                        HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                ).permitAll()
                // 其他地址的访问均需登录
                .anyRequest().authenticated()

                .and()

                // 登录
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index")
                .permitAll()

                .and()

                // 注销
                .logout()
                .logoutSuccessUrl("/login")
                .permitAll();
    }
}
