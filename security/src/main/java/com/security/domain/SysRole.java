package com.security.domain;

import javax.persistence.*;

/**
 * @classDesc: 角色实体类
 * @author: Vipin Zheng
 * @createDate: 2018-04-15 13:19:09
 * @version: v1.0
 */
@Entity
public class SysRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
