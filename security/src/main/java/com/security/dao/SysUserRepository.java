package com.security.dao;

import com.security.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @classDesc: 用户表 数据库访问接口
 * @author: Vipin Zheng
 * @createDate: 2018-04-15 13:33:47
 * @version: v1.0
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
