package com.security.service;

import com.security.dao.SysUserRepository;
import com.security.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;

/**
 * @classDesc: 用户表 业务逻辑类：实现UserDetailsService接口，在Spring Security中我们配置相关参数需要UserDetailsService类型的数据
 * @author: Vipin Zheng
 * @createDate: 2018-04-15 13:36:08
 * @version: v1.0
 */
public class SysUserService implements UserDetailsService {
    @Resource
    private SysUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
        return user;
    }
}
