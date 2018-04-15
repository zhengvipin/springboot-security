package com.security;

import com.security.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Resource
    private SysUserService userService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Test
    public void contextLoads() {
        UserDetails user = userService.loadUserByUsername("root");
        System.out.println(user.getAuthorities());
    }

    @Test
    public void getPassword(){
        System.out.println(passwordEncoder.encode("scott"));
    }
}
